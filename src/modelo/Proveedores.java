/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import persistencia.BD;
import static persistencia.BD.conexion;
import vista.CatalogoProveedores;

/**
 *
 * @author vikto
 */
public class Proveedores {
    int idProveedor;
    String nombre;
    String domicilio;
    String tel;
    String tel2;
    String contacto;
    String correo;
    String camposBusqueda;
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm; 
    Statement st = null;
    
    

    public int getIdProveedor() {
        return idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getTel() {
        return tel;
    }
    
     public String getTel2() {
        return tel2;
    }

    public String getContacto() {
        return contacto;
    }

    public String getCorreo() {
        return correo;
    }
    
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    
    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    public boolean RegistraProveedor(){
        String sql = "insert into proveedores (nombre,domicilio,tel,tel2,contacto,correo) "
                + "values ('"+this.nombre+"', '"+this.domicilio+"','"+this.tel+"','"+this.tel2+"','"+this.contacto+"', "
                + "'"+this.correo+"');";
        System.out.println("Registro de proveedor: "+sql);
        if (BD.ejecutarSQL(sql)) {
            return true;
        }else{
            return false;
        }
    }
    
    public void TablaConsultaProveedores(){
        try {
            if (BD.conectarBD()) {
                String sql = "select * from proveedores";
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
                dtm = (DefaultTableModel)CatalogoProveedores.jTableProveedores.getModel();
                for (int i = 0; i < datos.size(); i++) {
                    dtm.addRow(datos.get(i));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar lo datos en la tabla proveedores: "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
    public void ApuntaProveedor(){
        try {
            BD.conectarBD();
            int fila = CatalogoProveedores.jTableProveedores.getSelectedRow();
            String sql = "select nombre,domicilio,tel,tel2,contacto,correo"
                    + " from proveedores where idProveedor = "+CatalogoProveedores.jTableProveedores.getValueAt(fila, 0);
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            while (rs.next()) {                
                this.nombre = rs.getString(1);
                this.domicilio = rs.getString(2);
                this.tel = rs.getString(3);
                this.tel2 = rs.getString(4);
                this.contacto = rs.getString(5);
                this.correo = rs.getString(6);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudo mostrar este proveedor, vuelve a intentarlo: "+e, 
                    "Aviso",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public boolean ActualizarProveedor(JTable tabla){
        int fila = tabla.getSelectedRow();
        String sql = "update proveedores set nombre = '"+this.nombre+"', domicilio = '"+this.domicilio+"',"
                + " contacto='"+this.contacto+"', tel='"+this.tel+"', tel2='"+this.tel2+"', correo='"+this.correo+"' "
                + "where idProveedor = "+tabla.getValueAt(fila, 0);
        System.out.println("consulta: "+sql);
        if (BD.ejecutarSQL(sql)) {            
            return true;
        } else {
            return false;
        }
    }
    
    public boolean EliminaProveedor(JTable tabla){
        int fila = tabla.getSelectedRow();
        String sql = "delete from proveedores where IdProveedor = '"+tabla.getValueAt(fila, 0)+"'";
        if (BD.ejecutarSQL(sql)) {            
            return true;
        } else {
            return false;
        }
    }
    
     public void buscarProveedor(String tipoBuqueda,String busqueda){
        try {
            if (BD.conectarBD()) {
                String sql = "select * from proveedores where "+tipoBuqueda+" like '%"+busqueda+"%'";
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
                dtm = (DefaultTableModel)CatalogoProveedores.jTableProveedores.getModel();
                for (int i = 0; i < datos.size(); i++) {
                    dtm.addRow(datos.get(i));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar lo datos en la tabla proveedores: "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
     
     public void leerDatosLista(JList lista){

      String sql = "SELECT nombre FROM proveedores";
       DefaultListModel modelo = new DefaultListModel();
      
      if(BD.conectarBD()){
          try {
              st = conexion.createStatement();
              rs = st.executeQuery(sql);
              
              while (rs.next()) {
                  //prove.setNombre(rs.getString(1).toString());
                  //proveedores.add(prove);
                  modelo.addElement(rs.getString(1));
              }
              lista.setModel(modelo);
              st.close();
              rs.close();
          } catch (Exception e) {
              e.printStackTrace();
          } 
      }
      //return proveedores;
   }
     
    public void optenerIdProveedor(String nombreProveedor){
        try {
            BD.conectarBD();
            String sql = "select idProveedor from proveedores where nombre = '"+nombreProveedor.trim()+"'";
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            while (rs.next()) {                
                this.idProveedor = rs.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudo mostrar este proveedor, vuelve a intentarlo: "+e, 
                    "Aviso",JOptionPane.WARNING_MESSAGE);
        }
    }
}
