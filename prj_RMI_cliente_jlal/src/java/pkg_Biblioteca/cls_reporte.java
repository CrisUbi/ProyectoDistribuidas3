/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_Biblioteca;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pkg_interface.AutorCuda;
import pkg_interface.CabeceraCuda;
import pkg_interface.DetalleCuda;
import pkg_interface.cls_interface;

/**
 *
 * @author crist
 */
@ManagedBean()
@SessionScoped
public class cls_reporte {

    Date fechaI = new Date();
    Date fechaF = new Date();
    List<CabeceraCuda> detalle = null;
    String mensaje = "";
    List<AutorCuda> reporte = null;

    public cls_reporte() {
    }

    public void buscar() {
        detalle = null;
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            detalle = interface1.reporte1(fechaI, fechaF);
            mensaje = "Tabla encontrada";
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No encontro Tabla";
        }
        System.out.println(mensaje);
    }

    public void reporte1() {
        reporte = null;
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            reporte = interface1.reporte2(fechaI, fechaF);
            mensaje = "Tabla encontrada";
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No encontro Tabla";
        }
        System.out.println(mensaje);
    }

    public List<AutorCuda> getReporte() {
        return reporte;
    }

    public void setReporte(List<AutorCuda> reporte) {
        this.reporte = reporte;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFechaI() {
        return fechaI;
    }

    public void setFechaI(Date fechaI) {
        this.fechaI = fechaI;
    }

    public Date getFechaF() {
        return fechaF;
    }

    public void setFechaF(Date fechaF) {
        this.fechaF = fechaF;
    }

    public List<CabeceraCuda> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<CabeceraCuda> detalle) {
        this.detalle = detalle;
    }

}
