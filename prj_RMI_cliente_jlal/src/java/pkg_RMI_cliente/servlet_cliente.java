package pkg_cliente;

import java.io.IOException;
import java.io.PrintWriter;
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
    @Resource(mappedName="conexion_jms")
    javax.jms.QueueConnectionFactory queueConnection;
    @Resource(mappedName="destino_jms")
    javax.jms.Queue queue;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        Connection  connection =queueConnection.createConnection();
        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        MessageProducer producer=session.createProducer(queue);
        MapMessage message=session.createMapMessage();
        message.setString("cedula","12233322");
        message.setString("nombre","Juan");
        message.setString("direccion","10 agosto");
        producer.send(message);
        producer.close();
        session.close();
        connection.close();        }
        catch(Exception ex){            
        ex.printStackTrace();
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
