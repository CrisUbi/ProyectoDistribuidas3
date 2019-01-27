/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_RMI_servidor;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author crist
 */
@Entity
@Table(name = "detalle_cuda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleCuda.findAll", query = "SELECT d FROM DetalleCuda d")
    , @NamedQuery(name = "DetalleCuda.findByNumeroPrestamo", query = "SELECT d FROM DetalleCuda d WHERE d.detalleCudaPK.numeroPrestamo = :numeroPrestamo")
    , @NamedQuery(name = "DetalleCuda.findByIsbnLibro", query = "SELECT d FROM DetalleCuda d WHERE d.detalleCudaPK.isbnLibro = :isbnLibro")
    , @NamedQuery(name = "DetalleCuda.findByCantidad", query = "SELECT d FROM DetalleCuda d WHERE d.cantidad = :cantidad")})
public class DetalleCuda implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleCudaPK detalleCudaPK;
    @Column(name = "CANTIDAD")
    private Integer cantidad;


    public DetalleCuda() {
    }

    public DetalleCuda(DetalleCudaPK detalleCudaPK) {
        this.detalleCudaPK = detalleCudaPK;
    }

    public DetalleCuda(int numeroPrestamo, int isbnLibro) {
        this.detalleCudaPK = new DetalleCudaPK(numeroPrestamo, isbnLibro);
    }

    public DetalleCudaPK getDetalleCudaPK() {
        return detalleCudaPK;
    }

    public void setDetalleCudaPK(DetalleCudaPK detalleCudaPK) {
        this.detalleCudaPK = detalleCudaPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleCudaPK != null ? detalleCudaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCuda)) {
            return false;
        }
        DetalleCuda other = (DetalleCuda) object;
        if ((this.detalleCudaPK == null && other.detalleCudaPK != null) || (this.detalleCudaPK != null && !this.detalleCudaPK.equals(other.detalleCudaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_RMI_servidor.DetalleCuda[ detalleCudaPK=" + detalleCudaPK + " ]";
    }
    
}
