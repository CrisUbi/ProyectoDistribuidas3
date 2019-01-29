/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_interface;

import java.io.Serializable;
import javax.persistence.Basic;
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
 * @author josel
 */
@Entity
@Table(name = "detalle_mantenimiento_jlal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleMantenimientoJlal.findAll", query = "SELECT d FROM DetalleMantenimientoJlal d")
    , @NamedQuery(name = "DetalleMantenimientoJlal.findByCodigoActividad", query = "SELECT d FROM DetalleMantenimientoJlal d WHERE d.detalleMantenimientoJlalPK.codigoActividad = :codigoActividad")
    , @NamedQuery(name = "DetalleMantenimientoJlal.findByCodigoActivo", query = "SELECT d FROM DetalleMantenimientoJlal d WHERE d.detalleMantenimientoJlalPK.codigoActivo = :codigoActivo")
    , @NamedQuery(name = "DetalleMantenimientoJlal.findByNumeroMantenimiento", query = "SELECT d FROM DetalleMantenimientoJlal d WHERE d.detalleMantenimientoJlalPK.numeroMantenimiento = :numeroMantenimiento")
    , @NamedQuery(name = "DetalleMantenimientoJlal.findByValorDMantenimiento", query = "SELECT d FROM DetalleMantenimientoJlal d WHERE d.valorDMantenimiento = :valorDMantenimiento")})
public class DetalleMantenimientoJlal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    @Basic(optional = false)
    @Column(name = "CODIGO_ACTIVIDAD")
    private Integer codigoActividad;
    @Basic(optional = false)
    @Column(name = "CODIGO_ACTIVO")
    private Integer codigoActivo;
    @Basic(optional = false)
    @Column(name = "NUMERO_MANTENIMIENTO")
    private Integer numeroMantenimiento;
       @Basic(optional = false)
    @Column(name = "VALOR_D_MANTENIMIENTO")
    private Integer valorDMantenimiento;
    

    public DetalleMantenimientoJlal() {
    }

    

    public Integer getValorDMantenimiento() {
        return valorDMantenimiento;
    }

    public void setValorDMantenimiento(Integer valorDMantenimiento) {
        this.valorDMantenimiento = valorDMantenimiento;
    }

    public Integer getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(Integer codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public Integer getCodigoActivo() {
        return codigoActivo;
    }

    public void setCodigoActivo(Integer codigoActivo) {
        this.codigoActivo = codigoActivo;
    }

    public Integer getNumeroMantenimiento() {
        return numeroMantenimiento;
    }

    public void setNumeroMantenimiento(Integer numeroMantenimiento) {
        this.numeroMantenimiento = numeroMantenimiento;
    }

    


 
    
}
