/**
 * 
 */
package org.fbf.service;

import java.util.List;

import org.fbf.model.ContactUsMessage;

/**
 * @author amushate 23 Oct,2017
 */
public interface ContactUsMessageService {
	
	ContactUsMessage saveMessage(ContactUsMessage message);
	boolean deleteMessage(Long contactUsMessageId);
	ContactUsMessage findMessage(Long contactUsMessageId);
	List<ContactUsMessage> listMessages();
}
