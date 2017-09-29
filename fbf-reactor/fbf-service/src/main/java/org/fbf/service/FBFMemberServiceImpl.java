/**
 * 
 */
package org.fbf.service;

import java.util.List;

import org.fbf.model.FBFMember;
import org.fbf.dao.repositories.FBFMemberRepository;
import org.fbf.service.exception.FBFMemberDuplicateException;
import org.fbf.service.exception.FBFMemberIllegalArgumentException;

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

	/*
	 * (non-Javadoc)
	 * @see org.fbf.service.FBFMemberService#getActiveMembers()
	 */
	public List<FBFMember> getActiveMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.fbf.service.FBFMemberService#updateMember(org.fbf.model.FBFMember)
	 */
	public FBFMember updateMember(FBFMember fbfMember) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.fbf.service.FBFMemberService#deleteMember(int)
	 */
	public boolean deleteMember(int fbfMemberId) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.fbf.service.FBFMemberService#findMember(int)
	 */
	public FBFMember findMember(int fbfMemberId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean verifyMemberExists(String nationalId) {
		// TODO Auto-generated method stub
		return false;
	}

}
