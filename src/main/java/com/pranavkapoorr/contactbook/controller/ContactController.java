package com.pranavkapoorr.contactbook.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pranavkapoorr.contactbook.model.Contact;
import com.pranavkapoorr.contactbook.service.ContactService;


@RestController
public class ContactController {
	@Autowired
	ContactService service;

	@RequestMapping(path = "/contacts",method = RequestMethod.GET)
	public List<Contact> getContacts(@RequestParam(value="sort", defaultValue="")String sort) {
		return service.listContacts(sort);
	}

	@RequestMapping(path = "/contact",method = RequestMethod.GET)
	public Contact getContactById(@RequestParam(value="cid", defaultValue="1")int cid) {
		return service.getContactById(cid);
	}

	@RequestMapping(path = "/contact/{field}",method = RequestMethod.GET)
	public List<Contact> getContactByOtherFields(@PathVariable(value="field")String field,
			@RequestParam(value="sortfield", defaultValue="")String sortField, 
			@RequestParam(value="sort", defaultValue="")String sort) {
		return service.getContactByOtherFields(field,sortField,sort);
	}

	@RequestMapping(path = "/contact",method = RequestMethod.POST,consumes = "application/json")
	public String addContact(@RequestBody(required = true) Contact contact) {
		return service.addContact(contact);
	}

	@RequestMapping(path = "/contact/{contactId}",method = RequestMethod.DELETE,consumes = "application/json")
	public String removeContact(@PathVariable(name = "contactId") int contactId) {
		return service.removeContact(contactId);
	}

	@RequestMapping(path = "/contact",method = RequestMethod.PUT,consumes = "application/json")
	public String updateContact(@RequestBody(required = true) Contact contact) {
		return service.updateContact(contact);
	}
}
