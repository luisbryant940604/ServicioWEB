/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.JsonObject;
import java.io.IOException;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author alejandromontes
 */
public class ServiciosWeb {

    private String respuesta = "";

    public boolean invocarMetodoGet() {

        boolean estatus = true;
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(5000)
                .setSocketTimeout(60000)
                .build();

        HttpClientBuilder builder = HttpClientBuilder.create();

        builder.setDefaultRequestConfig(config);
        CloseableHttpClient httpClient = builder.build();

        //Se fija la URL base de los recursos REST
        String baseUrl = "http://localhost:8080/wsrestserver/webresources";
        HttpGet request = new HttpGet(baseUrl + "/testws");

        CloseableHttpResponse response = null;

        try {
            System.out.println("Enviando petición");
            //Se envía la petición
            response = httpClient.execute(request);
            //Se consigue la respuesta
            String resp = EntityUtils.toString(response.getEntity());

            //Error en la respuesta del servidor
            if (response.getStatusLine().getStatusCode() != 200) {
                this.respuesta = "ERROR: Código de error HTTP:  " + response.getStatusLine().getStatusCode();
                estatus = false;
            } else {
                //Se procesa la respuesta capturada en la cadena 'response'
                if (resp.startsWith("ERROR")) {
                    estatus = false;
                    this.respuesta = resp;
                } else {
                    estatus = true;
                    this.respuesta = resp;
                }
            }
        } catch (IOException | ParseException e) {
            estatus = false;
            this.respuesta = "Surgió un problema";
        } finally {
            //En cualquier caso se cierra la conexión
            request.releaseConnection();
            if (response != null) {
                try {
                    response.close();
                } catch (IOException ioe) {
                    estatus = false;
                    this.respuesta = "Surgió un problema";
                }
            }
        }

        return estatus;
    }
    
    public boolean invocarMetodoPost() {

        boolean estatus = true;
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(5000)
                .setSocketTimeout(60000)
                .build();

        HttpClientBuilder builder = HttpClientBuilder.create();

        builder.setDefaultRequestConfig(config);
        CloseableHttpClient httpClient = builder.build();

        //Se fija la URL base de los recursos REST
        String baseUrl = "http://localhost:8080/wsrestserver/webresources";
        HttpPost request = new HttpPost(baseUrl + "/testws");
        
        //Se construye el mensaje JSON

        JsonObject alumno = new JsonObject();

        alumno.addProperty("matricula", "123");
        alumno.addProperty("nombre", "Hugo");
        alumno.addProperty("carrera", "ICO");
        alumno.addProperty("promedio", 9);

        //Se añade el JSON al cuerpo de la petición codificado en UTF-8
        request.setEntity(new StringEntity(alumno.toString(), "UTF-8"));

        //Se fija el tipo de contenido de la peticion POST
        request.addHeader("content-type", "application/json;charset=UTF-8");

        CloseableHttpResponse response = null;

        try {
            System.out.println("Enviando petición");
            //Se envía la petición
            
            response = httpClient.execute(request);
            //Se consigue la respuesta
            String resp = EntityUtils.toString(response.getEntity());

            //Error en la respuesta del servidor
            if (response.getStatusLine().getStatusCode() != 200) {
                this.respuesta = "ERROR: Código de error HTTP:  " + response.getStatusLine().getStatusCode();
                estatus = false;
            } else {
                //Se procesa la respuesta capturada en la cadena 'response'
                if (resp.startsWith("ERROR")) {
                    estatus = false;
                    this.respuesta = resp;
                } else {
                    estatus = true;
                    this.respuesta = resp;
                }
            }
        } catch (IOException | ParseException e) {
            estatus = false;
            this.respuesta = "Surgió un problema";
        } finally {
            //En cualquier caso se cierra la conexión
            request.releaseConnection();
            if (response != null) {
                try {
                    response.close();
                } catch (IOException ioe) {
                    estatus = false;
                    this.respuesta = "Surgió un problema";
                }
            }
        }

        return estatus;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

}
