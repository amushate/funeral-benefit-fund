/**
 * 
 */
package org.fbf.service;

import java.util.List;

import org.fbf.dao.repositories.FBFBoardMemberRepository;
import org.fbf.model.FBFBoardMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author amushate 13 Oct,2017
 */
@Service
@Transactional
public class FBFBoardMemberServiceImpl implements FBFBoardMemberService{

	private static final Logger LOGGER = LoggerFactory.getLogger(FBFBoardMemberServiceImpl.class);
	@Autowired
	private FBFBoardMemberRepository fbfBoardMemberRepository;
	
	@Override
	public List<FBFBoardMember> getFBFBoardMembers() {
		return fbfBoardMemberRepository.findAll();
	}

	@Override
	public FBFBoardMember createMember(FBFBoardMember boardMember) {
		LOGGER.debug("boardMember---------------{}",boardMember);
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
