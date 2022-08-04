package com.deloitte.spring.boot.project.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.spring.boot.project.exception.NoSuchRecordException;

import com.deloitte.spring.boot.project.model.ElectoralOfficer;
import com.deloitte.spring.boot.project.model.Vote;
import com.deloitte.spring.boot.project.model.Voter;
import com.deloitte.spring.boot.project.repository.ElectoralOfficerRepository;
import com.deloitte.spring.boot.project.repository.VoteRepository;
import com.deloitte.spring.boot.project.repository.VoterRepository;

import logging.GlobalResources;

@Service
public class ElectoralOfficerService {
	
	private Logger Logger = GlobalResources.getLogger(AdministratorService.class);
	
	@Autowired
	ElectoralOfficerRepository eoRepository;
	
	@Autowired
	VoterRepository voterRepository;
	
	@Autowired
	VoteRepository voteRepository;
	

	public boolean addEO(ElectoralOfficer eo) {
		if(eoRepository.existsById(eo.getElectoralOfficerId()))
		{
			return false;
		}
		eoRepository.save(eo);
		return true;
		
	}

	public List<Voter> getAllVoters() throws NoSuchRecordException{
		List<Voter> result = voterRepository.findAll();
		if (!result.isEmpty()) {
			Logger.info("viewAllVoters");
			return result;
		}
		Logger.error("No voter list is found");
		throw new NoSuchRecordException("No voter list is found.");
	}

	public Voter getVoterById(String epic) {
		if(!voterRepository.existsById(epic))
		{
			 return null;
		}
		return voterRepository.getById(epic);
	}

	public List<Vote> getAllVotes() {
		List<Vote> result = voteRepository.findAll();
		if (!result.isEmpty()) {
			Logger.info("viewAllVotes");
			return result;
		}
		Logger.error("No vote list is found");
		throw new NoSuchRecordException("No vote list is found.");
	}

}
