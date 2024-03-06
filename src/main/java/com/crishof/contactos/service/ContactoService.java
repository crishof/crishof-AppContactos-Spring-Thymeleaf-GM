package com.crishof.contactos.service;

import com.crishof.contactos.model.Contacto;

import java.util.List;

public interface ContactoService {

    List<Contacto> listarContactos();

    Contacto buscarContactoPorId(Integer idContacto);

    void guardarContacto(Contacto contacto);

    void eliminarContacto(Contacto contacto);


}
