package org.fbf.service;

import java.util.List;

import org.fbf.model.FBFMember;

/**
 * 
 * @author amushate 29 Sep,2017
 */
public interface FBFMemberService {

	FBFMember createMember(FBFMember fbfMember);

	List<FBFMember> getActiveMembers();

	FBFMember updateMember(FBFMember fbfMember);

	boolean deleteMember(Long fbfMemberId);

	FBFMember findMember(Long fbfMemberId);

	List<FBFMember> listMembers();

}
