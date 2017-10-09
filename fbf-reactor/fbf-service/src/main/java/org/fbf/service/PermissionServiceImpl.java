package org.fbf.service;

import java.util.List;

import org.fbf.dao.repositories.PermissionRepository;
import org.fbf.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author amushate 09 Oct,2017
 */
@Service
public class PermissionServiceImpl implements PermissionService {

	private PermissionRepository permissionRepository;

	@Autowired
	public PermissionServiceImpl(PermissionRepository permissionRepository) {
		this.permissionRepository = permissionRepository;

	}

	@Override
	public Permission createPermission(Permission permission) {
		return permissionRepository.save(permission);
	}

	@Override
	public List<Permission> listPermissions() {
		return permissionRepository.findAll();
	}

	@Override
	public Permission findPermission(String role) {
		return permissionRepository.findOne(role);
	}

}
