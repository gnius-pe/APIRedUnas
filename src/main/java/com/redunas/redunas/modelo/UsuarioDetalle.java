package com.redunas.redunas.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Usuario_detalle")
public class UsuarioDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_detalle")
    private Integer idUsuarioDetalle;

    @Column(length = 35)
    private String nombre;

    @Column(name = "apellido_paterno", length = 35)
    private String apellidoPaterno;

    @Column(name = "apellido_materno", length = 35)
    private String apellidoMaterno;

    @Column(name = "fecha_nacimiento", length = 10)
    private String fechaNacimiento;

    @Column(length = 10)
    private String codigo;

    @Column(name = "numero_celular", length = 9)
    private String numeroCelular;

    @Column(name = "url_foto_perfil", length = 200)
    private String urlFotoPerfil;

    @Column(length = 200)
    private String descripcion;

    // Constructor, getters, setters, y otros métodos si es necesario
}

