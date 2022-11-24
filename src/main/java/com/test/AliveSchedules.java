package com.test;

import java.net.InetAddress;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AliveSchedules {

	@Autowired
	HostRepository repo;

	@Autowired
	HostService service;
	int timeout = 1000;

	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check1() {					
		try {				
			List<HostEntity> list = repo.findAll();
			
			// 호스트의 수가 1보다 큰 경우
			if (list.size() >= 1) {
				
				// 첫번째 호스트 정보를 저장
				HostEntity host = list.get(0);
				
				// 해당 호스트의 isReachable 값이 true인 경우
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {
					
					// 기존 호스트 정보의 isalive 컬럼값이 false였을 경우, 서버 콘솔창에 Alive 알림 출력
					if(!host.isIsalive())
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					
					// alive(host.getIp(), true) 메서드를 호출해 DB 수정
					service.alive(host.getIp(), true);
					
				// 해당 호스트의 isReachable 값이 false인 경우 
				} else {		
					// 기존 호스트 정보의 isalive 컬럼값이 true였을 경우, 서버 콘솔창에 Not Alive 알림 출력 
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						
						// alive(host.getIp(), false) 메서드를 호출해 DB 수정
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check2() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 2) {			
				HostEntity host = list.get(1);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check3() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 3) {			
				HostEntity host = list.get(2);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check4() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 4) {			
				HostEntity host = list.get(3);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check5() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 5) {			
				HostEntity host = list.get(4);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check6() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 6) {			
				HostEntity host = list.get(5);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check7() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 7) {			
				HostEntity host = list.get(6);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check8() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 8) {			
				HostEntity host = list.get(7);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check9() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 9) {			
				HostEntity host = list.get(8);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check10() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 10) {			
				HostEntity host = list.get(9);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check11() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 11) {			
				HostEntity host = list.get(10);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check12() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 12) {			
				HostEntity host = list.get(11);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check13() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 13) {			
				HostEntity host = list.get(12);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check14() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 14) {			
				HostEntity host = list.get(13);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check15() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 15) {			
				HostEntity host = list.get(14);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check16() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 16) {			
				HostEntity host = list.get(15);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check17() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 17) {			
				HostEntity host = list.get(16);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check18() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 18) {			
				HostEntity host = list.get(17);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check19() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 19) {			
				HostEntity host = list.get(18);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check20() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 20) {			
				HostEntity host = list.get(19);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check21() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 21) {			
				HostEntity host = list.get(20);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check22() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 22) {			
				HostEntity host = list.get(21);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check23() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 23) {			
				HostEntity host = list.get(22);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check24() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 24) {			
				HostEntity host = list.get(23);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check25() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 25) {			
				HostEntity host = list.get(24);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check26() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 26) {			
				HostEntity host = list.get(25);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check27() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 27) {			
				HostEntity host = list.get(26);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check28() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 28) {			
				HostEntity host = list.get(27);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check29() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 29) {			
				HostEntity host = list.get(28);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check30() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 30) {			
				HostEntity host = list.get(29);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check31() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 31) {			
				HostEntity host = list.get(30);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check32() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 32) {			
				HostEntity host = list.get(31);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check33() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 33) {			
				HostEntity host = list.get(32);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check34() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 34) {			
				HostEntity host = list.get(33);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check35() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 35) {			
				HostEntity host = list.get(34);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check36() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 36) {			
				HostEntity host = list.get(35);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check37() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 37) {			
				HostEntity host = list.get(36);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check38() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 38) {			
				HostEntity host = list.get(37);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check39() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 39) {			
				HostEntity host = list.get(38);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check40() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 40) {			
				HostEntity host = list.get(39);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check41() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 41) {			
				HostEntity host = list.get(40);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check42() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 42) {			
				HostEntity host = list.get(41);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check43() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 43) {			
				HostEntity host = list.get(42);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check44() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 44) {			
				HostEntity host = list.get(43);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check45() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 45) {			
				HostEntity host = list.get(44);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check46() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 46) {			
				HostEntity host = list.get(45);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check47() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 47) {			
				HostEntity host = list.get(46);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check48() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 48) {			
				HostEntity host = list.get(47);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check49() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 49) {			
				HostEntity host = list.get(48);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check50() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 50) {			
				HostEntity host = list.get(49);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check51() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 51) {			
				HostEntity host = list.get(50);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check52() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 52) {			
				HostEntity host = list.get(51);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check53() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 53) {			
				HostEntity host = list.get(52);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check54() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 54) {			
				HostEntity host = list.get(53);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check55() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 55) {			
				HostEntity host = list.get(54);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check56() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 56) {			
				HostEntity host = list.get(55);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check57() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 57) {			
				HostEntity host = list.get(56);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check58() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 58) {			
				HostEntity host = list.get(57);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check59() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 59) {			
				HostEntity host = list.get(58);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check60() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 60) {			
				HostEntity host = list.get(59);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check61() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 61) {			
				HostEntity host = list.get(60);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check62() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 62) {			
				HostEntity host = list.get(61);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check63() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 63) {			
				HostEntity host = list.get(62);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check64() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 64) {			
				HostEntity host = list.get(63);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check65() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 65) {			
				HostEntity host = list.get(64);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check66() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 66) {			
				HostEntity host = list.get(65);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check67() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 67) {			
				HostEntity host = list.get(66);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check68() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 68) {			
				HostEntity host = list.get(67);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check69() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 69) {			
				HostEntity host = list.get(68);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check70() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 70) {			
				HostEntity host = list.get(69);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check71() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 71) {			
				HostEntity host = list.get(70);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check72() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 72) {			
				HostEntity host = list.get(71);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check73() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 73) {			
				HostEntity host = list.get(72);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check74() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 74) {			
				HostEntity host = list.get(73);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check75() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 75) {			
				HostEntity host = list.get(74);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check76() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 76) {			
				HostEntity host = list.get(75);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check77() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 77) {			
				HostEntity host = list.get(76);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check78() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 78) {			
				HostEntity host = list.get(77);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check79() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 79) {			
				HostEntity host = list.get(78);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check80() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 80) {			
				HostEntity host = list.get(79);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check81() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 81) {			
				HostEntity host = list.get(80);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check82() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 82) {			
				HostEntity host = list.get(81);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check83() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 83) {			
				HostEntity host = list.get(82);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check84() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 84) {			
				HostEntity host = list.get(83);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check85() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 85) {			
				HostEntity host = list.get(84);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check86() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 86) {			
				HostEntity host = list.get(85);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check87() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 87) {			
				HostEntity host = list.get(86);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check88() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 88) {			
				HostEntity host = list.get(87);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check89() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 89) {			
				HostEntity host = list.get(88);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check90() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 90) {			
				HostEntity host = list.get(89);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check91() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 91) {			
				HostEntity host = list.get(90);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check92() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 92) {			
				HostEntity host = list.get(91);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check93() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 93) {			
				HostEntity host = list.get(92);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check94() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 94) {			
				HostEntity host = list.get(93);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check95() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 95) {			
				HostEntity host = list.get(94);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check96() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 96) {			
				HostEntity host = list.get(95);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check97() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 97) {			
				HostEntity host = list.get(96);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check98() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 98) {			
				HostEntity host = list.get(97);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check99() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 99) {			
				HostEntity host = list.get(98);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					
	@Async					
	@Scheduled(fixedRate = 1000)					
	public void Check100() {					
		try {				
			List<HostEntity> list = repo.findAll();			
			if (list.size() >= 100) {			
				HostEntity host = list.get(99);		
				if (InetAddress.getByName(host.getIp()).isReachable(timeout)) {		
					if(!host.isIsalive())	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned On");
					service.alive(host.getIp(), true);	
				} else {		
					if (host.isIsalive()) {	
						System.out.println(host.getName() + "(" + host.getIp() + ") turned Off");
						service.alive(host.getIp(), false);
					}	
				}		
			}			
		} catch (Exception e) {				
		}				
	}					


}
