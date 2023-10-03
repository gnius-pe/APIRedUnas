package com.redunas.redunas.repositorio;

import com.redunas.redunas.modelo.UsuarioDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioDetalleRepositorio extends JpaRepository<UsuarioDetalle,Long> {

    @Query("SELECT u FROM UsuarioDetalle u WHERE u.codigo = :codigo")
    public UsuarioDetalle existsUsuarioDetalleByCodigo(@Param("codigo") String codigo);
}
