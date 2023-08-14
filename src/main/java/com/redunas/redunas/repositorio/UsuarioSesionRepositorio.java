package com.redunas.redunas.repositorio;


import com.redunas.redunas.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioSesionRepositorio extends JpaRepository<Usuario,Long> {
    @Query("SELECT u FROM Usuario u WHERE u.correo = :correo")
    Usuario iniciarSesion(@Param("correo")String correo);
}
