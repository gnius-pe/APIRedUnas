package com.redunas.redunas.modelo.DTO;

public class Alumno {
    private String tdocumento;
    private String appaterno;
    private String apmaterno;

    private String nombre;

    private String email;

    private String dni;

    private String codigo;

    private int registered_days;
    public Alumno() {
    }

    // Constructor con todos los datos
    public Alumno(String tdocumento, String appaterno, String apmaterno, String nombre, String email, String dni, String codigo, int registered_days) {
        this.tdocumento = tdocumento;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.codigo = codigo;
        this.registered_days = registered_days;
    }

    // Métodos getter y setter para tdocumento
    public String getTdocumento() {
        return tdocumento;
    }

    public void setTdocumento(String tdocumento) {
        this.tdocumento = tdocumento;
    }

    // Métodos getter y setter para appaterno
    public String getAppaterno() {
        return appaterno;
    }

    public void setAppaterno(String appaterno) {
        this.appaterno = appaterno;
    }

    // Métodos getter y setter para apmaterno
    public String getApmaterno() {
        return apmaterno;
    }

    public void setApmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
    }

    // Métodos getter y setter para nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos getter y setter para email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Métodos getter y setter para dni
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // Métodos getter y setter para codigo
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Métodos getter y setter para registered_days
    public int getRegistered_days() {
        return registered_days;
    }

    public void setRegistered_days(int registered_days) {
        this.registered_days = registered_days;
    }
}
