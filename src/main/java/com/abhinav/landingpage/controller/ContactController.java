package com.abhinav.landingpage.controller;

import com.abhinav.landingpage.model.Contact;
import com.abhinav.landingpage.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/contact")
    @ResponseBody
    public String submitForm(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String message) {

        Contact contact = new Contact();

        contact.setName(name);
        contact.setEmail(email);
        contact.setMessage(message);

        contactRepository.save(contact);

        return """
                <h2>Thank You!</h2>
                <p>Your message has been saved successfully in MySQL.</p>
                <a href="/">Go Back</a>
                """;
    }

    @GetMapping("/contacts")
    @ResponseBody
    public List<Contact> getAllContacts() {

        return contactRepository.findAll();

    }

}