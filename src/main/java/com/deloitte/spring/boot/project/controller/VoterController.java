package com.deloitte.spring.boot.project.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.spring.boot.project.exception.NoSuchRecordException;
import com.deloitte.spring.boot.project.model.Candidates;
import com.deloitte.spring.boot.project.model.Election;
import com.deloitte.spring.boot.project.model.Party;
import com.deloitte.spring.boot.project.model.Vote;
import com.deloitte.spring.boot.project.model.Voter;
import com.deloitte.spring.boot.project.service.AdministratorService;
import com.deloitte.spring.boot.project.service.VoterService;

@RestController
@RequestMapping(path = "/voter")
public class VoterController {
	
	@Autowired
	private VoterService voterService;
	
	@Autowired
	private AdministratorService adminService;
	
	@RequestMapping(path = "/castVote",method=RequestMethod.POST)
	public ResponseEntity<String> castVote(@RequestBody Vote vote) throws NoSuchRecordException {
		ResponseEntity<String> response = null;
		String result = voterService.voteCasting(vote.getEpic(), vote.getCandidateId());
		if (result != null) {
			response = new ResponseEntity<String>(result, HttpStatus.CREATED);
		}
		return response;
	}
	
	@RequestMapping(path = "/add-voter",method=RequestMethod.POST)
	public ResponseEntity<Voter> addVoter(@RequestBody Voter voter) {
		voterService.addVoter(voter);
		return new ResponseEntity<Voter>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/get-voter-by-epic/{epic}",method=RequestMethod.GET)
	public ResponseEntity<Voter> getVoterByEpic(@PathVariable(name = "epic") String epic) {

		return new ResponseEntity<Voter>(voterService.getVoterByEpic(epic),HttpStatus.OK);
	}
	
	@RequestMapping(path = "/update-voter",method=RequestMethod.PUT)
	public ResponseEntity<Voter> updateVoter(@RequestBody Voter voter) {
		voterService.updateVoter(voter);
		return new ResponseEntity<Voter>(HttpStatus.OK);
	}
	
	@RequestMapping(path = "/get-all-elections", method = RequestMethod.GET)
	public List<Election> getAllElectiones() throws NoSuchRecordException {
		List<Election> list = adminService.getAllElections();
		return list;
	}
	
	@RequestMapping(path = "/get-all-parties", method = RequestMethod.GET)
	public List<Party> getAllParties() throws NoSuchRecordException {
		List<Party> list = adminService.getAllParties();
		return list;
	}
	
	@RequestMapping(path = "/get-all-candidates", method = RequestMethod.GET)
	public List<Candidates> getAllCandidates() throws NoSuchRecordException {
		List<Candidates> list = adminService.getAllCandidates();
		return list;
	}
	
	@RequestMapping(path = "/results/viewAllCandidatesVoteCount", method = RequestMethod.GET)
	public ResponseEntity<String> getCandidatesVoteCount() {
		String result = voterService.viewVoteForAllCandidate();
		ResponseEntity<String> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}
	
}
