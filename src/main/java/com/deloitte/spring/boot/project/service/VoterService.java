package com.deloitte.spring.boot.project.service;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.spring.boot.project.exception.NoSuchRecordException;
import com.deloitte.spring.boot.project.exception.AlreadyVotedException;
import com.deloitte.spring.boot.project.exception.NoSuchCandidateRecordException;
import com.deloitte.spring.boot.project.exception.NoSuchConstituencyException;
import com.deloitte.spring.boot.project.exception.NoSuchElectionException;
import com.deloitte.spring.boot.project.exception.NoSuchVoterException;
import com.deloitte.spring.boot.project.exception.NotScheduledException;
import com.deloitte.spring.boot.project.exception.UnauthorisedVoterException;
import com.deloitte.spring.boot.project.model.Election;
import com.deloitte.spring.boot.project.model.Vote;
import com.deloitte.spring.boot.project.model.Voter;
import com.deloitte.spring.boot.project.repository.CandidateRepository;
import com.deloitte.spring.boot.project.repository.ConstituencyRepository;
import com.deloitte.spring.boot.project.repository.ElectionRepository;
import com.deloitte.spring.boot.project.repository.PartyRepository;
import com.deloitte.spring.boot.project.repository.VoteRepository;
import com.deloitte.spring.boot.project.repository.VoterRepository;

import logging.GlobalResources;

@Service
public class VoterService {
	
	private Logger Logger = GlobalResources.getLogger(AdministratorService.class);
	
	@Autowired
	VoterRepository voterRepository;
	
	@Autowired
	CandidateRepository candidatesRepository;
	
	@Autowired
	VoteRepository voteRepository;
	
	@Autowired
	ConstituencyRepository constituencyRepository;
	
	@Autowired
	ElectionRepository electionRepository;
	
	@Autowired
	PartyRepository partyRepository;

	public Voter getVoterByEpic(String epic) {
		Voter voter = voterRepository.findVoterByEpic(epic);
		if (!voter.equals(null)) {
			return voter;
		} else {
			String errorMessage = "Voter with name " + voter.getVoterName() + " not found.";
			throw new NoSuchVoterException(errorMessage);
		}
	}

	public boolean addVoter(Voter voter) {
		boolean result = false;
		voter = voterRepository.save(voter);
		result = true;
		Logger.info("Voter is added successfully");
		return result;
	}

	public String voteCasting(String epic, int candidateId){
		String result = null;
		Vote vote = new Vote();
		vote.setEpic(epic);
		vote.setCandidateId(candidateId);
		voteRepository.save(vote);
		result = "Thanks for Voting "
				+ candidatesRepository.findById(candidateId).get().getCandidateName();
		Logger.info("castVote");
		return result;
		
	}

	public Voter updateVoter(Voter voter) throws NoSuchVoterException{
		if(!voterRepository.existsById(voter.getEpic())){
			String errorMessage = "Voter with name " + voter.getVoterName() + " not found.";
			throw new NoSuchVoterException(errorMessage);
		}
		return voterRepository.save(voter);
		
	}

	public String viewVoteForAllCandidate() throws NoSuchRecordException {
		
		String result = "";
		List<Object[]> list = voteRepository.cadidateVoteCount();
		if (!list.isEmpty()) {
			for (Object[] obj : list) {
				int candidateId = Integer.parseInt(obj[0].toString());
				String candidateName = candidatesRepository.findById(candidateId).get().getCandidateName()+ ", " + partyRepository
						.findById(candidatesRepository.findById(candidateId).get().getPartyRegId()).get()
						.getPartyName();
				String votes = obj[1].toString();
				result = result + "\n" + candidateName + " has received " + votes + " vote(s)"+ ".";
			}
			Logger.info("viewVoteForAllCandidate");
			return result;
		}
		Logger.error("No results present");
		throw new NoSuchRecordException("No record present");
	}
}
