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
@Table(name = "Galerias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Galerias.findAll", query = "SELECT g FROM Galerias g")
    , @NamedQuery(name = "Galerias.findById", query = "SELECT g FROM Galerias g WHERE g.id = :id")
    , @NamedQuery(name = "Galerias.activos", query = "SELECT g FROM Galerias g WHERE g.status = 1")
    , @NamedQuery(name = "Galerias.eliminados", query = "SELECT g FROM Galerias g WHERE g.status = 0")
    , @NamedQuery(name = "Galerias.findByNombre", query = "SELECT g FROM Galerias g WHERE g.nombre = :nombre")
    , @NamedQuery(name = "Galerias.findByCalle", query = "SELECT g FROM Galerias g WHERE g.calle = :calle")
    , @NamedQuery(name = "Galerias.findByNumExt", query = "SELECT g FROM Galerias g WHERE g.numExt = :numExt")
    , @NamedQuery(name = "Galerias.findByColonia", query = "SELECT g FROM Galerias g WHERE g.colonia = :colonia")
    , @NamedQuery(name = "Galerias.findByCp", query = "SELECT g FROM Galerias g WHERE g.cp = :cp")
    , @NamedQuery(name = "Galerias.findByTelefono", query = "SELECT g FROM Galerias g WHERE g.telefono = :telefono")
    , @NamedQuery(name = "Galerias.findByWeb", query = "SELECT g FROM Galerias g WHERE g.web = :web")
    , @NamedQuery(name = "Galerias.findByHorario", query = "SELECT g FROM Galerias g WHERE g.horario = :horario")
    , @NamedQuery(name = "Galerias.findByStatus", query = "SELECT g FROM Galerias g WHERE g.status = :status")})
public class Galerias implements Serializable {

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
    @Size(min = 1, max = 120)
    @Column(name = "calle")
    private String calle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_ext")
    private int numExt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "colonia")
    private String colonia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cp")
    private int cp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "web")
    private String web;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "horario")
    private String horario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(mappedBy = "idGaleria")
    private Collection<Exhibiciones> exhibicionesCollection;
    @JoinColumn(name = "id_pais", referencedColumnName = "id")
    @ManyToOne
    private Paises idPais;
    @JoinColumn(name = "id_entidad", referencedColumnName = "id")
    @ManyToOne
    private Entidades idEntidad;
    @JoinColumn(name = "id_municipio", referencedColumnName = "id")
    @ManyToOne
    private Municipios idMunicipio;

    public Galerias() {
    }

    public Galerias(Integer id) {
        this.id = id;
    }

    public Galerias(Integer id, String nombre, String calle, int numExt, String colonia, int cp, String telefono, String web, String horario, int status) {
        this.id = id;
        this.nombre = nombre;
        this.calle = calle;
        this.numExt = numExt;
        this.colonia = colonia;
        this.cp = cp;
        this.telefono = telefono;
        this.web = web;
        this.horario = horario;
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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumExt() {
        return numExt;
    }

    public void setNumExt(int numExt) {
        this.numExt = numExt;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Exhibiciones> getExhibicionesCollection() {
        return exhibicionesCollection;
    }

    public void setExhibicionesCollection(Collection<Exhibiciones> exhibicionesCollection) {
        this.exhibicionesCollection = exhibicionesCollection;
    }

    public Paises getIdPais() {
        return idPais;
    }

    public void setIdPais(Paises idPais) {
        this.idPais = idPais;
    }

    public Entidades getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Entidades idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Municipios getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Municipios idMunicipio) {
        this.idMunicipio = idMunicipio;
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
        if (!(object instanceof Galerias)) {
            return false;
        }
        Galerias other = (Galerias) object;
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
