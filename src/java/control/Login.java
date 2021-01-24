/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import modelo.Usuarios;

/**
 *
 * @author jsarabia
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {

    @EJB
    private UsuariosFacade usufacade;

    private HttpServletRequest httservlet;

    private String username;
    private String password;
    private Usuarios usuAuth;
    private String template = "template/template_crud.xhtml";

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuarios getUsuAuth() {
        return usuAuth;
    }

    public void setUsuAuth(Usuarios usuAuth) {
        this.usuAuth = usuAuth;
    }

    /**
     * Creates a new instance of Login
     */
    public Login() {
        httservlet = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }

    public void Acceso() throws IOException {
        System.out.println("##################Entraste##################################");
        httservlet = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        System.out.println("Username" + username);
        System.out.println("Passwd: " + password);
        usuAuth = usufacade.Buscar(username, password);
        if (usuAuth != null) {
            httservlet.getSession().setAttribute("username", usuAuth.getUsername());
            httservlet.getSession().setAttribute("nombre_com", usuAuth.getNombre()
                    + " " + usuAuth.getApPat() + " " + usuAuth.getApMat());
            httservlet.getSession().setAttribute("nivel_usu", usuAuth.getIdTipoUsu().getNivel());
            httservlet.getSession().setAttribute("usuario", usuAuth);
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAHHHHHHHHHHHHHHHHHHHHHHHHHHHHH" + usuAuth.getIdTipoUsu().getNivel());
            switch (usuAuth.getIdTipoUsu().getNivel()) {
                case 1:
                    System.out.println("Entró aquí");
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/GaleriaSaArt/faces/panel_admin.xhtml");
                    break;
                case 2:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/GaleriaSaArt/faces/panel_curador.xhtml");
                    break;
                case 3:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/GaleriaSaArt/faces/panel_vendedor.xhtml");
                    break;
                default:
                    template = "template/template_cliente.xhtml";
                    FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
                    break;
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Usuario o contraseña incorrectos.", null));
        }
    }

    public void cerrarSesion() {
        System.out.println("Aquí se cierra la sesión");
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/GaleriaSaArt/faces/login.xhtml");
        } catch (IOException e) {
        }
    }

    public void verificaSesionyNivel(int nivel) throws IOException {
        System.out.println("###############ESTÁ VERIFICANDO EL USUARIO: ");
        httservlet = (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
        Usuarios usu = (Usuarios) httservlet.getSession().getAttribute("usuario");
        /*System.out.println("Verifiación de usuario: " + usu);
        System.out.println(usu != null);
        System.out.println("NIVEL: " + nivel);
        System.out.println(usu.getIdTipoUsu().getNivel());*/
        if (usu != null) {
            System.out.println("El usuario NO es null");
            System.out.println(usu.getIdTipoUsu().getNivel() != nivel);
            int x = usu.getIdTipoUsu().getNivel();
            int y = nivel;
            System.out.println(x + " y " + y);
            if (usu.getIdTipoUsu().getNivel() != nivel) {
                System.out.println("El nivel sí");
                FacesContext.getCurrentInstance().getExternalContext().redirect("/GaleriaSaArt/faces/sin_privilegios.xhtml");
            }
        } else {
            System.out.println("No pasó");
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/GaleriaSaArt/faces/login.xhtml");
        }
    }

}
