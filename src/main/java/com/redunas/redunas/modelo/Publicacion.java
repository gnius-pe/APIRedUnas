package com.redunas.redunas.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_publicacion;


    private String descripcion;
    private int me_gusta;
    private String comentario;
    private int compartido;

    // Constructor vacío requerido por JPA
    public Publicacion() {
    }

    // Constructor con parámetros (opcional)
    public Publicacion(String descripcion, int me_gusta, String comentario, int compartido) {
        this.descripcion = descripcion;
        this.me_gusta = me_gusta;
        this.comentario = comentario;
        this.compartido = compartido;
    }

    // Getters y setters (métodos para acceder y modificar las propiedades)

    public Long getId_publicacion() {
        return id_publicacion;
    }

    public void setId_publicacion(Long id_publicacion) {
        this.id_publicacion = id_publicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMe_gusta() {
        return me_gusta;
    }

    public void setMe_gusta(int me_gusta) {
        this.me_gusta = me_gusta;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCompartido() {
        return compartido;
    }

    public void setCompartido(int compartido) {
        this.compartido = compartido;
    }

    @Override
    public String toString() {
        return "Publicacion [id_publicacion=" + id_publicacion + ", descripcion=" + descripcion + ", me_gusta=" + me_gusta
                + ", comentario=" + comentario + ", compartido=" + compartido + "]";
    }
}
