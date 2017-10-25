/**
 * 
 */
package org.fbf.dao.repositories;

import org.fbf.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author amushate 24 Oct,2017
 */
@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>{

}
