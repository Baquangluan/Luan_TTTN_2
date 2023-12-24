package com.example.example3.controller;

import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.example3.entity.Contact;
 // Import the User entity
import com.example.example3.service.ContactService; // Import the UserService


@RestController
@AllArgsConstructor
@RequestMapping("api/contacts")
@CrossOrigin(origins = "*", exposedHeaders = "Content-Range")
public class ContactController { 

    private ContactService contactService; // Rename the service

    // Create User REST API
    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) { // Rename the method
        Contact savedContact = contactService.createContact(contact); // Rename the service method
        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
    }

    // Get User by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id") Long contactId) { // Rename the method and parameter
        Contact contact = contactService.getContactById(contactId); // Rename the service method
        if (contact != null) {
            return new ResponseEntity<>(contact, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get All Users REST API
    @GetMapping
    public ResponseEntity<Page<Contact>> getAllContacts(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Contact> contacts = contactService.getAllContact(pageable); // Rename the service method
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    // Update User REST API
    @PutMapping("{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable("id") Long contactId,
            @RequestBody Contact contact) { // Rename the method and parameter
        contact.setId(contactId);
        Contact updatedContact = contactService.updateContact(contact); // Rename the service method
        return new ResponseEntity<>(updatedContact, HttpStatus.OK);
    }

    // Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteContact(@PathVariable("id") Long contactId) { // Rename the parameter
       contactService.deleteContact(contactId); // Rename the service method
        return new ResponseEntity<>("Contact successfully deleted!", HttpStatus.OK);
    }
    
}
