package com.redunas.redunas.utilidades.api.gniusUNAS;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.redunas.redunas.modelo.DTO.Alumno;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClienteAlumnoAPI {
    public AlumnoUnas obtenerAlumno(String codigo){
        String apiUrl = "https://itsm2023.rj.r.appspot.com/api/usuario/?codigo=" + codigo;
        ObjectMapper xmlObjectMapper = new XmlMapper();
        try {
            String xmlData = obtenerXmlDesdeUrl(apiUrl);
            System.out.println(xmlData);
            AlumnoUnas alumnoUnas = xmlObjectMapper.readValue(xmlData,AlumnoUnas.class);
            return alumnoUnas;
        }catch (Exception e){
            System.out.println("Error" + e.getMessage());
            return null;
        }
    }


    private static String consumirApi(String codigo) throws IOException {
        String apiUrl = "https://pagos.unas.edu.pe/person/validate/alumno/";
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiUrl + codigo);

        HttpResponse response = httpClient.execute(httpGet);
        String responseBody = EntityUtils.toString(response.getEntity());

        return responseBody;
    }

    private String obtenerXmlDesdeUrl(String apiUrl) throws IOException {
        HttpURLConnection conexion = null;
        BufferedReader lector = null;
        StringBuilder respuesta = new StringBuilder();

        try {
            URL url = new URL(apiUrl);
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            String linea;
            while ((linea = lector.readLine()) != null) {
                respuesta.append(linea);
            }
        } finally {
            // Cerrar la conexión y el lector cuando se complete
            if (lector != null) {
                try {
                    lector.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (conexion != null) {
                conexion.disconnect();
            }
        }
        return respuesta.toString();
    }



    private Alumno obtenerJsonDesdeUrl(String codigo) throws IOException {
        String apiUrl = "https://pagos.unas.edu.pe/person/validate/alumno/"+ codigo;
        HttpURLConnection conexion = null;
        try {
            URL url = new URL(apiUrl);
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            if (conexion.getResponseCode() == 200) {
                // Leer la respuesta JSON
                StringBuilder respuesta = new StringBuilder();
                try (java.io.BufferedReader in = new java.io.BufferedReader(
                        new java.io.InputStreamReader(conexion.getInputStream()))) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        respuesta.append(inputLine);
                    }
                }

                ObjectMapper objectMapper = new ObjectMapper();
                Alumno alumno = objectMapper.readValue(respuesta.toString(), Alumno.class);

                return alumno;
            } else {
                throw new IOException("Error al realizar la solicitud HTTP: " + conexion.getResponseCode());
            }
        } finally {
            if (conexion != null) {
                conexion.disconnect();
            }
        }
    }


}
