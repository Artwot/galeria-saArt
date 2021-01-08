/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jsarabia
 */
@Entity
@Table(name = "Paises")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paises.findAll", query = "SELECT p FROM Paises p")
    , @NamedQuery(name = "Paises.findById", query = "SELECT p FROM Paises p WHERE p.id = :id")
    , @NamedQuery(name = "Paises.activos", query = "SELECT p FROM Paises p WHERE p.status = 1")
    , @NamedQuery(name = "Paises.eliminados", query = "SELECT p FROM Paises p WHERE p.status = 0")
    , @NamedQuery(name = "Paises.findByClave", query = "SELECT p FROM Paises p WHERE p.clave = :clave")
    , @NamedQuery(name = "Paises.findByNombre", query = "SELECT p FROM Paises p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Paises.findByStatus", query = "SELECT p FROM Paises p WHERE p.status = :status")})
public class Paises implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(mappedBy = "idPais")
    private Collection<Usuarios> usuariosCollection;
    @OneToMany(mappedBy = "idPais")
    private Collection<Entidades> entidadesCollection;
    @OneToMany(mappedBy = "idPais")
    private Collection<Galerias> galeriasCollection;

    public Paises() {
    }

    public Paises(Integer id) {
        this.id = id;
    }

    public Paises(Integer id, String clave, String nombre, int status) {
        this.id = id;
        this.clave = clave;
        this.nombre = nombre;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
    }

    @XmlTransient
    public Collection<Entidades> getEntidadesCollection() {
        return entidadesCollection;
    }

    public void setEntidadesCollection(Collection<Entidades> entidadesCollection) {
        this.entidadesCollection = entidadesCollection;
    }

    @XmlTransient
    public Collection<Galerias> getGaleriasCollection() {
        return galeriasCollection;
    }

    public void setGaleriasCollection(Collection<Galerias> galeriasCollection) {
        this.galeriasCollection = galeriasCollection;
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
        if (!(object instanceof Paises)) {
            return false;
        }
        Paises other = (Paises) object;
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
