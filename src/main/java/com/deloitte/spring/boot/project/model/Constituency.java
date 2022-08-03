package com.deloitte.spring.boot.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "constituency")
public class Constituency {
	
	@Id
	@Column(name = "constituency_id")
	@GenericGenerator(name = "constituency_seq", strategy = "increment")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "constituency_seq")
	private int constituencyId;

	@Column(name = "constituency_name", length = 30, nullable = false, unique = true)
	private String constituencyName;

	@Column(name = "state", length = 30, nullable = false)
	private String state;

	@Column(name = "election_id", length = 3, nullable = false)
	private int electionId;

	public Constituency() {
		
		super();

	}

	public Constituency(String constituencyName, String state, int electionId) {
		super();
		this.constituencyName = constituencyName;
		this.state = state;
		this.electionId = electionId;
	}

	public Constituency(int constituencyId, String constituencyName, String state, int electionId) {
		super();
		this.constituencyId = constituencyId;
		this.constituencyName = constituencyName;
		this.state = state;
		this.electionId = electionId;
	}

	public int getConstituencyId() {
		return constituencyId;
	}

	public void setConstituencyId(int constituencyId) {
		this.constituencyId = constituencyId;
	}

	public String getConstituencyName() {
		return constituencyName;
	}

	public void setConstituencyName(String constituencyName) {
		this.constituencyName = constituencyName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getElectionId() {
		return electionId;
	}

	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}

	@Override
	public String toString() {
		return "Constituency [constituencyId=" + constituencyId + ", constituencyName=" + constituencyName + ", state="
				+ state + ", electionId=" + electionId + "]";
	}

}