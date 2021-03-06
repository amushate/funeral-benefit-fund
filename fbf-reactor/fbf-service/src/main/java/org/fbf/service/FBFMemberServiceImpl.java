/**
 * 
 */
package org.fbf.service;

import java.util.List;

import org.fbf.model.FBFMember;
import org.fbf.dao.repositories.FBFMemberRepository;
import org.fbf.enums.MemberStatus;
import org.fbf.service.exception.FBFMemberDuplicateException;
import org.fbf.service.exception.FBFMemberIllegalArgumentException;
import org.fbf.service.exception.FBFMemberResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author amushate 29 Sep,2017
 */
@Service
@Transactional
public class FBFMemberServiceImpl implements FBFMemberService {

	@Autowired
	private FBFMemberRepository fbfMemberRepository;
		
	public FBFMember createMember(FBFMember fbfMember) {
		if(fbfMember==null){
			throw new FBFMemberIllegalArgumentException("Member cannot be null");
		}
		if(verifyMemberExists(fbfMember.getNationalId())){
			throw new FBFMemberDuplicateException(String.format("Member with national id '%s' already exists",fbfMember.getNationalId()));
		}
		fbfMember.setMemberStatus(MemberStatus.PA);
		return fbfMemberRepository.save(fbfMember);
	}	

	public List<FBFMember> getActiveMembers() {
		List<FBFMember>fbfMembers=fbfMemberRepository.findByMemberStatus(MemberStatus.ACTIVE);
		if(fbfMembers==null || fbfMembers.isEmpty()){
			throw new FBFMemberResourceNotFoundException("No Active members found");
		}
		return fbfMembers;
	}

	public FBFMember updateMember(FBFMember rawFbfMember) {
		FBFMember member = findMember(rawFbfMember.getFbfMemberId());
		member.setDob(rawFbfMember.getDob());
		member.setEmployeeId(rawFbfMember.getEmployeeId());
		member.setFirstName(rawFbfMember.getFirstName());
		member.setSurname(rawFbfMember.getSurname());
		member.setGender(rawFbfMember.getGender());
		member.setNationalId(rawFbfMember.getNationalId());
		return fbfMemberRepository.save(member);
	}

	public boolean deleteMember(Long fbfMemberId) {	
		fbfMemberRepository.delete(findMember(fbfMemberId));
		return true;
	}

	public FBFMember findMember(Long fbfMemberId) {
		FBFMember fbfMember = fbfMemberRepository.findOne(fbfMemberId);
		if(fbfMember==null){
			throw new FBFMemberResourceNotFoundException("Member with member Id: "+fbfMemberId+" not found.");
		}
		return fbfMember;
	}
	
	private boolean verifyMemberExists(String nationalId) {
		FBFMember fbfMember = fbfMemberRepository.findByNationalId(nationalId);
		if(fbfMember==null){
			return false;
		}
		return true;
	}

	@Override
	public List<FBFMember> listMembers() {
		 List<FBFMember> fbfMembers = fbfMemberRepository.findAll();
		if(fbfMembers==null || fbfMembers.isEmpty()){
			throw new FBFMemberResourceNotFoundException("No Members found");
		}
		return fbfMembers;
	}

}
