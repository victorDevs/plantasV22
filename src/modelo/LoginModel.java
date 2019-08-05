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
    
    public boolean iniciarSesion(){
        boolean existeUsua=false;
        try {
            BD.conectarBD();
         
            String sql = "select idUsuario,nombre,usuario,contrasena,perfil from usuarios "
                + "where usuario = '"+MetodosGlobales.aceptarComillaSimple(this.usuario)+ "' and contrasena = '"+MetodosGlobales.aceptarComillaSimple(this.contrasena)+"'";
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            if (rs.next()) {
                this.nomUsuario = rs.getString(2); 
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
          
}