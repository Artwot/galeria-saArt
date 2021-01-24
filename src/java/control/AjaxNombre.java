/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author jsarabia
 */
@Named(value = "ajaxNombre")
@RequestScoped
public class AjaxNombre {

    @EJB
    private UsuariosFacade usufacade;

    String nombre;
    String val_nombre;
    String color = "#FB5849";
    String password;
    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVal_nombre() {
        return val_nombre;
    }

    public void setVal_nombre(String val_nombre) {
        this.val_nombre = val_nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        System.out.println("Set: " +nombre);
        this.nombre = nombre;
    }

    public void consultarUsername(AjaxBehaviorEvent event) {
        val_nombre = usufacade.consultarUsername(nombre);
        if (val_nombre.equals("Nombre de usuario disponible")) {
            color = "#55a630";
        }
    }

    public void comprobarPasswd(AjaxBehaviorEvent event) {
        System.out.println("###################Entraste a la comprobación del password##########################");
        System.out.println(password);
        Pattern pat = Pattern.compile("[a-zA-Z0-9]{5,100}");
        Matcher mat = pat.matcher(password);
        if (mat.matches()) {
            System.out.println("Yeah, yeah, la muñeca fea.");
            msg = "Contraseña correcta";
            color = "#55a630";
        } else {
            System.out.println("Yupi, yupi el muñeco chucky.");
            msg = "Contraseña débil";
            color = "#FB5849";
        }
    }

    /**
     * Creates a new instance of AjaxNombre
     */
    public AjaxNombre() {
    }

}
