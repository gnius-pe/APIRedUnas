package com.redunas.redunas.repositorio;


import com.redunas.redunas.modelo.UsuarioController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioSesionRepositorio extends JpaRepository<UsuarioController,Long> {
    @Query("SELECT u FROM UsuarioController u WHERE u.nombreUsuario = :nombreUsuario")
    UsuarioController iniciarSesion(@Param("nombreUsuario")String nombreUsuario);
}
