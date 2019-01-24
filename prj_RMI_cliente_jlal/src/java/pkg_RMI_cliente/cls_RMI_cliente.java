package pkg_RMI_cliente;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import pkg_interface.ActividadJlal;
import pkg_interface.cls_interface;


@ManagedBean()
@SessionScoped

public final class cls_RMI_cliente {
    Integer cedula;
    String  apellido;
 
    String mensaje;
    ArrayList<ActividadJlal> busca ;

    public ArrayList<ActividadJlal> getBusca() {
        return busca;
    }

    public void setBusca(ArrayList<ActividadJlal> busca) {
        this.busca = busca;
    }

    public Integer getCedula() {
        return cedula;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

   
    
    
        public cls_RMI_cliente ()
    {
        buscartabla();
    }
    public void buscar()
    { 
        try
        {Registry registro=LocateRegistry.getRegistry("127.0.0.1",1095);
        cls_interface interface1=(cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
        ActividadJlal busca=interface1.buscar(cedula);
        
        apellido=busca.getNombreActividad();
    
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
    busca= null;
        try
        {Registry registro=LocateRegistry.getRegistry("127.0.0.1",1095);
        cls_interface interface1=(cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
        busca=interface1.buscar();
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
        interface1.insertar(cedula, apellido);
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
        interface1.eliminar(cedula);
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
        interface1.modificar(cedula, apellido);
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

