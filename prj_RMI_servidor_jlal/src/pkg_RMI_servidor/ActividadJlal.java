/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_RMI_servidor;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author josel
 */
@Entity
@Table(name = "actividad_jlal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadJlal.findAll", query = "SELECT a FROM ActividadJlal a"),
    @NamedQuery(name = "ActividadJlal.findByCodigoActividad", query = "SELECT a FROM ActividadJlal a WHERE a.codigoActividad = :codigoActividad"),
    @NamedQuery(name = "ActividadJlal.findByNombreActividad", query = "SELECT a FROM ActividadJlal a WHERE a.nombreActividad = :nombreActividad")})
public class ActividadJlal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_ACTIVIDAD")
    private Integer codigoActividad;
    @Column(name = "NOMBRE_ACTIVIDAD")
    private String nombreActividad;

    public ActividadJlal() {
    }

    public ActividadJlal(Integer codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public Integer getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(Integer codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoActividad != null ? codigoActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadJlal)) {
            return false;
        }
        ActividadJlal other = (ActividadJlal) object;
        if ((this.codigoActividad == null && other.codigoActividad != null) || (this.codigoActividad != null && !this.codigoActividad.equals(other.codigoActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_RMI_servidor.ActividadJlal[ codigoActividad=" + codigoActividad + " ]";
    }
    
}
