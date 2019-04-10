/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author alejandromontes
 */
@ManagedBean
public class RespuestaBean {
    private String mensaje="";

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
