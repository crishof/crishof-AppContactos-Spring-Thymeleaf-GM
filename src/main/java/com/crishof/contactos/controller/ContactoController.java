package com.crishof.contactos.controller;

import com.crishof.contactos.model.Contacto;
import com.crishof.contactos.service.ContactoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ContactoController {

    private static final Logger logger =
            LoggerFactory.getLogger(ContactoController.class);

    @Autowired
    ContactoService contactoService;

    @GetMapping("/")
    public String iniciar(ModelMap modelMap) {
        List<Contacto> contactos = contactoService.listarContactos();
        contactos.forEach((contacto -> logger.info(contacto.toString())));
        modelMap.put("contactos", contactos);
        return "index";

    }

}
