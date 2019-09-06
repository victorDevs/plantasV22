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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import persistencia.BD;
import persistencia.MetodosGlobales;
import vista.CatalogoClientes;

/**
 *
 * @author vikto
 */
public class Clientes {
    int idCliente;
    String nombre;
    String domicilio;
    String contacto;
    String telefono;
    String correo;
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm;
    
    public int getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getContacto() {
        return contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public boolean RegistraCliente(){
        String sql = "insert into clientes (nombre,domicilio,tel,contacto,correo) "
                + "values ('"+MetodosGlobales.aceptarComillaSimple(this.nombre)+"', '"+MetodosGlobales.aceptarComillaSimple(this.domicilio)+"','"+this.telefono+"','"+MetodosGlobales.aceptarComillaSimple(this.contacto)+"', "
                + "'"+this.correo+"');";
        System.out.println("Registro de cliente: "+sql);
        if (BD.ejecutarSQL(sql)) {
            return true;
        }else{
            return false;
        }
    }
    
    public void TablaConsultaClientes(){
        try {
            if (BD.conectarBD()) {
                String sql = "select idCliente,nombre,contacto,tel,correo from clientes";
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
                dtm = (DefaultTableModel)CatalogoClientes.jTableClientes.getModel();
                for (int i = 0; i < datos.size(); i++) {
                    dtm.addRow(datos.get(i));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar lo datos en la tabla clientes: "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
    public void ApuntaCliente(){
        try {
            BD.conectarBD();
            int fila = CatalogoClientes.jTableClientes.getSelectedRow();
            String sql = "select nombre,domicilio,tel,contacto,correo"
                    + " from clientes where idCliente = "+CatalogoClientes.jTableClientes.getValueAt(fila, 0);
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            while (rs.next()) {                
                this.nombre = rs.getString(1);
                this.domicilio = rs.getString(2);
                this.telefono = rs.getString(3);
                this.contacto = rs.getString(4);
                this.correo = rs.getString(5);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudo mostrar este cliente, vuelve a intentarlo: "+e, 
                    "Aviso",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public boolean ActualizarCliente(JTable tabla){
        int fila = tabla.getSelectedRow();
        String sql = "update clientes set nombre = '"+MetodosGlobales.aceptarComillaSimple(this.nombre)+"', domicilio = '"+MetodosGlobales.aceptarComillaSimple(this.domicilio)+"',"
                + " contacto='"+MetodosGlobales.aceptarComillaSimple(this.contacto)+"', tel='"+this.telefono+"', correo='"+this.correo+"' "
                + "where idCliente = "+tabla.getValueAt(fila, 0);
//        System.out.println("consulta: "+sql);
        if (BD.ejecutarSQL(sql)) {            
            return true;
        } else {
            return false;
        }
    }
    
    public boolean EliminaCliente(JTable tabla){
        int fila = tabla.getSelectedRow();
        String sql = "delete from clientes where IdCliente = '"+tabla.getValueAt(fila, 0)+"'";
        if (BD.ejecutarSQL(sql)) {            
            return true;
        } else {
            return false;
        }
    }
    
//    public void buscarCliente(String tipoBuqueda,String busqueda){
//        try {
//            if (BD.conectarBD()) {
//                String sql = "select idCliente,nombre,domicilio,tel,contacto,correo from clientes where "+tipoBuqueda+" like '"+busqueda+"%'";
//                rs = BD.ejecutarSQLSelect(sql);
//                rsm = rs.getMetaData();
//                List<Object[]> datos = new ArrayList<Object[]>();
//                while (rs.next()) {                
//                    Object[] filas = new Object[rsm.getColumnCount()];
//                    for (int i = 0; i < filas.length; i++) {
//                        filas[i] = rs.getObject(i+1);
//                    }
//                    datos.add(filas);
//                }
//                dtm = (DefaultTableModel)CatalogoClientes.jTableClientes.getModel();
//                for (int i = 0; i < datos.size(); i++) {
//                    dtm.addRow(datos.get(i));
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
//                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
//                BD.cerrarConexion();
//            }            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Error al mostrar lo datos en la tabla Clientes: "+e, 
//                    "Error",JOptionPane.ERROR_MESSAGE);
//            BD.cerrarConexion();
//        }/
//    }
    
    public void buscarCliente(String tipoBuqueda,String busqueda){
        try {
            if (BD.conectarBD()) {
                String sql = "select * from clientes where "+tipoBuqueda+" like '%"+busqueda+"%'";
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
                dtm = (DefaultTableModel)CatalogoClientes.jTableClientes.getModel();
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
    
    public void llenaComboClientes(JComboBox combo){
        DefaultComboBoxModel comboCliente = new DefaultComboBoxModel();
        try {
            BD.conectarBD();
            String sql = "select * from clientes";
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            combo.setModel(comboCliente);
            comboCliente.addElement("-- Seleccione --");
            while (rs.next()) {
                this.idCliente = Integer.parseInt(rs.getString("idCliente"));
                this.nombre = rs.getString("nombre");
                comboCliente.addElement(rs.getObject("nombre"));
                combo.setModel(comboCliente);
            }
            BD.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Excepción: "+e);
            JOptionPane.showMessageDialog(null, "Error al mostrar el listado de clientes",
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
  
}
