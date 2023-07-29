package com.redunas.redunas.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Usuario")
public class UsuarioController {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre_usuario", unique = true, length = 30)
    private String nombreUsuario;
    @Column(name = "pasword", unique = true, length = 50)
    private String pasword;

    @Column(name = "rol_usuario", length = 30)
    private String rolUsuario;

    @Column(name = "id_usuario_detalle")
    private Integer idUsuarioDetalle;

    // Constructor, getters, setters, y otros métodos si es necesario
}