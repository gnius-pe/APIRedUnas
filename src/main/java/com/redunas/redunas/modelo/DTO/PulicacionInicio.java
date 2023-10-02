package com.redunas.redunas.modelo.DTO;

public class PulicacionInicio {
    private String nombre;
    private String apellido;

    private String fecha;

    private String descripcion;

    private int meGusta;

    private int comentarios;
    private int compartidos;

    public PulicacionInicio() {
    }

    // Constructor con todos los atributos
    public PulicacionInicio(String nombre, String apellido, String fecha, String descripcion,
                             int meGusta, int comentarios, int compartidos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.meGusta = meGusta;
        this.comentarios = comentarios;
        this.compartidos = compartidos;
    }

    // Getters y setters para los atributos

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMeGusta() {
        return meGusta;
    }

    public void setMeGusta(int meGusta) {
        this.meGusta = meGusta;
    }

    public int getComentarios() {
        return comentarios;
    }

    public void setComentarios(int comentarios) {
        this.comentarios = comentarios;
    }

    public int getCompartidos() {
        return compartidos;
    }

    public void setCompartidos(int compartidos) {
        this.compartidos = compartidos;
    }

    // Método toString para representar la clase como una cadena de texto
    @Override
    public String toString() {
        return "PublicacionInicio{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fecha='" + fecha + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", meGusta=" + meGusta +
                ", comentarios=" + comentarios +
                ", compartidos=" + compartidos +
                '}';
    }
}
