/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_RMI_servidor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author josel
 */
@Entity
@Table(name = "activo_jlal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivoJlal.findAll", query = "SELECT a FROM ActivoJlal a")
    , @NamedQuery(name = "ActivoJlal.findByCodigoActivo", query = "SELECT a FROM ActivoJlal a WHERE a.codigoActivo = :codigoActivo")
    , @NamedQuery(name = "ActivoJlal.findByNombreActivo", query = "SELECT a FROM ActivoJlal a WHERE a.nombreActivo = :nombreActivo")
    , @NamedQuery(name = "ActivoJlal.findByFechaActivo", query = "SELECT a FROM ActivoJlal a WHERE a.fechaActivo = :fechaActivo")})
public class ActivoJlal implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activoJlal")
    private List<DetalleMantenimientoJlal> detalleMantenimientoJlalList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_ACTIVO")
    private Integer codigoActivo;
    @Column(name = "NOMBRE_ACTIVO")
    private String nombreActivo;
    @Column(name = "FECHA_ACTIVO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaActivo;

    public ActivoJlal() {
    }

    public ActivoJlal(Integer codigoActivo) {
        this.codigoActivo = codigoActivo;
    }

    public Integer getCodigoActivo() {
        return codigoActivo;
    }

    public void setCodigoActivo(Integer codigoActivo) {
        this.codigoActivo = codigoActivo;
    }

    public String getNombreActivo() {
        return nombreActivo;
    }

    public void setNombreActivo(String nombreActivo) {
        this.nombreActivo = nombreActivo;
    }

    public Date getFechaActivo() {
        return fechaActivo;
    }

    public void setFechaActivo(Date fechaActivo) {
        this.fechaActivo = fechaActivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoActivo != null ? codigoActivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivoJlal)) {
            return false;
        }
        ActivoJlal other = (ActivoJlal) object;
        if ((this.codigoActivo == null && other.codigoActivo != null) || (this.codigoActivo != null && !this.codigoActivo.equals(other.codigoActivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_interface.ActivoJlal[ codigoActivo=" + codigoActivo + " ]";
    }

    @XmlTransient
    public List<DetalleMantenimientoJlal> getDetalleMantenimientoJlalList() {
        return detalleMantenimientoJlalList;
    }

    public void setDetalleMantenimientoJlalList(List<DetalleMantenimientoJlal> detalleMantenimientoJlalList) {
        this.detalleMantenimientoJlalList = detalleMantenimientoJlalList;
    }
    
}
