/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import persistencia.BD;
import persistencia.MetodosGlobales;

/**
 *
 * @author Luis
 */
public class LoginModel {
    
    String usuario;
    String contrasena;
    String nomUsuario;
    
    String permiso;

     ResultSet rs;
    ResultSetMetaData rsm;
    
    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }
    
    public boolean iniciarSesion(){
        boolean existeUsua=false;
        try {
            BD.conectarBD();
         
            String sql = "select idUsuario,nombre,usuario,contrasena,perfil from usuarios "
                + "where usuario = '"+MetodosGlobales.aceptarComillaSimple(this.usuario)+ "' and contrasena = '"+MetodosGlobales.aceptarComillaSimple(this.contrasena)+"'";
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            if (rs.next()) {
                this.nomUsuario = rs.getString(3); 
                existeUsua = true;
            }else{
                existeUsua = false;
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"No se pudo consultar este usuario, vuelve a intentarlo: "+ex, 
                    "Aviso",JOptionPane.WARNING_MESSAGE);
        }
         return existeUsua;
    }
    
    public String validaPermisos(String acceso,String usuario){
        try {
            BD.conectarBD();
            String sql = "select idUsuario,nombre,materialPermiso,proveedorPermiso,clientesPermiso,personalPermiso from usuarios "
                + "where usuario = '"+usuario+"'";
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            if (rs.next()) {
                if(acceso.equals("materiales")){this.permiso = rs.getString(3);}
                if(acceso.equals("proveedores")){this.permiso = rs.getString(4);}
                if(acceso.equals("clientes")){this.permiso = rs.getString(5);}
                if(acceso.equals("personal")){this.permiso = rs.getString(6);}
            }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"No se pudo consultar este usuario, vuelve a intentarlo: "+ex, 
                    "Aviso",JOptionPane.WARNING_MESSAGE);
        }
        return this.permiso;
    }
}
