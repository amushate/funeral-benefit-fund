/**
 * 
 */
package org.fbf.service;

import org.fbf.dao.repositories.DocumentRepository;
import org.fbf.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author amushate 24 Oct,2017
 */
@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository documentRepository;

	@Override
	public Document saveDocument(Document document) {
		return documentRepository.save(document);
	}

	@Override
	public Document updateDocument(Document document, Long documentId) {
		Document oldDocument = documentRepository.findOne(documentId);
		oldDocument.setDocumentName(document.getDocumentName());
		oldDocument.setDocumentOwnerId(document.getDocumentOwnerId());
		oldDocument.setDocumentType(document.getDocumentType());
		oldDocument.setDocumentUrl(document.getDocumentUrl());
		return documentRepository.save(oldDocument);
	}

	@Override
	public boolean deleteDocument(Long documentId) {
		Document document = documentRepository.findOne(documentId);
		try {
			documentRepository.delete(document);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
