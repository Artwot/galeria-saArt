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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jsarabia
 */
@Entity
@Table(name = "Fotos_autores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fotosautores.findAll", query = "SELECT f FROM Fotosautores f")
    , @NamedQuery(name = "Fotosautores.findById", query = "SELECT f FROM Fotosautores f WHERE f.id = :id")
    , @NamedQuery(name = "Fotosautores.activos", query = "SELECT f FROM Fotosautores f WHERE f.status = 1")
    , @NamedQuery(name = "Fotosautores.eliminados", query = "SELECT f FROM Fotosautores f WHERE f.status = 0")
    , @NamedQuery(name = "Fotosautores.findByRuta", query = "SELECT f FROM Fotosautores f WHERE f.ruta = :ruta")
    , @NamedQuery(name = "Fotosautores.findByStatus", query = "SELECT f FROM Fotosautores f WHERE f.status = :status")})
public class Fotosautores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "ruta")
    private String ruta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "id_autor", referencedColumnName = "id")
    @ManyToOne
    private Autores idAutor;

    public Fotosautores() {
    }

    public Fotosautores(Integer id) {
        this.id = id;
    }

    public Fotosautores(Integer id, String ruta, int status) {
        this.id = id;
        this.ruta = ruta;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Autores getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Autores idAutor) {
        this.idAutor = idAutor;
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
        if (!(object instanceof Fotosautores)) {
            return false;
        }
        Fotosautores other = (Fotosautores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Fotosautores[ id=" + id + " ]";
    }

}
