package com.redunas.redunas.utilidades.api.gniusUNAS;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlRootElement;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlumnoUnas {

    @JsonProperty("id_estudiante")
    private String nombre;

    @JsonProperty("apellido_paterno")
    private String apellidoPaterno;

    @JsonProperty("apellido_materno")
    private  String apellidoMaterno;

    @JsonProperty("codigo")
    private String codigo;

    @JsonProperty("email")
    private String email;

    @JsonProperty("creditos")
    private int creditos;

    @JsonProperty("semestre")
    private int semestre;

    @JsonProperty("promedio")
    private float promedio;

    @JsonProperty("url_foto")
    private String urlFoto;
}
