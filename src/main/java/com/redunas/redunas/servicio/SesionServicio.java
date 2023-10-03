package com.redunas.redunas.servicio;

import com.redunas.redunas.modelo.Usuario;
import com.redunas.redunas.modelo.UsuarioDetalle;
import com.redunas.redunas.repositorio.UsuarioSesionRepositorio;
import com.redunas.redunas.utilidades.api.gniusUNAS.AlumnoUnas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SesionServicio {
    @Autowired
    UsuarioSesionRepositorio usuarioSesionRepositorio ;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private UsuarioDetalleServicio usuarioDetalleServicio;

    public List<Usuario> obenerAlumnos(){

        return usuarioSesionRepositorio.findAll();
    }

    public Usuario buscarUsuarioPorCorreo(String correo){
        return usuarioSesionRepositorio.iniciarSesion(correo);
    }

    public Usuario registrarUsuario(AlumnoUnas alumnoUnas){
        UsuarioDetalle usuarioDetalle = new UsuarioDetalle();
        usuarioDetalle.setNombre(alumnoUnas.getNombre());
        usuarioDetalle.setApellidoPaterno(alumnoUnas.getApellidoPaterno());
        usuarioDetalle.setApellidoMaterno(alumnoUnas.getApellidoMaterno());
        usuarioDetalle.setCodigo(alumnoUnas.getCodigo());
        usuarioDetalle.setUrlFotoPerfil(alumnoUnas.getUrlFoto());
        Usuario usuario = new Usuario();
        usuario.setCorreo(alumnoUnas.getEmail());
        usuario.setUsuarioDetalle(usuarioDetalle);
        return usuarioServicio.guardarUsuario(usuario);
    }



}
