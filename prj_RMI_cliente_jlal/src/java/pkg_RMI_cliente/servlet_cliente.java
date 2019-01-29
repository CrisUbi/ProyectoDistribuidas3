/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_RMI_cliente;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servlet_cliente", urlPatterns = {"/servlet_cliente"})
public class servlet_cliente extends HttpServlet {

    @Resource(mappedName = "conexion_jms")
    javax.jms.QueueConnectionFactory queueConnection;
    @Resource(mappedName = "destino_jms")
    javax.jms.Queue queue;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nombre = "";
            String mensaje = "";
            String mensaje1 = "";
            Date fecha = new Date();
            String ls_pantalla = "";
            ls_pantalla += "<html>";
            ls_pantalla += "<head>";
            ls_pantalla += "</head>";
            ls_pantalla += "<center><body>";
            ls_pantalla += "<h2>Solicitudes de soporte o cambios</h2>";
            ls_pantalla += "<form action='servlet_cliente' method='post'>";
            ls_pantalla += "Nombre:<input type='text' name='nombre'" + " value='" + nombre + "'></input>";
            ls_pantalla += "<br>";
            ls_pantalla += "Mensaje:<textarea rows=\"10\" cols=\"40\" name='mensaje'" + " value='" + mensaje + "'>Escribe aqui tus solicitudes</textarea>";
            ls_pantalla += "<br>";
            ls_pantalla += "<input type='submit' value='enviar' name='boton'></input>";
            ls_pantalla += "<output type='text' name='mensaje'" + " value='" + mensaje1 + "'></output>";
            ls_pantalla += "</form>";
            ls_pantalla += "</body></center>";
            ls_pantalla += "</html>";
            out.println(ls_pantalla);
            String is_boton = "";
            is_boton = request.getParameter("boton");
            nombre = request.getParameter("nombre");
            mensaje = request.getParameter("mensaje");
            System.out.println(mensaje);
            if (is_boton.equals("enviar")) {
                try {
                    Connection connection = queueConnection.createConnection();
                    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                    MessageProducer producer = session.createProducer(queue);
                    MapMessage message = session.createMapMessage();
                    message.setString("nombre", nombre);
                    message.setString("mensaje", mensaje);
                    message.setString("fecha", String.valueOf(fecha.getDate() + "-" + (fecha.getMonth() + 1) + "-" + (1900 + fecha.getYear())));
                    producer.send(message);
                    producer.close();
                    session.close();
                    connection.close();
                    mensaje1="Enviado";
                } catch (Exception ex) {
                    ex.printStackTrace();
                    mensaje1="no Enviado";
                }
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
