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
import pkg_interface.ActividadJlal;
import pkg_interface.AutorCuda;
import pkg_interface.LibroCuda;
import pkg_interface.cls_interface;

/**
 *
 * @author crist
 */
@ManagedBean()
@SessionScoped
public class cls_libro {

    String mensaje = "";
    ArrayList<LibroCuda> libros = null;
    ArrayList<Integer> autores = null;
    Integer isbnLibro = 0;
    int codigoAutor = 0;
    String tituloLibro = "";
    Integer valorLibro;
    Integer cantidadLibro = 0;

    public cls_libro() {
        buscarT();
        buscarA();
    }

    public ArrayList<Integer> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Integer> autores) {
        this.autores = autores;
    }



    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ArrayList<LibroCuda> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<LibroCuda> libros) {
        this.libros = libros;
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

    public Integer getValorLibro() {
        return valorLibro;
    }

    public void setValorLibro(Integer valorLibro) {
        this.valorLibro = valorLibro;
    }

    public Integer getCantidadLibro() {
        return cantidadLibro;
    }

    public void setCantidadLibro(Integer cantidadLibro) {
        this.cantidadLibro = cantidadLibro;
    }

    public void insertar() {
        System.out.println("2");
        System.out.println(codigoAutor);
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            mensaje = interface1.insertarLibro(isbnLibro, codigoAutor, tituloLibro, Long.valueOf(String.valueOf(valorLibro)), cantidadLibro);
            buscarT();
            isbnLibro = 0;
            codigoAutor = 0;
            tituloLibro = "";
            valorLibro = 0;
            cantidadLibro = 0;
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
            LibroCuda busca = interface1.Libro(isbnLibro);
            codigoAutor = busca.getCodigoAutor();
            tituloLibro = busca.getTituloLibro();
            valorLibro = Integer.valueOf(String.valueOf(busca.getValorLibro()));
            cantidadLibro = busca.getCantidadLibro();
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
            mensaje = interface1.eliminarLibro(isbnLibro);
            buscarT();
            isbnLibro = 0;
            codigoAutor = 0;
            tituloLibro = "";
            valorLibro = 0;
            cantidadLibro = 0;
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
            mensaje = interface1.modificarLibro(isbnLibro, codigoAutor, tituloLibro, Long.valueOf(String.valueOf(valorLibro)), cantidadLibro);
            buscarT();
            isbnLibro = 0;
            codigoAutor = 0;
            tituloLibro = "";
            valorLibro = 0;
            cantidadLibro = 0;
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No se pudo modificar";
        }
    }

    public void buscarT() {
        libros = null;
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            libros = interface1.Libros();
            mensaje = "Tabla encontrada";
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No encontro Tabla";
        }
        System.out.println(mensaje);
    }

    public void buscarA() {
        autores = null;
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            autores = interface1.Autores1();
            mensaje = "Tabla encontrada11";
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No encontro Tabla11";
        }
        System.out.println(mensaje);
    }
}
