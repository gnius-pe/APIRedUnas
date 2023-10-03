package com.redunas.redunas.controlador;

import com.redunas.redunas.modelo.DTO.Alumno;
import com.redunas.redunas.modelo.DTO.UsuarioRegistro;
import com.redunas.redunas.modelo.Usuario;
import com.redunas.redunas.modelo.UsuarioDetalle;
import com.redunas.redunas.servicio.SesionServicio;
import com.redunas.redunas.servicio.UsuarioDetalleServicio;
import com.redunas.redunas.servicio.UsuarioServicio;
import com.redunas.redunas.utilidades.ProblemaDetalle;
import com.redunas.redunas.utilidades.api.gniusUNAS.AlumnoUnas;
import com.redunas.redunas.utilidades.api.gniusUNAS.ClienteAlumnoAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/redunas/sesion")
public class Sesion {

    @Autowired
    private SesionServicio sesionServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private UsuarioDetalleServicio usuarioDetalleServicio;

    /*
    agregar el CORS, para los local host de front :
    ejemplo @CrossOrigin(origins = "http://localhost:5173")
     */
    @CrossOrigin(origins = {"http://localhost:5173"})
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

    @CrossOrigin(origins = {"http://localhost:5173"})
    @PostMapping("/registro")
    public ResponseEntity<?> registroNuevoUsuario(@RequestBody UsuarioRegistro usuarioRegistro){

        if(usuarioRegistro != null) {
            //if(usuarioDetalleServicio.buscarPorCOdigo(usuarioRegistro.getCodigo()).getCodigo())
            AlumnoUnas alumnonuevo = new AlumnoUnas();
            ClienteAlumnoAPI  clienteAlumnoAPI= new ClienteAlumnoAPI();
            alumnonuevo = clienteAlumnoAPI.obtenerAlumno(usuarioRegistro.getCodigo());

            Usuario usuario = new Usuario();
            usuario.setCorreo(alumnonuevo.getEmail());
            usuario.setPasword(usuarioRegistro.getPassword());
            usuario.setRolUsuario("usuario");
            usuario.setNombreUsuario(alumnonuevo.getNombre()+alumnonuevo.getCodigo());
            //usuarioServicio.guardarUsuario(usuario);


            return ResponseEntity.ok(usuario);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/existe/{codigo}")
    public ResponseEntity<Boolean> buscarPorCodigo(@PathVariable String codigo){
        return ResponseEntity.ok(usuarioDetalleServicio.buscarPorCOdigo(codigo).getCodigo().isEmpty());
    }
}
