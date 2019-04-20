package com.pranavkapoorr.contactbook.utilities;

import java.util.Comparator;

import com.pranavkapoorr.contactbook.model.Contact;

public class ContactUtils {
	public static Comparator<Contact> firstNameComparatorAsc = new Comparator<Contact>() {         
		@Override         
		public int compare(Contact c1, Contact c2) {             
			return (int) (c1.getFirstName().compareTo(c2.getFirstName()));         
		}     
	};

	public static Comparator<Contact> firstNameComparatorDesc = new Comparator<Contact>() {         
		@Override         
		public int compare(Contact c1, Contact c2) {             
			return (int) (c2.getFirstName().compareTo(c1.getFirstName()));         
		}     
	};

	public static Comparator<Contact> lastNameComparatorAsc = new Comparator<Contact>() {         
		@Override         
		public int compare(Contact c1, Contact c2) {             
			return (int) (c1.getLastName().compareTo(c2.getLastName()));         
		}     
	};

	public static Comparator<Contact> lastNameComparatorDesc = new Comparator<Contact>() {         
		@Override         
		public int compare(Contact c1, Contact c2) {             
			return (int) (c2.getLastName().compareTo(c1.getLastName()));         
		}     
	};

	public static Comparator<Contact> cellPhoneComparatorDesc = new Comparator<Contact>() {         
		@Override         
		public int compare(Contact c1, Contact c2) {  
			long c1Phone = Long.parseLong(c1.getCellPhone());
			long c2Phone = Long.parseLong(c2.getCellPhone());

			return (c2Phone < c1Phone ? -1 :                     
				(c2Phone == c1Phone ? 0 : 1));           
		}     
	};
	public static Comparator<Contact> cellPhoneComparatorAsc = new Comparator<Contact>() {         
		@Override         
		public int compare(Contact c1, Contact c2) {  
			long c1Phone = Long.parseLong(c1.getCellPhone());
			long c2Phone = Long.parseLong(c2.getCellPhone());

			return (c2Phone < c1Phone ? 1 :                     
				(c2Phone == c1Phone ? 0 : -1));           
		}     
	};  
	public static Comparator<Contact> homePhoneComparatorDesc = new Comparator<Contact>() {         
		@Override         
		public int compare(Contact c1, Contact c2) {  
			long c1Phone = Long.parseLong(c1.getHomePhone());
			long c2Phone = Long.parseLong(c2.getHomePhone());

			return (c2Phone < c1Phone ? -1 :                     
				(c2Phone == c1Phone ? 0 : 1));           
		}     
	};

	public static Comparator<Contact> homePhoneComparatorAsc = new Comparator<Contact>() {         
		@Override         
		public int compare(Contact c1, Contact c2) {  
			long c1Phone = Long.parseLong(c1.getHomePhone());
			long c2Phone = Long.parseLong(c2.getHomePhone());

			return (c2Phone < c1Phone ? 1 :                     
				(c2Phone == c1Phone ? 0 : -1));           
		}     
	};  
}
