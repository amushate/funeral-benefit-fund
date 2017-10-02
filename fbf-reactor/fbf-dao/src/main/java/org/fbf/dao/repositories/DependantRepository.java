package org.fbf.dao.repositories;

import java.util.List;

import org.fbf.model.Dependant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author amushate 03 Oct,2017
 */
@Repository
public interface DependantRepository extends JpaRepository<Dependant, Long> {
	
	List<Dependant>findByFbfMemberFbfMemberId(Long memberid);
	Dependant findByNationalId(String nationalId);
}
