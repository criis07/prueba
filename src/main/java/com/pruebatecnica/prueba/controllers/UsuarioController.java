package com.pruebatecnica.prueba.controllers;

import com.pruebatecnica.prueba.dao.UsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.pruebatecnica.prueba.models.Usuario;
import com.pruebatecnica.prueba.models.GenericResponse;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;
    @RequestMapping(value = "api/v1/users")
    public List<Usuario> getUserList(){
        return usuarioDao.getUsuarios();
    }
    @RequestMapping(value = "api/v1/users/{id}", method = RequestMethod.GET)
    public Usuario getUserById(@PathVariable Long id){
        return usuarioDao.getUsuarioById(id);
    }
    @RequestMapping(value = "api/v1/users", method = RequestMethod.POST)
    public GenericResponse createUser(@RequestBody Usuario usuario){
        return usuarioDao.createUser(usuario);
    }

    @RequestMapping(value = "api/v1/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        usuarioDao.deleteUser(id);
    }

}
