/**
 * 
 */
package org.fbf.service;

import java.util.List;

import org.fbf.dao.repositories.DependantRepository;
import org.fbf.model.Dependant;
import org.fbf.model.FBFMember;
import org.fbf.service.exception.FBFMemberDuplicateException;
import org.fbf.service.exception.FBFMemberResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author amushate 29 Sep,2017
 */
@Service
@Transactional
public class DependantServiceImpl implements DependantService {

	@Autowired
	private DependantRepository dependantRepository;
	
	@Autowired
	private FBFMemberService fbfMemberService;
	
	@Override
	public List<Dependant> findDependantsByIdMember(Long fbfMemberId) {
		FBFMember fbfMember = fbfMemberService.findMember(fbfMemberId);
		if(fbfMember==null){
			throw new FBFMemberResourceNotFoundException("FBFMember with id '"+fbfMemberId+"' does not exist.");
		}
		if(fbfMember.getDependants()==null||fbfMember.getDependants().isEmpty()){
			throw new FBFMemberResourceNotFoundException("No dependants found for FBFMember with id '"+fbfMemberId+"'.");
		}
		return fbfMember.getDependants();
	}

	@Override
	public Dependant addDependant(Long fbfMemberId, Dependant newdependant) {
		FBFMember fbfMember = fbfMemberService.findMember(fbfMemberId);
		Dependant dependant = dependantRepository.findByNationalId(newdependant.getNationalId());
		if(dependant!=null){
			throw new FBFMemberDuplicateException(String.format("Dependant with national Id '%s' already exist.",newdependant.getNationalId()));
		}
		newdependant.setFbfMember(fbfMember);		
		return dependantRepository.save(newdependant);
	}

	@Override
	public Dependant removeDependant(Long dependantid) {
		Dependant dependant = findDependantById(dependantid);
		dependantRepository.delete(dependant);
		return dependant;
	}

	@Override
	public Dependant updateDependant(Dependant rawdependant) {
		Dependant dependant = findDependantById(rawdependant.getDependantId());
		dependant.setDob(rawdependant.getDob());
		dependant.setName(rawdependant.getName());
		dependant.setSurname(rawdependant.getSurname());
		dependant.setRelationShipType(rawdependant.getRelationShipType());
		return dependantRepository.save(dependant);
	}

	@Override
	public Dependant findDependantById(Long dependantid) {
		Dependant dependant = dependantRepository.findOne(dependantid);
		if(dependant==null){
			throw new FBFMemberResourceNotFoundException("Cannot find dependent with dependant ID:"+dependantid);
		}
		return dependant;
	}

	@Override
	public List<Dependant> listDependants() {
		List<Dependant>dependants=dependantRepository.findAll();
		if(dependants==null){
			throw new FBFMemberResourceNotFoundException("No dependants found");
		}
		return dependants;
	}

}
