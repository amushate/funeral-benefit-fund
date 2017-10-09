package org.fbf.dao.repositories;

import org.fbf.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author amushate 09 Oct,2017
 */
@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {

}
