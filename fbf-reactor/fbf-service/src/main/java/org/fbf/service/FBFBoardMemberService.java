/**
 * 
 */
package org.fbf.service;

import java.util.List;

import org.fbf.model.FBFBoardMember;

/**
 * @author amushate 13 Oct,2017
 */
public interface FBFBoardMemberService {

	List<FBFBoardMember> getFBFBoardMembers();

	FBFBoardMember createMember(FBFBoardMember boardMember);
	
	FBFBoardMember updateBoardMember(FBFBoardMember boardMember,Long fbfBoardMemberId);
}
