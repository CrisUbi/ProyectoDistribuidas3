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
public class cls_detalle_mantenimiento implements Serializable {

    
  
   Integer codigoActividad;
    Integer codigoActivo;
    Integer numeroMantenimiento;
    Integer valorDMantenimiento;
    String mensaje;
    ArrayList<DetalleMantenimientoJlal> busca ;
    ArrayList<DetalleMantenimientoJlal> busca1 ;
ArrayList<Integer> lcodigoActividad;
    ArrayList<Integer> lcodigoActivo;
    ArrayList<Integer> lnumeroMantenimiento;

    public ArrayList<DetalleMantenimientoJlal> getBusca1() {
        return busca1;
    }

    public void setBusca1(ArrayList<DetalleMantenimientoJlal> busca1) {
        this.busca1 = busca1;
    }
    

    public Integer getNumeroMantenimiento() {
        return numeroMantenimiento;
    }

    public void setNumeroMantenimiento(Integer numeroMantenimiento) {
        this.numeroMantenimiento = numeroMantenimiento;
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

    public Integer getValorDMantenimiento() {
        return valorDMantenimiento;
    }

    public void setValorDMantenimiento(Integer valorDMantenimiento) {
        this.valorDMantenimiento = valorDMantenimiento;
    }

    public ArrayList<DetalleMantenimientoJlal> getBusca() {
        return busca;
    }

    public void setBusca(ArrayList<DetalleMantenimientoJlal> busca) {
        this.busca = busca;
    }

   

    

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

   

   
    
    
        public cls_detalle_mantenimiento ()
    {
        buscartabla();
        buscarreporte();
    }
    public void buscar()
    { 
        try
        {Registry registro=LocateRegistry.getRegistry("127.0.0.1",1095);
        cls_interface interface1=(cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
        buscartabla();
        DetalleMantenimientoJlal busca=interface1.buscarDetalleM(codigoActividad, codigoActivo, numeroMantenimiento);
        valorDMantenimiento=busca.getValorDMantenimiento();
        mensaje="Encontro Dato";
        }
        catch(RemoteException | NotBoundException ex)
        { System.out.println("error");
        mensaje="No encontro Dato";
        }
        System.out.println(mensaje);
         
      }

    public ArrayList<Integer> getLcodigoActividad() {
        return lcodigoActividad;
    }

    public void setLcodigoActividad(ArrayList<Integer> lcodigoActividad) {
        this.lcodigoActividad = lcodigoActividad;
    }

    public ArrayList<Integer> getLcodigoActivo() {
        return lcodigoActivo;
    }

    public void setLcodigoActivo(ArrayList<Integer> lcodigoActivo) {
        this.lcodigoActivo = lcodigoActivo;
    }

    public ArrayList<Integer> getLnumeroMantenimiento() {
        return lnumeroMantenimiento;
    }

    public void setLnumeroMantenimiento(ArrayList<Integer> lnumeroMantenimiento) {
        this.lnumeroMantenimiento = lnumeroMantenimiento;
    }
    
    public void  buscartabla()
    { 
    busca= null;
        try
        {Registry registro=LocateRegistry.getRegistry("127.0.0.1",1095);
        cls_interface interface1=(cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
        busca=interface1.buscarDetalleM();
         ArrayList<Integer> lcodigoActividad1=new ArrayList();
    ArrayList<Integer> lcodigoActivo1=new ArrayList();
    ArrayList<Integer> lnumeroMantenimiento1=new ArrayList();
        for(int i=0;i<busca.size();i++){
            lcodigoActividad1.add(busca.get(i).getCodigoActividad());
    lcodigoActivo1.add(busca.get(i).getCodigoActivo());
    lnumeroMantenimiento1.add(busca.get(i).getNumeroMantenimiento());
        }
        lcodigoActividad=lcodigoActividad1;
        lcodigoActivo=lcodigoActivo1;
        lnumeroMantenimiento=lnumeroMantenimiento1;
         mensaje="Tabla encontrada";
        }
        catch(RemoteException | NotBoundException ex)
        { System.out.println("error");
        mensaje="No encontro Tabla";
        }
        System.out.println(mensaje);
      }
    public void  buscarreporte()
    { 
    busca1= null;
        try
        {Registry registro=LocateRegistry.getRegistry("127.0.0.1",1095);
        cls_interface interface1=(cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
        busca1=interface1.ReporteM1();
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
        interface1.insertarDetalleM(codigoActividad, codigoActivo, numeroMantenimiento, valorDMantenimiento);
        mensaje="Inserto Correctamente";
        }
        catch(RemoteException | NotBoundException ex)
        { System.out.println("error");
        mensaje="No se pudo insertar";
        }
        buscartabla();
         buscarreporte();
        System.out.println(mensaje);
      }
      public void eliminar()
    { 
        try
        {Registry registro=LocateRegistry.getRegistry("127.0.0.1",1095);
        cls_interface interface1=(cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
        interface1.eliminarDetalleM(codigoActividad, codigoActivo, numeroMantenimiento);
        mensaje="Inserto Correctamente";
        }
        catch(RemoteException | NotBoundException ex)
        { System.out.println("error");
        mensaje="No se pudo insertar";
        }
        buscartabla();
         buscarreporte();
        System.out.println(mensaje);
      }
       public void modificar()
    { 
        try
        {Registry registro=LocateRegistry.getRegistry("127.0.0.1",1095);
        cls_interface interface1=(cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
        interface1.modificarDetalleM(codigoActividad, codigoActivo, numeroMantenimiento, valorDMantenimiento);
        mensaje="Inserto Correctamente";
        }
        catch(RemoteException | NotBoundException ex)
        { System.out.println("error");
        mensaje="No se pudo insertar";
        }
        buscartabla();
         buscarreporte();
        System.out.println(mensaje);
      }
}
