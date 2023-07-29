package com.redunas.redunas.controlador;

import com.redunas.redunas.modelo.UsuarioDetalle;
import com.redunas.redunas.servicio.UsuarioDetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gnius/redunas/usuario")
public class UsuarioDetalleControlador {

    @Autowired
    UsuarioDetalleServicio usuarioServicio;

    @GetMapping("/HolaMundo")
    public String holaMundo(){
        return "Hola desde el back-end";
    }

    @GetMapping("/todos")
    public List<UsuarioDetalle> obtenerTotodUsuario(){
        return usuarioServicio.obtenerTodoUsuario();
    }
}
