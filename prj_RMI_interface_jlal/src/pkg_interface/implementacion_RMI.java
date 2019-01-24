package pkg_interface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

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
}
