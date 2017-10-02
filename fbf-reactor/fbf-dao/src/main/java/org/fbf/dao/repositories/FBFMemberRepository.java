/**
 * 
 */
package org.fbf.dao.repositories;

import java.util.List;

import org.fbf.enums.MemberStatus;
import org.fbf.model.FBFMember;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author amushate 29 Sep,2017
 */
public interface FBFMemberRepository extends JpaRepository<FBFMember, Long> {

	List<FBFMember> findByMemberStatus(MemberStatus memberStatus);
	FBFMember findByNationalId(String nationalId);
}
