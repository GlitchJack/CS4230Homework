package edu.weber.contact;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

import edu.weber.model.Contact;
import edu.weber.repository.ContactRepository;

public class ContactService {

	private static ContactService INSTANCE;
	private static HashSet<Contact> contacts = new HashSet<Contact>();
	private ContactRepository repo;
	
	public ContactService(ContactRepository repository) {
		this.repo = repository;
	}
	
	private ContactService() {
		this.repo = ContactRepository.getInstance();
	}
	
	public Collection<Contact> getContacts(){
		try {
			return repo.getAllContacts();
		}catch(SQLException e) {
			
		}
		return null;
	}
	
	public void addContact(Contact contact) {
//		contacts.add(contact);
		this.repo.insertContact(contact);
	}
	
	public static ContactService getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new ContactService();
		}
		return INSTANCE;
	}
}
