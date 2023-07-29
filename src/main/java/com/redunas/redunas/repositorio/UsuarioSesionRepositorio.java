package com.redunas.redunas.repositorio;


import com.redunas.redunas.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioSesionRepositorio extends JpaRepository<Usuario,Long> {

}
