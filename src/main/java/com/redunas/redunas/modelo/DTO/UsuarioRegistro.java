package com.redunas.redunas.modelo.DTO;

public class UsuarioRegistro {
    private String nombreCompleto;
    private String codigo;
    private String password;

    public UsuarioRegistro() {
    }

    // Constructor con todos los atributos
    public UsuarioRegistro(String nombreCompleto, String codigo, String password) {
        this.nombreCompleto = nombreCompleto;
        this.codigo = codigo;
        this.password = password;
    }

    // Getter y Setter para nombreCompleto
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    // Getter y Setter para codigo
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Getter y Setter para password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Método toString para representación de cadena
    @Override
    public String toString() {
        return "UsuarioRegistro{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", codigo='" + codigo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
