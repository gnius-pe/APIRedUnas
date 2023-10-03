package com.redunas.redunas.utilidades.api.gniusUNAS;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlumnoUnas {

    @JsonProperty("id_estudiante")
    private int idEstudiante;
    @JsonProperty("nombre")
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
    private String promedio;

    @JsonProperty("url_foto")
    private String urlFoto;

    public double getPromedioAsDouble() {
        if (promedio != null && !promedio.isEmpty()) {
            return Double.parseDouble(promedio);
        }
        return 0.0; // Valor predeterminado si el campo está vacío o no es válido
    }
}
