package pkg_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface cls_interface extends Remote {
    public ActividadJlal buscar(Integer cedula) throws RemoteException;
    public String insertar(Integer codigo,String nombre) throws RemoteException;
   
}
