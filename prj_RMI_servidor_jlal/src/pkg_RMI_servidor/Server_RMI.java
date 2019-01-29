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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import pkg_interface.ActividadJlal;
import pkg_interface.ActivoJlal;
import pkg_interface.AutorCuda;
import pkg_interface.CabeceraCuda;
import pkg_interface.LibroCuda;
import pkg_interface.Usuario;
import pkg_interface.cls_interface;
import pkg_interface.Cuenta;
import pkg_interface.DetalleComprobante;
import pkg_interface.DetalleCuda;
import pkg_interface.DetalleMantenimientoJlal;
import pkg_interface.MantenimientoJlal;
import pkg_interface.TipoCuenta;

/**
 *
 * @author josel
 */
public class Server_RMI extends UnicastRemoteObject implements cls_interface {

    public String mensaje = "";
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("prj_RMI_servidorPU");
    EntityManager em1 = factory.createEntityManager();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
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
    public ActivoJlal buscarActivo(Integer cedula) throws RemoteException {
        String sql = "SELECT * FROM activo_jlal where CODIGO_ACTIVO=" + cedula + "";
        Query qe = em1.createNativeQuery(sql);
        List l1 = qe.getResultList();
        String ls_nombre = "";
        ActivoJlal e = new ActivoJlal();
        if (l1.size() >= 1) {
            Object[] ar_objeto = (Object[]) (l1.get(0));
            ls_nombre = ar_objeto[1].toString();
            e.setNombreActivo(ls_nombre);

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
                + ", `PERMISOS`=" + "'" + permisos + "'" + " where `CODIGO`=" + "'" + codigo + "'";
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

    @Override
    public Usuario login(String nombre, String contrasena) throws RemoteException {

        String sql = "SELECT u FROM usuario u WHERE u.NOMBRE=:cod AND u.CONTRASENA=:pass";
        Query query = em1.createNativeQuery(sql).setParameter("cod", nombre).setParameter("pass", contrasena);
        List l1 = query.getResultList();
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
    public String insertarCuenta(Integer codigoCuenta, String nombreCuenta, int autor) throws RemoteException {
        String sql = "INSERT INTO CUENTA (`CODIGO_CUENTA`, `CODIGO_TIPO`, `NOMBRE_CUENTA`) \n"
                + "	VALUES (" + codigoCuenta + "," + autor + ", '" + nombreCuenta + "')";
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
    public String modificarCuenta(Integer codigoCuenta, String nombreCuenta, int cuenta) throws RemoteException {
        String sql = "UPDATE libro_cuda SET `CODIGO_TIPO`=" + cuenta + ", `NOMBRE_CUENTA`=" + "'" + nombreCuenta + " where `CODIGO_CUENTA`=" + codigoCuenta;
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
    public String eliminarCuenta(Integer codigoCuenta) throws RemoteException {
        String sql = "delete from cuenta where CODIGO_CUENTA=" + codigoCuenta + "";
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
    public Cuenta Cuenta(Integer codigoCuenta) throws RemoteException {
        String sql = "SELECT * FROM cuenta where CODIGO_TIPO=" + codigoCuenta + "";
        Query qe = em1.createNativeQuery(sql);
        List l1 = qe.getResultList();
        String ls_nombre = "";
        Integer ls_tipo;
        Cuenta e = new Cuenta();
        if (l1.size() >= 1) {
            Object[] ar_objeto = (Object[]) (l1.get(0));
            ls_nombre = ar_objeto[2].toString();
            ls_tipo = (Integer) ar_objeto[1];
            e.setNombreCuenta(ls_nombre);
            e.setCodigoTipo(ls_tipo);
            mensaje = "";
        } else {
            mensaje = "No se encontro el Autor";
        }
        return e;
    }

    public ArrayList<Integer> Cuentas1() throws RemoteException {
        String sql = "SELECT * FROM cuentas";
        Query query = em1.createNativeQuery(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<Integer> cuentas = null;
        if (l1.size() >= 1) {
            ArrayList<Integer> al = new ArrayList();
            for (Object[] row : l1) {
                Integer al1 = 0;
                al1 = (Integer) row[0];
                al.add(al1);
            }
            mensaje = "";
            cuentas = al;

        } else {
            mensaje = "No se encontro autores";
        }
        return cuentas;
    }

    @Override
    public String insertarTipoCuenta(Integer codigoTipo, String nombreTipo) throws RemoteException {
        String sql = "INSERT INTO tipo_cuenta (`CODIGO_TIPO`, `NOMBRE_TIPO`) \n"
                + "	VALUES (" + codigoTipo + ", '" + nombreTipo + "')";
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
    public String modificarTipoCuenta(Integer codigoTipo, String nombreTipo) throws RemoteException {
        String sql = "UPDATE tipo_cuenta SET `NOMBRE_AUTOR`=" + "'" + nombreTipo + "'"
                + "where `CODIGO_TIPO`=" + "'" + codigoTipo + "'";
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
    public String eliminarTipoCuenta(Integer codigoTipo) throws RemoteException {
        String sql = "delete from tipo_cuenta where codigo_tipo=" + codigoTipo + "";
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
    public pkg_interface.TipoCuenta TipoCuenta(Integer codigoTipo) throws RemoteException {
        String sql = "SELECT * FROM tipo_cuenta where CODIGO_TIPO=" + codigoTipo + "";
        Query qe = em1.createNativeQuery(sql);
        List l1 = qe.getResultList();
        String ls_nombre = "";
        pkg_interface.TipoCuenta e = new pkg_interface.TipoCuenta();
        if (l1.size() >= 1) {
            Object[] ar_objeto = (Object[]) (l1.get(0));
            ls_nombre = ar_objeto[1].toString();
            e.setNombreTipo(ls_nombre);
            mensaje = "";
        } else {
            mensaje = "No se encontro el Autor";
        }
        return e;
    }

    @Override
    public ArrayList<TipoCuenta> TipoCuentas() throws RemoteException {
        String sql = "SELECT * FROM TIPO_CUENTA";
        Query query = em1.createNativeQuery(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<TipoCuenta> tcuentas = null;
        if (l1.size() >= 1) {
            ArrayList<TipoCuenta> al = new ArrayList();
            for (Object[] row : l1) {
                TipoCuenta al1 = new TipoCuenta();
                al1.setCodigoTipo(((BigDecimal) row[0]).intValue());
                al1.setNombreTipo((String) row[1]);
                al.add(al1);
            }
            mensaje = "";
            tcuentas = al;

        } else {
            mensaje = "No se encontro libros";
        }
        return tcuentas;
    }

    @Override
    public ArrayList<pkg_interface.Cuenta> Cuentas() throws RemoteException {
        String sql = "SELECT * FROM TIPO_CUENTA";
        Query query = em1.createNativeQuery(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<Cuenta> cuentas = null;
        if (l1.size() >= 1) {
            ArrayList<Cuenta> al = new ArrayList();
            for (Object[] row : l1) {
                Cuenta al1 = new Cuenta();
                al1.setCodigoCuenta(((BigDecimal) row[0]).intValue());
                al1.setCodigoTipo(((BigDecimal) row[2]).intValue());
                al1.setNombreCuenta((String) row[2]);
                al.add(al1);
            }
            mensaje = "";
            cuentas = al;

        } else {
            mensaje = "No se encontro libros";
        }
        return cuentas;
    }

    @Override
    public ArrayList<Integer> TipoCuentas1() throws RemoteException {
        String sql = "SELECT * FROM TIPO_CUENTA";
        Query query = em1.createNativeQuery(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<Integer> cuentas = null;
        if (l1.size() >= 1) {
            ArrayList<Integer> al = new ArrayList();
            for (Object[] row : l1) {
                Integer al1 = 0;
                al1 = (Integer) row[0];
                al.add(al1);
            }
            mensaje = "";
            cuentas = al;

        } else {
            mensaje = "No se encontro autores";
        }
        return cuentas;
    }

    @Override
    public String eliminar(Integer codigo) throws RemoteException {
        String sql = "delete from sys.actividad_jlal where CODIGO_ACTIVIDAD=" + codigo + "";

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
    public String modificar(Integer codigo, String nombre) throws RemoteException {

        String sql = "UPDATE sys.actividad_jlal SET `NOMBRE_ACTIVIDAD`=" + "'" + nombre + "'"
                + "where `CODIGO_ACTIVIDAD`=" + "" + codigo + "";
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
    public String insertarActivo(Integer codigo, String nombre) throws RemoteException {
        String sql = "INSERT INTO sys.activo_jlal (`CODIGO_ACTIVO`, `NOMBRE_ACTIVO`) \n"
                + "	VALUES (" + codigo + ", '" + nombre + "')";
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
    public String eliminarActivo(Integer codigo) throws RemoteException {
        String sql = "delete from sys.activo_jlal where CODIGO_ACTIVO=" + codigo + "";
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
    public String modificarActivo(Integer codigo, String nombre) throws RemoteException {
        String sql = "UPDATE sys.activo_jlal SET `NOMBRE_ACTIVO`=" + "'" + nombre + "'"
                + "where `CODIGO_ACTIVO`=" + "'" + codigo + "'";
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
    public ArrayList<ActivoJlal> buscarActivo() throws RemoteException {
        String sql = "SELECT * FROM sys.activo_jlal ";
        Query query = em1.createNativeQuery(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<ActivoJlal> actividades = null;
        if (l1.size() >= 1) {
            ArrayList<ActivoJlal> al = new ArrayList();
            for (Object[] row : l1) {
                ActivoJlal al1 = new ActivoJlal();
                al1.setCodigoActivo((Integer) row[0]);
                al1.setNombreActivo((String) row[1]);
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
    public String insertarCabeceraC(Date fechaP, String descripcion, Date fechaE) throws RemoteException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String sql = "INSERT INTO cabecera_cuda (`FECHA_PRESTAMO`, `DESCRIPCION_PRESTAMO`, `FECHAENTREGA_PRESTAMO`) \n"
                + "	VALUES ('" + formatter.format(fechaP) + "', '" + descripcion + "'" + ",'"
                + formatter.format(fechaE) + "')";
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
    public String modificarCabeceraC(Integer numero, Date fechaP, String descripcion, Date fechaE) throws RemoteException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String sql = "UPDATE cabecera_cuda SET `FECHA_PRESTAMO`='" + formatter.format(fechaP) + "', `DESCRIPCION_PRESTAMO`=" + "'" + descripcion + "'"
                + ",`FECHAENTREGA_PRESTAMO`='" + formatter.format(fechaE) + "' where NUMERO_PRESTAMO=" + numero;
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
    public String eliminarCabeceraC(Integer numero) throws RemoteException {
        String sql = "delete from cabecera_cuda where NUMERO_PRESTAMO=" + numero + "";
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
    public CabeceraCuda CabeceraC(Integer numero) throws RemoteException {
        String sql = "SELECT * FROM cabecera_cuda where NUMERO_PRESTAMO=" + numero + "";
        Query qe = em1.createNativeQuery(sql);
        List l1 = qe.getResultList();
        Date fechaP = null;
        String descripcion;
        Date fechaE = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        pkg_interface.CabeceraCuda e = new pkg_interface.CabeceraCuda();
        if (l1.size() >= 1) {
            Object[] ar_objeto = (Object[]) (l1.get(0));
            try {
                fechaP = formatter.parse(ar_objeto[1].toString());
                fechaE = formatter.parse(ar_objeto[3].toString());
            } catch (ParseException ex) {
                Logger.getLogger(Server_RMI.class.getName()).log(Level.SEVERE, null, ex);
            }
            descripcion = ar_objeto[2].toString();
            e.setFechaPrestamo(fechaP);
            e.setDescripcionPrestamo(descripcion);
            e.setFechaentregaPrestamo(fechaE);
            mensaje = "";
        } else {
            mensaje = "No se encontro el Autor";
        }
        return e;
    }

    @Override
    public ArrayList<CabeceraCuda> CabecerasC() throws RemoteException {
        String sql = "SELECT * FROM cabecera_cuda";
        Query query = em1.createNativeQuery(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<CabeceraCuda> cabecera = null;
        if (l1.size() >= 1) {
            ArrayList<CabeceraCuda> al = new ArrayList();
            for (Object[] row : l1) {
                CabeceraCuda al1 = new CabeceraCuda();
                al1.setNumeroPrestamo((Integer) row[0]);
                al1.setFechaPrestamo((Date) row[1]);
                al1.setDescripcionPrestamo((String) row[2]);
                al1.setFechaentregaPrestamo((Date) row[3]);
                al.add(al1);
            }
            mensaje = "";
            cabecera = al;

        } else {
            mensaje = "No se encontro cabeceras";
        }
        return cabecera;
    }

    @Override
    public String insertarDetalleC(Integer numero, Integer ISBN, Integer cantidad) throws RemoteException {
        String sql = "INSERT INTO detalle_cuda (`NUMERO_PRESTAMO`, `ISBN_LIBRO`, `CANTIDAD`) \n"
                + "	VALUES (" + numero + "," + ISBN + "," + cantidad + ")";
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
    public String modificarDetalleC(Integer numero, Integer ISBN, Integer cantidad) throws RemoteException {
        String sql = "UPDATE detalle_cuda SET `cantidad`=" + cantidad + " where NUMERO_PRESTAMO=" + numero + " and ISBN_LIBRO=" + ISBN;
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
    public String eliminarDetalleC(Integer numero, Integer ISBN) throws RemoteException {
        String sql = "delete from detalle_cuda where NUMERO_PRESTAMO=" + numero + " and ISBN_LIBRO=" + ISBN;
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
    public DetalleCuda detalleC(Integer numero, Integer ISBN) throws RemoteException {
        String sql = "SELECT * FROM detalle_cuda where NUMERO_PRESTAMO=" + numero + " and ISBN_LIBRO=" + ISBN;
        Query qe = em1.createNativeQuery(sql);
        List l1 = qe.getResultList();
        Integer cantidad;
        pkg_interface.DetalleCuda e = new pkg_interface.DetalleCuda();
        if (l1.size() >= 1) {
            Object[] ar_objeto = (Object[]) (l1.get(0));
            cantidad = Integer.valueOf(ar_objeto[2].toString());
            e.setCantidad(cantidad);
            mensaje = "";
        } else {
            mensaje = "No se encontro el Autor";
        }
        return e;
    }

    @Override
    public ArrayList<DetalleCuda> DetallesC() throws RemoteException {
        String sql = "SELECT * FROM detalle_cuda";
        Query query = em1.createNativeQuery(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<DetalleCuda> detalles = null;
        if (l1.size() >= 1) {
            ArrayList<DetalleCuda> al = new ArrayList();
            for (Object[] row : l1) {
                DetalleCuda al1 = new DetalleCuda();
                pkg_interface.DetalleCudaPK al2 = new pkg_interface.DetalleCudaPK();
                al2.setNumeroPrestamo((Integer) row[0]);
                al2.setIsbnLibro(((BigDecimal) row[1]).intValue());
                al1.setDetalleCudaPK(al2);
                al1.setCantidad((Integer) row[2]);
                al.add(al1);
            }
            mensaje = "";
            detalles = al;

        } else {
            mensaje = "No se encontro detalles";
        }
        return detalles;
    }

    @Override
    public ArrayList<DetalleCuda> Detalles(Integer numero) throws RemoteException {
        String sql = "SELECT * FROM detalle_cuda where NUMERO_PRESTAMO=" + numero;
        System.out.println(sql);
        Query query = em1.createNativeQuery(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<DetalleCuda> detalles = null;
        if (l1.size() >= 1) {
            ArrayList<DetalleCuda> al = new ArrayList();
            for (Object[] row : l1) {
                DetalleCuda al1 = new DetalleCuda();
                pkg_interface.DetalleCudaPK al2 = new pkg_interface.DetalleCudaPK();
                al2.setNumeroPrestamo((Integer) row[0]);
                System.out.println(al2.getNumeroPrestamo());
                al2.setIsbnLibro(((BigDecimal) row[1]).intValue());
                System.out.println(al2.getIsbnLibro());
                al1.setDetalleCudaPK(al2);
                al1.setCantidad((Integer) row[2]);
                al.add(al1);
            }
            mensaje = "";
            detalles = al;

        } else {
            mensaje = "No se encontro detalles";
        }
        return detalles;
    }

    @Override
    public ArrayList<Integer> Libros1() throws RemoteException {
        String sql = "SELECT * FROM libro_cuda";
        Query query = em1.createNativeQuery(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<Integer> libros = null;
        if (l1.size() >= 1) {
            ArrayList<Integer> al = new ArrayList();
            for (Object[] row : l1) {
                Integer al1 = 0;
                al1 = ((BigDecimal) row[0]).intValue();
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
    public ArrayList<Integer> Numeros1() throws RemoteException {
        String sql = "SELECT * FROM cabecera_cuda";
        Query query = em1.createNativeQuery(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<Integer> numeros = null;
        if (l1.size() >= 1) {
            ArrayList<Integer> al = new ArrayList();
            for (Object[] row : l1) {
                Integer al1 = 0;
                al1 = ((Integer) row[0]);
                al.add(al1);
            }
            mensaje = "";
            numeros = al;

        } else {
            mensaje = "No se encontro libros";
        }
        return numeros;
    }

    @Override
    public String asiento(Date fechaC, String observacion, Integer codigo, Integer cuenta, int cnt_debe, int cnt_haber) throws RemoteException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String sql = "INSERT INTO cabecera_comprobante (`FECHA_CABECERA`, `OBSERVACIONES`) \n"
                + "	VALUES ('" + formatter.format(fechaC) + "','" + observacion + "')";
        System.out.println(sql);
        em1.getTransaction().begin();
        Query qe = em1.createNativeQuery(sql);
        try {
            qe.executeUpdate();
            em1.getTransaction().commit();
            mensaje = "Se insertó satisfactoriamente";
            sql = "SELECT * FROM cabecera_comprobante";
            System.out.println(sql);
            Query query = em1.createNativeQuery(sql);
            List<Object[]> l1 = query.getResultList();
            ArrayList<CabeceraComprobante> cabecera = null;
            if (l1.size() >= 1) {
                ArrayList<CabeceraComprobante> al = new ArrayList();
                for (Object[] row : l1) {
                    CabeceraComprobante al1 = new CabeceraComprobante();
                    al1.setNumeroCabecera((Integer) row[0]);
                    al1.setFechaCabecera((Date) row[1]);
                    al1.setObservaciones((String) row[2]);
                    al.add(al1);
                }
                mensaje = "";
                cabecera = al;
            } else {
                mensaje = "No se encontro cabeceras";
            }
            Integer ncabecera = cabecera.get(cabecera.size() - 1).getNumeroCabecera();
            sql = "INSERT INTO detalle_comprobante (`NUMERO_CABECERA`, `CODIGO_CUENTA`, `CANTIDAD_DEBE`, `CANTIDAD_HABER`) \n"
                    + "	VALUES (" + ncabecera + "," + cuenta + "," + cnt_debe + "," + cnt_haber + ")";
            System.out.println(sql);
            em1.getTransaction().begin();
            qe = em1.createNativeQuery(sql);
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
        } catch (Exception ex) {
            em1.getTransaction().rollback();
            mensaje = "No se pudo insertar";
        }
        System.out.println(mensaje);
        return mensaje;
    }

    @Override
    public ArrayList<CabeceraCuda> reporte1(Date fechaI, Date fechaF) throws RemoteException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        String sql = "SELECT C.FECHAENTREGA_PRESTAMO , sum(d.CANTIDAD) FROM cabecera_cuda C INNER JOIN detalle_cuda d on "
                + "d.NUMERO_PRESTAMO = C.NUMERO_PRESTAMO where C.FECHAENTREGA_PRESTAMO BETWEEN '" + formatter.format(fechaI) + "' "
                + "AND '" + formatter.format(fechaF) + "' GROUP BY `C`.`FECHAENTREGA_PRESTAMO` ASC";
        Query query = em1.createNativeQuery(sql);
        System.out.println(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<CabeceraCuda> cabecera = null;
        if (l1.size() >= 1) {
            ArrayList<CabeceraCuda> al = new ArrayList();
            for (Object[] row : l1) {
                CabeceraCuda al1 = new CabeceraCuda();
                al1.setNumeroPrestamo(((BigDecimal) row[1]).intValue());
                al1.setFechaPrestamo((Date) row[0]);
                al.add(al1);
            }
            mensaje = "";
            cabecera = al;

        } else {
            mensaje = "No se encontro cabeceras";
        }
        return cabecera;
    }

    @Override
    public ArrayList<AutorCuda> reporte2(Date fechaI, Date fechaF) throws RemoteException {
        
        String sql = " SELECT l.ISBN_LIBRO , l.TITULO_LIBRO , l.CANTIDAD_LIBRO ,a.CODIGO_AUTOR,a.NOMBRE_AUTOR,a.APELLIDO_AUTOR\n"
                + "FROM libro_cuda l \n"
                + "INNER JOIN autor_cuda a on a.CODIGO_AUTOR = l.CODIGO_AUTOR \n"
                + "INNER JOIN detalle_cuda  d on d.ISBN_LIBRO = l.ISBN_LIBRO \n"
                + "INNER JOIN cabecera_cuda  c on c.NUMERO_PRESTAMO = d.NUMERO_PRESTAMO where \n"
                + "        c.FECHAENTREGA_PRESTAMO BETWEEN '" + formatter.format(fechaI) + "' "
                + "AND '" + formatter.format(fechaF) + "' ORDER BY `C`.`FECHAENTREGA_PRESTAMO` ASC";
        Query query = em1.createNativeQuery(sql);
        System.out.println(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<AutorCuda> cabecera = null;
        if (l1.size() >= 1) {
            ArrayList<AutorCuda> al = new ArrayList();
            for (Object[] row : l1) {
                AutorCuda al1 = new AutorCuda();
                al1.setCodigoAutor((Integer) row[2]);
                al1.setNombreAutor(((BigDecimal) row[0]).toString() + " " + (String) row[1]);
                al1.setApellidoAutor(((Integer) row[3]).toString() + " " + (String) row[4] + " " + (String) row[5]);
                al.add(al1);
            }
            mensaje = "";
            cabecera = al;

        } else {
            mensaje = "No se encontro cabeceras";
        }
        return cabecera;
    }

    @Override
    public void soporte(String nombre, String mensaje, String fecha) throws RemoteException {
        Soporte c1 = new Soporte();
        c1.setNombre(nombre);
        c1.setMensaje(mensaje);
        c1.setFecha(fecha);
        try {
            em1.getTransaction().begin();
            em1.persist(c1);
            em1.getTransaction().commit();
            System.out.println("correcto Soporte");
        } catch (Exception ex) {
            em1.getTransaction().rollback();
        }
        em1.close();
        factory.close();

    }

    @Override
    public String insertarDetalleM(Integer codigoActividad, Integer codigoActivo, Integer numeroMantenimiento, Integer valorDMantenimiento) throws RemoteException {
        String sql = "INSERT INTO sys.detalle_mantenimiento_jlal (`CODIGO_ACTIVIDAD`, `CODIGO_ACTIVO`, `NUMERO_MANTENIMIENTO`, `VALOR_D_MANTENIMIENTO`) \n" +
"	VALUES ("+codigoActividad+", "+codigoActivo+","+numeroMantenimiento+"," +valorDMantenimiento+")";
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
    public String eliminarDetalleM(Integer codigoActividad, Integer codigoActivo, Integer numeroMantenimiento) throws RemoteException {
        
        
        String sql = "DELETE FROM `sys`.`detalle_mantenimiento_jlal` WHERE (`CODIGO_ACTIVIDAD` = '"+codigoActividad+"') and (`CODIGO_ACTIVO` = '"+codigoActivo+"') and (`NUMERO_MANTENIMIENTO` = '"+numeroMantenimiento+"')";
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
    public String modificarDetalleM(Integer codigoActividad, Integer codigoActivo, Integer numeroMantenimiento, Integer valorDMantenimiento) throws RemoteException {
        String sql = "UPDATE `sys`.`detalle_mantenimiento_jlal` SET `VALOR_D_MANTENIMIENTO` = '"+valorDMantenimiento+"' WHERE (`CODIGO_ACTIVIDAD` = '"+codigoActividad+"') and (`CODIGO_ACTIVO` = '"+codigoActivo+"') and (`NUMERO_MANTENIMIENTO` = '"+numeroMantenimiento+"')";
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
    public DetalleMantenimientoJlal buscarDetalleM(Integer codigoActividad, Integer codigoActivo, Integer numeroMantenimiento) throws RemoteException {
         String sql = "SELECT * FROM sys.detalle_mantenimiento_jlal WHERE (`CODIGO_ACTIVIDAD` = '"+codigoActividad+"') and (`CODIGO_ACTIVO` = '"+codigoActivo+"') and (`NUMERO_MANTENIMIENTO` = '"+numeroMantenimiento+"')";
        Query qe = em1.createNativeQuery(sql);
        List l1 = qe.getResultList();
        Integer ls_nombre = 0;
        DetalleMantenimientoJlal e = new DetalleMantenimientoJlal();
        if (l1.size() >= 1) {
            Object[] ar_objeto = (Object[]) (l1.get(0));
            ls_nombre = ((BigDecimal) ar_objeto[3]).intValue() ;
            e.setValorDMantenimiento(ls_nombre);
            e.setCodigoActividad(codigoActividad);
            e.setCodigoActivo(codigoActivo);
            e.setNumeroMantenimiento(numeroMantenimiento);

            mensaje = "";
        } else {
            mensaje = "No se encontro el PROVEEDOR";
        }
        System.out.println("Actividad:" + ls_nombre + "");

        return e;
    }

    @Override
    public ArrayList<DetalleMantenimientoJlal> buscarDetalleM() throws RemoteException {
        String sql = "SELECT * FROM sys.detalle_mantenimiento_jlal ";
        Query query = em1.createNativeQuery(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<DetalleMantenimientoJlal> actividades = null;
        if (l1.size() >= 1) {
            ArrayList<DetalleMantenimientoJlal> al = new ArrayList();
            for (Object[] row : l1) {
                DetalleMantenimientoJlal al1 = new DetalleMantenimientoJlal();
                al1.setCodigoActividad((Integer) row[0]);
                al1.setCodigoActivo((Integer) row[1]);
                al1.setNumeroMantenimiento((Integer) row[2]);
                al1.setValorDMantenimiento(((BigDecimal) row[3]).intValue());
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
    public String insertarMante(Integer numeroMantenimiento, Date fechaMantenimiento, String responsableMantenimiento) throws RemoteException {
       
        String sql = "INSERT INTO `sys`.`mantenimiento_jlal` (`NUMERO_MANTENIMIENTO`, `FECHA_MANTENIMIENTO`, `RESPONSABLE_MANTENIMIENTO`) VALUES ('"+numeroMantenimiento+"', '"+formatter.format(fechaMantenimiento)+"', '"+responsableMantenimiento+"')";
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
    public String eliminarMante(Integer numeroMantenimiento) throws RemoteException {
          String sql = "DELETE FROM `sys`.`mantenimiento_jlal` WHERE (`NUMERO_MANTENIMIENTO` = '"+numeroMantenimiento+"')";
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
    public String modificarMante(Integer numeroMantenimiento, Date fechaMantenimiento, String responsableMantenimiento) throws RemoteException {
        String sql = "UPDATE `sys`.`mantenimiento_jlal` SET `FECHA_MANTENIMIENTO` = '"+formatter.format(fechaMantenimiento)+"', `RESPONSABLE_MANTENIMIENTO` = '"+responsableMantenimiento+"' WHERE (`NUMERO_MANTENIMIENTO` = '"+numeroMantenimiento+"')";
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
    public MantenimientoJlal buscarActivoMante(Integer numeroMantenimiento) throws RemoteException {
        String sql = "SELECT * FROM sys.mantenimiento_jlal WHERE (`NUMERO_MANTENIMIENTO` = '"+numeroMantenimiento+"')";
        Query qe = em1.createNativeQuery(sql);
        List l1 = qe.getResultList();
        String ls_nombre = "";
        MantenimientoJlal e = new MantenimientoJlal();
        if (l1.size() >= 1) {
            Object[] ar_objeto = (Object[]) (l1.get(0));
            ls_nombre = ar_objeto[2].toString();
            e.setResponsableMantenimiento(ls_nombre);
            e.setNumeroMantenimiento(numeroMantenimiento);
            
            e.setFechaMantenimiento((Date)ar_objeto[1]);
            

            mensaje = "";
        } else {
            mensaje = "No se encontro el PROVEEDOR";
        }
        System.out.println("Actividad:" + ls_nombre + "");

        return e;
    }

    @Override
    public ArrayList<MantenimientoJlal> buscarMante() throws RemoteException {
        String sql = "SELECT * FROM mantenimiento_jlal ";
        Query query = em1.createNativeQuery(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<MantenimientoJlal> actividades = null;
        if (l1.size() >= 1) {
            ArrayList<MantenimientoJlal> al = new ArrayList();
            for (Object[] row : l1) {
                MantenimientoJlal al1 = new MantenimientoJlal();
                
             
            
            al1.setResponsableMantenimiento(row[2].toString());
            al1.setNumeroMantenimiento((Integer) row[0]);
                al1.setFechaMantenimiento((Date)row[1]);
            
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
    public ArrayList<DetalleMantenimientoJlal> ReporteM1() throws RemoteException {
        String sql = "SELECT CODIGO_ACTIVIDAD,SUM(VALOR_D_MANTENIMIENTO) FROM sys.detalle_mantenimiento_jlal group by CODIGO_ACTIVIDAD  ";
        Query query = em1.createNativeQuery(sql);
        List<Object[]> l1 = query.getResultList();
        ArrayList<DetalleMantenimientoJlal> actividades = null;
        if (l1.size() >= 1) {
            ArrayList<DetalleMantenimientoJlal> al = new ArrayList();
            for (Object[] row : l1) {
                DetalleMantenimientoJlal al1 = new DetalleMantenimientoJlal();
                al1.setCodigoActividad((Integer) row[0]);
                al1.setValorDMantenimiento(((BigDecimal) row[1]).intValue());
                al1.setCodigoActivo(0);
                al1.setNumeroMantenimiento(0);
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
