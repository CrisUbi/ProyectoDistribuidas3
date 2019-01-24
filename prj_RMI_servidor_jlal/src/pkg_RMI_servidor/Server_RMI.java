/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_RMI_servidor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pkg_interface.ActividadJlal;
import pkg_interface.AutorCuda;
import pkg_interface.LibroCuda;
import pkg_interface.Usuario;
import pkg_interface.cls_interface;

/**
 *
 * @author josel
 */
public class Server_RMI extends UnicastRemoteObject implements cls_interface {

    public String mensaje = "";
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("prj_RMI_servidorPU");
    EntityManager em1 = factory.createEntityManager();

    public Server_RMI() throws RemoteException {
        super();
    }

    @Override
    public String insertar(Integer cedula, String apellido) throws RemoteException {
        String sql = "INSERT INTO sys.actividad_jlal (`CODIGO_ACTIVIDAD`, `NOMBRE_ACTIVIDAD`) \n"
                + "	VALUES (" + cedula + ", '" + apellido + "')";
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
        String ls_nombre = "";
        ActividadJlal e = new ActividadJlal();
        if (l1.size() >= 1) {
            Object[] ar_objeto = (Object[]) (l1.get(0));
            ls_nombre = ar_objeto[1].toString();
            e.setNombreActividad(ls_nombre);

            mensaje = "";
        } else {
            mensaje = "No se encontro el PROVEEDOR";
        }
        System.out.println("Actividad:" + ls_nombre + "");

        return e;
    }

    @Override
    public ArrayList<ActividadJlal> buscar() throws RemoteException {
        String sql = "SELECT * FROM actividad_jlal ";
        Query query = em1.createNativeQuery(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<ActividadJlal> actividades = null;
        if (l1.size() >= 1) {
            ArrayList<ActividadJlal> al = new ArrayList();
            for (Object[] row : l1) {
                ActividadJlal al1 = new ActividadJlal();
                al1.setCodigoActividad((Integer) row[0]);
                al1.setNombreActividad((String) row[1]);
                al.add(al1);
            }
            mensaje = "";
            actividades = al;

        } else {
            mensaje = "No se encontro el PROVEEDOR";
        }

        return actividades;
    }

    @Override
    public String insertarAutor(Integer codigo, String nombre, String apellido) throws RemoteException {
        String sql = "INSERT INTO autor_cuda (`CODIGO_AUTOR`, `NOMBRE_AUTOR`, `APELLIDO_AUTOR`) \n"
                + "	VALUES (" + codigo + ", '" + nombre + "'" + ", '" + apellido + "')";
        System.out.println(sql);
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
    public String modificarAutor(Integer codigo, String nombre, String apellido) throws RemoteException {
        String sql = "UPDATE autor_cuda SET `NOMBRE_AUTOR`=" + "'" + nombre + "'" + ", `APELLIDO_AUTOR`=" + "'" + apellido + "'"
                + "where `CODIGO_AUTOR`=" + "'" + codigo + "'";
        System.out.println(sql);
        em1.getTransaction().begin();
        Query qe = em1.createNativeQuery(sql);
        try {
            qe.executeUpdate();
            em1.getTransaction().commit();
            mensaje = "Se modifico satisfactoriamente";
        } catch (Exception ex) {
            em1.getTransaction().rollback();
            mensaje = "No se pudo modificar";
        }
        System.out.println(mensaje);
        return mensaje;
    }

    @Override
    public String eliminarAutor(Integer codigo) throws RemoteException {
        String sql = "delete from autor_cuda where codigo_autor=" + codigo + "";
        System.out.println(sql);
        em1.getTransaction().begin();
        Query qe = em1.createNativeQuery(sql);
        try {
            int li_filas = qe.executeUpdate();
            if (li_filas >= 1) {
                em1.getTransaction().commit();
                mensaje = "Se eliminó satisfactoriamente";
            }
        } catch (Exception ex) {
            em1.getTransaction().rollback();
            mensaje = "No se pudo eliminar";
        }
        System.out.println(mensaje);
        return mensaje;
    }

    @Override
    public pkg_interface.AutorCuda Autor(Integer codigo) throws RemoteException {
        String sql = "SELECT * FROM autor_cuda where CODIGO_AUTOR=" + codigo + "";
        Query qe = em1.createNativeQuery(sql);
        List l1 = qe.getResultList();
        String ls_nombre = "";
        String ls_apellido = "";
        pkg_interface.AutorCuda e = new pkg_interface.AutorCuda();
        if (l1.size() >= 1) {
            Object[] ar_objeto = (Object[]) (l1.get(0));
            ls_nombre = ar_objeto[1].toString();
            ls_apellido = ar_objeto[2].toString();
            e.setNombreAutor(ls_nombre);
            e.setApellidoAutor(ls_apellido);
            mensaje = "";
        } else {
            mensaje = "No se encontro el Autor";
        }
        return e;
    }

    @Override
    public String insertarLibro(Integer isbn, int autor, String titulo, Long valor, Integer cantidad) throws RemoteException {
        String sql = "INSERT INTO libro_cuda (`ISBN_LIBRO`, `CODIGO_AUTOR`, `TITULO_LIBRO`, `VALOR_LIBRO`, `CANTIDAD_LIBRO`) \n"
                + "	VALUES (" + isbn + "," + autor + ", '" + titulo + "'" + ","
                + valor + "," + cantidad + ")";
        System.out.println(sql);
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
    public String modificarLibro(Integer isbn, int autor, String titulo, Long valor, Integer cantidad) throws RemoteException {
        String sql = "UPDATE libro_cuda SET `CODIGO_AUTOR`=" + autor + ", `titulo_libro`=" + "'" + titulo + "'"
                + ",`VALOR_LIBRO`=" + valor + ",`CANTIDAD_LIBRO`=" + cantidad + " where `ISBN_LIBRO`=" + isbn;
        System.out.println(sql);
        em1.getTransaction().begin();
        Query qe = em1.createNativeQuery(sql);
        try {
            qe.executeUpdate();
            em1.getTransaction().commit();
            mensaje = "Se modifico satisfactoriamente";
        } catch (Exception ex) {
            em1.getTransaction().rollback();
            mensaje = "No se pudo modificar";
        }
        System.out.println(mensaje);
        return mensaje;
    }

    @Override
    public String eliminarLibro(Integer isbn) throws RemoteException {
        String sql = "delete from libro_cuda where ISBN_LIBRO=" + isbn + "";
        System.out.println(sql);
        em1.getTransaction().begin();
        Query qe = em1.createNativeQuery(sql);
        try {
            int li_filas = qe.executeUpdate();
            if (li_filas >= 1) {
                em1.getTransaction().commit();
                mensaje = "Se eliminó satisfactoriamente";
            }
        } catch (Exception ex) {
            em1.getTransaction().rollback();
            mensaje = "No se pudo eliminar";
        }
        System.out.println(mensaje);
        return mensaje;
    }

    @Override
    public pkg_interface.LibroCuda Libro(Integer isbn) throws RemoteException {
        String sql = "SELECT * FROM libro_cuda where ISBN_LIBRO=" + isbn + "";
        Query qe = em1.createNativeQuery(sql);
        List l1 = qe.getResultList();
        int autor = 0;
        String titulo = "";
        Long valor;
        Integer cantidad = 0;
        pkg_interface.LibroCuda e = new pkg_interface.LibroCuda();
        if (l1.size() >= 1) {
            Object[] ar_objeto = (Object[]) (l1.get(0));
            autor = Integer.valueOf(ar_objeto[1].toString());
            titulo = ar_objeto[2].toString();
            valor = Long.valueOf(ar_objeto[3].toString());
            cantidad = Integer.valueOf(ar_objeto[4].toString());
            e.setCodigoAutor(autor);
            e.setTituloLibro(titulo);
            e.setValorLibro(valor);
            e.setCantidadLibro(cantidad);
            mensaje = "";
        } else {
            mensaje = "No se encontro el Autor";
        }
        return e;
    }

    @Override
    public ArrayList<LibroCuda> Libros() throws RemoteException {
        String sql = "SELECT * FROM libro_cuda";
        Query query = em1.createNativeQuery(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<LibroCuda> libros = null;
        if (l1.size() >= 1) {
            ArrayList<LibroCuda> al = new ArrayList();
            for (Object[] row : l1) {
                LibroCuda al1 = new LibroCuda();
                al1.setIsbnLibro(((BigDecimal) row[0]).intValue());
                al1.setCodigoAutor((Integer) row[1]);
                al1.setTituloLibro((String) row[2]);
                al1.setValorLibro(((BigDecimal) row[3]).longValue());
                al1.setCantidadLibro((Integer) row[4]);
                al.add(al1);
            }
            mensaje = "";
            libros = al;

        } else {
            mensaje = "No se encontro libros";
        }
        return libros;
    }

    @Override
    public ArrayList<AutorCuda> Autores() throws RemoteException {
        String sql = "SELECT * FROM autor_cuda";
        Query query = em1.createNativeQuery(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<AutorCuda> autores = null;
        if (l1.size() >= 1) {
            ArrayList<AutorCuda> al = new ArrayList();
            for (Object[] row : l1) {
                AutorCuda al1 = new AutorCuda();
                al1.setCodigoAutor((Integer) row[0]);
                al1.setNombreAutor((String) row[1]);
                al1.setApellidoAutor((String) row[2]);
                al.add(al1);
            }
            mensaje = "";
            autores = al;

        } else {
            mensaje = "No se encontro autores";
        }
        return autores;
    }

    @Override
    public ArrayList<Integer> Autores1() throws RemoteException {
        String sql = "SELECT * FROM autor_cuda";
        Query query = em1.createNativeQuery(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<Integer> autores = null;
        if (l1.size() >= 1) {
            ArrayList<Integer> al = new ArrayList();
            for (Object[] row : l1) {
                Integer al1 = 0;
                al1 = (Integer) row[0];
                al.add(al1);
            }
            mensaje = "";
            autores = al;

        } else {
            mensaje = "No se encontro autores";
        }
        return autores;
    }

    @Override
    public String insertarUsuario(Integer codigo, String nombre, String contrasena, String permisos) throws RemoteException {
        String sql = "INSERT INTO usuario (`CODIGO`, `NOMBRE`, `CONTRASENA`, `PERMISOS`) \n"
                + "	VALUES (" + codigo + ", '" + nombre + "'" + ", '" + contrasena + "'" + ", '" + permisos + "')";
        System.out.println(sql);
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
    public String modificarUsuario(Integer codigo, String nombre, String contrasena, String permisos) throws RemoteException {
        String sql = "UPDATE usuario SET `NOMBRE`=" + "'" + nombre + "'" + ", `CONTRASENA`=" + "'" + contrasena + "'"
                + ", `PERMISOS`=" + "'" + permisos + "'" + " where `CODIGO_AUTOR`=" + "'" + codigo + "'";
        System.out.println(sql);
        em1.getTransaction().begin();
        Query qe = em1.createNativeQuery(sql);
        try {
            qe.executeUpdate();
            em1.getTransaction().commit();
            mensaje = "Se modifico satisfactoriamente";
        } catch (Exception ex) {
            em1.getTransaction().rollback();
            mensaje = "No se pudo modificar";
        }
        System.out.println(mensaje);
        return mensaje;
    }

    @Override
    public String eliminarUsuario(Integer codigo) throws RemoteException {
        String sql = "delete from usuario where CODIGO=" + codigo + "";
        System.out.println(sql);
        em1.getTransaction().begin();
        Query qe = em1.createNativeQuery(sql);
        try {
            int li_filas = qe.executeUpdate();
            if (li_filas >= 1) {
                em1.getTransaction().commit();
                mensaje = "Se eliminó satisfactoriamente";
            }
        } catch (Exception ex) {
            em1.getTransaction().rollback();
            mensaje = "No se pudo eliminar";
        }
        System.out.println(mensaje);
        return mensaje;
    }

    @Override
    public Usuario usuario(Integer codigo) throws RemoteException {
        String sql = "SELECT * FROM usuario where CODIGO=" + codigo + "";
        Query qe = em1.createNativeQuery(sql);
        List l1 = qe.getResultList();
        String ls_nombre = "";
        String ls_contrasena = "";
        String ls_permisos = "";
        Usuario e = new Usuario();
        if (l1.size() >= 1) {
            Object[] ar_objeto = (Object[]) (l1.get(0));
            ls_nombre = ar_objeto[1].toString();
            ls_contrasena = ar_objeto[2].toString();
            ls_permisos = ar_objeto[3].toString();
            e.setNombre(ls_nombre);
            e.setContrasena(ls_contrasena);
            e.setPermisos(ls_permisos);
            mensaje = "";
        } else {
            mensaje = "No se encontro el usuario";
        }
        return e;
    }

    @Override
    public ArrayList<Usuario> Usuarios() throws RemoteException {
        String sql = "SELECT * FROM usuario";
        Query query = em1.createNativeQuery(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<Usuario> usuarios = null;
        if (l1.size() >= 1) {
            ArrayList<Usuario> al = new ArrayList();
            for (Object[] row : l1) {
                Usuario al1 = new Usuario();
                al1.setCodigo((Integer) row[0]);
                al1.setNombre((String) row[1]);
                al1.setContrasena((String) row[2]);
                al1.setPermisos((String) row[3]);
                al.add(al1);
            }
            mensaje = "";
            usuarios = al;

        } else {
            mensaje = "No se encontro usuarios";
        }
        return usuarios;
    }
}
