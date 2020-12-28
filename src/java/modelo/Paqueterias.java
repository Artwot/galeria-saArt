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
@Table(name = "Paqueterias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paqueterias.findAll", query = "SELECT p FROM Paqueterias p")
    , @NamedQuery(name = "Paqueterias.findById", query = "SELECT p FROM Paqueterias p WHERE p.id = :id")
    , @NamedQuery(name = "Paqueterias.activos", query = "SELECT p FROM Paqueterias p WHERE p.status = 1")
    , @NamedQuery(name = "Paqueterias.eliminados", query = "SELECT p FROM Paqueterias p WHERE p.status = 0")
    , @NamedQuery(name = "Paqueterias.findByNombre", query = "SELECT p FROM Paqueterias p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Paqueterias.findByWeb", query = "SELECT p FROM Paqueterias p WHERE p.web = :web")
    , @NamedQuery(name = "Paqueterias.findByStatus", query = "SELECT p FROM Paqueterias p WHERE p.status = :status")})
public class Paqueterias implements Serializable {

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
    @Column(name = "web")
    private String web;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(mappedBy = "idPaqueteria")
    private Collection<Envios> enviosCollection;

    public Paqueterias() {
    }

    public Paqueterias(Integer id) {
        this.id = id;
    }

    public Paqueterias(Integer id, String nombre, String web, int status) {
        this.id = id;
        this.nombre = nombre;
        this.web = web;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Envios> getEnviosCollection() {
        return enviosCollection;
    }

    public void setEnviosCollection(Collection<Envios> enviosCollection) {
        this.enviosCollection = enviosCollection;
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
        if (!(object instanceof Paqueterias)) {
            return false;
        }
        Paqueterias other = (Paqueterias) object;
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