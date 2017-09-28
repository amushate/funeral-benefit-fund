/**
 * 
 */
package org.fbf.api.controller;

import java.util.List;

import org.fbf.model.Dependant;
import org.fbf.service.DependantService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author amushate 29 Sep,2017
 */
@RestController("/members/{fbfMemberId}/dependants")
public class DependantController {

	private DependantService dependantService;
	public DependantController(final DependantService dependantService) {
		this.dependantService = dependantService;		
	}
	
	@GetMapping(path="/{dependantid}")
	public List<Dependant>findDependantId(@PathVariable Long dependantid){
		return dependantService.findDependantById(dependantid);		
	}
	
	@GetMapping
	public List<Dependant>findDependantsByMemberId(@PathVariable Long fbfMemberId){
		return dependantService.findDependantsByIdMember(fbfMemberId);		
	}
	
	@PostMapping
	public Dependant addDependant(@PathVariable  Long fbfMemberId, @RequestBody final Dependant newdependant){
		return dependantService.addDependant(fbfMemberId,newdependant);		
	}
	
	@DeleteMapping(path="/{dependantid}")
	public Dependant removeDependant(@PathVariable  Long fbfMemberId, @PathVariable  Long dependantid){
		return dependantService.removeDependant(fbfMemberId,dependantid);		
	}
	
	@PutMapping(path="/{dependantid}")
	public Dependant updateDependant(@PathVariable  Long fbfMemberId, @RequestBody final Dependant rawdependant){
		return dependantService.updateDependant(fbfMemberId,rawdependant);		
	}
}
