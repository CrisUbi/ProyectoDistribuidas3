/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_Mantenimiento;

import pkg_Biblioteca.*;
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
import pkg_interface.DetalleMantenimientoJlal;
import pkg_interface.MantenimientoJlal;

import pkg_interface.cls_interface;

/**
 *
 * @author crist
 */
@ManagedBean()
@SessionScoped
public class cls_cabecera_Mantenimiento implements Serializable {

    
   Integer numeroMantenimiento;
   Date fechaMantenimiento =new Date();
 String responsableMantenimiento;
    String mensaje;
    ArrayList<MantenimientoJlal> busca ;

    public ArrayList<MantenimientoJlal> getBusca() {
        return busca;
    }

    public void setBusca(ArrayList<MantenimientoJlal> busca) {
        this.busca = busca;
    }

    public Integer getNumeroMantenimiento() {
        return numeroMantenimiento;
    }

    public void setNumeroMantenimiento(Integer numeroMantenimiento) {
        this.numeroMantenimiento = numeroMantenimiento;
    }

    public Date getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    public void setFechaMantenimiento(Date fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public String getResponsableMantenimiento() {
        return responsableMantenimiento;
    }

    public void setResponsableMantenimiento(String responsableMantenimiento) {
        this.responsableMantenimiento = responsableMantenimiento;
    }

    

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

   

   
    
    
        public cls_cabecera_Mantenimiento ()
    {
        buscartabla();
    }
    public void buscar()
    { 
        try
        {Registry registro=LocateRegistry.getRegistry("127.0.0.1",1095);
        cls_interface interface1=(cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
        MantenimientoJlal busca=interface1.buscarActivoMante(numeroMantenimiento);
        
        fechaMantenimiento=busca.getFechaMantenimiento();
        responsableMantenimiento=busca.getResponsableMantenimiento();
        mensaje="Encontro Dato";
        }
        catch(RemoteException | NotBoundException ex)
        { System.out.println("error");
        mensaje="No encontro Dato";
        }
        System.out.println(mensaje);
         buscartabla();
      }
    public void  buscartabla()
    { 
    busca= null;
        try
        {Registry registro=LocateRegistry.getRegistry("127.0.0.1",1095);
        cls_interface interface1=(cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
        busca=interface1.buscarMante();
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
        interface1.insertarMante(numeroMantenimiento, fechaMantenimiento, responsableMantenimiento);
        mensaje="Inserto Correctamente";
        }
        catch(RemoteException | NotBoundException ex)
        { System.out.println("error");
        mensaje="No se pudo insertar";
        }
        buscartabla();
        System.out.println(mensaje);
      }
      public void eliminar()
    { 
        try
        {Registry registro=LocateRegistry.getRegistry("127.0.0.1",1095);
        cls_interface interface1=(cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
        interface1.eliminarMante(numeroMantenimiento);
        mensaje="Inserto Correctamente";
        }
        catch(RemoteException | NotBoundException ex)
        { System.out.println("error");
        mensaje="No se pudo insertar";
        }
        buscartabla();
        System.out.println(mensaje);
      }
       public void modificar()
    { 
        try
        {Registry registro=LocateRegistry.getRegistry("127.0.0.1",1095);
        cls_interface interface1=(cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
        interface1.modificarMante(numeroMantenimiento, fechaMantenimiento, responsableMantenimiento);
        mensaje="Inserto Correctamente";
        }
        catch(RemoteException | NotBoundException ex)
        { System.out.println("error");
        mensaje="No se pudo insertar";
        }
        buscartabla();
        System.out.println(mensaje);
      }
}
