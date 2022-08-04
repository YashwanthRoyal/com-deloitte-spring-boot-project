package com.deloitte.spring.boot.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deloitte.spring.boot.project.model.ElectoralOfficer;

public interface ElectoralOfficerRepository extends JpaRepository<ElectoralOfficer,String>{

	List<ElectoralOfficer> findByElectoralOfficerName(String electoralOfficerName);

}
