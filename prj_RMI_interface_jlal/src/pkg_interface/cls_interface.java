package pkg_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public interface cls_interface extends Remote {

    public ActividadJlal buscar(Integer cedula) throws RemoteException;

    public ArrayList<Integer> Autores1() throws RemoteException;

    public String insertar(Integer codigo, String nombre) throws RemoteException;

    public String eliminar(Integer codigo) throws RemoteException;

    public String modificar(Integer codigo, String nombre) throws RemoteException;

    public ActivoJlal buscarActivo(Integer cedula) throws RemoteException;

    public ArrayList<ActividadJlal> buscar() throws RemoteException;

    public String insertarActivo(Integer codigo, String nombre) throws RemoteException;

    public String eliminarActivo(Integer codigo) throws RemoteException;

    public String modificarActivo(Integer codigo, String nombre) throws RemoteException;

    public ArrayList<ActivoJlal> buscarActivo() throws RemoteException;

    public String insertarAutor(Integer codigo, String nombre, String apellido) throws RemoteException;

    public String modificarAutor(Integer codigo, String nombre, String apellido) throws RemoteException;

    public String eliminarAutor(Integer codigo) throws RemoteException;

    public AutorCuda Autor(Integer codigo) throws RemoteException;

    public ArrayList<AutorCuda> Autores() throws RemoteException;

    public String insertarLibro(Integer isbn, int autor, String titulo, Long valor, Integer cantidad) throws RemoteException;

    public String modificarLibro(Integer isbn, int autor, String titulo, Long valor, Integer cantidad) throws RemoteException;

    public String eliminarLibro(Integer isbn) throws RemoteException;

    public LibroCuda Libro(Integer isbn) throws RemoteException;

    public ArrayList<LibroCuda> Libros() throws RemoteException;

    public String insertarUsuario(Integer codigo, String nombre, String contrasena, String permisos) throws RemoteException;

    public String modificarUsuario(Integer codigo, String nombre, String contrasena, String permisos) throws RemoteException;

    public String eliminarUsuario(Integer codigo) throws RemoteException;

    public Usuario usuario(Integer codigo) throws RemoteException;

    public Usuario login(String nombre, String contrasena) throws RemoteException;

    public ArrayList<Usuario> Usuarios() throws RemoteException;

    public String insertarCuenta(Integer codigoCuenta, String nombreCuenta, int autor) throws RemoteException;

    public String modificarCuenta(Integer codigoCuenta, String nombreCuenta, int cuenta) throws RemoteException;

    public String eliminarCuenta(Integer codigoCuenta) throws RemoteException;

    public Cuenta Cuenta(Integer codigoCuenta) throws RemoteException;

    public ArrayList<Cuenta> Cuentas() throws RemoteException;

    public ArrayList<Integer> Cuentas1() throws RemoteException;

    public String insertarTipoCuenta(Integer codigoTipo, String nombreTipo) throws RemoteException;

    public String modificarTipoCuenta(Integer codigoTipo, String nombreTipo) throws RemoteException;

    public String eliminarTipoCuenta(Integer codigoTipo) throws RemoteException;

    public TipoCuenta TipoCuenta(Integer codigoTipo) throws RemoteException;

    public ArrayList<TipoCuenta> TipoCuentas() throws RemoteException;

    public ArrayList<Integer> TipoCuentas1() throws RemoteException;

    public String insertarCabeceraC(Date fechaP, String descripcion, Date fechaE) throws RemoteException;

    public String modificarCabeceraC(Integer numero, Date fechaP, String descripcion, Date fechaE) throws RemoteException;

    public String eliminarCabeceraC(Integer numero) throws RemoteException;

    public CabeceraCuda CabeceraC(Integer numero) throws RemoteException;

    public ArrayList<CabeceraCuda> CabecerasC() throws RemoteException;

    public String insertarDetalleC(Integer numero, Integer ISBN, Integer cantidad) throws RemoteException;

    public String modificarDetalleC(Integer numero, Integer ISBN, Integer cantidad) throws RemoteException;

    public String eliminarDetalleC(Integer numero, Integer ISBN) throws RemoteException;

    public DetalleCuda detalleC(Integer numero, Integer ISBN) throws RemoteException;

    public ArrayList<DetalleCuda> DetallesC() throws RemoteException;

    public ArrayList<DetalleCuda> Detalles(Integer numero) throws RemoteException;

    public ArrayList<Integer> Libros1() throws RemoteException;

    public ArrayList<Integer> Numeros1() throws RemoteException;

    public String asiento(Date fechaC, String observacion, Integer codigo, Integer cuenta, int cnt_debe, int cnt_haber) throws RemoteException;

    public ArrayList<CabeceraCuda> reporte1(Date fechaI, Date fechaF) throws RemoteException;

    public ArrayList<AutorCuda> reporte2(Date fechaI, Date fechaF) throws RemoteException;

    public void soporte(String nombre, String mensaje,String fecha) throws RemoteException;
    
    public String insertarDetalleM(Integer codigoActividad,Integer codigoActivo, Integer numeroMantenimiento,Integer valorDMantenimiento) throws RemoteException;

    public String eliminarDetalleM(Integer codigoActividad,Integer codigoActivo, Integer numeroMantenimiento) throws RemoteException;

    public String modificarDetalleM(Integer codigoActividad,Integer codigoActivo, Integer numeroMantenimiento,Integer valorDMantenimiento) throws RemoteException;

    public DetalleMantenimientoJlal buscarDetalleM(Integer codigoActividad,Integer codigoActivo, Integer numeroMantenimiento) throws RemoteException;

    public ArrayList<DetalleMantenimientoJlal> buscarDetalleM() throws RemoteException;
    
    
    public String insertarMante(Integer numeroMantenimiento,Date fechaMantenimiento, String responsableMantenimiento) throws RemoteException;

    public String eliminarMante(Integer numeroMantenimiento) throws RemoteException;

    public String modificarMante(Integer numeroMantenimiento,Date fechaMantenimiento, String responsableMantenimiento) throws RemoteException;

    public MantenimientoJlal buscarActivoMante(Integer numeroMantenimiento) throws RemoteException;

    public ArrayList<MantenimientoJlal> buscarMante() throws RemoteException;
}
