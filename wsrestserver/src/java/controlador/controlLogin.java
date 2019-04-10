/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import modelo.Login;

/**
 *
 * @author Eduardo
 */
@ManagedBean

public class controlLogin {
    
    @ManagedProperty(value="#{login}")
    private Login login = new Login();
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    public boolean validar(){
        if(this.login.getUsuario().equals("admin")){
            if(this.login.getContra().equals("12345")){
                System.out.println("Bienvenido");
                return true;
            }else{
                System.out.println("Contraseña incorrecta");
                return false;
            }
        }else{
            System.out.println("Volver a intentar");
            return false;
        }
    }
    
    
    
    
    
    
}
