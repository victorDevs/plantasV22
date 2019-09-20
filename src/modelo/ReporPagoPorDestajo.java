/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.BD;
import vista.DetallesPagoPorDestajo;
import vista.PagosPorDestajo;

/**
 *
 * @author Luis
 */
public class ReporPagoPorDestajo {
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm; 
    
    String proceso;

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }
    
    
    public void TablaPrincipalConsultaPagoPorDestajo(){
         try {
            if (BD.conectarBD()) {
                String sql = "select pedidos.idPersonal,CONCAT(personal.nombre,' ',personal.apellidoPaterno,' ',personal.apellidoMaterno)as nombre, pedidos.precio,pedidos.total from pedidos inner join personal on pedidos.idPersonal=personal.idPersonal";
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
                dtm = (DefaultTableModel)PagosPorDestajo.jTablePrincipalPagosDestajo.getModel();
                for (int i = 0; i < datos.size(); i++) {
                    dtm.addRow(datos.get(i));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar lo datos PagosPorDestajo(en tablas Pedidos y Pesonal): "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
    public void llenaComboProcesos(JComboBox combo,int idPersonal){
        DefaultComboBoxModel comboProcesos = new DefaultComboBoxModel();
        try {
            BD.conectarBD();
            String sql = "select proceso from personal where idPersonal = "+idPersonal;
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            combo.setModel(comboProcesos);
            comboProcesos.addElement("-- Seleccione --");
            while (rs.next()) {
                this.proceso = rs.getString("proceso");
                comboProcesos.addElement(rs.getObject("proceso"));
                combo.setModel(comboProcesos);
            }
            BD.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Excepción: "+e);
            JOptionPane.showMessageDialog(null, "Error al mostrar el listado de procesos en tabla personal",
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
    public void consultarPorProceso(int idPersonal){
        try {
            if (BD.conectarBD()) {
                String sql = "select tallas.talla, tallas.cantidad from tallas inner join pedidos on tallas.idPedido=pedidos.idPedido where pedidos.idPersonal ="+idPersonal;
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
                dtm = (DefaultTableModel)DetallesPagoPorDestajo.jTableDetallePagoDestajo.getModel();
                for (int i = 0; i < datos.size(); i++) {
                    dtm.addRow(datos.get(i));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar lo datos DetallesPagosPorDestajo(en tabla tallas): "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
    public void buscarEstilosPorPersonal(){
        try {
            if (BD.conectarBD()) {
                String sql = "select estilos.idEstilo,estilos.estilo, estilos_procesos.proceso,sum(tallas.cantidad) as totalTallas, procesos.destajo,"+
                        "round(sum(tallas.cantidad)*(procesos.destajo),2) as totalDes from pedidos inner join tallas on tallas.idPedido=pedidos.idPedido "+
                        "inner join estilos on estilos.idEstilo=pedidos.idEstilo inner join estilos_procesos on estilos_procesos.idEstilo=estilos.idEstilo "+
                        "inner join procesos on procesos.nombre=estilos_procesos.proceso WHERE pedidos.idPersonal =4 ";
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
                dtm = (DefaultTableModel)PagosPorDestajo.jTablePrincipalPagosDestajo.getModel();
                for (int i = 0; i < datos.size(); i++) {
                    dtm.addRow(datos.get(i));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar lo datos PagosPorDestajo-tablaPrincipal "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
}
