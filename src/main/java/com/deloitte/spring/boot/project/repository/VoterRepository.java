package com.deloitte.spring.boot.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.spring.boot.project.model.Voter;


@Repository
public interface VoterRepository extends JpaRepository<Voter, String> {
	
	@Query(value = "Select v from Voter v where v.epic= :epic")
	public Voter findVoterByEpic(@Param("epic") String epic);

}
