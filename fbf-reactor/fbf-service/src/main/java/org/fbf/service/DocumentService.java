/**
 * 
 */
package org.fbf.service;

import org.fbf.model.Document;

/**
 * @author amushate 24 Oct,2017
 */
public interface DocumentService {

	Document saveDocument(Document document);
	Document updateDocument(Document document,Long documentId);
	boolean deleteDocument(Long documentId);
}
