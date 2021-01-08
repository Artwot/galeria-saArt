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
@Table(name = "Autores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autores.findAll", query = "SELECT a FROM Autores a")
    , @NamedQuery(name = "Autores.findById", query = "SELECT a FROM Autores a WHERE a.id = :id")
    , @NamedQuery(name = "Autores.autoresActivos", query = "SELECT a FROM Autores a WHERE a.status = 1") 
    , @NamedQuery(name = "Autores.autoresEliminados", query = "SELECT a FROM Autores a WHERE a.status = 0") 
    , @NamedQuery(name = "Autores.findByNombre", query = "SELECT a FROM Autores a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Autores.findByApellido", query = "SELECT a FROM Autores a WHERE a.apellido = :apellido")
    , @NamedQuery(name = "Autores.findByInformacion", query = "SELECT a FROM Autores a WHERE a.informacion = :informacion")
    , @NamedQuery(name = "Autores.findByAutorHistorico", query = "SELECT a FROM Autores a WHERE a.autorHistorico = :autorHistorico")
    , @NamedQuery(name = "Autores.findByStatus", query = "SELECT a FROM Autores a WHERE a.status = :status")})
public class Autores implements Serializable {

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
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "informacion")
    private String informacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "autor_historico")
    private boolean autorHistorico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(mappedBy = "idAutor")
    private Collection<Obras> obrasCollection;
    @OneToMany(mappedBy = "idAutor")
    private Collection<Fotosautores> fotosautoresCollection;

    public Autores() {
    }

    public Autores(Integer id) {
        this.id = id;
    }

    public Autores(Integer id, String nombre, String apellido, String informacion, boolean autorHistorico, int status) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.informacion = informacion;
        this.autorHistorico = autorHistorico;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public boolean getAutorHistorico() {
        return autorHistorico;
    }

    public void setAutorHistorico(boolean autorHistorico) {
        this.autorHistorico = autorHistorico;
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

    @XmlTransient
    public Collection<Fotosautores> getFotosautoresCollection() {
        return fotosautoresCollection;
    }

    public void setFotosautoresCollection(Collection<Fotosautores> fotosautoresCollection) {
        this.fotosautoresCollection = fotosautoresCollection;
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
        if (!(object instanceof Autores)) {
            return false;
        }
        Autores other = (Autores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre +" " +apellido;
    }
    
}
