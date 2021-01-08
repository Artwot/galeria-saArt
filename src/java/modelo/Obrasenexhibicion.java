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
@Table(name = "Obras_en_exhibicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obrasenexhibicion.findAll", query = "SELECT o FROM Obrasenexhibicion o")
    , @NamedQuery(name = "Obrasenexhibicion.findById", query = "SELECT o FROM Obrasenexhibicion o WHERE o.id = :id")
    , @NamedQuery(name = "Obrasenexhibicion.activos", query = "SELECT o FROM Obrasenexhibicion o WHERE o.status = 1")
    , @NamedQuery(name = "Obrasenexhibicion.eliminados", query = "SELECT o FROM Obrasenexhibicion o WHERE o.status = 0")
    , @NamedQuery(name = "Obrasenexhibicion.findByStatus", query = "SELECT o FROM Obrasenexhibicion o WHERE o.status = :status")})
public class Obrasenexhibicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "id_exhibicion", referencedColumnName = "id")
    @ManyToOne
    private Exhibiciones idExhibicion;
    @JoinColumn(name = "id_obra", referencedColumnName = "id")
    @ManyToOne
    private Obras idObra;

    public Obrasenexhibicion() {
    }

    public Obrasenexhibicion(Integer id) {
        this.id = id;
    }

    public Obrasenexhibicion(Integer id, int status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Obras getIdObra() {
        return idObra;
    }

    public void setIdObra(Obras idObra) {
        this.idObra = idObra;
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
        if (!(object instanceof Obrasenexhibicion)) {
            return false;
        }
        Obrasenexhibicion other = (Obrasenexhibicion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Obrasenexhibicion[ id=" + id + " ]";
    }

}
