package com.redunas.redunas.servicio;

import com.redunas.redunas.modelo.Usuario;
import com.redunas.redunas.modelo.UsuarioDetalle;
import com.redunas.redunas.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public Usuario usuarioPorID(Long id){
        return usuarioRepositorio.getReferenceById(id);
    }

    public Usuario guardarUsuario (Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

}
