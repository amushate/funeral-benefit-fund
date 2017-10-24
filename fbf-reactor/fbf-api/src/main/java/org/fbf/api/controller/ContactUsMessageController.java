/**
 * 
 */
package org.fbf.api.controller;

import java.util.List;

import org.fbf.model.ContactUsMessage;
import org.fbf.service.ContactUsMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author amushate 23 Oct,2017
 */
@RestController
@RequestMapping(value = "/api/contact-us")
public class ContactUsMessageController {

	@Autowired
	private ContactUsMessageService contactUsMessageService;

	@PostMapping
	public ContactUsMessage saveMessage(@RequestBody ContactUsMessage contactUsMessage) {
		return contactUsMessageService.saveMessage(contactUsMessage);
	}

	@GetMapping(path = "/{contactUsMessageId}")
	public ContactUsMessage findMessage(@PathVariable Long contactUsMessageId) {
		return contactUsMessageService.findMessage(contactUsMessageId);
	}

	@DeleteMapping(path = "/{contactUsMessageId}")
	public boolean deleteMessage(@PathVariable Long contactUsMessageId) {
		return contactUsMessageService.deleteMessage(contactUsMessageId);
	}
	
	@GetMapping
	public List<ContactUsMessage> listMessages() {
		return contactUsMessageService.listMessages();
	}

}
