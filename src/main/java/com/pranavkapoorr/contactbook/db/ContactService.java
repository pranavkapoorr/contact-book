package com.pranavkapoorr.contactbook.db;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pranavkapoorr.contactbook.model.Contact;

@Component
public interface ContactService {
	public String addContact(Contact contact);
	public String updateContact(Contact contact);
	public List<Contact> listContacts();
	public Contact getContactById(int contactId);
	public List<Contact> getContactByOtherFields(String field);
	public String removeContact(int contactId);
}
