package org.fbf.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.fbf.api.ui.model.UIFBFMember;
import org.fbf.model.FBFMember;
import org.fbf.service.FBFMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping(value = "/api/members")
public class FBFMemberController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FBFMemberController.class);
	
	
	@Autowired
	private FBFMemberService service;

	@Autowired
	private DozerBeanMapper mapper;

	@PostMapping
	public UIFBFMember createMember(@RequestBody final FBFMember fbfMember) {
		FBFMember createMember = service.createMember(fbfMember);
		return mapper.map(createMember, UIFBFMember.class);
	}

	@PutMapping(path="/{fbfMemberId}")
	public UIFBFMember updateMember(@RequestBody final FBFMember fbfMember,@PathVariable Long fbfMemberId) {
		LOGGER.debug("FBFMEMBER---------------------{}", fbfMember);
		FBFMember updateMember = service.updateMember(fbfMember);
		return mapper.map(updateMember, UIFBFMember.class);

	}

	@DeleteMapping
	public boolean deleteMember(@PathVariable final Long fbfMemberId) {
		return service.deleteMember(fbfMemberId);
	}

	@GetMapping(path = "/{fbfMemberId}")
	// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public UIFBFMember findMember(@PathVariable final Long fbfMemberId) {
		FBFMember findMember = service.findMember(fbfMemberId);
		return mapper.map(findMember, UIFBFMember.class);
	}

	@GetMapping
	public List<UIFBFMember> listMembers() {
		List<UIFBFMember>uifbfMembers=new ArrayList<>();
		service.listMembers().stream().forEach(member-> uifbfMembers.add(mapper.map(member, UIFBFMember.class))
		);
		return uifbfMembers;
	}
	
	@GetMapping(path = "/active-members")
	public List<UIFBFMember> getActiveMembers() {
		List<UIFBFMember>uifbfMembers=new ArrayList<>();
		service.getActiveMembers().stream().forEach(member-> uifbfMembers.add(mapper.map(member, UIFBFMember.class))
		);
		return uifbfMembers;
	}

}
