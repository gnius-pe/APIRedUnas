package com.redunas.redunas.servicio;

import com.redunas.redunas.modelo.UsuarioDetalle;
import com.redunas.redunas.repositorio.UsuarioDetalleRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioDetalleServicio {
    @Autowired
    private UsuarioDetalleRepositorio usuarioRepositorio;

    public List<UsuarioDetalle> obtenerTodoUsuario(){
        return usuarioRepositorio.findAll();
    }
}
