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
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pkg_interface.AutorCuda;

import pkg_interface.cls_interface;

/**
 *
 * @author crist
 */
@ManagedBean()
@SessionScoped
public class cls_autor {

    Integer codigoAutor = 0;
    String nombreAutor = "";
    String apellidoAutor = "";
    String mensaje = "";
    ArrayList<AutorCuda> autores = null;

    public cls_autor() {
        buscarT();
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
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

    public ArrayList<AutorCuda> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<AutorCuda> autores) {
        this.autores = autores;
    }

    public void insertar() {
        System.out.println("2");
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            mensaje = interface1.insertarAutor(codigoAutor, nombreAutor, apellidoAutor);
            buscarT();
            codigoAutor = 0;
            nombreAutor = "";
            apellidoAutor = "";
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
            AutorCuda busca = interface1.Autor(codigoAutor);
            nombreAutor = busca.getNombreAutor();
            apellidoAutor = busca.getApellidoAutor();
            mensaje = "Dato encontrado";
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
            mensaje = interface1.eliminarAutor(codigoAutor);
            buscarT();
            codigoAutor = 0;
            nombreAutor = "";
            apellidoAutor = "";
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
            mensaje = interface1.modificarAutor(codigoAutor, nombreAutor, apellidoAutor);
            buscarT();
            codigoAutor = 0;
            nombreAutor = "";
            apellidoAutor = "";
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No se pudo modificar";
        }
    }

    public void buscarT() {
        autores = null;
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            autores = interface1.Autores();
            mensaje = "Tabla encontrada";
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No encontro Tabla";
        }
        System.out.println(mensaje);
    }

}
