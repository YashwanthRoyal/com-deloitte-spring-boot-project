package com.deloitte.spring.boot.project.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "vote")
public class Vote {
	
	@Id
	@Column(name = "vote_id")
	@GenericGenerator(name = "vote_seq", strategy = "increment")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vote_seq")	
	private int voteId;

	@JoinColumn(name = "candidate_id", nullable = false)
	private int candidate;

	@JoinColumn(name = "epic", nullable = false)
	private String epic;

	public Vote() {
		
		super();


	}
	
	public Vote(int candidate, String epic) {
		super();
		this.candidate = candidate;
		this.epic = epic;
	}
	
	public Vote(int voteId, int candidate, String epic) {
		super();
		this.voteId = voteId;
		this.candidate = candidate;
		this.epic = epic;
	}

	public int getVoteId() {
		return voteId;
	}

	public void setVoteId(int voteId) {
		this.voteId = voteId;
	}

	public int getCandidate() {
		return candidate;
	}

	public void setCandidate(int candidate) {
		this.candidate = candidate;
	}

	public String getEpic() {
		return epic;
	}

	public void setEpic(String epic) {
		this.epic = epic;
	}

	@Override
	public String toString() {
		return "Vote [voteId=" + voteId + ", candidate=" + candidate + ", epic=" + epic + "]";
	}

}