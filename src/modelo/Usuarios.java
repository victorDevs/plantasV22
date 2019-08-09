/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import persistencia.BD;
import persistencia.MetodosGlobales;
import vista.CatalogoUsuarios;

/**
 *
 * @author Luis
 */
public class Usuarios {
    int idUsuario;
    int idPerfil;
  
    String nombre;
    String perfil;
    String Usuario;
    String contrasena;
    String repeContrasena;
    String rol;
    String correo;

    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm; 

  
    
    
    public int getIdUsuario() {
        return idUsuario;
    }

      public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRepeContrasena() {
        return repeContrasena;
    }

    public void setRepeContrasena(String repeContrasena) {
        this.repeContrasena = repeContrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
      public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public void TablaConsultaUsuarios(){
        try {
            if (BD.conectarBD()) {
                String sql = "select idUsuario,nombre,usuario,perfil,rol,correo from usuarios";
                rs = BD.ejecutarSQLSelect(sql);
                rsm = rs.getMetaData();
                List<Object[]> datos = new ArrayList<Object[]>();
                while (rs.next()) {                
                    Object[] filas = new Object[rsm.getColumnCount()];
                    for (int i = 0; i < filas.length; i++) {
                        filas[i] = rs.getObject(i+1);
                    }
                    datos.add(filas);
                }
                dtm = (DefaultTableModel)CatalogoUsuarios.jTableUsuarios.getModel();
                for (int i = 0; i < datos.size(); i++) {
                    dtm.addRow(datos.get(i));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar lo datos en la tabla usuarios: "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
    public void ApuntaUsuario(){
        try {
            BD.conectarBD();
            int fila = CatalogoUsuarios.jTableUsuarios.getSelectedRow();
            String sql = "select nombre,usuario,contrasena,correo,perfil,rol"
                    + " from usuarios where idUsuario = "+CatalogoUsuarios.jTableUsuarios.getValueAt(fila, 0);
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            while (rs.next()) {                
                this.nombre = rs.getString(1);
                this.Usuario = rs.getString(2);
                this.contrasena = rs.getString(3);
                this.correo = rs.getString(4);
                this.perfil = rs.getString(5);
                this.rol = rs.getString(6);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudo mostrar este usuario, vuelve a intentarlo: "+e, 
                    "Aviso",JOptionPane.WARNING_MESSAGE);
        }
    }
    
   public void buscarUsuario(String tipoBuqueda,String busqueda){
        try {
            if (BD.conectarBD()) {
                String sql = "select idUsuario,nombre,usuario,perfil,rol,correo from usuarios where "+tipoBuqueda+" like '%"+busqueda+"%'";
                rs = BD.ejecutarSQLSelect(sql);
                rsm = rs.getMetaData();
                List<Object[]> datos = new ArrayList<Object[]>();
                while (rs.next()) {                
                    Object[] filas = new Object[rsm.getColumnCount()];
                    for (int i = 0; i < filas.length; i++) {
                        filas[i] = rs.getObject(i+1);
                    }
                    datos.add(filas);
                }
                dtm = (DefaultTableModel)CatalogoUsuarios.jTableUsuarios.getModel();
                for (int i = 0; i < datos.size(); i++) {
                    dtm.addRow(datos.get(i));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar lo datos en la tabla usuarios: "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
   
   public void ListadoComboPerfil(JComboBox combo){
        DefaultComboBoxModel comboPerfil = new DefaultComboBoxModel();
        try {
            BD.conectarBD();
            String sql = "select idPerfil,nombre from perfiles";
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            combo.setModel(comboPerfil);
            ArrayList flagArea = new ArrayList();
            comboPerfil.addElement("Selecciona un Perfil");
            while (rs.next()) {
                this.idPerfil = Integer.parseInt(rs.getString("idPerfil"));
                this.perfil = rs.getString("nombre");
                comboPerfil.addElement(rs.getObject("nombre"));
                combo.setModel(comboPerfil);
            }
            comboPerfil.addElement("REGISTRAR PERFIL");
            combo.setModel(comboPerfil);
            BD.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Excepción: "+e);
            JOptionPane.showMessageDialog(null, "Error al mostrar el listado de procesos",
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
   
    public boolean RegistraUsuario(){
        String sql = "insert into usuarios (nombre,usuario,contrasena,correo,perfil,rol) "
                + "values ('"+MetodosGlobales.aceptarComillaSimple(this.nombre)+"', '"+MetodosGlobales.aceptarComillaSimple(this.Usuario)+"','"
                +MetodosGlobales.aceptarComillaSimple(this.contrasena)+"','"+this.correo+"','"+this.perfil+"','0')";
        System.out.println("Registro de usuario: "+sql);
        if (BD.ejecutarSQL(sql)) {
            return true;
        }else{
            return false;
        }
    }
    
    public boolean ActualizarUsuario(JTable tabla){
        int fila = tabla.getSelectedRow();
        String sql = "update usuarios set nombre = '"+MetodosGlobales.aceptarComillaSimple(this.nombre)+"', usuario = '"+MetodosGlobales.aceptarComillaSimple(this.Usuario)+"',"
                + " contrasena='"+MetodosGlobales.aceptarComillaSimple(this.contrasena)+"', correo='"+this.correo+"', perfil='"+this.perfil+"'"
                + "where idUsuario= "+tabla.getValueAt(fila, 0);
        System.out.println("consulta: "+sql);
        if (BD.ejecutarSQL(sql)) {            
            return true;
        } else {
            return false;
        }
    }
    
    public boolean EliminaUsuario(JTable tabla){
        int fila = tabla.getSelectedRow();
        String sql = "delete from usuarios where IdUsuario = '"+tabla.getValueAt(fila, 0)+"'";
        if (BD.ejecutarSQL(sql)) {            
            return true;
        } else {
            return false;
        }
    }
}
