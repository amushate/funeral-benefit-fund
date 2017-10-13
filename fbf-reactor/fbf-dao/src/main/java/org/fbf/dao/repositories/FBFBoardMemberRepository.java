/**
 * 
 */
package org.fbf.dao.repositories;

import org.fbf.model.FBFBoardMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author amushate
 * 13 Oct,2017
 */
@Repository
public interface FBFBoardMemberRepository extends JpaRepository<FBFBoardMember, Long> {

}
