/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import modelo.Entidades;
import modelo.Municipios;
import modelo.Paises;
import modelo.Tiposusuario;
import modelo.Usuarios;

/**
 *
 * @author jsarabia
 */
@Named(value = "ajaxPaises")
@RequestScoped
public class AjaxPaises {

    private Usuarios selected;

    @EJB
    private PaisesFacade paisesfacade;

    @EJB
    private EntidadesFacade entidadesfacade;

    @EJB
    private MunicipiosFacade municipiosfacade;

    @EJB
    private UsuariosFacade usufacade;

    private String nombre = "";
    private String apPat = "";
    private String apMat = "";
    private String email = "";
    private String telefono = "";
    private String calle = "";
    private int noExt;
    private String colonia = "";
    private int cp;
    private Date fechaNaci;
    private String username = "";
    private String password = "";
    String color = "#FB5849";
    String msg;
    String nombreUsu;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPat() {
        System.out.println(nombre);
        return apPat;
    }

    public void setApPat(String apPat) {
        this.apPat = apPat;
    }

    public String getApMat() {
        return apMat;
    }

    public void setApMat(String apMat) {
        this.apMat = apMat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNoExt() {
        return noExt;
    }

    public void setNoExt(int noExt) {
        this.noExt = noExt;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public Date getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(Date fechaNaci) {
        this.fechaNaci = fechaNaci;
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

    private int id_pais;
    private int id_entidad;
    private int id_municipio;
    private List<SelectItem> listPaises;
    private List<SelectItem> listEntidades;
    private List<SelectItem> listMunicipios;

    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public int getId_entidad() {
        return id_entidad;
    }

    public void setId_entidad(int id_entidad) {
        this.id_entidad = id_entidad;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public List<SelectItem> getListPaises() {
        return listPaises;
    }

    public void setListPaises(List<SelectItem> listPaises) {
        this.listPaises = listPaises;
    }

    public List<SelectItem> getListEntidades() {
        return listEntidades;
    }

    public void setListEntidades(List<SelectItem> listEntidades) {
        this.listEntidades = listEntidades;
    }

    public List<SelectItem> getListMunicipios() {
        return listMunicipios;
    }

    public void setListMunicipios(List<SelectItem> listMunicipios) {
        this.listMunicipios = listMunicipios;
    }

    public void consultarUsername(AjaxBehaviorEvent event) {
        nombreUsu = usufacade.consultarUsername(username);
        if (nombreUsu.equals("Nombre de usuario disponible")) {
            System.out.println("Está disponible");
            color = "#55a630";
        }
    }

    public void comprobarPasswd(AjaxBehaviorEvent event) {
        Pattern pat = Pattern.compile("[a-zA-Z0-9]{5,100}");
        Matcher mat = pat.matcher(password);
        if (mat.matches()) {
            msg = "Contraseña correcta";
            color = "#55a630";
        } else {
            msg = "Contraseña débil";
            color = "#FB5849";
        }
    }

    public List<SelectItem> buscarEntidades(final AjaxBehaviorEvent event) {
        listEntidades = new ArrayList<SelectItem>();
        List<Entidades> le = entidadesfacade.Buscar(id_pais);
        listEntidades.clear();
        for (Entidades e : le) {
            SelectItem entidad_item = new SelectItem(e.getId(), e.getNombre());
            listEntidades.add(entidad_item);
        }
        FacesContext.getCurrentInstance().renderResponse();
        return listEntidades;
    }

    public List<SelectItem> buscarMunicipios(final AjaxBehaviorEvent event) {
        listMunicipios = new ArrayList<SelectItem>();
        List<Municipios> lm = municipiosfacade.Buscar(id_entidad);
        listMunicipios.clear();
        for (Municipios m : lm) {
            SelectItem municipio_item = new SelectItem(m.getId(), m.getNombre());
            listMunicipios.add(municipio_item);
        }
        FacesContext.getCurrentInstance().renderResponse();
        return listMunicipios;
    }

    public void create() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido Materno:" + apMat);
        System.out.println("Apellido Paterno:" + apPat);
        System.out.println("Email: " + email);
        System.out.println("Tel: " + telefono);
        System.out.println("Calle: " + calle);
        System.out.println("No. ext: " + noExt);
        System.out.println("Colonia: " + colonia);
        System.out.println("C.P.:" + cp);
        System.out.println("Fecha de nacimiento: " + fechaNaci);
        System.out.println("Id. País:" + id_pais);
        System.out.println("Id. Entidad: " + id_entidad);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        Usuarios cliente = new Usuarios();
        cliente.setNombre(nombre);
        cliente.setApMat(apMat);
        cliente.setApPat(apPat);
        cliente.setEmail(email);
        cliente.setTelefono(telefono);
        cliente.setCalle(calle);
        cliente.setNoExt(noExt);
        cliente.setColonia(colonia);
        cliente.setCp(cp);
        cliente.setFechaNaci(fechaNaci);
        cliente.setUsername(username);
        cliente.setPassword("123456");
        Paises p = new Paises(id_pais);
        cliente.setIdPais(p);
        Entidades e = new Entidades(id_entidad);
        cliente.setIdEntidad(e);
        Tiposusuario tu = new Tiposusuario(4);
        cliente.setIdTipoUsu(tu);
        cliente.setStatus(1);

        System.out.println("El objeto cliente está así: " + cliente.getCalle());

        UsuariosController uctrl = new UsuariosController();
        uctrl.createCliente(cliente, usufacade);
    }

    /**
     * Creates a new instance of AjaxPaises
     */
    public AjaxPaises() {
    }

    @PostConstruct
    private void initialize() {
        selected = new Usuarios();

        listPaises = new ArrayList<SelectItem>();
        List<Paises> lp = paisesfacade.findAll();
        listPaises.clear();
        for (Paises p : lp) {
            SelectItem pais_item = new SelectItem(p.getId(), p.getNombre());
            listPaises.add(pais_item);
        }

        listEntidades = new ArrayList<SelectItem>();
        List<Entidades> le = entidadesfacade.findAll();
        listEntidades.clear();
        for (Entidades e : le) {
            SelectItem entidad_item = new SelectItem(e.getId(), e.getNombre());
            listEntidades.add(entidad_item);
        }
    }

}
