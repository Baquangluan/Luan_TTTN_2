package com.example.example3.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.example3.entity.Contact; // Import the Contact entity
import com.example.example3.repository.ContactRepository; // Import the ContactRepository
import com.example.example3.service.ContactService;

import java.util.Date;  // Add this import statement
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactServicelmpl implements ContactService {

    private ContactRepository contactRepository; // Rename the repository

    @Override
    public Contact createContact(Contact contact) {
        // Set default values for the new fields
        contact.setReplay_id(0L);  // Assuming a default value for replay_id
        contact.setCreated_at(new Date());
        contact.setUpdated_at(new Date());
        contact.setCreated_by("Default Creator");
        contact.setUpdated_by("Default Updater");
        contact.setStatus("Active");

        return contactRepository.save(contact);
    }

    @Override
    public Contact getContactById(Long contactId) {
        Optional<Contact> optionalContact = contactRepository.findById(contactId);
        return optionalContact.orElse(null);
    }

    @Override
    public Page<Contact> getAllContact(Pageable pageable) {
        return contactRepository.findAll(pageable);
    }

    @Override
    public Contact updateContact(Contact contact) {
        Contact existingContact = contactRepository.findById(contact.getId()).orElse(null);
        if (existingContact != null) {
            existingContact.setUserid(contact.getUserid());
            existingContact.setName(contact.getName());
            existingContact.setEmail(contact.getEmail());
            existingContact.setPhone(contact.getPhone());
            existingContact.setTitle(contact.getTitle());
            existingContact.setContent(contact.getContent());
            existingContact.setReplay_id(contact.getReplay_id());
            existingContact.setUpdated_at(new Date());
            existingContact.setUpdated_by(contact.getUpdated_by());
            existingContact.setStatus(contact.getStatus());

            Contact updatedContact = contactRepository.save(existingContact);
            return updatedContact;
        }
        return null; // Handle error or throw an exception as needed
    }

    @Override
    public void deleteContact(Long contactId) {
        contactRepository.deleteById(contactId);
    }
}
