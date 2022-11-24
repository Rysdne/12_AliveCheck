package com.test;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends JpaRepository<HostEntity, Integer> {

	Optional<HostEntity> findByIp(String ip);

	Optional<HostEntity> findByName(String name);

	HostEntity save(HostEntity host);

	Optional<HostEntity> deleteByIp(String ip);

	Optional<HostEntity> deleteByName(String name);

}
