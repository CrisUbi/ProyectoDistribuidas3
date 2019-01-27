/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_RMI_servidor;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author crist
 */
@Entity
@Table(name = "cabecera_cuda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CabeceraCuda.findAll", query = "SELECT c FROM CabeceraCuda c")
    , @NamedQuery(name = "CabeceraCuda.findByNumeroPrestamo", query = "SELECT c FROM CabeceraCuda c WHERE c.numeroPrestamo = :numeroPrestamo")
    , @NamedQuery(name = "CabeceraCuda.findByFechaPrestamo", query = "SELECT c FROM CabeceraCuda c WHERE c.fechaPrestamo = :fechaPrestamo")
    , @NamedQuery(name = "CabeceraCuda.findByDescripcionPrestamo", query = "SELECT c FROM CabeceraCuda c WHERE c.descripcionPrestamo = :descripcionPrestamo")
    , @NamedQuery(name = "CabeceraCuda.findByFechaentregaPrestamo", query = "SELECT c FROM CabeceraCuda c WHERE c.fechaentregaPrestamo = :fechaentregaPrestamo")})
public class CabeceraCuda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUMERO_PRESTAMO")
    private Integer numeroPrestamo;
    @Column(name = "FECHA_PRESTAMO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPrestamo;
    @Column(name = "DESCRIPCION_PRESTAMO")
    private String descripcionPrestamo;
    @Column(name = "FECHAENTREGA_PRESTAMO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaentregaPrestamo;

    public CabeceraCuda() {
    }

    public CabeceraCuda(Integer numeroPrestamo) {
        this.numeroPrestamo = numeroPrestamo;
    }

    public Integer getNumeroPrestamo() {
        return numeroPrestamo;
    }

    public void setNumeroPrestamo(Integer numeroPrestamo) {
        this.numeroPrestamo = numeroPrestamo;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getDescripcionPrestamo() {
        return descripcionPrestamo;
    }

    public void setDescripcionPrestamo(String descripcionPrestamo) {
        this.descripcionPrestamo = descripcionPrestamo;
    }

    public Date getFechaentregaPrestamo() {
        return fechaentregaPrestamo;
    }

    public void setFechaentregaPrestamo(Date fechaentregaPrestamo) {
        this.fechaentregaPrestamo = fechaentregaPrestamo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroPrestamo != null ? numeroPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CabeceraCuda)) {
            return false;
        }
        CabeceraCuda other = (CabeceraCuda) object;
        if ((this.numeroPrestamo == null && other.numeroPrestamo != null) || (this.numeroPrestamo != null && !this.numeroPrestamo.equals(other.numeroPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_RMI_servidor.CabeceraCuda[ numeroPrestamo=" + numeroPrestamo + " ]";
    }
    
}
