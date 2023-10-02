package com.redunas.redunas.modelo.DTO;

public class Publicar {
    private String descripcion;
    private Long idUsuario;


    public Publicar() {
    }

    // Constructor con todos los atributos
    public Publicar(String descripcion, Long idUsuario) {
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
    }

    // Métodos getter y setter para descripcion
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Métodos getter y setter para idUsuario
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    // Métodos getter y setter para idPublicacion



    @Override
    public String toString() {
        return "Publicar [descripcion=" + descripcion + ", idUsuario=" + idUsuario
                + "]";
    }
}
