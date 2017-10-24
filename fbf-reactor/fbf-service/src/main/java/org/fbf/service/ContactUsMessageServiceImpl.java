/**
 * 
 */
package org.fbf.service;

import java.util.List;

import org.fbf.dao.repositories.ContactUsMessageRepository;
import org.fbf.model.ContactUsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author amushate
 * 23 Oct,2017
 */
@Service
public class ContactUsMessageServiceImpl implements ContactUsMessageService {

	@Autowired
	private ContactUsMessageRepository contactUsMessageRepository;
	
	@Override
	public ContactUsMessage saveMessage(ContactUsMessage message) {
		return contactUsMessageRepository.save(message);
	}

	@Override
	public boolean deleteMessage(Long contactUsMessageId) {
		ContactUsMessage message = contactUsMessageRepository.findOne(contactUsMessageId);
		try{
			contactUsMessageRepository.delete(message);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public ContactUsMessage findMessage(Long contactUsMessageId) {
		return contactUsMessageRepository.findOne(contactUsMessageId);
	}

	@Override
	public List<ContactUsMessage> listMessages() {
		return contactUsMessageRepository.findAll();
	}

}
