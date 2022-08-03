package com.deloitte.spring.boot.project.service;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.spring.boot.project.exception.ElectionAlreadyExistsException;
import com.deloitte.spring.boot.project.exception.InvalidFieldException;
import com.deloitte.spring.boot.project.exception.NoSuchCandidateRecordException;
import com.deloitte.spring.boot.project.exception.NoSuchConstituencyException;
import com.deloitte.spring.boot.project.exception.NoSuchElectionException;
import com.deloitte.spring.boot.project.exception.NoSuchPartyRecordException;
import com.deloitte.spring.boot.project.exception.NoSuchRecordException;
import com.deloitte.spring.boot.project.model.Administrator;
import com.deloitte.spring.boot.project.model.Candidates;
import com.deloitte.spring.boot.project.model.Constituency;
import com.deloitte.spring.boot.project.model.Election;
import com.deloitte.spring.boot.project.model.Party;
import com.deloitte.spring.boot.project.repository.AdministratorRepository;
import com.deloitte.spring.boot.project.repository.CandidateRepository;
import com.deloitte.spring.boot.project.repository.ConstituencyRepository;
import com.deloitte.spring.boot.project.repository.ElectionRepository;
import com.deloitte.spring.boot.project.repository.PartyRepository;

@Service
public class AdministratorService {

	@Autowired
	private AdministratorRepository adminrepository;

	@Autowired
	private ElectionRepository electionRepository;

	@Autowired
	private PartyRepository partyRepository;

	@Autowired
	private CandidateRepository candidateRepository;

	@Autowired
	private ConstituencyRepository constituencyRepository;

	private final Logger Logger = LoggerFactory.getLogger(this.getClass());

//Add Administrator
	public boolean addAdmin(Administrator admin) {
		if (admin.getAdminId() != null && admin.getAdminName() != null && admin.getAdminPassword() != null) {
			boolean result = false;
			String name = admin.getAdminName();
			String regex = "^[A-Za-z ]+";
			if (name.matches(regex)) {
				admin = adminrepository.save(admin);
				result = true;
				if (!admin.getAdminId().isEmpty()) {
					Logger.info("Admin is added successfully");
					return result;
				}
			}
			Logger.error("incorrect details");
			throw new InvalidFieldException("Not able to add admin record");
		}
		throw new InvalidFieldException("Fields are empty");
	}

//Add Election
	public boolean addElection(Election election)
			throws InvalidFieldException, NoSuchElectionException, ElectionAlreadyExistsException {
//
//		boolean result = false;
//
//		if (election.getElectionDate() != null && election.getElectionName() != null) {
//
//			if (electionRepository.findByElectionName(election.getElectionName()) == null) {
//
//				election = electionRepository.save(election);
//				result = true;
//				if (election.getElectionId() != 0) {
//					Logger.info("Election is added");
//					return result;
//				}
//				Logger.error("Not able to add Election record");
//				throw new NoSuchElectionException("Not able to add Election record");
//			}
//			Logger.error("Election Name Already Exists");
//			throw new ElectionAlreadyExistsException("Election Name Already Exists");
//		}
//		Logger.error("Field is Empty");
//		throw new InvalidFieldException("Field is Empty");
		 if(electionRepository.getById(election.getElectionId())!=null) {
	            return false;
	        }
	        electionRepository.save(election);
	        return true;
		
	}

//Get All Elections
	public List<Election> getAllElections() throws NoSuchRecordException {
		List<Election> list = electionRepository.findAll();
		if (!list.isEmpty()) {
			Logger.info("findAllElection");
			return list;
		}
		Logger.error("No List found");
		throw new NoSuchRecordException("No List found");
	}

//Update Election
	public Election updateElection(@Valid Election election) {
		if (electionRepository.existsById(election.getElectionId()))
			return electionRepository.save(election);
		Logger.error("No List found");
		throw new NoSuchRecordException("No List found");
	}

//Delete Election
	public boolean deleteElection(int electionId) throws NoSuchElectionException {
		if (electionRepository.existsById(electionId)) {
			electionRepository.deleteById(electionId);
			Logger.info("deleteElection");
			return true;
		}
		Logger.error("Given id does not exist to delete Election");
		throw new NoSuchElectionException("Given id does not exist to delete Election");
	}

//Get Election By Name
	public List<Election> getElectionByName(String electionName) {
		List<Election> empList = electionRepository.findByElectionName(electionName);
		if (!empList.isEmpty()) {
			return empList;
		} else {
			String errorMessage = "Employee with name " + electionName + " not found.";
			throw new NoSuchElectionException(errorMessage);
		}
	}

//Add Party
	public boolean addParty(Party party)
			throws InvalidFieldException, NoSuchElectionException, ElectionAlreadyExistsException {
//		boolean result = false;
//
//		if (party.getPartyName() != null && party.getLeader() != null) {
//
//			if (partyRepository.findByPartyName(party.getPartyName()) == null) {
//
//				party = partyRepository.save(party);
//				result = true;
//				if (party.getRegId() != null) {
//					Logger.info("Party is added");
//					return result;
//				}
//				Logger.error("Not able to add Party record");
//				throw new NoSuchElectionException("Not able to add Party record");
//			}
//			Logger.error("Party Name Already Exists");
//			throw new ElectionAlreadyExistsException("Party Name Already Exists");
//		}
//		Logger.error("Field is Empty");
//		throw new InvalidFieldException("Field is Empty");
		if(partyRepository.getById(party.getRegId())!=null) {
            return false;
        }
        partyRepository.save(party);
        return true;
	}

//Get All Parties
	public List<Party> getAllParties() throws NoSuchRecordException {
		List<Party> list = partyRepository.findAll();
		if (!list.isEmpty()) {
			Logger.info("findAllParty");
			return list;
		}
		Logger.error("No List found");
		throw new NoSuchRecordException("No List found");
	}

//Get Parties By Name
	public List<Party> getPartiesByName(String partyName) {
		List<Party> empList = partyRepository.findByPartyName(partyName);
		if (!empList.isEmpty()) {
			return empList;
		} else {
			String errorMessage = "Party with name " + partyName + " not found.";
			throw new NoSuchPartyRecordException(errorMessage);
		}
	}

//Update Party
	public Party updateParty(@Valid Party party) {
		if (partyRepository.existsById(party.getRegId()))
			return partyRepository.save(party);
		Logger.error("No List found");
		throw new NoSuchRecordException("No List found");
	}

//Delete Party
	public boolean deleteParty(String regId) throws NoSuchPartyRecordException {
		if (partyRepository.existsById(regId)) {
			partyRepository.deleteById(regId);
			Logger.info("deleteParty");
			return true;
		}
		Logger.error("Given id does not exist to delete Party");
		throw new NoSuchPartyRecordException("Given id does not exist to delete Party");
	}

//Add Candidate
	public boolean addCandidate(Candidates candidate)
			throws InvalidFieldException, NoSuchElectionException, ElectionAlreadyExistsException {
//		boolean result = false;
//
//		if (candidate.getCandidateName() != null && candidate.getConstituencyId() != 0
//				&& candidate.getPartyRegId() != null) {
//
//			if (candidateRepository.findCandidateByName(candidate.getCandidateName().toLowerCase()) == null) {
//
//				candidate = candidateRepository.save(candidate);
//				result = true;
//				if (candidate.getCandidateId() != 0) {
//					Logger.info("candidate is added");
//					return result;
//				}
//				Logger.error("Not able to add candidate record");
//				throw new NoSuchElectionException("Not able to add candidate record");
//			}
//			Logger.error("candidate Name Already Exists");
//			throw new ElectionAlreadyExistsException("candidate Name Already Exists");
//		}
//		Logger.error("Field is Empty");
//		throw new InvalidFieldException("Field is Empty");
		if(candidateRepository.getById(candidate.getCandidateId())!=null) {
            return false;
        }
        candidateRepository.save(candidate);
        return true;
	}

// Get All Candidates
	public List<Candidates> getAllCandidates() throws NoSuchRecordException {
		List<Candidates> list = candidateRepository.findAll();
		if (!list.isEmpty()) {
			Logger.info("findAllCandidates");
			return list;
		}
		Logger.error("No List found");
		throw new NoSuchRecordException("No List found");
	}

//Get Candidate By Name
	public List<Candidates> getCandidateByName(String candidateName) {
		List<Candidates> empList = candidateRepository.findCandidatesByName(candidateName);
		if (!empList.isEmpty()) {
			return empList;
		} else {
			String errorMessage = "Candidate with name " + candidateName + " not found.";
			throw new NoSuchCandidateRecordException(errorMessage);
		}
	}

//Update Candidate
	public Candidates updateCandidate(@Valid Candidates candidate) {
		if (candidateRepository.existsById(candidate.getCandidateId()))
			return candidateRepository.save(candidate);
		Logger.error("No List found");
		throw new NoSuchRecordException("No List found");
	}

//Delete Candidate
	public boolean deleteCandidate(int candidateId) throws NoSuchCandidateRecordException {
		if (candidateRepository.existsById(candidateId)) {
			candidateRepository.deleteById(candidateId);
			Logger.info("deleteCandidate");
			return true;
		}
		Logger.error("Given id does not exist to delete candidate");
		throw new NoSuchCandidateRecordException("Given id does not exist to delete candidate");
	}

// Add Constituency
	public boolean addConstituency(Constituency constituency)
			throws InvalidFieldException, NoSuchElectionException, ElectionAlreadyExistsException {
//		boolean result = false;
//
//		if (constituency.getConstituencyName() != null && constituency.getElectionId() != 0
//				&& constituency.getState() != null) {
//
//			if (constituencyRepository
//					.findConstituencyByName(constituency.getConstituencyName().toLowerCase()) == null) {
//
//				constituency = constituencyRepository.save(constituency);
//				result = true;
//				if (constituency.getConstituencyId() != 0) {
//					Logger.info("constituency is added");
//					return result;
//				}
//				Logger.error("Not able to add constituency record");
//				throw new NoSuchElectionException("Not able to add constituency record");
//			}
//			Logger.error("constituency Name Already Exists");
//			throw new ElectionAlreadyExistsException("constituency Name Already Exists");
//		}
//		Logger.error("Field is Empty");
//		throw new InvalidFieldException("Field is Empty");
		if(constituencyRepository.getById(constituency.getConstituencyId())!=null) {
            return false;
        }
        constituencyRepository.save(constituency);
        return true;
		
	}

//Get All Constituencies
	public List<Constituency> getAllConstituencies() throws NoSuchRecordException {
		List<Constituency> list = constituencyRepository.findAll();
		if (!list.isEmpty()) {
			Logger.info("findAllConstituency");
			return list;
		}
		Logger.error("No List found");
		throw new NoSuchRecordException("No List found");
	}

//Get Constituency By Name
	public List<Constituency> getConstituencyByName(String constituencyName) {
		List<Constituency> List = constituencyRepository.findConstituenciesByName(constituencyName);
		if (!List.isEmpty()) {
			return List;
		} else {
			String errorMessage = "Constituency with name " + constituencyName + " not found.";
			throw new NoSuchConstituencyException(errorMessage);
		}
	}

//Update Constituency
	public Constituency updateConstituency(@Valid Constituency constituency) {
		if (constituencyRepository.existsById(constituency.getConstituencyId()))
			return constituencyRepository.save(constituency);
		Logger.error("No List found");
		throw new NoSuchRecordException("No List found");
	}

//Delete Constituency
	public boolean deleteConstituency(int constituencyId) throws NoSuchConstituencyException {
		if (constituencyRepository.existsById(constituencyId)) {
			constituencyRepository.deleteById(constituencyId);
			Logger.info("deleteConstituency");
			return true;
		}
		Logger.error("Given id does not exist to delete constituency");
		throw new NoSuchConstituencyException("Given id does not exist to delete constituency");
	}

}
