package pkg_RMI_cliente;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import pkg_interface.Empleado;
import pkg_interface.cls_interface;


@ManagedBean()
@SessionScoped

public class cls_RMI_cliente {
    Integer cedula;
    String  apellido;
    Integer edad;
    String mensaje;

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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    
    
        public cls_RMI_cliente ()
    {
    }
    public void buscar()
    { System.out.println("1");
        try
        {Registry registro=LocateRegistry.getRegistry("127.0.0.1",1095);
        cls_interface interface1=(cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
        Empleado busca=interface1.buscar(cedula);
        
        apellido=busca.getApellido();
    edad=busca.getEdad();
    mensaje="Encontro Dato";
        }
        catch(RemoteException | NotBoundException ex)
        { System.out.println("error");
        mensaje="No encontro Dato";
        }
      }
     public void insertar()
    { System.out.println("2");
        try
        {Registry registro=LocateRegistry.getRegistry("127.0.0.1",1095);
        cls_interface interface1=(cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
        interface1.insertar(cedula, apellido, edad);
mensaje="Inserto Correctamenteo";
        }
        catch(RemoteException | NotBoundException ex)
        { System.out.println("error");
        mensaje="No se pudo insertar";
        }
      }
}

