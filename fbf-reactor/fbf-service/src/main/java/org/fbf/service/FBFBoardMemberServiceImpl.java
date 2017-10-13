/**
 * 
 */
package org.fbf.service;

import java.util.List;

import org.fbf.dao.repositories.FBFBoardMemberRepository;
import org.fbf.model.FBFBoardMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author amushate 13 Oct,2017
 */
@Service
public class FBFBoardMemberServiceImpl implements FBFBoardMemberService{

	@Autowired
	private FBFBoardMemberRepository fbfBoardMemberRepository;
	
	@Override
	public List<FBFBoardMember> getFBFBoardMembers() {
		return fbfBoardMemberRepository.findAll();
	}

	@Override
	public FBFBoardMember createMember(FBFBoardMember boardMember) {
		return fbfBoardMemberRepository.save(boardMember);
	}

	@Override
	public FBFBoardMember updateBoardMember(FBFBoardMember boardMember, Long fbfBoardMemberId) {
		FBFBoardMember oldboardMember=fbfBoardMemberRepository.findOne(fbfBoardMemberId);
		oldboardMember.setEmail(boardMember.getEmail());
		oldboardMember.setFullName(boardMember.getFullName());
		oldboardMember.setImageUrl(boardMember.getImageUrl());
		oldboardMember.setPhoneNumber(boardMember.getPhoneNumber());
		oldboardMember.setQualities(boardMember.getQualities());
		oldboardMember.setTitle(oldboardMember.getTitle());
		return fbfBoardMemberRepository.save(oldboardMember);
	}
	
}
