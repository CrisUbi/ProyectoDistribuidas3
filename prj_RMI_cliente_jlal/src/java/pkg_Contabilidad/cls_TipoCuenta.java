/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_Contabilidad;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pkg_interface.TipoCuenta;
import pkg_interface.cls_interface;

/**
 *
 * @author kelog
 */
@ManagedBean()
@SessionScoped
public class cls_TipoCuenta {
    Integer codigoTipo = 0;
    String nombreTipo = "";
    String mensaje = "";
    ArrayList<TipoCuenta> tcuentas = null;

    public Integer getCodigoTipo() {
        return codigoTipo;
    }

    public void setCodigoTipo(Integer codigoTipo) {
        this.codigoTipo = codigoTipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ArrayList<TipoCuenta> getTcuentas() {
        return tcuentas;
    }

    public void setTcuentas(ArrayList<TipoCuenta> tcuentas) {
        this.tcuentas = tcuentas;
    }

    public cls_TipoCuenta() {
        buscartabla();
    }
    
    public void buscar()
    { 
        try
        {Registry registro=LocateRegistry.getRegistry("127.0.0.1",1095);
        cls_interface interface1=(cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
        TipoCuenta busca=interface1.TipoCuenta(codigoTipo);
        nombreTipo=busca.getNombreTipo();
        
    
    mensaje="Encontro Dato";
        }
        catch(RemoteException | NotBoundException ex)
        { System.out.println("error");
        mensaje="No encontro Dato";
        }
        System.out.println(mensaje);
      }
    
    
    
    public void  buscartabla()
    { 
    tcuentas= null;
        try
        {Registry registro=LocateRegistry.getRegistry("127.0.0.1",1095);
        cls_interface interface1=(cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
        tcuentas=interface1.TipoCuentas();
         mensaje="Tabla encontrada";
        }
        catch(RemoteException | NotBoundException ex)
        { System.out.println("error");
        mensaje="No encontro Tabla";
        }
        System.out.println(mensaje);
      }
    
    public void insertar()
    { 
        try
        {Registry registro=LocateRegistry.getRegistry("127.0.0.1",1095);
        cls_interface interface1=(cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
        interface1.insertar(codigoTipo, nombreTipo);
        mensaje="Inserto Correctamente";
        }
        catch(RemoteException | NotBoundException ex)
        { System.out.println("error");
        mensaje="No se pudo insertar";
        }
        buscartabla();
        System.out.println(mensaje);
      }
    


    public void eliminar() {
        System.out.println("4");
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            mensaje = interface1.eliminarAutor(codigoTipo);
            buscartabla();
            codigoTipo = 0;
            nombreTipo = "";
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No se pudo eliminar";
        }
        buscartabla();
    }

    public void modificar() {
        System.out.println("1");
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            mensaje = interface1.modificarTipoCuenta(codigoTipo, nombreTipo);
            buscartabla();
            codigoTipo = 0;
            nombreTipo = "";
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No se pudo modificar";
        }
        buscartabla();
    }
    
}
