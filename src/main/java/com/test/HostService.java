package com.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HostService {

	@Autowired
	HostRepository repo;

	// ReadAll
	public List<HostEntity> findAll() {
		List<HostEntity> hosts = new ArrayList<>();
		repo.findAll().forEach(e -> hosts.add(e));
		return hosts;
	}
	// ReadByIp	
	public Optional<HostEntity> findByIp(String ip) {
		
		// 입력받은 IP값으로 호스트 정보 색인
		Optional<HostEntity> host = repo.findByIp(ip);
		return host;
	}

	// ReadByName
	public Optional<HostEntity> findByName(String name) {
		
		// 입력받은 이름값으로 호스트 정보 색인
		Optional<HostEntity> host = repo.findByName(name);
		return host;
	}

	// Create
	@Transactional
	public Map<String, Object> insert(HostEntity host) {
		Map<String, Object> response = new HashMap<>();
		
		// isPresent() 메서드를 사용하기 위해 Optional<HostEntity> 형태로 선언
		Optional<HostEntity> oHostIp = repo.findByIp(host.getIp());
		Optional<HostEntity> oHostName = repo.findByName(host.getName());
		
		// 등록된 호스트 정보가 있을 경우(IP, 이름으로 검색하여 확인)
		if (oHostIp.isPresent() || oHostName.isPresent()) {
			response.put("result", "FAIL");
			response.put("reason", "Already exist");
		} else {
			
			// 등록된 호스트 수가 100보다 작을 경우 입력 실행 
			if (repo.count() < 100) {
				LocalDateTime now = LocalDateTime.now();
				host.setInserttime(now);
				host.setUpdatetime(now);
				repo.save(host);
				response.put("result", "SUCCESS");
				
			// 등록된 호스트 수가 100개일 때 입력 취소 
			} else {
				response.put("result", "FAIL");
				response.put("reason", "Table is full");
			}
		}
		return response;
	}

	// Update
	@Transactional
	public Map<String, Object> update(Map<String, String> map) {
		Map<String, Object> response = new HashMap<>();
		
		// 입력된 "target" 값이 "name"일 경우, IP로 호스트를 찾아 이름을 수정
		if (map.get("target").equals("name")) {
			Optional<HostEntity> oHost = repo.findByIp((String) map.get("ip"));
			
			// 호스트 정보가 존재할 경우 내용 수정
			if (oHost.isPresent()) {
				HostEntity host = oHost.get();
				LocalDateTime now = LocalDateTime.now();
				
				// 수정할 입력값이 공백이 아닐 경우 내용 수정
				if (!map.get("name").equals("")) {
					host.setName((String) map.get("name"));
					host.setUpdatetime(now);
					repo.save(host);
					response.put("result", "SUCCESS");
					
				// 수정할 입력값이 공백일 경우 수정 취소
				} else {
					response.put("result", "FAIL");
					response.put("reason", "Input is Null");
				}
				
			// 호스트 정보가 존재하지 않을 경우 수정 취소
			} else {
				response.put("result", "FAIL");
				response.put("reason", "Not exist");
			}
			
		// 입력된 "target" 값이 "ip"일 경우, 이름으로 호스트를 찾아 IP를 수정
		} else if (map.get("target").equals("ip")) {
			Optional<HostEntity> oHost = repo.findByName((String) map.get("name"));
			
			// 호스트 정보가 존재할 경우 내용 수정
			if (oHost.isPresent()) {
				HostEntity host = oHost.get();
				LocalDateTime now = LocalDateTime.now();
				
				// 수정할 입력값이 공백이 아닐 경우 내용 수정
				if (!map.get("ip").equals("")) {
					host.setIp((String) map.get("ip"));
					host.setUpdatetime(now);
					repo.save(host);
					response.put("result", "SUCCESS");
					
				// 수정할 입력값이 공백일 경우 수정 취소
				} else {
					response.put("result", "FAIL");
					response.put("reason", "Input is Null");
				}
				
			// 호스트 정보가 존재하지 않을 경우 수정 취소
			} else {
				response.put("result", "FAIL");
				response.put("reason", "Not exist");
			}
			
		// 입력된 "target" 값이 "ip"와 "name"이 아닐 경우, 수정 취소
		} else {
			response.put("result", "FAIL");
			response.put("reason", "Invalid target");
		}
		return response;
	}

	// DeleteByIp
	@Transactional
	public Map<String, Object> deleteByIp(String ip) {
		Map<String, Object> response = new HashMap<>();
		
		// 입력받은 IP값으로 호스트 정보 색인
		Optional<HostEntity> oHost = repo.findByIp(ip);
		
		// 호스트 정보가 존재할 경우 내용 삭제
		if (oHost.isPresent()) {
			repo.deleteByIp(ip);
			response.put("result", "SUCCESS");
			
		// 호스트 정보가 존재하지 않을 경우 삭제 취소
		} else {
			response.put("result", "FAIL");
			response.put("reason", "Not exist");
		}
		return response;
	}

	// DeleteByName
	@Transactional
	public Map<String, Object> deleteByName(String name) {
		Map<String, Object> response = new HashMap<>();
		
		// 입력받은 이름값으로 호스트 정보 색인
		Optional<HostEntity> oHost = repo.findByName(name);
		
		// 호스트 정보가 존재할 경우 내용 삭제
		if (oHost.isPresent()) {
			repo.deleteByName(name);
			response.put("result", "SUCCESS");
			
		// 호스트 정보가 존재하지 않을 경우 삭제 취소
		} else {
			response.put("result", "FAIL");
			response.put("reason", "Not exist");
		}
		return response;
	}

	// AliveCheck
	@Transactional
	public void alive(String ip, boolean status) {
		HostEntity host = repo.findByIp(ip).get();
		
		// 전달받은 status 값으로 isalive컬럼 값을 수정
		host.setIsalive(status);
		
		// 호스트와 연결할 수 있는 경우 lastalive컬럼 값을 현재 시간으로 수정
		if (status) {
			host.setLastalive(LocalDateTime.now());
		}
		repo.save(host);
	}
}
