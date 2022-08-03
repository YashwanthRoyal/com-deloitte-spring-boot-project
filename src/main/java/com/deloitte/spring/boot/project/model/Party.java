package com.deloitte.spring.boot.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "party")
public class Party {

	@Id
	@Column(name = "reg_id")
	private String regId;

	@Column(name = "party_name", length = 40, nullable = false)
	private String partyName;

	@Column(name = "leader", length = 40, nullable = false)
	private String leader;

	public Party() {
		
		super();

	}

	public Party(String regId, String partyName, String leader) {
		super();
		this.regId = regId;
		this.partyName = partyName;
		this.leader = leader;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	@Override
	public String toString() {
		return "Party [regId=" + regId + ", partyName=" + partyName + ",leader=" + leader + "]";
	}

}