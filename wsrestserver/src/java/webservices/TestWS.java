/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.Alumno;
import modelo.Respuesta;

/**
 *
 * @author alejandromontes
 */
@Path("/testws")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TestWS {

    @GET
    public Response testGET() {
        //Lógica a desarrollar por el servicio
        Gson gson = new Gson();
        List<Alumno> listaAlumnos = new ArrayList<>();

        Alumno alumno = new Alumno();
        alumno.setMatricula("12345");
        alumno.setNombre("Hugo");
        alumno.setCarrera("ICO");
        alumno.setPromedio(6.5);
        listaAlumnos.add(alumno);

        alumno = new Alumno();
        alumno.setMatricula("6789");
        alumno.setNombre("Paco");
        alumno.setCarrera("LAE");
        alumno.setPromedio(3.8);
        listaAlumnos.add(alumno);

        alumno = new Alumno();
        alumno.setMatricula("5432");
        alumno.setNombre("Luis");
        alumno.setCarrera("CP");
        alumno.setPromedio(10);
        listaAlumnos.add(alumno);

        //{"matricula":"12345",
        // "nombre":"Hugo",
        // "carrera":"ICO",
        // "promedio":6.5}
        String respuesta = gson.toJson(listaAlumnos, List.class);

        return Response.ok(respuesta,
                MediaType.APPLICATION_JSON).build();
    }

    @POST
    public Response testPOST(Alumno alumno) {
        //Lógica a desarrollar por el servicio
        //Gson gson = new Gson();
        //Alumno alumno = gson.fromJson(json, Alumno.class);

        //System.out.println("Datos JSON:");
        //System.out.println(json);
        System.out.println("Datos recibidos:");
        System.out.println("matricula = " + alumno.getMatricula());
        System.out.println("nombre = " + alumno.getNombre());
        System.out.println("carrera = " + alumno.getCarrera());
        System.out.println("promedio = " + alumno.getPromedio());

        Respuesta resp = new Respuesta();

        resp.setMensaje("Registro insertado");
        resp.setEstatus(true);
        //{"mensaje":"Registro insertado",
        // "estatus":true}

        //String respuesta = gson.toJson(resp,Respuesta.class);
        return Response.ok(resp,
                MediaType.APPLICATION_JSON).build();
    }

    /**
     * Recibir un JSON que contenga los datos: clave, nombre, titulo de un
     * maestro lo convierta a objeto Java y regrese un JSON con el aviso de que
     * fue modificado
     *
     * @param alumno
     * @return
     */
    @PUT
    public Response testPUT(Alumno alumno) {
        //Lógica a desarrollar por el servicio
        System.out.println("Datos recibidos");
        System.out.println("Matrícula:" + alumno.getMatricula());

        Respuesta resp = new Respuesta();
        if (alumno.getMatricula().length() == 0) {
            resp.setEstatus(false);
            resp.setMensaje("Se debe indicar la matrícula");
        } else {
            alumno.setNombre("Felipe");
            alumno.setCarrera("Turismo");
            alumno.setPromedio(10);
            resp.setEstatus(true);
            resp.setMensaje("Registro modificado");
        }

        return Response.ok(resp,
                MediaType.APPLICATION_JSON).build();
    }

    /**
     * Reciba JSON con la matricula a eliminar.
     * Si la matricula es 123 que genere mensaje de registro eliminado
     * En caso contrario genere mensaje de la matrícula no existe en formato JSON
     * Mostrar en consola la matrícula a eliminar
     * @return 
     */
    @DELETE
    public Response testDELETE() {
        //Lógica a desarrollar por el servicio
        return Response.ok("Método invocado por DELETE - Montes",
                MediaType.APPLICATION_JSON).build();
    }

}
