package org.fbf.service;

import java.util.List;

import org.fbf.model.Permission;

public interface PermissionService {

	Permission createPermission(Permission permision);

	List<Permission> listPermissions();

	Permission findPermission(String role);

}
