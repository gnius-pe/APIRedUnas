package com.redunas.redunas.utilidades;

public class ManejoCadena {
    public boolean esTextoValido(String texto) {
        // Verificar si el texto es nulo o está vacío
        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }

        // Verificar si el texto contiene solo espacios en blanco
        for (char c : texto.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                return true; // El texto contiene al menos un carácter no espaciado
            }
        }

        return false; // El texto contiene solo espacios en blanco
    }
}
