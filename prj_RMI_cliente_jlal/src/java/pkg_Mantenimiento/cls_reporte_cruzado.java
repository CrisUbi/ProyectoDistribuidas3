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
import pkg_interface.ActividadJlal;
import pkg_interface.ActivoJlal;
import pkg_interface.DetalleMantenimientoJlal;
import pkg_interface.MantenimientoJlal;

import pkg_interface.cls_interface;

/**
 *
 * @author crist
 */
@ManagedBean()
@SessionScoped
public class cls_reporte_cruzado implements Serializable {

    ArrayList<ActivoJlal> activo;
    ArrayList<ActividadJlal> actividad;
    ArrayList<DetalleMantenimientoJlal> mantenimiento;
    String mensaje = "";
    ArrayList<ArrayList<String>> nombre= new ArrayList();

    public cls_reporte_cruzado() {
        buscarTabla();
    }

    public ArrayList<ArrayList<String>> getNombre() {
        return nombre;
    }

    public void setNombre(ArrayList<ArrayList<String>> nombre) {
        this.nombre = nombre;
    }

    public ArrayList<ActivoJlal> getActivo() {
        return activo;
    }

    public void setActivo(ArrayList<ActivoJlal> activo) {
        this.activo = activo;
    }

    public ArrayList<ActividadJlal> getActividad() {
        return actividad;
    }

    public void setActividad(ArrayList<ActividadJlal> actividad) {
        this.actividad = actividad;
    }

    public ArrayList<DetalleMantenimientoJlal> getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(ArrayList<DetalleMantenimientoJlal> mantenimiento) {
        this.mantenimiento = mantenimiento;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void buscarmantenimiento() {
        mantenimiento = null;
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            mantenimiento = interface1.buscarDetalleM();

            mensaje = "Tabla encontrada";
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No encontro Tabla";
        }
        System.out.println(mensaje);
    }

    public void buscarActivo() {
        activo = null;
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            activo = interface1.buscarActivo();
            mensaje = "Tabla encontrada";
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No encontro Tabla";
        }
        System.out.println(mensaje);
    }

    public void buscarActividad() {
        actividad = null;
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            actividad = interface1.buscar();
            mensaje = "Tabla encontrada";
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No encontro Tabla";
        }
        System.out.println(mensaje);
    }

    public void buscarTabla() {
        buscarActividad();
        buscarActivo();
        buscarmantenimiento();
        ArrayList<ActivoJlal> activo1 = new ArrayList();
        ArrayList<ActividadJlal> actividad1 = new ArrayList();
        ArrayList<DetalleMantenimientoJlal> mantenimiento1 = new ArrayList();
        mensaje = "actividad";

        for (int i = 0; activo.size() > i; i++) {
            mensaje += "," + activo.get(i).getNombreActivo();

        }
        mensaje += ":";
        for (int i = 0; actividad.size() > i; i++) {
            mensaje += actividad.get(i).getNombreActividad();

            for (int j = 0; activo.size() > j; j++) {
                int total = 0;
                int cad = actividad.get(i).getCodigoActividad();
                int cao = activo.get(j).getCodigoActivo();
                for (int k = 0; mantenimiento.size() > k; k++) {
                    int cad1 = mantenimiento.get(k).getCodigoActividad();
                    int cao1 = mantenimiento.get(k).getCodigoActivo();
                    if (cad1 == cad) {
                        if (cao1 == cao) {
                            total += mantenimiento.get(k).getValorDMantenimiento();
                        }
                    }
                }
                mensaje += "," + total;
            }
            mensaje += ":";

        }
        ArrayList<ArrayList<String>> nombres= new ArrayList();
        String[] n1 = mensaje.split(":");
        for (int i = 0; i < n1.length; i++) {
            String[] n2 = n1[i].split(",");
            ArrayList<String> n=new ArrayList();
            for (int j = 0; j < n2.length; j++) {
                    n.add(n2[j]);
                    
            }
            nombres.add(n);
        }
        nombre=nombres;

    }

}
