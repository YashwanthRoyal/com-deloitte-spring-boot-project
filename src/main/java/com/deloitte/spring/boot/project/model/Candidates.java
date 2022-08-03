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
@Table(name = "candidate")
public class Candidates{

	@Id
	@Column(name = "candidate_id")
	@GenericGenerator(name = "candidates_seq", strategy = "increment")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidates_seq")	
	private int candidateId;

	@Column(name = "candidate_name", length = 40, nullable = false)
	private String candidateName;

	@Column(name = "party_reg_id", length = 10, nullable = false)
	private String partyRegId;

	@Column(name = "constituency_id", length = 3, nullable = false)
	private int constituencyId;

	public Candidates() {
		
		super();

	}

	public Candidates(String candidateName, String partyRegId, int constituencyId) {
		super();
		this.candidateName = candidateName;
		this.partyRegId = partyRegId;
		this.constituencyId = constituencyId;
	}

	public Candidates(int candidateId, String candidateName, String partyRegId, int constituencyId) {
		super();
		this.candidateId = candidateId;
		this.candidateName = candidateName;
		this.partyRegId = partyRegId;
		this.constituencyId = constituencyId;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getPartyRegId() {
		return partyRegId;
	}

	public void setPartyRegId(String partyRegId) {
		this.partyRegId = partyRegId;
	}

	public int getConstituencyId() {
		return constituencyId;
	}

	public void setConstituencyId(int constituencyId) {
		this.constituencyId = constituencyId;
	}

	@Override
	public String toString() {
		return "Candidates [candidateId=" + candidateId + ", candidateName=" + candidateName + ", partyRegId="
				+ partyRegId + ", constituencyId=" + constituencyId + "]";
	}

}