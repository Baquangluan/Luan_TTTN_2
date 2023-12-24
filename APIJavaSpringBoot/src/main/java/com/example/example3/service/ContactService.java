package com.example.example3.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.example3.entity.Contact;
 

public interface ContactService {  
    
    public Contact createContact(Contact contact); 
    public Contact getContactById(Long contactId);  
    public Page<Contact> getAllContact(Pageable pageable);
    public Contact updateContact(Contact contact); 
    public void deleteContact(Long contactId); 
}
