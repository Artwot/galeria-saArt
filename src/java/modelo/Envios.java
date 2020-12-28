/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jsarabia
 */
@Entity
@Table(name = "Envios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Envios.findAll", query = "SELECT e FROM Envios e")
    , @NamedQuery(name = "Envios.findById", query = "SELECT e FROM Envios e WHERE e.id = :id")
    , @NamedQuery(name = "Envios.activos", query = "SELECT e FROM Envios e WHERE e.status = 1")
    , @NamedQuery(name = "Envios.eliminados", query = "SELECT e FROM Envios e WHERE e.status = 0")
    , @NamedQuery(name = "Envios.findByFechaEnvio", query = "SELECT e FROM Envios e WHERE e.fechaEnvio = :fechaEnvio")
    , @NamedQuery(name = "Envios.findByFechaEntrega", query = "SELECT e FROM Envios e WHERE e.fechaEntrega = :fechaEntrega")
    , @NamedQuery(name = "Envios.findByStatus", query = "SELECT e FROM Envios e WHERE e.status = :status")
    , @NamedQuery(name = "Envios.findByNoGuia", query = "SELECT e FROM Envios e WHERE e.noGuia = :noGuia")
    , @NamedQuery(name = "Envios.findByDescripcion", query = "SELECT e FROM Envios e WHERE e.descripcion = :descripcion")})
public class Envios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_envio")
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.DATE)
    private Date fechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "no_guia")
    private long noGuia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 800)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_venta", referencedColumnName = "id")
    @ManyToOne
    private DetalleVenta idVenta;
    @JoinColumn(name = "id_paqueteria", referencedColumnName = "id")
    @ManyToOne
    private Paqueterias idPaqueteria;

    public Envios() {
    }

    public Envios(Integer id) {
        this.id = id;
    }

    public Envios(Integer id, Date fechaEnvio, Date fechaEntrega, int status, long noGuia, String descripcion) {
        this.id = id;
        this.fechaEnvio = fechaEnvio;
        this.fechaEntrega = fechaEntrega;
        this.status = status;
        this.noGuia = noGuia;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getNoGuia() {
        return noGuia;
    }

    public void setNoGuia(long noGuia) {
        this.noGuia = noGuia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public DetalleVenta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(DetalleVenta idVenta) {
        this.idVenta = idVenta;
    }

    public Paqueterias getIdPaqueteria() {
        return idPaqueteria;
    }

    public void setIdPaqueteria(Paqueterias idPaqueteria) {
        this.idPaqueteria = idPaqueteria;
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
        if (!(object instanceof Envios)) {
            return false;
        }
        Envios other = (Envios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Envios[ id=" + id + " ]";
    }

}
