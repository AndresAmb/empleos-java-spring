package com.andres.empleos.service.db;

import com.andres.empleos.model.Usuario;
import com.andres.empleos.repository.UsuariosRepository;
import com.andres.empleos.service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceJpa implements IUsuariosService {
    
    @Autowired
    private UsuariosRepository usuariosRepo;
    
    public void guardar(Usuario usuario) {
        usuariosRepo.save(usuario);
    }
    
    public void eliminar(Integer idUsuario) {
        usuariosRepo.deleteById(idUsuario);
    }
    
    public List<Usuario> buscarTodos() {
        return usuariosRepo.findAll();
    }
    
}