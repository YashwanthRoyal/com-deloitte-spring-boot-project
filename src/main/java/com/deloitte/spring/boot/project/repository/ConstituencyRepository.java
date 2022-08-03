package com.deloitte.spring.boot.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deloitte.spring.boot.project.model.Constituency;


@Repository
public interface ConstituencyRepository  extends JpaRepository<Constituency, Integer>  {
	
	@Query(value = "Select c From Constituency c Where Lower(c.constituencyName) = :name")
	public List<Constituency> findConstituencyByName(@Param("name") String constituencyName);
	
	@Query(value = "Select c From Constituency c Where Lower(c.constituencyName) = :name")
	public List<Constituency> findConstituenciesByName(@Param("name") String constituencyName);

}

