package pkg_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface cls_interface extends Remote {
    public ActividadJlal buscar(Integer cedula) throws RemoteException;
    public String insertar(Integer codigo,String nombre) throws RemoteException;
   public ArrayList<ActividadJlal> buscar() throws RemoteException;
}
