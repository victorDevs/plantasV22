/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import persistencia.BD;
import persistencia.MetodosGlobales;
import vista.CatalogoMateriales;

/**
 *
 * @author alber
 */
public class Materiales {
    
    int idMaterial;
    String nombre;
    String unidad;
    String rendimiento;
    double precio;
   
    String descripcionBM;
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm; 

    public int getIdMaterial() {
        return idMaterial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUnidad() {
        return unidad;
    }

    public String getRendimiento() {
        return rendimiento;
    }

     public double getPrecio() {
        return precio;
    }
     
    public String getDescripcionBM() {
        return descripcionBM;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public void setRendimiento(String rendimiento) {
        this.rendimiento = rendimiento;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescripcionBM(String descripcionBM) {
        this.descripcionBM = descripcionBM;
    }
    
    public int noRepetirMaterial(String nombre){
        int existeMaterial = 0;
        try {
                BD.conectarBD();
                String sql = "select nombre from materiales where nombre='"+nombre+"'";
                rs = BD.ejecutarSQLSelect(sql);
                while (rs.next()) {                
                    existeMaterial = 1;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"No se pudo buscar el proveedor para saber si exite en la BD. CONSULTE AL DESARROLLADOR "+e, 
                        "Aviso",JOptionPane.WARNING_MESSAGE);
            }
        return existeMaterial;
    }
    
    public boolean registrarMaterial(){
        int idMaterialMax=0;
        String sql = "insert into materiales (nombre,unidad,rendimiento,descripcionBM,precio) "
                + "values ('"+this.nombre+"', '"+this.unidad+"','"+this.rendimiento+"','"+this.descripcionBM+"',"+this.precio+");";
        System.out.println("Registro de material: "+sql);
        
        if (BD.ejecutarSQL(sql)) {
            try {
                BD.conectarBD();
                String sqlMax = "select max(idMateriales) from materiales";
                rs = BD.ejecutarSQLSelect(sqlMax);
                while (rs.next()) {                
                    idMaterialMax = rs.getInt(1);
                    registrarProveedoresMateriales(idMaterialMax);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"No se pudo mostrar el ultimo id del Material, puede ser que no se registro el/los proveedores.\n CONSULTE AL DESARROLLADOR "+e, 
                        "Aviso",JOptionPane.WARNING_MESSAGE);
            }
            return true;
        }else{
            return false;
        }
    }
    
    public void registrarProveedoresMateriales(int materialId){
        for(int i=0; i<CatalogoMateriales.jTableProveedoresMaterial.getRowCount(); i++){
         String sql = "insert into materialproveedor (idMaterial,idProveedor,tipo,descripcionProveedor)"
                +"values ("+materialId+","+CatalogoMateriales.jTableProveedoresMaterial.getValueAt(i, 0)+",'"+CatalogoMateriales.jTableProveedoresMaterial.getValueAt(i, 2)+"',"
                +"'"+CatalogoMateriales.jTableProveedoresMaterial.getValueAt(i, 3)+"');";
         System.out.println("Registro de Proveedores de los Materiales: "+sql);
         if(BD.ejecutarSQL(sql)){
            //JOptionPane.showMessageDialog(null,"Se registro exitosamente el/los Proveedores", "Aviso",JOptionPane.INFORMATION_MESSAGE);
         }else{
            JOptionPane.showMessageDialog(null,"No se pudo registrar el Proveedor"+CatalogoMateriales.jTableProveedoresMaterial.getValueAt(i, 1), 
                        "Aviso",JOptionPane.WARNING_MESSAGE);
         }
        }  
    }
    
     
     public void TablaConsultaMateriales(){
        try {
            if (BD.conectarBD()) {
                String sql = "select * from materiales";
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
                dtm = (DefaultTableModel)CatalogoMateriales.jTableMateriales.getModel();
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
    
    public void TablaConsultaProveedoresMateriales(int materialId){
        try {
            if (BD.conectarBD()) {
                String sql = "select materialproveedor.idMaterialProveedor, proveedores.nombre, materialproveedor.tipo, materialproveedor.descripcionProveedor "+
                        "from materialproveedor inner join proveedores on materialproveedor.idProveedor=proveedores.idProveedor where idMaterial ="+materialId;
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
                dtm = (DefaultTableModel)CatalogoMateriales.jTableProveedoresMaterial.getModel();
                for (int i = 0; i < datos.size(); i++) {
                    dtm.addRow(datos.get(i));
                }
                
                if(CatalogoMateriales.jTableProveedoresMaterial.getRowCount()<=0){
                    JOptionPane.showMessageDialog(null,"Este Material no cuenta con algún Proveedor ", 
                    "Aviso",JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar lo datos en la tabla materialproveedor: "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
     
    public void ApuntaMaterial(){
        try {
            BD.conectarBD();
            int fila = CatalogoMateriales.jTableMateriales.getSelectedRow();
            String sql = "select nombre,unidad,rendimiento,descripcionBM,precio"
                    + " from materiales where idMateriales = "+CatalogoMateriales.jTableMateriales.getValueAt(fila, 0);
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            while (rs.next()) {                
                this.nombre = rs.getString(1);
                this.unidad = rs.getString(2);
                this.rendimiento = rs.getString(3);
                this.descripcionBM = rs.getString(4);
                this.precio = rs.getDouble(5);
                MetodosGlobales.LimpiaTabla(CatalogoMateriales.jTableProveedoresMaterial);
                TablaConsultaProveedoresMateriales((int) CatalogoMateriales.jTableMateriales.getValueAt(fila, 0));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudo mostrar este proveedor, vuelve a intentarlo: "+e, 
                    "Aviso",JOptionPane.WARNING_MESSAGE);
        }
    }
     
      public boolean ActualizarProveedor(JTable tabla){
        int fila = tabla.getSelectedRow();
        String sql = "update materiales set nombre = '"+this.nombre+"', unidad = '"+this.unidad+"',"
                + " rendimiento='"+this.rendimiento+"', descripcionBM='"+this.descripcionBM+"', precio="+this.precio
                + "where idMateriales = "+tabla.getValueAt(fila, 0);
        System.out.println("consulta: "+sql);
        if (BD.ejecutarSQL(sql)) {            
            return true;
        } else {
            return false;
        }
    }
      
    public boolean EliminaMaterial(JTable tabla){
        int fila = tabla.getSelectedRow();
        
        String sql = "delete from materiales where idMateriales = '"+tabla.getValueAt(fila, 0)+"'";
        if (BD.ejecutarSQL(sql)) { 
            return true;
        } else {
            return false;
        }
    }
       
    public void buscarProveedor(String tipoBuqueda,String busqueda){
        try {
            if (BD.conectarBD()) {
                String sql = "select * from materiales where "+tipoBuqueda+" like '%"+busqueda+"%'";
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
                dtm = (DefaultTableModel)CatalogoMateriales.jTableMateriales.getModel();
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
}
