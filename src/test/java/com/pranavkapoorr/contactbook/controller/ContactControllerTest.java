package com.pranavkapoorr.contactbook.controller;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.context.junit4.SpringRunner;
import com.pranavkapoorr.contactbook.db.ContactService;
import com.pranavkapoorr.contactbook.model.Contact;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ContactController.class)
public class ContactControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ContactService service;

	Contact mockContact = new Contact(1,"Pranav","Kapoor","6476337891","6479937891","1665 Clark Blvd");
	
	@Test
	public void getAllContacts() throws Exception {
		List<Contact> list = new ArrayList<>();
		list.add(mockContact);
		Mockito.when(
				service.listContacts()).thenReturn(list);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/contacts").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "[{"
                +"\"id\": 1,"
                +"\"firstName\": \"Pranav\","
                +"\"lastName\": \"Kapoor\","
                +"\"cellPhone\": \"6476337891\","
                +"\"homePhone\": \"6479937891\","
                +"\"address\": \"1665 Clark Blvd\","
                +"\"createdTime\": \"\","
                +"\"updatedTime\": \"\""
            +"}]";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void getContactByIdTest() throws Exception {

		Mockito.when(
				service.getContactById(Mockito.anyInt())).thenReturn(mockContact);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/contact?cid=1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "{"
                +"\"id\": 1,"
                +"\"firstName\": \"Pranav\","
                +"\"lastName\": \"Kapoor\","
                +"\"cellPhone\": \"6476337891\","
                +"\"homePhone\": \"6479937891\","
                +"\"address\": \"1665 Clark Blvd\","
                +"\"createdTime\": \"\","
                +"\"updatedTime\": \"\""
            +"}";

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void addContact() throws Exception {//need to be fixed
		String exampleAddContact = "{"
                +"\"id\": 1,"
                +"\"firstName\": \"Pranav\","
                +"\"lastName\": \"Kapoor\","
                +"\"cellPhone\": \"6476337891\","
                +"\"homePhone\": \"6479937891\","
                +"\"address\": \"1665 Clark Blvd\","
                +"\"createdTime\": \"\","
                +"\"updatedTime\": \"\""
            +"}";
		String resultString = "Added Successfully!";
		Mockito.when(
				service.addContact(Mockito.any(Contact.class)))
				.thenReturn(resultString);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/contact")
				.contentType(MediaType.APPLICATION_JSON)
				.content(exampleAddContact);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals("Added Successfully!",result.getResponse().getContentAsString());
	}
	
	@Test
	public void getContactByOtherFields() throws Exception {
		List<Contact> list = new ArrayList<>();
		list.add(mockContact);
		Mockito.when(
				service.getContactByOtherFields(Mockito.anyString())).thenReturn(list);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/contact/647").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		String expected = "[{"
                +"\"id\": 1,"
                +"\"firstName\": \"Pranav\","
                +"\"lastName\": \"Kapoor\","
                +"\"cellPhone\": \"6476337891\","
                +"\"homePhone\": \"6479937891\","
                +"\"address\": \"1665 Clark Blvd\","
                +"\"createdTime\": \"\","
                +"\"updatedTime\": \"\""
            +"}]";
		assertEquals(200,result.getResponse().getStatus());
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
	@Test
	public void removeContact() throws Exception {//need to be fixed
		
		String resultString = "Deleted Successfully!";
		Mockito.when(
				service.removeContact(Mockito.anyInt()))
				.thenReturn(resultString);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.delete("/contact/1")
				.characterEncoding("UTF-8")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		int status = result.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = result.getResponse().getContentAsString();
		assertEquals("Deleted Successfully!",content);
	}
	
	@Test
	public void updateContact() throws Exception {//need to be fixed
		String exampleUpdateContact = "{"
                +"\"id\": 1,"
                +"\"firstName\": \"Pranav\","
                +"\"lastName\": \"Kapoor\","
                +"\"cellPhone\": \"6476337891\","
                +"\"homePhone\": \"6479937891\","
                +"\"address\": \"1665 Clark Blvd\","
                +"\"createdTime\": \"\","
                +"\"updatedTime\": \"\""
            +"}";
		String resultString = "Updated Successfully!";
		Mockito.when(
				service.updateContact(Mockito.any(Contact.class)))
				.thenReturn(resultString);

		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.put("/contact")
				.content(exampleUpdateContact)
				.characterEncoding("UTF-8")
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		int status = result.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = result.getResponse().getContentAsString();
		assertEquals("Updated Successfully!",content);
	}
	

}