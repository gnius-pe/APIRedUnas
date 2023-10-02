package com.redunas.redunas.servicio;

import com.redunas.redunas.modelo.DTO.Publicar;
import com.redunas.redunas.modelo.DTO.PulicacionInicio;
import com.redunas.redunas.modelo.DTO.UsuarioPublicacion;
import com.redunas.redunas.modelo.Publicacion;
import com.redunas.redunas.modelo.Usuario;
import com.redunas.redunas.repositorio.PublicacionRepositorio;
import com.redunas.redunas.repositorio.UsuarioPublicacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicacionServicio {
    @Autowired
    private PublicacionRepositorio publicacionRepositorio;

    @Autowired
    private UsuarioPublicacionRepositorio usuarioPublicacionRepositorio;

    @Autowired
    private UsuarioServicio usuarioServicio;



    public List<Publicacion> publicaciones(){
        return publicacionRepositorio.findAll();
    }

    public List<PulicacionInicio> publicacionesInicio(){
        List<PulicacionInicio> pulicacionInicio = new ArrayList<>() ;
        usuarioPublicacionRepositorio.findAll().forEach(p -> {
            Usuario usuario = usuarioServicio.usuarioPorID(p.getUsuario());
            Publicacion publicacion1 = publicacionRepositorio.getReferenceById(p.getPublicacion());
            pulicacionInicio.add(new PulicacionInicio(
                    usuario.getUsuarioDetalle().getNombre(),
                    usuario.getUsuarioDetalle().getApellidoPaterno() + usuario.getUsuarioDetalle().getApellidoMaterno(),
                    p.getFechaPublicacion(),
                    publicacion1.getDescripcion(),
                    publicacion1.getMe_gusta(),
                    0,
                    publicacion1.getCompartido()
            ));
        });
        return pulicacionInicio;
    }

    public List<UsuarioPublicacion> todosUsuarioPublicacion(){
        return usuarioPublicacionRepositorio.findAll();
    }

    public Publicacion guardarPublicacion(Publicacion publicacion){
        return publicacionRepositorio.save(publicacion);
    }

    public UsuarioPublicacion guardarUsuarioPublicacion(UsuarioPublicacion usuarioPublicacion){
        return usuarioPublicacionRepositorio.save(usuarioPublicacion);
    }
}
