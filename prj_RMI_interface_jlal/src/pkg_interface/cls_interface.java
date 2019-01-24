package pkg_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

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

}
