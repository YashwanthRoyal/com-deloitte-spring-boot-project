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
@Table(name = "election")
public class Election {

	@Id //PK
	@Column(name = "election_id")
	@GenericGenerator(name = "election_seq", strategy = "increment")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "election_seq")
	private int electionId;

	@Column(name = "election_name", length = 40, nullable = false)
	private String electionName;

	@Column(name = "election_date", length = 10, nullable = false)
	private String electionDate;

	public Election() {
		
		super();

	}

	public Election(String electionName, String electionDate) {
		super();
		this.electionName = electionName;
		this.electionDate = electionDate;
	}


	public Election(int electionId, String electionName, String electionDate) {
		super();
		this.electionId = electionId;
		this.electionName = electionName;
		this.electionDate = electionDate;

	}

	public int getElectionId() {
		return electionId;
	}

	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}

	public String getElectionName() {
		return electionName;
	}

	public void setElectionName(String electionName) {
		this.electionName = electionName;
	}

	public String getElectionDate() {
		return electionDate;
	}

	public void setElectionDate(String electionDate) {
		this.electionDate = electionDate;
	}

	@Override
	public String toString() {
		return "Election [electionId=" + electionId + ", electionName=" + electionName + ", electionDate=" + electionDate + "]";
	}

}