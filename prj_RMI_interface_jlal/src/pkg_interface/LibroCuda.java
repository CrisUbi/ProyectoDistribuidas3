/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_interface;

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
@Table(name = "libro_cuda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LibroCuda.findAll", query = "SELECT l FROM LibroCuda l")
    , @NamedQuery(name = "LibroCuda.findByIsbnLibro", query = "SELECT l FROM LibroCuda l WHERE l.isbnLibro = :isbnLibro")
    , @NamedQuery(name = "LibroCuda.findByCodigoAutor", query = "SELECT l FROM LibroCuda l WHERE l.codigoAutor = :codigoAutor")
    , @NamedQuery(name = "LibroCuda.findByTituloLibro", query = "SELECT l FROM LibroCuda l WHERE l.tituloLibro = :tituloLibro")
    , @NamedQuery(name = "LibroCuda.findByValorLibro", query = "SELECT l FROM LibroCuda l WHERE l.valorLibro = :valorLibro")
    , @NamedQuery(name = "LibroCuda.findByCantidadLibro", query = "SELECT l FROM LibroCuda l WHERE l.cantidadLibro = :cantidadLibro")})
public class LibroCuda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ISBN_LIBRO")
    private Integer isbnLibro;
    @Basic(optional = false)
    @Column(name = "CODIGO_AUTOR")
    private int codigoAutor;
    @Column(name = "TITULO_LIBRO")
    private String tituloLibro;
    @Column(name = "VALOR_LIBRO")
    private Long valorLibro;
    @Column(name = "CANTIDAD_LIBRO")
    private Integer cantidadLibro;

    public LibroCuda() {
    }

    public LibroCuda(Integer isbnLibro) {
        this.isbnLibro = isbnLibro;
    }

    public LibroCuda(Integer isbnLibro, int codigoAutor) {
        this.isbnLibro = isbnLibro;
        this.codigoAutor = codigoAutor;
    }

    public Integer getIsbnLibro() {
        return isbnLibro;
    }

    public void setIsbnLibro(Integer isbnLibro) {
        this.isbnLibro = isbnLibro;
    }

    public int getCodigoAutor() {
        return codigoAutor;
    }

    public void setCodigoAutor(int codigoAutor) {
        this.codigoAutor = codigoAutor;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public Long getValorLibro() {
        return valorLibro;
    }

    public void setValorLibro(Long valorLibro) {
        this.valorLibro = valorLibro;
    }

    public Integer getCantidadLibro() {
        return cantidadLibro;
    }

    public void setCantidadLibro(Integer cantidadLibro) {
        this.cantidadLibro = cantidadLibro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbnLibro != null ? isbnLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LibroCuda)) {
            return false;
        }
        LibroCuda other = (LibroCuda) object;
        if ((this.isbnLibro == null && other.isbnLibro != null) || (this.isbnLibro != null && !this.isbnLibro.equals(other.isbnLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_interface.LibroCuda[ isbnLibro=" + isbnLibro + " ]";
    }
    
}
