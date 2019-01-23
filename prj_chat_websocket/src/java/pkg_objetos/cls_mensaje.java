package pkg_objetos;

import java.util.Calendar;
import java.util.Date;

public class cls_mensaje {

    private String nombre;
    private String mensaje;
    private String hora;
    private String fecha;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getHora() {
        Date momentoActual = new Date();
        int hora1 = momentoActual.getHours();
        int minuto = momentoActual.getMinutes();
        int segundo = momentoActual.getSeconds();
        hora = hora1 + ":" + minuto + ":" + segundo;
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        Date momentoActual = new Date();
        int dia = momentoActual.getDate();
        int mes = momentoActual.getMonth() + 1;
        Calendar cal= Calendar.getInstance();
        int anio = cal.get(Calendar.YEAR);
        fecha = dia + "/" + mes + "/" + anio;
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public cls_mensaje() {
    }
}
