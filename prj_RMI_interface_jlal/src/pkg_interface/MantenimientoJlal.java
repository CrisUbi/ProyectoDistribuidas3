/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_interface;

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
 * @author josel
 */
@Entity
@Table(name = "mantenimiento_jlal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MantenimientoJlal.findAll", query = "SELECT m FROM MantenimientoJlal m")
    , @NamedQuery(name = "MantenimientoJlal.findByNumeroMantenimiento", query = "SELECT m FROM MantenimientoJlal m WHERE m.numeroMantenimiento = :numeroMantenimiento")
    , @NamedQuery(name = "MantenimientoJlal.findByFechaMantenimiento", query = "SELECT m FROM MantenimientoJlal m WHERE m.fechaMantenimiento = :fechaMantenimiento")
    , @NamedQuery(name = "MantenimientoJlal.findByResponsableMantenimiento", query = "SELECT m FROM MantenimientoJlal m WHERE m.responsableMantenimiento = :responsableMantenimiento")})
public class MantenimientoJlal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUMERO_MANTENIMIENTO")
    private Integer numeroMantenimiento;
    @Column(name = "FECHA_MANTENIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMantenimiento;
    @Column(name = "RESPONSABLE_MANTENIMIENTO")
    private String responsableMantenimiento;
    

    public MantenimientoJlal() {
    }

    
    public MantenimientoJlal(Integer numeroMantenimiento) {
        this.numeroMantenimiento = numeroMantenimiento;
    }

    public Integer getNumeroMantenimiento() {
        return numeroMantenimiento;
    }

    public void setNumeroMantenimiento(Integer numeroMantenimiento) {
        this.numeroMantenimiento = numeroMantenimiento;
    }

    public Date getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    public void setFechaMantenimiento(Date fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public String getResponsableMantenimiento() {
        return responsableMantenimiento;
    }

    public void setResponsableMantenimiento(String responsableMantenimiento) {
        this.responsableMantenimiento = responsableMantenimiento;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroMantenimiento != null ? numeroMantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MantenimientoJlal)) {
            return false;
        }
        MantenimientoJlal other = (MantenimientoJlal) object;
        if ((this.numeroMantenimiento == null && other.numeroMantenimiento != null) || (this.numeroMantenimiento != null && !this.numeroMantenimiento.equals(other.numeroMantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_RMI_servidor.MantenimientoJlal[ numeroMantenimiento=" + numeroMantenimiento + " ]";
    }
    
}
