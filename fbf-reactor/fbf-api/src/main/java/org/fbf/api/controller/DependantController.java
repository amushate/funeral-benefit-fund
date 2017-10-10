/**
 * 
 */
package org.fbf.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.fbf.api.ui.model.UIDependant;
import org.fbf.model.Dependant;
import org.fbf.service.DependantService;
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
 * @author amushate 29 Sep,2017
 */
@RestController
@RequestMapping(value = "/api/dependants")
public class DependantController {

	@Autowired
	private DependantService dependantService;
	
	@Autowired
	private DozerBeanMapper mapper;
		
	@GetMapping(path="/{dependantid}")
	public UIDependant findDependantId(@PathVariable Long dependantid){
		return mapper.map(dependantService.findDependantById(dependantid),UIDependant.class);		
	}
	
	@GetMapping
	public List<UIDependant>listDependants(){
		List<Dependant> listDependants = dependantService.listDependants();	
		List<UIDependant>uiDependants=new ArrayList<>();
		listDependants.stream().forEach(dependant->{
			uiDependants.add(mapper.map(dependant, UIDependant.class));
		});
		return uiDependants;
	}
	
	@GetMapping(path="/members/{fbfMemberId}")
	public List<UIDependant>findDependantsByMemberId(@PathVariable Long fbfMemberId){
		List<Dependant> listDependants = dependantService.findDependantsByIdMember(fbfMemberId);	
		List<UIDependant>uiDependants=new ArrayList<>();
		listDependants.stream().forEach(dependant->{
			uiDependants.add(mapper.map(dependant, UIDependant.class));
		});
		return uiDependants;
	}
	
	@PostMapping
	public UIDependant addDependant(@PathVariable  Long fbfMemberId, @RequestBody final Dependant newdependant){
		return mapper.map(dependantService.addDependant(fbfMemberId,newdependant),UIDependant.class);
	}
	
	@DeleteMapping(path="/{dependantid}")
	public UIDependant removeDependant(@PathVariable  Long dependantid){
		return mapper.map(dependantService.removeDependant(dependantid),UIDependant.class);
	}
	
	@PutMapping(path="/{dependantid}")
	public UIDependant updateDependant( @RequestBody final Dependant rawdependant){
		return mapper.map(dependantService.updateDependant(rawdependant),UIDependant.class);		
	}
}
