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
@Table(name = "Obras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obras.findAll", query = "SELECT o FROM Obras o")
    , @NamedQuery(name = "Obras.findById", query = "SELECT o FROM Obras o WHERE o.id = :id")
    , @NamedQuery(name = "Obras.activos", query = "SELECT o FROM Obras o WHERE o.status = 1")
    , @NamedQuery(name = "Obras.eliminados", query = "SELECT o FROM Obras o WHERE o.status = 0")
    , @NamedQuery(name = "Obras.findByNombre", query = "SELECT o FROM Obras o WHERE o.nombre = :nombre")
    , @NamedQuery(name = "Obras.findByDescripcion", query = "SELECT o FROM Obras o WHERE o.descripcion = :descripcion")
    , @NamedQuery(name = "Obras.findByAnioCreacion", query = "SELECT o FROM Obras o WHERE o.anioCreacion = :anioCreacion")
    , @NamedQuery(name = "Obras.findByMedidas", query = "SELECT o FROM Obras o WHERE o.medidas = :medidas")
    , @NamedQuery(name = "Obras.findByStock", query = "SELECT o FROM Obras o WHERE o.stock = :stock")
    , @NamedQuery(name = "Obras.findByPrecio", query = "SELECT o FROM Obras o WHERE o.precio = :precio")
    , @NamedQuery(name = "Obras.findByStatus", query = "SELECT o FROM Obras o WHERE o.status = :status")})
public class Obras implements Serializable {

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
    @Size(min = 1, max = 800)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anio_creacion")
    @Temporal(TemporalType.DATE)
    private Date anioCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "medidas")
    private String medidas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "id_autor", referencedColumnName = "id")
    @ManyToOne
    private Autores idAutor;
    @JoinColumn(name = "id_corriente", referencedColumnName = "id")
    @ManyToOne
    private Corrientesart idCorriente;
    @JoinColumn(name = "id_tecnica", referencedColumnName = "id")
    @ManyToOne
    private Tecnicas idTecnica;
    @JoinColumn(name = "id_estilo", referencedColumnName = "id")
    @ManyToOne
    private Estilos idEstilo;
    @JoinColumn(name = "id_tipo", referencedColumnName = "id")
    @ManyToOne
    private Tiposobra idTipo;
    @OneToMany(mappedBy = "idObra")
    private Collection<DetalleVenta> detalleVentaCollection;
    @OneToMany(mappedBy = "idObra")
    private Collection<Fotosobras> fotosobrasCollection;
    @OneToMany(mappedBy = "idObra")
    private Collection<Obrasenexhibicion> obrasenexhibicionCollection;

    public Obras() {
    }

    public Obras(Integer id) {
        this.id = id;
    }

    public Obras(Integer id, String nombre, String descripcion, Date anioCreacion, String medidas, int stock, double precio, int status) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.anioCreacion = anioCreacion;
        this.medidas = medidas;
        this.stock = stock;
        this.precio = precio;
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

    public Date getAnioCreacion() {
        return anioCreacion;
    }

    public void setAnioCreacion(Date anioCreacion) {
        this.anioCreacion = anioCreacion;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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

    public Autores getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Autores idAutor) {
        this.idAutor = idAutor;
    }

    public Corrientesart getIdCorriente() {
        return idCorriente;
    }

    public void setIdCorriente(Corrientesart idCorriente) {
        this.idCorriente = idCorriente;
    }

    public Tecnicas getIdTecnica() {
        return idTecnica;
    }

    public void setIdTecnica(Tecnicas idTecnica) {
        this.idTecnica = idTecnica;
    }

    public Estilos getIdEstilo() {
        return idEstilo;
    }

    public void setIdEstilo(Estilos idEstilo) {
        this.idEstilo = idEstilo;
    }

    public Tiposobra getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Tiposobra idTipo) {
        this.idTipo = idTipo;
    }

    @XmlTransient
    public Collection<DetalleVenta> getDetalleVentaCollection() {
        return detalleVentaCollection;
    }

    public void setDetalleVentaCollection(Collection<DetalleVenta> detalleVentaCollection) {
        this.detalleVentaCollection = detalleVentaCollection;
    }

    @XmlTransient
    public Collection<Fotosobras> getFotosobrasCollection() {
        return fotosobrasCollection;
    }

    public void setFotosobrasCollection(Collection<Fotosobras> fotosobrasCollection) {
        this.fotosobrasCollection = fotosobrasCollection;
    }

    @XmlTransient
    public Collection<Obrasenexhibicion> getObrasenexhibicionCollection() {
        return obrasenexhibicionCollection;
    }

    public void setObrasenexhibicionCollection(Collection<Obrasenexhibicion> obrasenexhibicionCollection) {
        this.obrasenexhibicionCollection = obrasenexhibicionCollection;
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
        if (!(object instanceof Obras)) {
            return false;
        }
        Obras other = (Obras) object;
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
