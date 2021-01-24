/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jsarabia
 */
@Entity
@Table(name = "Usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id")
    , @NamedQuery(name = "Usuarios.activos", query = "SELECT u FROM Usuarios u WHERE u.status = 1")
    , @NamedQuery(name = "Usuarios.eliminados", query = "SELECT u FROM Usuarios u WHERE u.status = 0")
    , @NamedQuery(name = "Usuarios.buscar", query = "SELECT u FROM Usuarios u WHERE u.username = :username and u.password = :password")
    , @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuarios.findByApPat", query = "SELECT u FROM Usuarios u WHERE u.apPat = :apPat")
    , @NamedQuery(name = "Usuarios.findByApMat", query = "SELECT u FROM Usuarios u WHERE u.apMat = :apMat")
    , @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email")
    , @NamedQuery(name = "Usuarios.findByTelefono", query = "SELECT u FROM Usuarios u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "Usuarios.findByCalle", query = "SELECT u FROM Usuarios u WHERE u.calle = :calle")
    , @NamedQuery(name = "Usuarios.findByNoExt", query = "SELECT u FROM Usuarios u WHERE u.noExt = :noExt")
    , @NamedQuery(name = "Usuarios.findByColonia", query = "SELECT u FROM Usuarios u WHERE u.colonia = :colonia")
    , @NamedQuery(name = "Usuarios.findByCp", query = "SELECT u FROM Usuarios u WHERE u.cp = :cp")
    , @NamedQuery(name = "Usuarios.findByFechaNaci", query = "SELECT u FROM Usuarios u WHERE u.fechaNaci = :fechaNaci")
    , @NamedQuery(name = "Usuarios.findByUsername", query = "SELECT u FROM Usuarios u WHERE u.username = :username")
    , @NamedQuery(name = "Usuarios.userName", query = "SELECT u.username FROM Usuarios u WHERE u.username = :username")
    , @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password")
    , @NamedQuery(name = "Usuarios.findByStatus", query = "SELECT u FROM Usuarios u WHERE u.status = :status")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "ap_pat")
    private String apPat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "ap_mat")
    private String apMat;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "calle")
    private String calle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_ext")
    private int noExt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "colonia")
    private String colonia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cp")
    private int cp;
    @Column(name = "fecha_naci")
    @Temporal(TemporalType.DATE)
    private Date fechaNaci;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(mappedBy = "idCliente")
    private Collection<Ventas> ventasCollection;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Ventas> ventasCollection1;
    @JoinColumn(name = "id_pais", referencedColumnName = "id")
    @ManyToOne
    private Paises idPais;
    @JoinColumn(name = "id_entidad", referencedColumnName = "id")
    @ManyToOne
    private Entidades idEntidad;
    @JoinColumn(name = "id_tipo_usu", referencedColumnName = "id")
    @ManyToOne
    private Tiposusuario idTipoUsu;
    @OneToMany(mappedBy = "idCliente")
    private Collection<Tarjetascliente> tarjetasclienteCollection;
    @OneToMany(mappedBy = "idUsuRemitente")
    private Collection<Correos> correosCollection;

    public Usuarios() {
    }

    public Usuarios(Integer id) {
        this.id = id;
    }

    public Usuarios(Integer id, String nombre, String apPat, String apMat, String email, String telefono, String calle, int noExt, String colonia, int cp, String username, String password, int status) {
        this.id = id;
        this.nombre = nombre;
        this.apPat = apPat;
        this.apMat = apMat;
        this.email = email;
        this.telefono = telefono;
        this.calle = calle;
        this.noExt = noExt;
        this.colonia = colonia;
        this.cp = cp;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        System.out.println("Get");
        return nombre;
    }

    public void setNombre(String nombre) {
        System.out.println("Set");
        this.nombre = nombre;
    }

    public String getApPat() {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Ventas> getVentasCollection() {
        return ventasCollection;
    }

    public void setVentasCollection(Collection<Ventas> ventasCollection) {
        this.ventasCollection = ventasCollection;
    }

    @XmlTransient
    public Collection<Ventas> getVentasCollection1() {
        return ventasCollection1;
    }

    public void setVentasCollection1(Collection<Ventas> ventasCollection1) {
        this.ventasCollection1 = ventasCollection1;
    }

    public Paises getIdPais() {
        return idPais;
    }

    public void setIdPais(Paises idPais) {
        this.idPais = idPais;
    }

    public Entidades getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Entidades idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Tiposusuario getIdTipoUsu() {
        return idTipoUsu;
    }

    public void setIdTipoUsu(Tiposusuario idTipoUsu) {
        this.idTipoUsu = idTipoUsu;
    }

    @XmlTransient
    public Collection<Tarjetascliente> getTarjetasclienteCollection() {
        return tarjetasclienteCollection;
    }

    public void setTarjetasclienteCollection(Collection<Tarjetascliente> tarjetasclienteCollection) {
        this.tarjetasclienteCollection = tarjetasclienteCollection;
    }

    @XmlTransient
    public Collection<Correos> getCorreosCollection() {
        return correosCollection;
    }

    public void setCorreosCollection(Collection<Correos> correosCollection) {
        this.correosCollection = correosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
