package com.crishof.contactos.service;

import com.crishof.contactos.model.Contacto;
import com.crishof.contactos.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoServiceImpl implements ContactoService {


    @Autowired
    private ContactoRepository contactoRepository;

    @Override
    public List<Contacto> listarContactos() {
        return contactoRepository.findAll();
    }

    @Override
    public Contacto buscarContactoPorId(Integer idContacto) {
        return contactoRepository.findById(idContacto).orElse(null);
    }

    @Override
    public void guardarContacto(Contacto contacto) {
        contactoRepository.save(contacto);
    }

    @Override
    public void eliminarContacto(Contacto contacto) {
        contactoRepository.delete(contacto);
    }
}
