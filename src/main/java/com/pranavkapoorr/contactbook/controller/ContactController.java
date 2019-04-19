package com.pranavkapoorr.contactbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pranavkapoorr.contactbook.db.ContactService;
import com.pranavkapoorr.contactbook.model.Contact;


@RestController
public class ContactController {
	@Autowired
	ContactService service;
	int id = 0;
	
	@RequestMapping(path = "/contacts",method = RequestMethod.GET)
	public List<Contact> getContacts() {
		return service.listContacts();
	}
	
	@RequestMapping(path = "/contact",method = RequestMethod.GET)
	public Contact getContactById(@RequestParam(value="cid", defaultValue="1")int cid) {
		return service.getContactById(cid);
	}
	
	@RequestMapping(path = "/contact/{field}",method = RequestMethod.GET)
	public List<Contact> getContactByFirstName(@PathVariable(value="field")String field) {
		return service.getContactByOtherFields(field);
	}
	
	@RequestMapping(path = "/contact",method = RequestMethod.POST,consumes = "application/json")
	public String addContact(@RequestBody(required = true) Contact contact) {
		contact.setId(id);
		id++;
		return service.addContact(contact);
	}
	
	@RequestMapping(path = "/contact",method = RequestMethod.DELETE,consumes = "application/json")
	public String removeContact(@RequestBody(required = true) int contactId) {
		return service.removeContact(contactId);
	}
	
	@RequestMapping(path = "/contact",method = RequestMethod.PUT,consumes = "application/json")
	public String updateContact(@RequestBody(required = true) Contact contact) {
		return service.updateContact(contact);
	}
}
