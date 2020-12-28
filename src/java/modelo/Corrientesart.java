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
@Table(name = "Corrientes_art")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Corrientesart.findAll", query = "SELECT c FROM Corrientesart c")
    , @NamedQuery(name = "Corrientesart.findById", query = "SELECT c FROM Corrientesart c WHERE c.id = :id")
    , @NamedQuery(name = "Corrientesart.activos", query = "SELECT c FROM Corrientesart c WHERE c.status = 1")
    , @NamedQuery(name = "Corrientesart.eliminados", query = "SELECT c FROM Corrientesart c WHERE c.status = 0")
    , @NamedQuery(name = "Corrientesart.findByNombre", query = "SELECT c FROM Corrientesart c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Corrientesart.findByPeriodo", query = "SELECT c FROM Corrientesart c WHERE c.periodo = :periodo")
    , @NamedQuery(name = "Corrientesart.findByDescripcion", query = "SELECT c FROM Corrientesart c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Corrientesart.findByStatus", query = "SELECT c FROM Corrientesart c WHERE c.status = :status")})
public class Corrientesart implements Serializable {

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
    @Size(min = 1, max = 200)
    @Column(name = "periodo")
    private String periodo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 800)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(mappedBy = "idCorriente")
    private Collection<Obras> obrasCollection;

    public Corrientesart() {
    }

    public Corrientesart(Integer id) {
        this.id = id;
    }

    public Corrientesart(Integer id, String nombre, String periodo, String descripcion, int status) {
        this.id = id;
        this.nombre = nombre;
        this.periodo = periodo;
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

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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
        if (!(object instanceof Corrientesart)) {
            return false;
        }
        Corrientesart other = (Corrientesart) object;
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
