/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_ejb_mesage;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MapMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author crist
 */
@MessageDriven(mappedName = "destino_jms", activationConfig = {
    @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
    ,
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})

public class NewMessageBean implements MessageListener {

    public NewMessageBean() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("hello from message driven bean");
            MapMessage msg = (MapMessage) message;
            System.out.print("Nombre:" + msg.getString("nombre"));
            System.out.print("Mensaje:" + msg.getString("mensaje"));
            System.out.print("Fecha:" + msg.getString("fecha"));
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("message_driver_bean-ejbPU");
            EntityManager em1 = factory.createEntityManager();
            Soporte c1 = new Soporte();
            c1.setNombre(msg.getString("nombre"));
            c1.setMensaje(msg.getString("mensaje"));
            c1.setFecha(msg.getString("fecha"));
            try {
                em1.getTransaction().begin();
                em1.persist(c1);
                em1.getTransaction().commit();
                System.out.println("correcto");
            } catch (Exception ex) {
                em1.getTransaction().rollback();
            }
            em1.close();
            factory.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
