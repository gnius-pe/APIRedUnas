package com.redunas.redunas.controlador;

import com.redunas.redunas.modelo.Usuario;
import com.redunas.redunas.servicio.SesionServicio;
import com.redunas.redunas.utilidades.ProblemaDetalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/redunas/sesion")
public class Sesion {

    @Autowired
    private SesionServicio sesionServicio;



    @GetMapping("/login/{correo}")
    public ResponseEntity<?> iniciarSesion(@PathVariable String correo){
        Usuario usuario = sesionServicio.buscarUsuarioPorCorreo(correo);
        if(usuario != null){
            return ResponseEntity.ok(usuario);
        }else{
            int statusCode = HttpStatus.NOT_FOUND.value();
            String mensajeTitulo = "El correo no fue encontrado";
            String  mensajeDetalle = "El correo con nombre de '" + correo + "' no fue encontrado";
            ProblemaDetalle problemaDetalle =  new ProblemaDetalle(statusCode,mensajeTitulo,mensajeDetalle);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemaDetalle);
        }
    }
}
