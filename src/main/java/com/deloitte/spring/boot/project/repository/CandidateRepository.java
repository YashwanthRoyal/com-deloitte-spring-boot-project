package com.deloitte.spring.boot.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.spring.boot.project.model.Candidates;

@Repository
public interface CandidateRepository  extends JpaRepository<Candidates, Integer>  {
	
	@Query(value = "Select c From Candidates c Where Lower(c.candidateName) Like %:name%")
	public List<Candidates> findCandidateByName(@Param("name") String candidateName);
	
	@Query(value = "Select c From Candidates c Where Lower(c.candidateName) Like %:name%")
	public List<Candidates> findCandidatesByName(@Param("name") String candidateName);

}
