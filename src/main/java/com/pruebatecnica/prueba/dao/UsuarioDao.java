package com.pruebatecnica.prueba.dao;

import com.pruebatecnica.prueba.models.GenericResponse;
import com.pruebatecnica.prueba.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();
    Usuario getUsuarioById(Long id);

    GenericResponse createUser(Usuario usuario);
    void deleteUser(Long id);
}
