package com.pranavkapoorr.contactbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranavkapoorr.contactbook.db.ContactDao;
import com.pranavkapoorr.contactbook.model.Contact;

@Service
public class ContactServiceImp implements ContactService{
	@Autowired
	ContactDao contactDao;
	
	@Override
	public String addContact(Contact contact) {
		return contactDao.addContact(contact);
	}

	@Override
	public String updateContact(Contact contact) {
		return contactDao.updateContact(contact);
	}

	@Override
	public List<Contact> listContacts(String sorting) {
		return contactDao.listContacts(sorting);
	}

	@Override
	public Contact getContactById(int contactId) {
		return contactDao.getContactById(contactId);
	}

	@Override
	public String removeContact(int contactId) {
		return contactDao.removeContact(contactId);
	}

	@Override
	public List<Contact> getContactByOtherFields(String field, String sortField, String sort) {
		return contactDao.getContactByOtherFields(field,sortField,sort);
	}


}
