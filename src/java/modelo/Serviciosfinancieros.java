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
@Table(name = "Servicios_financieros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Serviciosfinancieros.findAll", query = "SELECT s FROM Serviciosfinancieros s")
    , @NamedQuery(name = "Serviciosfinancieros.findById", query = "SELECT s FROM Serviciosfinancieros s WHERE s.id = :id")
    , @NamedQuery(name = "Serviciosfinancieros.activos", query = "SELECT s FROM Serviciosfinancieros s WHERE s.status = 1")
    , @NamedQuery(name = "Serviciosfinancieros.eliminados", query = "SELECT s FROM Serviciosfinancieros s WHERE s.status = 0")
    , @NamedQuery(name = "Serviciosfinancieros.findByNombre", query = "SELECT s FROM Serviciosfinancieros s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Serviciosfinancieros.findByStatus", query = "SELECT s FROM Serviciosfinancieros s WHERE s.status = :status")})
public class Serviciosfinancieros implements Serializable {

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
    @Column(name = "status")
    private int status;
    @OneToMany(mappedBy = "idServicio")
    private Collection<Tarjetascliente> tarjetasclienteCollection;

    public Serviciosfinancieros() {
    }

    public Serviciosfinancieros(Integer id) {
        this.id = id;
    }

    public Serviciosfinancieros(Integer id, String nombre, int status) {
        this.id = id;
        this.nombre = nombre;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Tarjetascliente> getTarjetasclienteCollection() {
        return tarjetasclienteCollection;
    }

    public void setTarjetasclienteCollection(Collection<Tarjetascliente> tarjetasclienteCollection) {
        this.tarjetasclienteCollection = tarjetasclienteCollection;
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
        if (!(object instanceof Serviciosfinancieros)) {
            return false;
        }
        Serviciosfinancieros other = (Serviciosfinancieros) object;
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
