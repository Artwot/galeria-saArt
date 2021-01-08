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
@Table(name = "Correos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Correos.findAll", query = "SELECT c FROM Correos c")
    , @NamedQuery(name = "Correos.findById", query = "SELECT c FROM Correos c WHERE c.id = :id")
    , @NamedQuery(name = "Correos.activos", query = "SELECT c FROM Correos c WHERE c.status = 1")
    , @NamedQuery(name = "Correos.eliminados", query = "SELECT c FROM Correos c WHERE c.status = 0")
    , @NamedQuery(name = "Correos.findByDestinatario", query = "SELECT c FROM Correos c WHERE c.destinatario = :destinatario")
    , @NamedQuery(name = "Correos.findByContenido", query = "SELECT c FROM Correos c WHERE c.contenido = :contenido")
    , @NamedQuery(name = "Correos.findByFecha", query = "SELECT c FROM Correos c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Correos.findByStatus", query = "SELECT c FROM Correos c WHERE c.status = :status")})
public class Correos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "destinatario")
    private String destinatario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 800)
    @Column(name = "contenido")
    private String contenido;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "id_usu_remitente", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idUsuRemitente;

    public Correos() {
    }

    public Correos(Integer id) {
        this.id = id;
    }

    public Correos(Integer id, String destinatario, String contenido, int status) {
        this.id = id;
        this.destinatario = destinatario;
        this.contenido = contenido;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Usuarios getIdUsuRemitente() {
        return idUsuRemitente;
    }

    public void setIdUsuRemitente(Usuarios idUsuRemitente) {
        this.idUsuRemitente = idUsuRemitente;
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
        if (!(object instanceof Correos)) {
            return false;
        }
        Correos other = (Correos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Correos[ id=" + id + " ]";
    }

}
