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
@Table(name = "Estilos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estilos.findAll", query = "SELECT e FROM Estilos e")
    , @NamedQuery(name = "Estilos.findById", query = "SELECT e FROM Estilos e WHERE e.id = :id")
    , @NamedQuery(name = "Estilos.activos", query = "SELECT e FROM Estilos e WHERE e.status = 1")
    , @NamedQuery(name = "Estilos.eliminados", query = "SELECT e FROM Estilos e WHERE e.status = 0")
    , @NamedQuery(name = "Estilos.findByNombre", query = "SELECT e FROM Estilos e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Estilos.findByDescripcion", query = "SELECT e FROM Estilos e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "Estilos.findByStatus", query = "SELECT e FROM Estilos e WHERE e.status = :status")})
public class Estilos implements Serializable {

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
    @Size(min = 1, max = 800)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(mappedBy = "idEstilo")
    private Collection<Obras> obrasCollection;

    public Estilos() {
    }

    public Estilos(Integer id) {
        this.id = id;
    }

    public Estilos(Integer id, String nombre, String descripcion, int status) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Obras> getObrasCollection() {
        return obrasCollection;
    }

    public void setObrasCollection(Collection<Obras> obrasCollection) {
        this.obrasCollection = obrasCollection;
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
        if (!(object instanceof Estilos)) {
            return false;
        }
        Estilos other = (Estilos) object;
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
