/**
 * 
 */
package org.fbf.api.controller;

import java.util.List;

import org.fbf.model.Permission;
import org.fbf.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author amushate 09 Oct,2017
 */
@RestController
@RequestMapping("/permissions")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;
	
	@PostMapping
	public Permission createPermission(@RequestBody Permission permision){
		return permissionService.createPermission(permision);		
	}
	
	@GetMapping
	public List<Permission> listPermissions(){
		return permissionService.listPermissions();
	}
	
	@GetMapping("/{role}")
	public Permission findPermission(@PathVariable String role){
		return permissionService.findPermission(role);
	}

}
