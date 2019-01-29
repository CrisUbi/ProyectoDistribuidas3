package pkg_interface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

public class implementacion_RMI extends UnicastRemoteObject implements cls_interface {

    public implementacion_RMI() throws RemoteException {
        super();
    }

    @Override
    public ActividadJlal buscar(Integer cedula) throws RemoteException {
        System.out.println("Valor a buscar:" + cedula);
        return new ActividadJlal();
    }

    @Override
    public String insertar(Integer Codigo, String nombre) throws RemoteException {
        System.out.println("Cedula:" + Codigo);
        System.out.println("Actividad:" + nombre);

        return "";
    }

    @Override
    public ArrayList<ActividadJlal> buscar() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertarAutor(Integer codigo, String nombre, String apellido) throws RemoteException {
        System.out.println("codigo:" + codigo);
        System.out.println("nombre:" + nombre);
        System.out.println("apellido:" + apellido);
        return "";
    }

    @Override
    public String modificarAutor(Integer codigo, String nombre, String apellido) throws RemoteException {
        System.out.println("codigo:" + codigo);
        System.out.println("nombre:" + nombre);
        System.out.println("apellido:" + apellido);
        return "";
    }

    @Override
    public String eliminarAutor(Integer codigo) throws RemoteException {
        System.out.println("codigo:" + codigo);
        return "";
    }

    @Override
    public AutorCuda Autor(Integer codigo) throws RemoteException {
        System.out.println("Valor a buscar:" + codigo);
        return new AutorCuda();
    }

    @Override
    public String insertarLibro(Integer isbn, int autor, String titulo, Long valor, Integer cantidad) throws RemoteException {
        System.out.println("codigo:" + isbn);
        System.out.println("autor:" + autor);
        System.out.println("titulo:" + titulo);
        System.out.println("valor:" + valor);
        System.out.println("cantidad:" + cantidad);
        return "";
    }

    @Override
    public String modificarLibro(Integer isbn, int autor, String titulo, Long valor, Integer cantidad) throws RemoteException {
        System.out.println("codigo:" + isbn);
        System.out.println("autor:" + autor);
        System.out.println("titulo:" + titulo);
        System.out.println("valor:" + valor);
        System.out.println("cantidad:" + cantidad);
        return "";
    }

    @Override
    public String eliminarLibro(Integer isbn) throws RemoteException {
        System.out.println("codigo:" + isbn);
        return "";
    }

    @Override
    public LibroCuda Libro(Integer isbn) throws RemoteException {
        System.out.println("codigo:" + isbn);
        return new LibroCuda();
    }

    @Override
    public ArrayList<AutorCuda> Autores() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<LibroCuda> Libros() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> Autores1() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertarUsuario(Integer codigo, String nombre, String contrasena, String permisos) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificarUsuario(Integer codigo, String nombre, String contrasena, String permisos) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminarUsuario(Integer codigo) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario usuario(Integer codigo) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> Usuarios() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario login(String nombre, String contrasena) throws RemoteException {
       System.out.println("Ingreso:" + nombre+","+contrasena);
       return new Usuario();
    }

    @Override
    public String insertarCuenta(Integer codigoCuenta, String nombreCuenta, int autor) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificarCuenta(Integer codigoCuenta, String nombreCuenta,int cuenta) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminarCuenta(Integer codigoCuenta) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cuenta Cuenta(Integer codigoCuenta) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cuenta> Cuentas() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertarTipoCuenta(Integer codigoTipo, String nombreTipo) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificarTipoCuenta(Integer codigoTipo, String nombreTipo) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminarTipoCuenta(Integer codigoTipo) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoCuenta TipoCuenta(Integer codigoTipo) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TipoCuenta> TipoCuentas() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> Cuentas1() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> TipoCuentas1() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminar(Integer codigo) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificar(Integer codigo, String nombre) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertarActivo(Integer codigo, String nombre) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminarActivo(Integer codigo) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificarActivo(Integer codigo, String nombre) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ActivoJlal> buscarActivo() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ActivoJlal buscarActivo(Integer cedula) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertarCabeceraC(Date fechaP, String descripcion, Date fechaE) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificarCabeceraC(Integer numero,Date fechaP, String descripcion, Date fechaE) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminarCabeceraC(Integer numero) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CabeceraCuda CabeceraC(Integer numero) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CabeceraCuda> CabecerasC() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public ArrayList<DetalleCuda> DetallesC() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertarDetalleC(Integer numero, Integer ISBN, Integer cantidad) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificarDetalleC(Integer numero, Integer ISBN, Integer cantidad) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminarDetalleC(Integer numero, Integer ISBN) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleCuda detalleC(Integer numero,Integer ISBN) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleCuda> Detalles(Integer numero) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> Libros1() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Integer> Numeros1() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String asiento(Date fechaC, String observacion, Integer codigo, Integer cuenta, int cnt_debe, int cnt_haber) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CabeceraCuda> reporte1(Date fechaI, Date fechaF) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<AutorCuda> reporte2(Date fechaI, Date fechaF) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void soporte(String nombre, String mensaje,String fecha) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertarDetalleM(Integer codigoActividad, Integer codigoActivo, Integer numeroMantenimiento, Integer valorDMantenimiento) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminarDetalleM(Integer codigoActividad, Integer codigoActivo, Integer numeroMantenimiento) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public DetalleMantenimientoJlal buscarDetalleM(Integer codigoActividad, Integer codigoActivo, Integer numeroMantenimiento) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleMantenimientoJlal> buscarDetalleM() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertarMante(Integer numeroMantenimiento, Date fechaMantenimiento, String responsableMantenimiento) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminarMante(Integer numeroMantenimiento) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificarMante(Integer numeroMantenimiento, Date fechaMantenimiento, String responsableMantenimiento) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MantenimientoJlal buscarActivoMante(Integer numeroMantenimiento) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<MantenimientoJlal> buscarMante() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificarDetalleM(Integer codigoActividad, Integer codigoActivo, Integer numeroMantenimiento, Integer valorDMantenimiento) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleMantenimientoJlal> ReporteM1() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertarCabeceraComprobante(Date fechaCab, String observaciones) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificarCabeceraComprobante(Integer numeroCab, Date fechaCab, String observaciones) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminarCabeceraComprobante(Integer numeroCab) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public pkg_interface.CabeceraComprobante CabeceraComprobante(Integer numero) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<pkg_interface.CabeceraComprobante> CabecerasComp() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertarDetalleComprobante(Integer numeroD, Integer cantidadHaber, Integer cantidadDebe, Integer numeroCab, Integer codigoCuenta) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificarDetalleComprobante(Integer numeroD, Integer cantidadHaber, Integer cantidadDebe, Integer numeroCab, Integer codigoCuenta) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String eliminarDetalleComprobante(Integer numeroD) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetalleComprobante detalleComprobante(Integer numero, Integer codigoCuenta) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleComprobante> DetallesComp() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleComprobante> DetallesComprobante(Integer numero) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<pkg_interface.CabeceraComprobante> reporteCabeceraComprobante(Date fechaI, Date fechaF) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<DetalleComprobante> reporteDetalle(Date fechaI, Date fechaF) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}
