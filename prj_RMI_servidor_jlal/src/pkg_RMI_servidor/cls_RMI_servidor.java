package pkg_RMI_servidor;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import pkg_interface.cls_interface;
import pkg_interface.implementacion_RMI;


public class cls_RMI_servidor {
   public cls_RMI_servidor() throws RemoteException
   {    try{
            Registry registro=LocateRegistry.createRegistry(1095);
            registro.rebind("rmi://localhost:1095/RMI_interface", new Server_RMI());
            System.out.println("Servidor activo");   
            }
            catch(Exception e)
            {         
                System.out.println("Error");  
            }
    }
  
 public static void main(String[] Args)
    { try
        {
            new cls_RMI_servidor();
        }
        catch (Exception ex)
        {
        }
    }
}
