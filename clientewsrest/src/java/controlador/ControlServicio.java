/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import modelo.RespuestaBean;
import ws.ServiciosWeb;

/**
 *
 * @author alejandromontes
 */
@ManagedBean
public class ControlServicio {
    private ServiciosWeb sw = new ServiciosWeb();
    @ManagedProperty(value="#{respuestaBean}")
    private RespuestaBean respuestaBean = new RespuestaBean();
    
    public void atenderServicioGET(){
     
        if(this.sw.invocarMetodoGet()){
            this.respuestaBean.setMensaje(this.sw.getRespuesta());
        }else{
            this.respuestaBean.setMensaje(this.sw.getRespuesta());
        }
    }
    
    public void atenderServicioPOST(){
     
        if(this.sw.invocarMetodoPost()){
            this.respuestaBean.setMensaje(this.sw.getRespuesta());
        }else{
            this.respuestaBean.setMensaje(this.sw.getRespuesta());
        }
    }

    public ServiciosWeb getSw() {
        return sw;
    }

    public void setSw(ServiciosWeb sw) {
        this.sw = sw;
    }

    public RespuestaBean getRespuestaBean() {
        return respuestaBean;
    }

    public void setRespuestaBean(RespuestaBean respuestaBean) {
        this.respuestaBean = respuestaBean;
    }
}
