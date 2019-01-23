/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_RMI_servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pkg_interface.ActividadJlal;
import pkg_interface.cls_interface;

/**
 *
 * @author josel
 */
public class Server_RMI extends UnicastRemoteObject implements  cls_interface{
       public String mensaje = "";
 EntityManagerFactory factory = Persistence.createEntityManagerFactory("prj_RMI_servidorPU");
    EntityManager em1 = factory.createEntityManager();
    public Server_RMI() throws RemoteException
   {
       super();
   }
   

   
    @Override
    public String insertar(Integer cedula, String apellido) throws RemoteException {
         String sql = "INSERT INTO actividad_jlal (`CODIGO_ACTIVIDAD`, `NOMBRE_ACTIVIDAD`) \n" +
"	VALUES ("+cedula+", '"+apellido+"')";
        em1.getTransaction().begin();
        Query qe = em1.createNativeQuery(sql);
        try {
            qe.executeUpdate();
            em1.getTransaction().commit();
            mensaje = "Se insertó satisfactoriamente";
        } catch (Exception ex) {
            em1.getTransaction().rollback();
            mensaje = "No se pudo insertar";
        }
        System.out.println(mensaje);
        return mensaje;
    }

    @Override
    public ActividadJlal buscar(Integer cedula) throws RemoteException {
        String sql = "SELECT * FROM actividad_jlal where CODIGO_ACTIVIDAD=" + cedula + "";
        Query qe = em1.createNativeQuery(sql);
        List l1 = qe.getResultList();
        String ls_nombre="";
        ActividadJlal e=new ActividadJlal();
        if (l1.size() >= 1) {
            Object[] ar_objeto = (Object[]) (l1.get(0));
            ls_nombre = ar_objeto[1].toString();
            e.setNombreActividad(ls_nombre);
        
            mensaje = "";
        } else {
            mensaje = "No se encontro el PROVEEDOR";
        }
        System.out.println("Actividad:"+ls_nombre+"");
        
        
        return e;  
    }
    

    
}
