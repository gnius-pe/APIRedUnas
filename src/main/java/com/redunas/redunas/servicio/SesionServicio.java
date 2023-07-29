package com.redunas.redunas.servicio;

import com.redunas.redunas.modelo.UsuarioController;
import com.redunas.redunas.repositorio.UsuarioSesionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SesionServicio {
    @Autowired
    UsuarioSesionRepositorio usuarioSesionRepositorio ;

    public List<UsuarioController> obenerAlumnos(){

        return usuarioSesionRepositorio.findAll();
    }

    public UsuarioController buscarUsuarioPorNombre(String nombreUsuario){
        return usuarioSesionRepositorio.iniciarSesion(nombreUsuario);
    }
}
