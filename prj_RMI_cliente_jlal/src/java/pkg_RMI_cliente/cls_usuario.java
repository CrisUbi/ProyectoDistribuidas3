/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg_RMI_cliente;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import pkg_interface.AutorCuda;
import pkg_interface.Usuario;
import pkg_interface.cls_interface;

/**
 *
 * @author crist
 */
@ManagedBean()
@SessionScoped
public class cls_usuario {

    Integer codigo;
    String nombre;
    String contrasena;
    String permisos;
    String mensaje;
    String biblioteca = "display:none;";
    String cuenta = "display:none;";
    String activo = "display:none;";
    String admin = "display:none;";
    ArrayList<Usuario> busca;
    Usuario usu;

    public cls_usuario() {
        buscarT();
    }

    public String getBiblioteca() {
        return biblioteca;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public void setBiblioteca(String biblioteca) {
        this.biblioteca = biblioteca;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public ArrayList<Usuario> getBusca() {
        return busca;
    }

    public void setBusca(ArrayList<Usuario> busca) {
        this.busca = busca;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public void insertar() {
        System.out.println("2");
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            mensaje = interface1.insertarUsuario(codigo, nombre, contrasena, permisos);
            buscarT();
            codigo = 0;
            nombre = "";
            contrasena = "";
            permisos = "";
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No se pudo insertar";
        }
    }

    public void buscar() {
        System.out.println("5");
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            Usuario busca = interface1.usuario(codigo);
            nombre = busca.getNombre();
            contrasena = busca.getContrasena();
            permisos = busca.getPermisos();
            mensaje = "Dato encontrado";
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "Dato no encontrado";
        }
    }

    public void eliminar() {
        System.out.println("4");
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            mensaje = interface1.eliminarUsuario(codigo);
            buscarT();
            codigo = 0;
            nombre = "";
            contrasena = "";
            permisos = "";
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No se pudo eliminar";
        }
    }

    public void modificar() {
        System.out.println("1");
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            mensaje = interface1.modificarUsuario(codigo, nombre, contrasena, permisos);
            buscarT();
            codigo = 0;
            nombre = "";
            contrasena = "";
            permisos = "";
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No se pudo modificar";
        }
    }

    public void buscarT() {
        busca = null;
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            busca = interface1.Usuarios();
            mensaje = "Tabla encontrada";
        } catch (RemoteException | NotBoundException ex) {
            System.out.println("error");
            mensaje = "No encontro Tabla";
        }
        System.out.println(mensaje);
    }

    public Usuario login() {
        System.out.println("login");
        Usuario usuarioCuda = null;
        try {
            Registry registro = LocateRegistry.getRegistry("127.0.0.1", 1095);
            cls_interface interface1 = (cls_interface) registro.lookup("rmi://localhost:1095/RMI_interface");
            usuarioCuda = interface1.login(nombre, contrasena);
            usu = usuarioCuda;
            System.out.println("entro");
            if (usu != null) {
                ExternalContext ec = FacesContext.getCurrentInstance()
                        .getExternalContext();
                try {
                    menu();
                    ec.redirect(ec.getRequestContextPath()
                            + "/faces/menu.xhtml");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                ExternalContext ec = FacesContext.getCurrentInstance()
                        .getExternalContext();
                try {
                    menu();
                    ec.redirect(ec.getRequestContextPath()
                            + "/faces/login.xhtml");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (RemoteException | NotBoundException ex) {
            Logger.getLogger(cls_usuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error");
        }
        return usuarioCuda;
    }

    public void menu() {
        biblioteca = "display:none;";
        cuenta = "display:none;";
        activo = "display:none;";
        admin = "display:none;";
        String[] perm = usu.getPermisos().split(",");
        for (int i = 0; i < perm.length; i++) {
            if (perm[i].equals("admin")) {
                biblioteca = "display:block;";
                cuenta = "display:block;";
                activo = "display:block;";
                admin = "display:block;";
            } else {
                if (perm[i].equals("biblioteca")) {
                    biblioteca = "display:block;";
                }
                if (perm[i].equals("cuenta")) {
                    cuenta = "display:block;";
                }
                if (perm[i].equals("activo")) {
                    activo = "display:block;";
                }
            }
        }
    }
}
