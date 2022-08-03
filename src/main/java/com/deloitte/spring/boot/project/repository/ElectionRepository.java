package com.deloitte.spring.boot.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.spring.boot.project.model.Election;


@Repository
public interface ElectionRepository extends JpaRepository<Election, Integer> {

//	List<Election> findElectionsByName(String electionName);
//
//    List<Election> readAllElectionsByName(String electionName);

//	public List<Election> readAllElectionsByName(@Param("name") String electionName);
	
//	@Query(value = "Select e From Election e Where Lower(e.electionName) = :name")
	public List<Election> findByElectionName( String electionName);
}
