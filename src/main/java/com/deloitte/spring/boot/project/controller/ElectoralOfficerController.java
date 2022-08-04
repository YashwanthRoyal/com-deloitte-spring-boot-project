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

import com.deloitte.spring.boot.project.model.Voter;
import com.deloitte.spring.boot.project.exception.NoSuchRecordException;
import com.deloitte.spring.boot.project.model.Candidates;
import com.deloitte.spring.boot.project.model.Constituency;
import com.deloitte.spring.boot.project.model.Election;
import com.deloitte.spring.boot.project.model.ElectoralOfficer;
import com.deloitte.spring.boot.project.model.Party;
import com.deloitte.spring.boot.project.model.Vote;
import com.deloitte.spring.boot.project.service.*;

@RestController
@RequestMapping(path = "e-voting/eo")
public class ElectoralOfficerController {
	
	@Autowired
	private ElectoralOfficerService eoService;
	
	@Autowired
	private AdministratorService adminService;
	
	@RequestMapping(path = "/add-eo",method=RequestMethod.POST)
	public ResponseEntity<String> addEO(@RequestBody ElectoralOfficer eo) throws NoSuchRecordException {
		ResponseEntity<String> response = null;
		if (eoService.addEO(eo)) {
			response = new ResponseEntity<String>(eo.toString(), HttpStatus.CREATED);
		}
		return response;
	}
	
	@RequestMapping(path = "/get-all-voters",method=RequestMethod.GET)
	public ResponseEntity<List<Voter>> getAllVoters() throws NoSuchRecordException {
		List<Voter> result = eoService.getAllVoters();
		ResponseEntity<List<Voter>> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}
	
	@RequestMapping(path = "/get-voter-by-id/{vid}",method=RequestMethod.GET)
	public ResponseEntity<Voter> getVoterById(@PathVariable (name="vid") String epic) throws NoSuchRecordException {
		Voter result = eoService.getVoterById(epic);
		ResponseEntity<Voter> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
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
	
	@RequestMapping(path = "/get-all-constituencies", method = RequestMethod.GET)
	public List<Constituency> getAllConstituencies() throws NoSuchRecordException {
		List<Constituency> list = adminService.getAllConstituencies();
		return list;
	}
	
	@RequestMapping(path = "/view-all-votes", method = RequestMethod.GET)
	public ResponseEntity<List<Vote>> getAllVotes() throws NoSuchRecordException {
		List<Vote> result = eoService.getAllVotes();
		ResponseEntity<List<Vote>> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}

}
