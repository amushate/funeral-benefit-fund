/**
 * 
 */
package org.fbf.dao.repositories;

import java.util.List;

import org.fbf.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author amushate 25 Oct,2017
 */
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

	List<Payment> findByFbfmemberId(Long fbfMemberId);
}
