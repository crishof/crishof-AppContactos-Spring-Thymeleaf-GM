package com.crishof.contacts.service;

import com.crishof.contacts.model.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> findAllContacts();

    Contact findContactById(Integer idContact);

    void saveContact(Contact contact);

    void deleteContact(Contact contact);


}
