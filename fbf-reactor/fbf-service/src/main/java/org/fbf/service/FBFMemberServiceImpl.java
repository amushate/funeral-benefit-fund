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

/**
 * @author amushate 29 Sep,2017
 */

public class FBFMemberServiceImpl implements FBFMemberService {

	private FBFMemberRepository fbfMemberRepository;
	
	public FBFMemberServiceImpl(final FBFMemberRepository fbfMemberRepository){
		this.fbfMemberRepository=fbfMemberRepository;
	}
	
	public FBFMember createMember(FBFMember fbfMember) {
		if(fbfMember==null){
			throw new FBFMemberIllegalArgumentException(String.format("Member cannot be null"));
		}
		if(verifyMemberExists(fbfMember.getNationalId())){
			throw new FBFMemberDuplicateException(String.format("Member with national id '%s' already exists",fbfMember.getNationalId()));
		}
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

}
