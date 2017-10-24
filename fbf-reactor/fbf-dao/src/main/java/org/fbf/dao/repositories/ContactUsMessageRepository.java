/**
 * 
 */
package org.fbf.dao.repositories;

import org.fbf.model.ContactUsMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author amushate 23 Oct,2017
 */
@Repository
public interface ContactUsMessageRepository extends JpaRepository<ContactUsMessage, Long> {

}
