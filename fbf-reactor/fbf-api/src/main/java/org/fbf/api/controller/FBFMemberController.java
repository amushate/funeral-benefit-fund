package org.fbf.api.controller;

import java.util.List;

import org.fbf.model.FBFMember;
import org.fbf.service.FBFMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author amushate 28 Sep,2017
 */
@RestController
@RequestMapping(value = "/members")
public class FBFMemberController {

	@Autowired
	private FBFMemberService service;

	@PostMapping
	public FBFMember createMember(@RequestBody final FBFMember fbfMember) {
		return service.createMember(fbfMember);
	}
	
	@PutMapping
	public FBFMember updateMember(@RequestBody final FBFMember fbfMember){
		return service.updateMember(fbfMember);
	}

	@DeleteMapping
	public boolean deleteMember(@PathVariable final Long fbfMemberId){
		return service.deleteMember(fbfMemberId);
	}
	
	@GetMapping(path="/{fbfMemberId}")
	public FBFMember findMember(@PathVariable final Long fbfMemberId){
		return service.findMember(fbfMemberId);
	}
	
	@GetMapping(path = "/active-members")
	public List<FBFMember> getActiveMembers() {
		return service.getActiveMembers();
	}

}
