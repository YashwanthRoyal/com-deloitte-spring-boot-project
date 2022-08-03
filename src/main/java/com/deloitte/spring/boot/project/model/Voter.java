package com.deloitte.spring.boot.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "voter_table")

public class Voter {
	
	@Id
	@Column(name = "epic",nullable = false, unique = true)
	private String epic;

	@Column(name = "voter_name", length = 60, nullable = false)
	private String voterName;

	@Column(name = "dob", length = 10, nullable = false)
	private String dob;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "Address", length = 200)
	private String address;

	@Column(name = "district")
	private String district;

	@Column(name = "contituency_id", length = 3, nullable = false)
	private int constituencyId;

	@Column(name = "mobile", length = 10, nullable = false, unique = true)
	private long mobile;

	@Column(name = "voter_password", length = 10, nullable = false)
	private String voterPassword;

	@Column(name = "status", nullable = false)
	private String status;
	
	public Voter() {
		
		super();

	}

	public Voter(String epic, String voterName, String dob, String gender, String address, String district,
			int constituencyId, long mobile, String voterPassword, String status) {
		super();
		this.epic = epic;
		this.voterName = voterName;
		this.dob = dob;
		this.gender = gender;
		this.address = address;
		this.district = district;
		this.constituencyId = constituencyId;
		this.mobile = mobile;
		this.voterPassword = voterPassword;
		this.status = status;
	}

	public String getEpic() {
		return epic;
	}

	public void setEpic(String epic) {
		this.epic = epic;
	}

	public String getVoterName() {
		return voterName;
	}

	public void setVoterName(String voterName) {
		this.voterName = voterName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getConstituencyId() {
		return constituencyId;
	}

	public void setConstituencyId(int constituencyId) {
		this.constituencyId = constituencyId;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getVoterPassword() {
		return voterPassword;
	}

	public void setVoterPassword(String voterPassword) {
		this.voterPassword = voterPassword;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Voter [epic=" + epic + ", voterName=" + voterName + ", dob=" + dob + ", gender=" + gender + ", address="
				+ address + ", district=" + district + ", constituencyId=" + constituencyId + ", mobile=" + mobile
				+ ", voterPassword=" + voterPassword + ", status=" + status + "]";
	}
	

}


	
	