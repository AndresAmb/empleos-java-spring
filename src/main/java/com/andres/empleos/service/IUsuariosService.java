package com.andres.empleos.service;

import com.andres.empleos.model.Usuario;

import java.util.List;

public interface IUsuariosService {
    void guardar(Usuario usuario);
    
    // Ejercicio: Método que elimina un usuario de la base de datos.
    void eliminar(Integer idUsuario);
    
    // Ejercicio: Implementar método que recupera todos los usuarios. Usar vista de listUsuarios.html
    List<Usuario> buscarTodos();
}
