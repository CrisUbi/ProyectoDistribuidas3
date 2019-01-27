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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author crist
 */
@Entity
@Table(name = "cabecera_comprobante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CabeceraComprobante.findAll", query = "SELECT c FROM CabeceraComprobante c")
    , @NamedQuery(name = "CabeceraComprobante.findByNumeroCabecera", query = "SELECT c FROM CabeceraComprobante c WHERE c.numeroCabecera = :numeroCabecera")
    , @NamedQuery(name = "CabeceraComprobante.findByFechaCabecera", query = "SELECT c FROM CabeceraComprobante c WHERE c.fechaCabecera = :fechaCabecera")
    , @NamedQuery(name = "CabeceraComprobante.findByObservaciones", query = "SELECT c FROM CabeceraComprobante c WHERE c.observaciones = :observaciones")})
public class CabeceraComprobante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUMERO_CABECERA")
    private Integer numeroCabecera;
    @Column(name = "FECHA_CABECERA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCabecera;
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroCabecera")
    private List<DetalleComprobante> detalleComprobanteList;

    public CabeceraComprobante() {
    }

    public CabeceraComprobante(Integer numeroCabecera) {
        this.numeroCabecera = numeroCabecera;
    }

    public Integer getNumeroCabecera() {
        return numeroCabecera;
    }

    public void setNumeroCabecera(Integer numeroCabecera) {
        this.numeroCabecera = numeroCabecera;
    }

    public Date getFechaCabecera() {
        return fechaCabecera;
    }

    public void setFechaCabecera(Date fechaCabecera) {
        this.fechaCabecera = fechaCabecera;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<DetalleComprobante> getDetalleComprobanteList() {
        return detalleComprobanteList;
    }

    public void setDetalleComprobanteList(List<DetalleComprobante> detalleComprobanteList) {
        this.detalleComprobanteList = detalleComprobanteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroCabecera != null ? numeroCabecera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CabeceraComprobante)) {
            return false;
        }
        CabeceraComprobante other = (CabeceraComprobante) object;
        if ((this.numeroCabecera == null && other.numeroCabecera != null) || (this.numeroCabecera != null && !this.numeroCabecera.equals(other.numeroCabecera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_RMI_servidor.CabeceraComprobante[ numeroCabecera=" + numeroCabecera + " ]";
    }
    
}
