/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_Biblioteca;

import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pkg_interface.CabeceraCuda;
import pkg_interface.DetalleCuda;
import pkg_interface.LibroCuda;
import pkg_interface.cls_interface;

/**
 *
 * @author crist
 */
@ManagedBean()
@SessionScoped
public class cls_cabecera implements Serializable {

    Date fechaPrestamo =new Date();
    ArrayList<CabeceraCuda> cabeceras = null;
    List<DetalleCuda> detalle = null;
    String descripcionPrestamo;
    Date fechaentregaPrestamo=new Date();
    String mensaje = "";
    Integer numero = 0;
    Integer libro = 0;
    Integer cantida = 0;
    ArrayList<Integer> libros = null;

    public cls_cabecera() {
        buscarT();
    }

    public Integer getNumero() {
        return numero;
    }

    public ArrayList<Integer> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Integer> libros) {
        this.libros = libros;
    }

    public Integer getLibro() {
        return libro;
    }

    public void setLibro(Integer libro) {
        this.libro = libro;
    }

    public List<DetalleCuda> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleCuda> detalle) {
        this.detalle = detalle;
    }

    public ArrayList<CabeceraCuda> getCabeceras() {
        return cabeceras;
    }

    public void setCabeceras(ArrayList<CabeceraCuda> cabeceras) {
        this.cabeceras = cabeceras;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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

    public Integer getCantida() {
        return cantida;
    }

    public void setCantida(Integer cantida) {
        this.cantida = cantida;
    }

    public void insertar() {
        System.out.println("1");
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            mensaje = interface1.insertarCabeceraC(fechaPrestamo, descripcionPrestamo, fechaentregaPrestamo);
            buscarT();
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No se pudo insertar";
        }
    }

    public void buscar() {
        System.out.println("5");
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            CabeceraCuda busca = interface1.CabeceraC(numero);
            fechaPrestamo = busca.getFechaPrestamo();
            descripcionPrestamo = busca.getDescripcionPrestamo();
            fechaentregaPrestamo = busca.getFechaentregaPrestamo();
            mensaje = "Dato encontrado";
            buscarT();
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "Dato no encontrado";
        }
    }

    public void eliminar() {
        System.out.println("4");
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            mensaje = interface1.eliminarCabeceraC(numero);
            buscarT();
            descripcionPrestamo = "";
            numero = 0;
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No se pudo eliminar";
        }
    }

    public void modificar() {
        System.out.println("1");
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            mensaje = interface1.modificarCabeceraC(numero, fechaPrestamo, descripcionPrestamo, fechaentregaPrestamo);
            buscarT();
            descripcionPrestamo = "";
            numero = 0;
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No se pudo modificar";
        }
    }

    public void buscarT() {
        cabeceras = null;
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            cabeceras = interface1.CabecerasC();
            mensaje = "Tabla encontrada";
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No encontro Tabla";
        }
        System.out.println(mensaje);
    }

    public void detalles() {
        System.out.println("3de");
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            cabeceras = interface1.CabecerasC();
            numero = cabeceras.get(cabeceras.size() - 1).getNumeroPrestamo();
            System.out.println(numero);
            mensaje = interface1.insertarDetalleC(numero, libro, cantida);
            detallesV(numero);
            libro = 0;
            cantida = 0;
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No se pudo insertar";
        }
    }

    public void guardar() {
        fechaPrestamo=new Date();
        cabeceras = null;
        detalle = null;
        descripcionPrestamo="";
        fechaentregaPrestamo=new Date();
        mensaje = "";
        numero = 0;
        libro = 0;
        cantida = 0;
        libros = null;
    }

    public void detallesV(Integer numero1) {
        detalle = null;
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            detalle = interface1.Detalles(numero1);
            mensaje = "Tabla encontrada";
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No encontro Tabla";
        }
        System.out.println(mensaje);
    }

    public void buscarL() {
        libros = null;
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            libros = interface1.Libros1();
            mensaje = "Tabla encontrada11";
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No encontro Tabla11";
        }
        System.out.println(mensaje);
    }
}
