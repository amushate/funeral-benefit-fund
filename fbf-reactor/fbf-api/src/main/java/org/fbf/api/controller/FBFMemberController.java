package org.fbf.api.controller;

import java.util.List;

import org.fbf.model.FBFMember;
import org.fbf.service.FBFMemberService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author amushate 28 Sep,2017
 */
@RestController("/members")
public class FBFMemberController {

	private FBFMemberService service;

	public FBFMemberController(FBFMemberService service) {
		this.service = service;
	}

	@PostMapping
	public FBFMember createMember(@RequestBody final FBFMember fbfMember) {
		FBFMember createMember = service.createMember(fbfMember);
		return createMember;
	}
	
	@PutMapping
	public FBFMember updateMember(@RequestBody final FBFMember fbfMember){
		return service.updateMember(fbfMember);
	}

	@DeleteMapping
	public boolean deleteMember(@RequestBody final int fbfMemberId){
		return service.deleteMember(fbfMemberId);
	}
	
	@GetMapping(path="/{fbfMemberId}")
	public FBFMember findMember(@RequestBody final int fbfMemberId){
		return service.findMember(fbfMemberId);
	}
	
	@GetMapping(path = "/active-members")
	public List<FBFMember> getActiveMembers() {
		return service.getActiveMembers();
		/*
		 * List<FBFMember> list=new ArrayList<FBFMember>();
		 * 
		 * FBFMember fbfMember = new FBFMember();
		 * fbfMember.setFirstName("Anesu"); fbfMember.setSurname("Mushate");
		 * fbfMember.setMemberStatus(MemberStatus.ACTIVE); list.add(fbfMember);
		 * 
		 * FBFMember fbfMember2 = new FBFMember();
		 * fbfMember2.setFirstName("Anesu"); fbfMember2.setSurname("Mushate");
		 * fbfMember2.setMemberStatus(MemberStatus.ACTIVE);
		 * list.add(fbfMember2); return list;
		 */
	}

}
