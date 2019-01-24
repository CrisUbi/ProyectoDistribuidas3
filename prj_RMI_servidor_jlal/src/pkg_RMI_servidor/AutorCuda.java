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
 * @author crist
 */
@Entity
@Table(name = "autor_cuda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AutorCuda.findAll", query = "SELECT a FROM AutorCuda a")
    , @NamedQuery(name = "AutorCuda.findByCodigoAutor", query = "SELECT a FROM AutorCuda a WHERE a.codigoAutor = :codigoAutor")
    , @NamedQuery(name = "AutorCuda.findByNombreAutor", query = "SELECT a FROM AutorCuda a WHERE a.nombreAutor = :nombreAutor")
    , @NamedQuery(name = "AutorCuda.findByApellidoAutor", query = "SELECT a FROM AutorCuda a WHERE a.apellidoAutor = :apellidoAutor")})
public class AutorCuda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_AUTOR")
    private Integer codigoAutor;
    @Column(name = "NOMBRE_AUTOR")
    private String nombreAutor;
    @Column(name = "APELLIDO_AUTOR")
    private String apellidoAutor;

    public AutorCuda() {
    }

    public AutorCuda(Integer codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    public Integer getCodigoAutor() {
        return codigoAutor;
    }

    public void setCodigoAutor(Integer codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getApellidoAutor() {
        return apellidoAutor;
    }

    public void setApellidoAutor(String apellidoAutor) {
        this.apellidoAutor = apellidoAutor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoAutor != null ? codigoAutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutorCuda)) {
            return false;
        }
        AutorCuda other = (AutorCuda) object;
        if ((this.codigoAutor == null && other.codigoAutor != null) || (this.codigoAutor != null && !this.codigoAutor.equals(other.codigoAutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_RMI_servidor.AutorCuda[ codigoAutor=" + codigoAutor + " ]";
    }
    
}
