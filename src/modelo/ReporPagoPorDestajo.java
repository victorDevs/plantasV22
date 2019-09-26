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
    String nombreTrabajador;
    int idEstilo;
    String nomEstilo;
    String tipoTalla;
    int idPersonal;
    double destajo;
    int idPedido;
    int numSemana;

    public String getProceso() {
        return proceso;
    }
    
    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public int getIdEstilo() {
        return idEstilo;
    }

    public void setIdEstilo(int idEstilo) {
        this.idEstilo = idEstilo;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getNomEstilo() {
        return nomEstilo;
    }

    public void setNomEstilo(String nomEstilo) {
        this.nomEstilo = nomEstilo;
    }

    public String getTipoTalla() {
        return tipoTalla;
    }

    public void setTipoTalla(String tipoTalla) {
        this.tipoTalla = tipoTalla;
    }

    public double getDestajo() {
        return destajo;
    }

    public void setDestajo(double destajo) {
        this.destajo = destajo;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getNumSemana() {
        return numSemana;
    }

    public void setNumSemana(int numSemana) {
        this.numSemana = numSemana;
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
    
    public void consultarPorProceso(){
        try {
            setNombreTrabajador("");
            dtm = (DefaultTableModel)DetallesPagoPorDestajo.jTableDetallePagoDestajo.getModel();
            if (BD.conectarBD()) {
                String sql = "select concat(personal.nombre,' ',personal.apellidoPaterno,' ',personal.apellidoMaterno) as nombre, estilos.estilo,"+
                        "procesos.nombre,procesos.destajo,tallas.talla, tallas.cantidad, pedidos.tipoTalla,pedidos.numeroSemana from tallas inner join pedidos on tallas.idPedido=pedidos.idPedido "+
                        "inner join personal on pedidos.idPersonal=personal.idPersonal inner join estilos on pedidos.idEstilo=estilos.idEstilo inner join procesos "+
                        "on personal.proceso=procesos.nombre where pedidos.idPedido = "+this.idPedido+" group by tallas.talla";
                rs = BD.ejecutarSQLSelect(sql);
                rsm = rs.getMetaData();
                //List<Object[]> datos = new ArrayList<Object[]>();
                while (rs.next()) { 
                    this.nombreTrabajador = rs.getString(1);
                    this.nomEstilo = rs.getString(2);
                    this.proceso = rs.getString(3);
                    this.destajo = rs.getDouble(4);
                    System.out.println("destajo "+rs.getDouble(4));
                    this.tipoTalla = rs.getString(7);
                    Object muestraDatos[] = {rs.getString(5),rs.getString(6),rs.getString(8)};
                    dtm.addRow(muestraDatos);
                    
//                    Object[] filas = new Object[rsm.getColumnCount()];
//                    for (int i = 0; i < filas.length; i++) {
//                        filas[i] = rs.getObject(i+1);
//                    }
//                    datos.add(filas);
                }
//                dtm = (DefaultTableModel)DetallesPagoPorDestajo.jTableDetallePagoDestajo.getModel();
//                for (int i = 0; i < datos.size(); i++) {
//                    Object muestraDatos[] = {rs.getString(1)};
//                    dtm.addRow(muestraDatos);
//                }
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
        int existenDatos=0;
        try {
            if (BD.conectarBD()) {
                String sql = "select pedidos.idPedido,estilos.estilo,sum(tallas.cantidad) as totalTallas,concat('$ ',round(sum(tallas.cantidad*(procesos.destajo)),2)) as totalDes "+
                        "from pedidos inner join tallas on tallas.idPedido=pedidos.idPedido inner join estilos on estilos.idEstilo=pedidos.idEstilo "+
                        "inner join estilos_procesos on estilos_procesos.idEstilo=estilos.idEstilo inner join procesos on procesos.nombre=estilos_procesos.proceso "+
                        "inner join personal on pedidos.idPersonal=personal.idPersonal WHERE personal.proceso=procesos.nombre and (personal.nombre like '"+this.nombreTrabajador+"%' "+
                        "or personal.apellidoPaterno like '"+this.nombreTrabajador+"%' or personal.apellidoMaterno like '"+this.nombreTrabajador+"%' or concat(personal.nombre,' ',personal.apellidoPaterno) "+
                        "like '"+this.nombreTrabajador+"%' or concat(personal.nombre,' ',personal.apellidoMaterno) like '"+this.nombreTrabajador+"%' or concat(personal.nombre,' ',personal.apellidoPaterno,' ',"+
                        "personal.apellidoMaterno) like '"+this.nombreTrabajador+"%') and pedidos.numeroSemana="+this.numSemana+" group by estilos.idEstilo";
                rs = BD.ejecutarSQLSelect(sql);
                rsm = rs.getMetaData();
                List<Object[]> datos = new ArrayList<Object[]>();
                while (rs.next()) {   
                    existenDatos++;//valida si encontro el personal ligado a algún estilo
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
                if(existenDatos==0){//Si es cero significa que no encontro personal algúno
                    JOptionPane.showMessageDialog(null, "No se encontro a "+this.nombreTrabajador+" en algún estilo ",
                        "Aviso",JOptionPane.WARNING_MESSAGE);
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
