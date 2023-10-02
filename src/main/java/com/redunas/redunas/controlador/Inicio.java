package com.redunas.redunas.controlador;

import com.redunas.redunas.modelo.DTO.Publicar;
import com.redunas.redunas.modelo.DTO.PulicacionInicio;
import com.redunas.redunas.modelo.DTO.UsuarioPublicacion;
import com.redunas.redunas.modelo.Publicacion;
import com.redunas.redunas.modelo.Usuario;
import com.redunas.redunas.servicio.PublicacionServicio;
import com.redunas.redunas.servicio.UsuarioServicio;
import com.redunas.redunas.utilidades.FechaActual;
import com.redunas.redunas.utilidades.ManejoCadena;
import jakarta.persistence.GenerationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gnius/api/redunas/inicio")
public class Inicio {

    @Autowired
    private PublicacionServicio publicacionServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @CrossOrigin(origins = {"http://localhost:5173"})
    @GetMapping("/publicaciones")
    public List<Publicacion> publicaciones() {
        return publicacionServicio.publicaciones();
    }

    @CrossOrigin(origins = {"http://localhost:5173"})
    @GetMapping("/publicaciones-inicio")
    public List<PulicacionInicio> publicacionInicio(){
        return publicacionServicio.publicacionesInicio();
    }

    @CrossOrigin(origins = {"http://localhost:5173"})
    @GetMapping("/usuario-publicacion")
    public List<UsuarioPublicacion> todoUsuarioPublicacion (){
        return publicacionServicio.todosUsuarioPublicacion();
    }

    @CrossOrigin(origins = {"http://localhost:5173"})
    @PostMapping("/publicar")
    public ResponseEntity<PulicacionInicio> crearPublicacion(@RequestBody Publicar publicar){
        if(new ManejoCadena().esTextoValido(publicar.getDescripcion())){
            try {
                Publicacion nuevaPublicacion = publicacionServicio.guardarPublicacion(
                        new Publicacion(publicar.getDescripcion(),
                                0,
                                "0",
                                0));

                UsuarioPublicacion usuarioPublicacion = new UsuarioPublicacion(
                        new FechaActual().obtenerFechaActualEnFormato(),
                        publicar.getIdUsuario(),
                        nuevaPublicacion.getId_publicacion());

                publicacionServicio.guardarUsuarioPublicacion(usuarioPublicacion);
                Usuario usuario = usuarioServicio.usuarioPorID(publicar.getIdUsuario());

                PulicacionInicio pulicacionInicio = new PulicacionInicio(
                        usuario.getUsuarioDetalle().getNombre(),
                        usuario.getUsuarioDetalle().getApellidoMaterno(),
                        usuarioPublicacion.getFechaPublicacion(),
                        nuevaPublicacion.getDescripcion(),
                        nuevaPublicacion.getMe_gusta(),
                        0,
                        nuevaPublicacion.getCompartido());
                return ResponseEntity.status(HttpStatus.CREATED).body(pulicacionInicio);
            }catch (Exception e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
