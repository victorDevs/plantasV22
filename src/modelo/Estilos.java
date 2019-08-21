/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import persistencia.BD;
import persistencia.MetodosGlobales;
import vista.CatalogoEstilos;

/**
 *
 * @author vikto
 */
public class Estilos {

    int idEstilo;
    String estilo;
    int idMaterial;
    String material;
    int idProceso;
    String proceso;
    ArrayList txtMateriales = new ArrayList();
    ArrayList txtProcesos = new ArrayList();
    Array mat[];
    
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm; 
    
    public int getIdEstilo() {
        return idEstilo;
    }

    public String getEstilo() {
        return estilo;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public String getMaterial() {
        return material;
    }

    public int getIdProceso() {
        return idProceso;
    }

    public String getProceso() {
        return proceso;
    }
    
    public ArrayList getTxtMateriales() {
        return txtMateriales;
    }

    public ArrayList getTxtProcesos() {
        return txtProcesos;
    }

    public void setIdEstilo(int idEstilo) {
        this.idEstilo = idEstilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setIdProceso(int idProceso) {
        this.idProceso = idProceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }
    
    public void setTxtMateriales(ArrayList txtMateriales) {
        this.txtMateriales = txtMateriales;
    }

    public void setTxtProcesos(ArrayList txtProcesos) {
        this.txtProcesos = txtProcesos;
    }
    
    public boolean registrarEstilo(){
        String sql = "insert into estilos (estilo) values ('"+this.estilo+"');";
        if (BD.ejecutarSQL(sql)) {
            try {
                String sqlMax = "select max(idEstilo) from estilos";
                rs = BD.ejecutarSQLSelect(sqlMax);
                while (rs.next()) {                
                    this.idEstilo = rs.getInt(1);
                }
                for (int i = 0; i < txtMateriales.size(); i++) {
//                    System.out.println("item radio: "+txtMateriales.get(i));
                    this.material = txtMateriales.get(i).toString();
                    if(!registrarEstiloMaterial()){
                        JOptionPane.showMessageDialog(null,"La asignación de materiales para el estilo "
                                +this.material+" no se realizó correctamente.", 
                                "Aviso",JOptionPane.WARNING_MESSAGE);
                    }
                }
                for (int i = 0; i < txtProcesos.size(); i++) {
//                    System.out.println("item radio: "+txtMateriales.get(i));
                    this.proceso = txtProcesos.get(i).toString();
                    if(!registrarEstiloProceso()){
                        JOptionPane.showMessageDialog(null,"La asignación de procesos para el estilo "
                                +this.material+" no se realizó correctamente.", 
                                "Aviso",JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"No se pudo obtener el último id del Estilo, "
                        + "puede ser que no se registro el Estillo.\n CONSULTE AL DESARROLLADOR "+e, 
                        "Aviso",JOptionPane.WARNING_MESSAGE);
            }
            return true;
        }else{
            return false;
        }
    }
    
    public boolean registrarEstiloMaterial(){
        String sql = "insert into estilos_materiales (idEstilos, material) "
                + "values ("+this.idEstilo+",'"+this.material+"');";
        if (BD.ejecutarSQL(sql)) {
            return true;
        }else{
            return false;
        }
    }
    
    public boolean registrarEstiloProceso(){
        String sql = "insert into estilos_procesos (idEstilo, proceso) "
                + "values ("+this.idEstilo+",'"+this.proceso+"');";
        if (BD.ejecutarSQL(sql)) {
            return true;
        }else{
            return false;
        }
    }
    
    public boolean testArrayList(){
        for (int i = 0; i < txtMateriales.size(); i++) {
            System.out.println("item radio: "+txtMateriales.get(i));
        }
        return true;
    }
    
    public void TablaConsultaEstilos(){
        try {
            if (BD.conectarBD()) {
                String sql = "select idEstilo,estilo from estilos";
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
                dtm = (DefaultTableModel)CatalogoEstilos.jTableEstilos.getModel();
                for (int i = 0; i < datos.size(); i++) {
                    dtm.addRow(datos.get(i));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar lo datos en la tabla estilos: "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
    public void ApuntaEstilo(){
        try {
            BD.conectarBD();
            int fila = CatalogoEstilos.jTableEstilos.getSelectedRow();
            String sql = "select estilo"
                    + " from estilos where idEstilo = "+CatalogoEstilos.jTableEstilos.getValueAt(fila, 0);
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            while (rs.next()) {                
                this.estilo = rs.getString(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudo mostrar el nombre del estilo, vuelve a intentarlo: "+e, 
                    "Aviso",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void ApuntaEstiloMateriales(){
        try {
            if (BD.conectarBD()) {
                int fila = CatalogoEstilos.jTableEstilos.getSelectedRow();
                String sql = "select material from estilos_materiales"
                    + " where idEstilos = "+CatalogoEstilos.jTableEstilos.getValueAt(fila, 0);
                rs = BD.ejecutarSQLSelect(sql);
                rsm = rs.getMetaData();
                List<Object[]> datos = new ArrayList<Object[]>();
                while (rs.next()) {                
                    Object[] filas = new Object[rsm.getColumnCount()];
                    for (int i = 0; i < filas.length; i++) {
                        filas[i] = rs.getObject(i+1);
                        this.txtMateriales.add(i,rs.getObject(i+1));
                    }
                    datos.add(filas);
                }
                dtm = (DefaultTableModel)CatalogoEstilos.jTableMateriales.getModel();
                for (int i = 0; i < datos.size(); i++) {
                    dtm.addRow(datos.get(i));
                }
                System.out.println("this.txtMateriales: "+this.txtMateriales);
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudieron mostrar los materiales del estilo seleccionado, intente de nuevo: "+e, 
                    "Aviso",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
    public void ApuntaEstiloProcesos(){
        try {
            if (BD.conectarBD()) {
                int fila = CatalogoEstilos.jTableEstilos.getSelectedRow();
                String sql = "select proceso from estilos_procesos"
                    + " where idEstilo = "+CatalogoEstilos.jTableEstilos.getValueAt(fila, 0);
                rs = BD.ejecutarSQLSelect(sql);
                rsm = rs.getMetaData();
                List<Object[]> datos = new ArrayList<Object[]>();
                while (rs.next()) {                
                    Object[] filas = new Object[rsm.getColumnCount()];
                    for (int i = 0; i < filas.length; i++) {
                        filas[i] = rs.getObject(i+1);
                        this.txtProcesos.add(i,rs.getObject(i+1));
                    }
                    datos.add(filas);
                }
                dtm = (DefaultTableModel)CatalogoEstilos.jTableProcesos.getModel();
                for (int i = 0; i < datos.size(); i++) {
                    dtm.addRow(datos.get(i));
                }
                System.out.println("this.txtProcesos: "+this.txtProcesos);
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudieron mostrar los procesos del estilo seleccionado, intente de nuevo: "+e, 
                    "Aviso",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
    public void buscarEstilo(String busqueda){
        try {
            if (BD.conectarBD()) {
                String sql = "select idEstilo,estilo from estilos where estilo like '%"+busqueda+"%'";
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
                dtm = (DefaultTableModel)CatalogoEstilos.jTableEstilos.getModel();
                for (int i = 0; i < datos.size(); i++) {
                    dtm.addRow(datos.get(i));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar lo datos en la tabla Estilos: "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
    public boolean ActualizarEstilo(){
        
        String sql = "update estilos set estilo = '"+MetodosGlobales.aceptarComillaSimple(this.estilo)+"' where idEstilo = "+this.idEstilo;
        if (BD.ejecutarSQL(sql)) {
            try {
//                String sqlMax = "select max(idEstilo) from estilos";
//                rs = BD.ejecutarSQLSelect(sqlMax);
//                while (rs.next()) {                
//                    this.idEstilo = rs.getInt(1);
//                }
                for (int i = 0; i < txtMateriales.size(); i++) {
//                    System.out.println("item radio: "+txtMateriales.get(i));
                    this.material = txtMateriales.get(i).toString();
                    if(!actualizarEstiloMaterial(i)){
                        JOptionPane.showMessageDialog(null,"La asignación de materiales para el estilo "
                                +this.estilo+" no se realizó correctamente.", 
                                "Aviso",JOptionPane.WARNING_MESSAGE);
                    }
                }
                for (int i = 0; i < txtProcesos.size(); i++) {
//                    System.out.println("item radio: "+txtMateriales.get(i));
                    this.proceso = txtProcesos.get(i).toString();
                    if(!actualizarEstiloProceso(i)){
                        JOptionPane.showMessageDialog(null,"La asignación de procesos para el estilo "
                                +this.estilo+" no se realizó correctamente.", 
                                "Aviso",JOptionPane.WARNING_MESSAGE);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"No se pudo modificar el estilo junto con sus materiales y procesos."
                        + "\n CONSULTE AL DESARROLLADOR "+e, 
                        "Aviso",JOptionPane.WARNING_MESSAGE);
            }
            return true;
        }else{
            return false;
        }
    }
    
     public boolean actualizarEstiloMaterial(int val){
        if(val ==0){//VALIDA PARA QUE SOLAMENTE ENTRE UNA VEZ LA ELIMINACIÓN DE LOS MATERIALES
            String sqlDelete = "delete from estilos_materiales where idEstilos= "+this.idEstilo;
            if(!BD.ejecutarSQL(sqlDelete)){
                JOptionPane.showMessageDialog(null,"Error a eliminar el listado de los materiales. \nNo fue posible modificar el Estilo", 
                    "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
        //PASAMOS A INSERTAR TODOS LOS MATERIALES SELECCIONADOS
        String sql = "insert into estilos_materiales (idEstilos, material) "
            + "values ("+this.idEstilo+",'"+this.material+"');";
        if(BD.ejecutarSQL(sql)){
            return true;
        }else{
            return false;
        }    
    }
    
    public boolean actualizarEstiloProceso(int val){
        if(val ==0){//VALIDA PARA QUE SOLAMENTE ENTRE UNA VEZ LA ELIMINACIÓN DE LOS PROCESOS
            String sqlDelete = "delete from estilos_procesos where idEstilo= "+this.idEstilo;
            if(!BD.ejecutarSQL(sqlDelete)){
                JOptionPane.showMessageDialog(null,"Error a eliminar el listado de los procesos. \nNo fue posible modificar el Estilo", 
                    "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
        //PASAMOS A INSERTAR TODOS LOS PROCESOS SELECCIONADOS
        String sql = "insert into estilos_procesos (idEstilo, proceso) "
                + "values ("+this.idEstilo+",'"+this.proceso+"');";
        if(BD.ejecutarSQL(sql)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean eliminaEstilo(){
        String sqlEstilo = "delete from estilos where idEstilo = "+this.idEstilo;
        String sqlEstiloMateriales = "delete from estilos_materiales where idEstilos = "+this.idEstilo;
        String sqlEstiloProcesos = "delete from estilos_procesos where idEstilo = "+this.idEstilo;
        if (BD.ejecutarSQL(sqlEstilo) && BD.ejecutarSQL(sqlEstiloMateriales) && BD.ejecutarSQL(sqlEstiloProcesos)) { 
            return true;
        } else {
            return false;
        }
    }
    
    public void llenaComboEstilos(JComboBox combo){
        DefaultComboBoxModel comboEstilo = new DefaultComboBoxModel();
        try {
            BD.conectarBD();
            String sql = "select * from estilos";
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            combo.setModel(comboEstilo);
            comboEstilo.addElement("-- Seleccione --");
            while (rs.next()) {
                this.idEstilo = Integer.parseInt(rs.getString("idEstilo"));
                this.estilo = rs.getString("estilo");
                comboEstilo.addElement(rs.getObject("estilo"));
                combo.setModel(comboEstilo);
            }
            BD.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Excepción: "+e);
            JOptionPane.showMessageDialog(null, "Error al mostrar el listado de estilos",
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
}
