package com.redunas.redunas.controlador;

import com.redunas.redunas.modelo.UsuarioController;
import com.redunas.redunas.repositorio.UsuarioSesionRepositorio;
import com.redunas.redunas.utilidades.ProblemaDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gnius/redunas/sesion")
public class Sesion {

    @Autowired
    UsuarioSesionRepositorio usuarioSesionRepositorio;

    @GetMapping("/alumnos")
    public List<UsuarioController> obentenerAlumnos(){
        return usuarioSesionRepositorio.findAll();
    }

    @GetMapping("/login/{nombreUsuario}")
    public ResponseEntity<?> iniciarSesion(@PathVariable String nombreUsuario){
        UsuarioController usuario = usuarioSesionRepositorio.iniciarSesion(nombreUsuario);
        if(usuario != null){
            return ResponseEntity.ok(usuario);
        }else{
            int statusCode = HttpStatus.NOT_FOUND.value();
            String mensajeTitulo = "El usuario no fue encontrado";
            String  mensajeDetalle = "El usuario con nombre de '" + nombreUsuario + "' no fue encontrado";
            ProblemaDetalle problemaDetalle =  new ProblemaDetalle(statusCode,mensajeTitulo,mensajeDetalle);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemaDetalle);
        }
    }
}
