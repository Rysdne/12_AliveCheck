package com.test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hosts")
public class HostController {

	@Autowired
	HostService service;

	// ReadAll
	@GetMapping
	public List<HostEntity> hosts() {
		return service.findAll();
	}

	// ReadByIp
	@GetMapping(value = "/ip/{ip}")
	public Optional<HostEntity> host(@PathVariable String ip) {
		return service.findByIp(ip);
	}

	// ReadByName
	@GetMapping(value = "/name/{name}")
	public Optional<HostEntity> findByName(@PathVariable String name) {
		return service.findByName(name);
	}

	// Create
	@PostMapping
	public Map<String, Object> insert(@RequestBody HostEntity host) {
		return service.insert(host);
	}
	
	// Update
	@PutMapping
	public Map<String, Object> update(@RequestBody Map<String, String> map) {
		return service.update(map);
	}

	// DeleteByIp
	@DeleteMapping(value = "/ip/{ip}")
	public Map<String, Object> deleteIp(@PathVariable String ip) {
		return service.deleteByIp(ip);
	}

	// DeleteByName
	@DeleteMapping(value = "/name/{name}")
	public Map<String, Object> deleteName(@PathVariable String name) {
		return service.deleteByName(name);
	}

}
