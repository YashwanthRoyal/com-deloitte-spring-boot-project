package com.deloitte.spring.boot.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.spring.boot.project.exception.InvalidFieldException;
import com.deloitte.spring.boot.project.exception.NoSuchRecordException;
import com.deloitte.spring.boot.project.model.Administrator;
import com.deloitte.spring.boot.project.model.Candidates;
import com.deloitte.spring.boot.project.model.Constituency;
import com.deloitte.spring.boot.project.model.Election;
import com.deloitte.spring.boot.project.model.Party;
import com.deloitte.spring.boot.project.service.AdministratorService;

@RestController
@RequestMapping(path = "/admin")
public class AdministratorController {

	@Autowired
	private AdministratorService adminService;

	@RequestMapping(path = "/add-admin", method = RequestMethod.POST)
	public ResponseEntity<String> addAdmin(@RequestBody Administrator admin) throws InvalidFieldException {
		ResponseEntity<String> response = null;
		if (adminService.addAdmin(admin)) {
			response = new ResponseEntity<String>(admin.toString(), HttpStatus.CREATED);
		}
		return response;
	}

	@RequestMapping(path = "/add-election",method=RequestMethod.POST)
	public ResponseEntity<String> addElection(@RequestBody Election election) throws NoSuchRecordException{
		ResponseEntity<String> response = null;
		if (adminService.addElection(election)) {
			response = new ResponseEntity<String>("Election with id " + election.getElectionId() + " successfully added",
					HttpStatus.CREATED);
		}
		return response;
	}

	@RequestMapping(path = "/get-all-elections", method = RequestMethod.GET)
	public List<Election> getAllElectiones() throws NoSuchRecordException {
		List<Election> list = adminService.getAllElections();
		return list;
	}

	@RequestMapping(path = "/get-election-by-name/{electionName}")
	public ResponseEntity<List<Election>> getElectionsByName(@PathVariable(name = "electionName") String electionName) {

		return new ResponseEntity<List<Election>>(adminService.getElectionByName(electionName),HttpStatus.OK);
	}
	

	@RequestMapping(path = "/update-election", method = RequestMethod.PUT)
	public ResponseEntity<Election> updateElection(@Valid @RequestBody Election election) throws NoSuchRecordException {
		ResponseEntity<Election> response = new ResponseEntity<>(election, HttpStatus.CREATED);
		adminService.updateElection(election);
		return response;
	}

	@RequestMapping(path = "/delete-election-by-id/{electionId}")
	public ResponseEntity<String> deleteElection(@PathVariable("electionId") int electionId)
			throws NoSuchRecordException {
		ResponseEntity<String> response = null;
		if (adminService.deleteElection(electionId)) {
			response = new ResponseEntity<String>("Election Deleted", HttpStatus.OK);
		}
		return response;
	}
	
	@RequestMapping(path = "/add-party", method = RequestMethod.POST)
	public ResponseEntity<String> addParty(@RequestBody Party party) throws InvalidFieldException {
		ResponseEntity<String> response = null;
		if (adminService.addParty(party)) {
			response = new ResponseEntity<String>(party.toString(), HttpStatus.CREATED);
		}
		return response;
	}

	@RequestMapping(path = "/get-all-parties", method = RequestMethod.GET)
	public List<Party> getAllParties() throws NoSuchRecordException {
		List<Party> list = adminService.getAllParties();
		return list;
	}

	@RequestMapping(path = "/get-party-by-name/{partyName}")
	public ResponseEntity<List<Party>> getPartiesByName(@PathVariable(name = "partyName") String partyName) {

		return new ResponseEntity<List<Party>>(adminService.getPartiesByName(partyName),HttpStatus.OK);
	}
	

	@RequestMapping(path = "/update-party", method = RequestMethod.PUT)
	public ResponseEntity<Party> updateParty(@Valid @RequestBody Party party) throws NoSuchRecordException {
		ResponseEntity<Party> response = new ResponseEntity<>(party, HttpStatus.CREATED);
		adminService.updateParty(party);
		return response;
	}

	@RequestMapping(path = "/delete-party-by-id/{partyId}")
	public ResponseEntity<String> deleteParty(@PathVariable("partyId") String regId)
			throws NoSuchRecordException {
		ResponseEntity<String> response = null;
		if (adminService.deleteParty(regId)) {
			response = new ResponseEntity<String>("Party Deleted", HttpStatus.OK);
		}
		return response;
	}
	
	@RequestMapping(path = "/add-candidate", method = RequestMethod.POST)
	public ResponseEntity<String> addCandidate(@RequestBody Candidates candidate) throws InvalidFieldException {
		ResponseEntity<String> response = null;
		if (adminService.addCandidate(candidate)) {
			response = new ResponseEntity<String>(candidate.toString(), HttpStatus.CREATED);
		}
		return response;
	}

	@RequestMapping(path = "/get-all-candidates", method = RequestMethod.GET)
	public List<Candidates> getAllCandidates() throws NoSuchRecordException {
		List<Candidates> list = adminService.getAllCandidates();
		return list;
	}

	@RequestMapping(path = "/get-candidate-by-name/{candidateName}")
	public ResponseEntity<List<Candidates>> getCandidatesByName(@PathVariable(name = "candidateName") String candidateName) {

		return new ResponseEntity<List<Candidates>>(adminService.getCandidateByName(candidateName),HttpStatus.OK);
	}
	

	@RequestMapping(path = "/update-candidate", method = RequestMethod.PUT)
	public ResponseEntity<Candidates> updateCandidate(@Valid @RequestBody Candidates candidate) throws NoSuchRecordException {
		ResponseEntity<Candidates> response = new ResponseEntity<>(candidate, HttpStatus.CREATED);
		adminService.updateCandidate(candidate);
		return response;
	}

	@RequestMapping(path = "/delete-candidate-by-id/{candidateId}")
	public ResponseEntity<String> deleteCandidate(@PathVariable("candidateId") int partyRegId)
			throws NoSuchRecordException {
		ResponseEntity<String> response = null;
		if (adminService.deleteCandidate(partyRegId)) {
			response = new ResponseEntity<String>("Candidate Deleted", HttpStatus.OK);
		}
		return response;
	}
	
	@RequestMapping(path = "/add-constituency", method = RequestMethod.POST)
	public ResponseEntity<String> addConstituency(@RequestBody Constituency constituency) throws InvalidFieldException {
		ResponseEntity<String> response = null;
		if (adminService.addConstituency(constituency)) {
			response = new ResponseEntity<String>(constituency.toString(), HttpStatus.CREATED);
		}
		return response;
	}

	@RequestMapping(path = "/get-all-constituencies", method = RequestMethod.GET)
	public List<Constituency> getAllConstituencies() throws NoSuchRecordException {
		List<Constituency> list = adminService.getAllConstituencies();
		return list;
	}

	@RequestMapping(path = "/get-constituency-by-name/{constituencyName}")
	public ResponseEntity<List<Constituency>> getConstituencyByName(@PathVariable(name = "constituencyName") String constituencyName) {

		return new ResponseEntity<List<Constituency>>(adminService.getConstituencyByName(constituencyName),HttpStatus.OK);
	}
	

	@RequestMapping(path = "/update-constituency", method = RequestMethod.PUT)
	public ResponseEntity<Constituency> updateConstituency(@Valid @RequestBody Constituency constituency) throws NoSuchRecordException {
		ResponseEntity<Constituency> response = new ResponseEntity<>(constituency, HttpStatus.CREATED);
		adminService.updateConstituency(constituency);
		return response;
	}

	@RequestMapping(path = "/delete-constituency-by-id/{constituencyId}")
	public ResponseEntity<String> deleteConstituency(@PathVariable("constituencyId") int constituencyId)
			throws NoSuchRecordException {
		ResponseEntity<String> response = null;
		if (adminService.deleteConstituency(constituencyId)) {
			response = new ResponseEntity<String>("Candidate Deleted", HttpStatus.OK);
		}
		return response;
	}

}
