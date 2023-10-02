package com.redunas.redunas.repositorio;

import com.redunas.redunas.modelo.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface PublicacionRepositorio extends JpaRepository<Publicacion,Long> {
}
