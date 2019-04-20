package com.pranavkapoorr.contactbook.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pranavkapoorr.contactbook.model.Contact;

@Component
public interface ContactService {
	public String addContact(Contact contact);
	public String updateContact(Contact contact);
	public List<Contact> listContacts(String sorting);
	public Contact getContactById(int contactId);
	public List<Contact> getContactByOtherFields(String field, String sortField, String sort);
	public String removeContact(int contactId);
}
