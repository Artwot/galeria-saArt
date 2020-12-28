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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Tarjetas_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarjetascliente.findAll", query = "SELECT t FROM Tarjetascliente t")
    , @NamedQuery(name = "Tarjetascliente.findById", query = "SELECT t FROM Tarjetascliente t WHERE t.id = :id")
    , @NamedQuery(name = "Tarjetascliente.activos", query = "SELECT t FROM Tarjetascliente t WHERE t.status = 1")
    , @NamedQuery(name = "Tarjetascliente.eliminados", query = "SELECT t FROM Tarjetascliente t WHERE t.status = 0")
    , @NamedQuery(name = "Tarjetascliente.findByNombrePropietario", query = "SELECT t FROM Tarjetascliente t WHERE t.nombrePropietario = :nombrePropietario")
    , @NamedQuery(name = "Tarjetascliente.findByNumero", query = "SELECT t FROM Tarjetascliente t WHERE t.numero = :numero")
    , @NamedQuery(name = "Tarjetascliente.findByCvv", query = "SELECT t FROM Tarjetascliente t WHERE t.cvv = :cvv")
    , @NamedQuery(name = "Tarjetascliente.findByFechaExpiracion", query = "SELECT t FROM Tarjetascliente t WHERE t.fechaExpiracion = :fechaExpiracion")
    , @NamedQuery(name = "Tarjetascliente.findByStatus", query = "SELECT t FROM Tarjetascliente t WHERE t.status = :status")})
public class Tarjetascliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre_propietario")
    private String nombrePropietario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private long numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cvv")
    private int cvv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "fecha_expiracion")
    private String fechaExpiracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(mappedBy = "idTarjeta")
    private Collection<Ventas> ventasCollection;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idCliente;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id")
    @ManyToOne
    private Serviciosfinancieros idServicio;

    public Tarjetascliente() {
    }

    public Tarjetascliente(Integer id) {
        this.id = id;
    }

    public Tarjetascliente(Integer id, String nombrePropietario, long numero, int cvv, String fechaExpiracion, int status) {
        this.id = id;
        this.nombrePropietario = nombrePropietario;
        this.numero = numero;
        this.cvv = cvv;
        this.fechaExpiracion = fechaExpiracion;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(String fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
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

    public Usuarios getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Usuarios idCliente) {
        this.idCliente = idCliente;
    }

    public Serviciosfinancieros getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Serviciosfinancieros idServicio) {
        this.idServicio = idServicio;
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
        if (!(object instanceof Tarjetascliente)) {
            return false;
        }
        Tarjetascliente other = (Tarjetascliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombrePropietario;
    }

}
