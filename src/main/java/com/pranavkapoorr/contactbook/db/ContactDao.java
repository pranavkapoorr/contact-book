package com.pranavkapoorr.contactbook.db;

import java.util.List;

import org.springframework.stereotype.Component;

import com.pranavkapoorr.contactbook.model.Contact;

@Component
public interface ContactDao {
	public String addContact(Contact contact);
	public String updateContact(Contact contact);
	public List<Contact> listContacts(String sort);
	public Contact getContactById(int contactId);
	public List<Contact> getContactByOtherFields(String field,String sortField,String sorting);
	public String removeContact(int contactId);
}
