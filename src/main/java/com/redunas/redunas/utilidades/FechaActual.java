package com.redunas.redunas.utilidades;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class FechaActual {

    public String obtenerFechaActualEnFormato() {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Definir un formato personalizado "yyyy-MM-dd"
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fechaActual.format(formato);
        return fechaFormateada;
    }
}
