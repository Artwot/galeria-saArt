/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author jsarabia
 */
@Named(value = "ajaxNombre")
@RequestScoped
public class AjaxNombre {
    String nombre;
    String val_nombre;

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
        this.nombre = nombre;
    }
    
    /**
     * Creates a new instance of AjaxNombre
     */
    public AjaxNombre() {
    }
    
}
