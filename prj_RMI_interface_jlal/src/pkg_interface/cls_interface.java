package pkg_interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface cls_interface extends Remote {

    public ActividadJlal buscar(Integer cedula) throws RemoteException;

    public ArrayList<Integer> Autores1() throws RemoteException;

    public String insertar(Integer codigo, String nombre) throws RemoteException;

    public ArrayList<ActividadJlal> buscar() throws RemoteException;

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

    public String insertarUsuario(Integer codigo,String nombre, String contrasena, String permisos) throws RemoteException;

    public String modificarUsuario(Integer codigo,String nombre, String contrasena, String permisos) throws RemoteException;

    public String eliminarUsuario(Integer codigo) throws RemoteException;

    public Usuario usuario(Integer codigo) throws RemoteException;

    public ArrayList<Usuario> Usuarios() throws RemoteException;
}
