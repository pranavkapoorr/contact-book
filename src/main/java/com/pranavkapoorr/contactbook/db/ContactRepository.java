package com.pranavkapoorr.contactbook.db;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import com.pranavkapoorr.contactbook.model.Contact;
import com.pranavkapoorr.contactbook.utilities.ContactUtils;

@Repository
public class ContactRepository implements ContactDao{
	private static List<Contact> contacts;
	private int id = 0;
	
	public ContactRepository() {
		contacts = new ArrayList<Contact>();
		//contacts.add(new Contact(1,"Pranav","Kapoor","6476337891","6479937891","1665 Clark Blvd","11:30:11","12:30:44"));
		//contacts.add(new Contact(2,"Sundar","Pichai","7488706094","7488706098","1402 Beverly Hills","11:30:20","12.30:50"));
	}
	
	@Override
	public String addContact(Contact contact) {
		contact.setCreatedTime(getCurrentTimeStamp());//adding created time
		boolean result = false;
		contact.setId(id);
		id++;
		result = contacts.add(contact);
		return !result?"Failed to Add":"Added Successfully!";
	}

	@Override
	public String updateContact(Contact contact) {
		Contact originalContact = contacts.stream().filter(c->c.getId()==contact.getId()).findAny().orElse(null);
		boolean result = false;
		int index = contacts.indexOf(originalContact);
		if(index != -1) {
			contact.setCreatedTime(originalContact.getCreatedTime());
			result = true;
			contact.setUpdatedTime(getCurrentTimeStamp());//setting update time
			contacts.set(index, contact);
		}
		return !result?"Requested Contact doesn't exist!":"Updated Successfully!";
	}

	@Override
	public List<Contact> listContacts(String sort) {
		List<Contact> tempList = contacts;
		if(sort.equalsIgnoreCase("asc")) {
			Collections.sort(tempList,ContactUtils.firstNameComparatorAsc);
		}else if(sort.equalsIgnoreCase("desc")) {
			Collections.sort(tempList,ContactUtils.firstNameComparatorDesc);
		}
		return tempList;
	}

	@Override
	public Contact getContactById(int contactId) {
		return contacts.stream().filter(c->c.getId()==contactId).findAny().orElse(null);
	}

	@Override
	public String removeContact(int contactId) {
		Contact contact = contacts.stream().filter(c->c.getId()==contactId).findAny().orElse(null);
		boolean result = false;
		if(contact!=null) {
			result = contacts.remove(contact);
		}
		return !result?"Failed to Delete":"Deleted Successfully!";
	}
	
	private String getCurrentTimeStamp() {
		return new Timestamp(new Date().getTime()).toString();
	}

	@Override
	public List<Contact> getContactByOtherFields(String field, String sortField,String sort) {
		List<Contact> tempList = contacts.stream()
				.filter(c->
				(c.getFirstName().toLowerCase().contains(field.toLowerCase()))//firstname
				||(c.getLastName().toLowerCase().contains(field.toLowerCase()))//lastname
				||(c.getCellPhone().contains(field))//cellphone
				||(c.getHomePhone().contains(field)))//homephone
				.collect(Collectors.toList());
		//sorting if both fields are populated by request
		if(sortField.equalsIgnoreCase("firstname") && sort.equalsIgnoreCase("asc")) {
			Collections.sort(tempList,ContactUtils.firstNameComparatorAsc);
		}else if(sortField.equalsIgnoreCase("firstname") && sort.equalsIgnoreCase("desc")) {
			Collections.sort(tempList,ContactUtils.firstNameComparatorDesc);
		}else if(sortField.equalsIgnoreCase("lastname") && sort.equalsIgnoreCase("asc")) {
			Collections.sort(tempList,ContactUtils.lastNameComparatorAsc);
		}else if(sortField.equalsIgnoreCase("lastname") && sort.equalsIgnoreCase("desc")) {
			Collections.sort(tempList,ContactUtils.lastNameComparatorDesc);
		}else if(sortField.equalsIgnoreCase("cellphone") && sort.equalsIgnoreCase("asc")) {
			Collections.sort(tempList,ContactUtils.cellPhoneComparatorAsc);
		}else if(sortField.equalsIgnoreCase("cellphone") && sort.equalsIgnoreCase("desc")) {
			Collections.sort(tempList,ContactUtils.cellPhoneComparatorDesc);
		}else if(sortField.equalsIgnoreCase("homephone") && sort.equalsIgnoreCase("asc")) {
			Collections.sort(tempList,ContactUtils.homePhoneComparatorAsc);
		}else if(sortField.equalsIgnoreCase("homephone") && sort.equalsIgnoreCase("desc")) {
			Collections.sort(tempList,ContactUtils.homePhoneComparatorDesc);
		}
		return tempList;
	}

}
