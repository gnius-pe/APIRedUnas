package com.redunas.redunas.modelo.DTO;

import com.redunas.redunas.modelo.Publicacion;
import com.redunas.redunas.modelo.Usuario;
import jakarta.persistence.*;

@Entity
@Table(name = "usuario_publicacion")
public class UsuarioPublicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_publicacion")
    private Long idUsuarioPublicacion;

    @Column(name = "fecha_publicacion")
    private String fechaPublicacion;


    @JoinColumn(name = "id_usuario")
    private Long idUsuario;


    @JoinColumn(name = "id_publicacion")
    private Long idPublicacion;

    // Constructor vacío requerido por JPA
    public UsuarioPublicacion() {
    }

    // Constructor con parámetros (opcional)
    public UsuarioPublicacion(String fechaPublicacion, Long idUsuario, Long idPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
        this.idUsuario = idUsuario;
        this.idPublicacion = idPublicacion;
    }

    // Getters y setters (métodos para acceder y modificar las propiedades)

    public Long getIdUsuarioPublicacion() {
        return idUsuarioPublicacion;
    }

    public void setIdUsuarioPublicacion(Long idUsuarioPublicacion) {
        this.idUsuarioPublicacion = idUsuarioPublicacion;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Long getUsuario() {
        return idUsuario;
    }

    public void setUsuario(Long usuario) {
        this.idUsuario = usuario;
    }

    public Long getPublicacion() {
        return idPublicacion;
    }

    public void setPublicacion(Long publicacion) {
        this.idPublicacion = publicacion;
    }

    @Override
    public String toString() {
        return "UsuarioPublicacion [idUsuarioPublicacion=" + idUsuarioPublicacion + ", fechaPublicacion=" + fechaPublicacion
                + ", usuario=" + idUsuario + ", publicacion=" + idPublicacion + "]";
    }
}
