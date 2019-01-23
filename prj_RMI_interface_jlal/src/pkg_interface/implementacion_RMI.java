package pkg_interface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class implementacion_RMI extends UnicastRemoteObject implements cls_interface
{
   public implementacion_RMI() throws RemoteException
   {
       super();
   }
  
    @Override
    public ActividadJlal buscar(Integer cedula) throws RemoteException {
         System.out.println("Valor a buscar:"+cedula);
        return new ActividadJlal();
    }

    @Override
    public String insertar(Integer Codigo, String nombre) throws RemoteException {
        System.out.println("Cedula:"+Codigo);
        System.out.println("Actividad:"+nombre);
        
        
        return "";
    }
}
