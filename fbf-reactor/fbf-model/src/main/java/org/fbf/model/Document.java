/**
 * 
 */
package org.fbf.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.fbf.enums.DocumentType;

/**
 * @author amushate 19 Oct,2017
 */
@Entity
@Access(AccessType.PROPERTY)
public class Document {

	private Long documentId;
	private String documentName;
	private DocumentType documentType;
	private Long documentOwnerId;
	private String documentUrl;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public Long getDocumentOwnerId() {
		return documentOwnerId;
	}

	public void setDocumentOwnerId(Long documentOwnerId) {
		this.documentOwnerId = documentOwnerId;
	}

	public String getDocumentUrl() {
		return documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}

}
