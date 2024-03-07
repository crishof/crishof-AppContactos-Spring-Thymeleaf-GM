package com.crishof.contacts.controller;

import com.crishof.contacts.model.Contact;
import com.crishof.contacts.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContactController {

    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @Autowired
    ContactService contactService;

    @GetMapping("/")
    public String iniciar(ModelMap modelMap) {
        List<Contact> contacts = contactService.findAllContacts();
        contacts.forEach((contact -> logger.info(contact.toString())));
        modelMap.put("contacts", contacts);
        return "index";

    }

    @GetMapping("/add")
    public String add() {
        return "addContact";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("contactForm") Contact contact) {

        logger.info("Contact a agregar: " + contact);
        contactService.saveContact(contact);

        return "redirect:/";

    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id") int id, ModelMap model) {

        Contact contact = contactService.findContactById(id);

        logger.info("Contact to edit: " + contact);
        model.put("contact", contact);

        return "editContact";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("contact") Contact contact) {

        logger.info("Contact to save: " + contact);

        contactService.saveContact(contact);

        return "redirect:/";

    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") int id) {

        Contact contact = new Contact();
        contact.setId(id);

        contactService.deleteContact(contact);

        return "redirect:/";
    }


}
