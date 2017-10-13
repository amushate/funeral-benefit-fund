/**
 * 
 */
package org.fbf.api.controller;

import java.util.List;

import org.fbf.model.FBFBoardMember;
import org.fbf.service.FBFBoardMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author amushate 13 Oct,2017
 */
@RestController
@RequestMapping("/api/board-members")
public class FBFBoardMemberController {

	@Autowired
	public FBFBoardMemberService boardMemberService;
	
	@GetMapping
	public List<FBFBoardMember> listBoardMembers(){
		return boardMemberService.getFBFBoardMembers();		
	}
	
	@PostMapping
	public FBFBoardMember createBoardMember(FBFBoardMember boardMember){		
		return boardMemberService.createMember(boardMember);		
	}
	
	@PutMapping(path="/{fbfBoardMemberId}")
	public FBFBoardMember updateBoardMember(@RequestBody FBFBoardMember boardMember, @PathVariable final Long fbfBoardMemberId){		
		return boardMemberService.updateBoardMember(boardMember, fbfBoardMemberId);		
	}
}
