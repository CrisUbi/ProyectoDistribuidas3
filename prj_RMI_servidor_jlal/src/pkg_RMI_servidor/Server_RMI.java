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
import pkg_interface.ActivoJlal;
import pkg_interface.AutorCuda;
import pkg_interface.LibroCuda;
import pkg_interface.Usuario;
import pkg_interface.cls_interface;
import pkg_interface.Cuenta;
import pkg_interface.TipoCuenta;

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

}
