/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jsarabia
 */
@Entity
@Table(name = "Boletos_exhibicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boletosexhibicion.findAll", query = "SELECT b FROM Boletosexhibicion b")
    , @NamedQuery(name = "Boletosexhibicion.findById", query = "SELECT b FROM Boletosexhibicion b WHERE b.id = :id")
    , @NamedQuery(name = "Boletosexhibicion.activos", query = "SELECT b FROM Boletosexhibicion b WHERE b.status = 1")
    , @NamedQuery(name = "Boletosexhibicion.eliminados", query = "SELECT b FROM Boletosexhibicion b WHERE b.status = 0")
    , @NamedQuery(name = "Boletosexhibicion.findByCantidad", query = "SELECT b FROM Boletosexhibicion b WHERE b.cantidad = :cantidad")
    , @NamedQuery(name = "Boletosexhibicion.findByPrecio", query = "SELECT b FROM Boletosexhibicion b WHERE b.precio = :precio")
    , @NamedQuery(name = "Boletosexhibicion.findByStatus", query = "SELECT b FROM Boletosexhibicion b WHERE b.status = :status")})
public class Boletosexhibicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "id_exhibicion", referencedColumnName = "id")
    @ManyToOne
    private Exhibiciones idExhibicion;

    public Boletosexhibicion() {
    }

    public Boletosexhibicion(Integer id) {
        this.id = id;
    }

    public Boletosexhibicion(Integer id, int cantidad, double precio, int status) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Exhibiciones getIdExhibicion() {
        return idExhibicion;
    }

    public void setIdExhibicion(Exhibiciones idExhibicion) {
        this.idExhibicion = idExhibicion;
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
        if (!(object instanceof Boletosexhibicion)) {
            return false;
        }
        Boletosexhibicion other = (Boletosexhibicion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Boletosexhibicion[ id=" + id + " ]";
    }

}
