package com.redunas.redunas.controlador;

import com.redunas.redunas.modelo.Usuario;
import com.redunas.redunas.repositorio.UsuarioSesionRepositorio;
import com.redunas.redunas.servicio.UsuarioDetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gnius/redunas/sesion")
public class Sesion {

    @Autowired
    UsuarioSesionRepositorio usuarioSesionRepositorio;

    @GetMapping("/alumnos")
    public List<Usuario> obentenerAlumnos(){
        return usuarioSesionRepositorio.findAll();
    }
}
