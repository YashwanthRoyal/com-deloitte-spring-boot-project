package com.deloitte.spring.boot.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.spring.boot.project.model.Party;

@Repository
public interface PartyRepository  extends JpaRepository<Party, String>  {
	
	public List<Party> findByPartyName(String partyName);

}
