/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_interface;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author crist
 */
@Embeddable
public class DetalleCudaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "NUMERO_PRESTAMO")
    private int numeroPrestamo;
    @Basic(optional = false)
    @Column(name = "ISBN_LIBRO")
    private int isbnLibro;

    public DetalleCudaPK() {
    }

    public DetalleCudaPK(int numeroPrestamo, int isbnLibro) {
        this.numeroPrestamo = numeroPrestamo;
        this.isbnLibro = isbnLibro;
    }

    public int getNumeroPrestamo() {
        return numeroPrestamo;
    }

    public void setNumeroPrestamo(int numeroPrestamo) {
        this.numeroPrestamo = numeroPrestamo;
    }

    public int getIsbnLibro() {
        return isbnLibro;
    }

    public void setIsbnLibro(int isbnLibro) {
        this.isbnLibro = isbnLibro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numeroPrestamo;
        hash += (int) isbnLibro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCudaPK)) {
            return false;
        }
        DetalleCudaPK other = (DetalleCudaPK) object;
        if (this.numeroPrestamo != other.numeroPrestamo) {
            return false;
        }
        if (this.isbnLibro != other.isbnLibro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pkg_interface.DetalleCudaPK[ numeroPrestamo=" + numeroPrestamo + ", isbnLibro=" + isbnLibro + " ]";
    }
    
}
