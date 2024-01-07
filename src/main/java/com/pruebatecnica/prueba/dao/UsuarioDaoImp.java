package com.pruebatecnica.prueba.dao;

import com.pruebatecnica.prueba.models.GenericResponse;
import com.pruebatecnica.prueba.models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Usuario> getUsuarios() {
        String query = "From Usuario";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Usuario getUsuarioById( Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        return usuario;
    }

    @Override
    public GenericResponse createUser(Usuario usuario) {
        Usuario mergedUsuario = entityManager.merge(usuario);

        GenericResponse response = new GenericResponse();

        // Verificar si la entidad está gestionada por el EntityManager
        if (entityManager.contains(mergedUsuario)) {
            response.setMessage("Creado correctamente");
        } else {
            response.setMessage("No creado");
        }

        return response;
    }

    @Override
    public void deleteUser(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }
}
