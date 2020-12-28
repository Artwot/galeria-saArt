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
@Table(name = "Exhibiciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Exhibiciones.findAll", query = "SELECT e FROM Exhibiciones e")
    , @NamedQuery(name = "Exhibiciones.findById", query = "SELECT e FROM Exhibiciones e WHERE e.id = :id")
    , @NamedQuery(name = "Exhibiciones.activos", query = "SELECT e FROM Exhibiciones e WHERE e.status = 1")
    , @NamedQuery(name = "Exhibiciones.eliminados", query = "SELECT e FROM Exhibiciones e WHERE e.status = 0")
    , @NamedQuery(name = "Exhibiciones.findByNombre", query = "SELECT e FROM Exhibiciones e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Exhibiciones.findByDescripcion", query = "SELECT e FROM Exhibiciones e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "Exhibiciones.findByFechaInicio", query = "SELECT e FROM Exhibiciones e WHERE e.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Exhibiciones.findByFechaFin", query = "SELECT e FROM Exhibiciones e WHERE e.fechaFin = :fechaFin")
    , @NamedQuery(name = "Exhibiciones.findByStatus", query = "SELECT e FROM Exhibiciones e WHERE e.status = :status")})
public class Exhibiciones implements Serializable {

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
    @Size(min = 1, max = 1200)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "id_galeria", referencedColumnName = "id")
    @ManyToOne
    private Galerias idGaleria;
    @OneToMany(mappedBy = "idExhibicion")
    private Collection<Fotosexhibiciones> fotosexhibicionesCollection;
    @OneToMany(mappedBy = "idExhibicion")
    private Collection<Obrasenexhibicion> obrasenexhibicionCollection;
    @OneToMany(mappedBy = "idExhibicion")
    private Collection<Boletosexhibicion> boletosexhibicionCollection;

    public Exhibiciones() {
    }

    public Exhibiciones(Integer id) {
        this.id = id;
    }

    public Exhibiciones(Integer id, String nombre, String descripcion, int status) {
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Galerias getIdGaleria() {
        return idGaleria;
    }

    public void setIdGaleria(Galerias idGaleria) {
        this.idGaleria = idGaleria;
    }

    @XmlTransient
    public Collection<Fotosexhibiciones> getFotosexhibicionesCollection() {
        return fotosexhibicionesCollection;
    }

    public void setFotosexhibicionesCollection(Collection<Fotosexhibiciones> fotosexhibicionesCollection) {
        this.fotosexhibicionesCollection = fotosexhibicionesCollection;
    }

    @XmlTransient
    public Collection<Obrasenexhibicion> getObrasenexhibicionCollection() {
        return obrasenexhibicionCollection;
    }

    public void setObrasenexhibicionCollection(Collection<Obrasenexhibicion> obrasenexhibicionCollection) {
        this.obrasenexhibicionCollection = obrasenexhibicionCollection;
    }

    @XmlTransient
    public Collection<Boletosexhibicion> getBoletosexhibicionCollection() {
        return boletosexhibicionCollection;
    }

    public void setBoletosexhibicionCollection(Collection<Boletosexhibicion> boletosexhibicionCollection) {
        this.boletosexhibicionCollection = boletosexhibicionCollection;
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
        if (!(object instanceof Exhibiciones)) {
            return false;
        }
        Exhibiciones other = (Exhibiciones) object;
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
