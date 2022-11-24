package com.test;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "hostlist", uniqueConstraints = { @UniqueConstraint(columnNames = "IDX") })
public class HostEntity implements Serializable {

	private static final long serialVersionUID = -4551845353534824962L;

	@Id
	@SequenceGenerator(name = "idx", sequenceName = "HOST_IDX_SEQ", initialValue = 101, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idx")
	@Column(name = "IDX", unique = true, nullable = false)
	private Integer idx;

	@Column(name = "IP", unique = true, nullable = false)
	private String ip;

	@Column(name = "NAME", unique = true, nullable = false)
	private String name;

	@Column(name = "ISALIVE")
	private boolean isalive;

	@Column(name = "LASTALIVE")
	private LocalDateTime lastalive;

	@Column(name = "INSERTTIME")
	private LocalDateTime inserttime;

	@Column(name = "UPDATETIME")
	private LocalDateTime updatetime;

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isIsalive() {
		return isalive;
	}

	public void setIsalive(boolean isalive) {
		this.isalive = isalive;
	}

	public LocalDateTime getLastalive() {
		return lastalive;
	}

	public void setLastalive(LocalDateTime lastalive) {
		this.lastalive = lastalive;
	}

	public LocalDateTime getInserttime() {
		return inserttime;
	}

	public void setInserttime(LocalDateTime inserttime) {
		this.inserttime = inserttime;
	}

	public LocalDateTime getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(LocalDateTime updatetime) {
		this.updatetime = updatetime;
	}

	@Override
	public String toString() {
		return "HostEntity [ip=" + ip + ", name=" + name + ", isalive=" + isalive + ", lastalive=" + lastalive
				+ ", inserttime=" + inserttime + ", updatetime=" + updatetime + "]";
	}

}
