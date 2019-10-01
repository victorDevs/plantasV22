/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import persistencia.BD;
import persistencia.IconCellRenderer;
import persistencia.MetodosGlobales;
import vista.AgregarProveedorMaterial;
import vista.CatalogoEstilos;
import vista.CatalogoMateriales;
import vista.Main;
import vista.ModificarProveedorMaterial;

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
    String tipoProveedor;
    String descripcionProveedor;
    String nombreProveedor;
   
    String descripcionBM;
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm; 
    
    //PARA LOS BOTONES DE LA TABLA PROVEEDORESMATERIALES 
    ImageIcon iconModif = new ImageIcon(getClass().getResource("/imagenes/editar.png"));
    ImageIcon iconElimina = new ImageIcon(getClass().getResource("/imagenes/quitar.png"));
    //CREAMOS ESTOS BOTONES PARA ANEXARLOS A LA TABLA DE PROVEEDORESMATERIALES
     JButton btnModificar = new JButton(iconModif);
     JButton btnEliminar = new JButton(iconElimina);
     
    LoginModel login = new LoginModel();

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
        
    public String getTipoProveedor() {
        return tipoProveedor;
    }
    
     public String getDescripcionProveedor() {
        return descripcionProveedor;
    }
     
    public String getNombreProveedor() {
        return nombreProveedor;
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
    
    public void setTipoProveedor(String tipoProveedor) {
        this.tipoProveedor = tipoProveedor;
    }
    
    public void setDescripcionProveedor(String descipProveedor) {
        this.descripcionProveedor = descipProveedor;
    }
    
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
    
    
    public int noRepetirMaterial(String nombre){
        int existeMaterial = 0;
        try {
                BD.conectarBD();
                String sql = "select nombre from materiales where nombre='"+MetodosGlobales.aceptarComillaSimple(nombre)+"'";
                rs = BD.ejecutarSQLSelect(sql);
                while (rs.next()) {                
                    existeMaterial = 1;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"No se pudo buscar el material para saber si exite en la BD. CONSULTE AL DESARROLLADOR "+e, 
                        "Aviso",JOptionPane.WARNING_MESSAGE);
            }
        return existeMaterial;
    }
    
    public boolean registrarMaterial(){
        int idMaterialMax=0;
        
        String sql = "insert into materiales (nombre,unidad,rendimiento,descripcionBM,precio) "
                + "values ('"+MetodosGlobales.aceptarComillaSimple(this.nombre)+"', '"+this.unidad+"','"+this.rendimiento+"','"+MetodosGlobales.aceptarComillaSimple(this.descripcionBM)+"',"+this.precio+");";
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
        String sql = "";
        for(int i=0; i<CatalogoMateriales.jTableProveedoresMaterial.getRowCount(); i++){
            if(CatalogoMateriales.jTableProveedoresMaterial.getValueAt(i, 0).equals("")){
                sql = "insert into materialproveedor (idMaterial,idProveedor,tipo,descripcionProveedor)"
                +"values ("+materialId+","+CatalogoMateriales.jTableProveedoresMaterial.getValueAt(i, 1)+",'"+CatalogoMateriales.jTableProveedoresMaterial.getValueAt(i, 3)+"',"
                +"'"+MetodosGlobales.aceptarComillaSimple((String) CatalogoMateriales.jTableProveedoresMaterial.getValueAt(i, 4))+"');";
                System.out.println("Registro de Proveedores de los Materiales: "+sql);
                if(BD.ejecutarSQL(sql)){
                   //JOptionPane.showMessageDialog(null,"Se registro exitosamente el/los Proveedores", "Aviso",JOptionPane.INFORMATION_MESSAGE);
                }else{
                   JOptionPane.showMessageDialog(null,"No se pudo registrar el Proveedor"+CatalogoMateriales.jTableProveedoresMaterial.getValueAt(i, 2), 
                               "Aviso",JOptionPane.WARNING_MESSAGE);
                }
            }
            
        }  
    }

    public boolean ActualizarMaterialProveedor(JTable tabla, int idProveedor){
        int fila = tabla.getSelectedRow();
        String sql = "update materialproveedor set idProveedor = "+idProveedor+", tipo = '"+this.tipoProveedor+"',"
                + " descripcionProveedor='"+MetodosGlobales.aceptarComillaSimple(this.descripcionProveedor)+"' where idMaterialProveedor = "+tabla.getValueAt(fila, 0);
        System.out.println("consulta: "+sql);
        if (BD.ejecutarSQL(sql)) {            
            return true;
        } else {
            return false;
        }
    }
     
     public void TablaConsultaMateriales(){
        try {
            if (BD.conectarBD()) {
                String sql = "select idMateriales,nombre,unidad,rendimiento,descripcionBM,CONCAT('$ ', round(precio,2)) from materiales";
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
            dtm = (DefaultTableModel)CatalogoMateriales.jTableProveedoresMaterial.getModel();
            CatalogoMateriales.jTableProveedoresMaterial.setDefaultRenderer(Object.class, new IconCellRenderer());
            btnModificar.setName("modif");
            btnEliminar.setName("elimi");
                        
            if (BD.conectarBD()) {
                String sql = "select materialproveedor.idMaterialProveedor,materialproveedor.idProveedor, proveedores.nombre, materialproveedor.tipo, materialproveedor.descripcionProveedor"+
                        " from materialproveedor inner join materiales on materialproveedor.idMaterial=materiales.idMateriales"+
                        " left join proveedores on materialproveedor.idProveedor=proveedores.idProveedor where materialproveedor.idMaterial ="+materialId;
                rs = BD.ejecutarSQLSelect(sql);
                rsm = rs.getMetaData();

                while (rs.next()) {                
                    Object  nuev[] ={rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),btnModificar,btnEliminar}; 
                    dtm.addRow(nuev);
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
                if(!login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("UD") && !login.validaPermisos("materiales",Main.menuNomUsuario.getText()).equals("RUD")){
                    MetodosGlobales.LimpiaTabla(CatalogoMateriales.jTableProveedoresMaterial);
                    TablaConsultaProveedoresMateriales((int) CatalogoMateriales.jTableMateriales.getValueAt(fila, 0));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudo mostrar este material, vuelve a intentarlo: "+e, 
                    "Aviso",JOptionPane.WARNING_MESSAGE);
        }
    }
     
    public boolean ActualizarProveedor(JTable tabla){
        int fila = tabla.getSelectedRow();
        int materialId = 0;
        String sql = "update materiales set nombre = '"+MetodosGlobales.aceptarComillaSimple(this.nombre)+"', unidad = '"+this.unidad+"',"
                + " rendimiento='"+this.rendimiento+"', descripcionBM='"+MetodosGlobales.aceptarComillaSimple(this.descripcionBM)+"', precio="+this.precio
                + "where idMateriales = "+tabla.getValueAt(fila, 0);
        System.out.println("consulta: "+sql);
        if (BD.ejecutarSQL(sql)) {   
            try {
                BD.conectarBD();
                String sqlMax = "select idMateriales from materiales where idMateriales = "+tabla.getValueAt(fila, 0);
                rs = BD.ejecutarSQLSelect(sqlMax);
                while (rs.next()) {                
                    materialId = rs.getInt(1);
                    registrarProveedoresMateriales(materialId);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"No se pudo mostrar el ultimo id del Material, puede ser que no se registro el/los proveedores.\n CONSULTE AL DESARROLLADOR "+e, 
                        "Aviso",JOptionPane.WARNING_MESSAGE);
            }
            return true;
        } else {
            return false;
        }
    }
      
    public boolean EliminaMaterial(JTable tabla){
        int fila = tabla.getSelectedRow();
        String sql = "delete from materiales where idMateriales = '"+tabla.getValueAt(fila, 0)+"'";
        if (BD.ejecutarSQL(sql)) { 
            try {
                EliminaMaterialProveedorTodo(tabla);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Error al eliminar todos los proveedores que le pertenecen al idMaterial: "+tabla.getValueAt(fila, 1)+"", 
                    "Error",JOptionPane.ERROR_MESSAGE);
            }
            
            return true;
            
        } else {
            return false;
        }
    }
    public boolean EliminaMaterialProveedorTodo(JTable tabla){
        int fila = tabla.getSelectedRow();
        
        String sql = "delete from materialproveedor where idMaterial = "+tabla.getValueAt(fila, 0)+"";
        if (BD.ejecutarSQL(sql)) { 
            return true;
        } else {
            return false;
        }
    }
    public boolean EliminaMaterialProveedorUnoenUno(JTable tabla){
        int fila = tabla.getSelectedRow();
        
        String sql = "delete from materialproveedor where idMaterialProveedor = '"+tabla.getValueAt(fila, 0)+"'";
        if (BD.ejecutarSQL(sql)) { 
            return true;
        } else {
            return false;
        }
    }
       
    public void buscarMaterial(String tipoBuqueda,String busqueda){
        try {
            if (BD.conectarBD()) {
                String sql = "select materiales.idMateriales,materiales.nombre,materiales.unidad,materiales.rendimiento,materiales.descripcionBM,materiales.precio "+
                        "from materiales inner join materialproveedor on materiales.idMateriales=materialproveedor.idMaterial left join proveedores on "+
                        "materialproveedor.idProveedor = proveedores.idProveedor where "+tipoBuqueda+" like '%"+busqueda+"%'";
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
            JOptionPane.showMessageDialog(null,"Error al mostrar lo datos en la tabla Material: "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
    public void llenaPanelMateriales(){
        try {
            if (BD.conectarBD()) {
                String sql = "select idMateriales,nombre from materiales";
                rs = BD.ejecutarSQLSelect(sql);
                rsm = rs.getMetaData();
                JRadioButton  radio = null;
                while (rs.next()) { 
                    radio = new JRadioButton(rs.getString("nombre"));
                    CatalogoEstilos.panelMateriales.add(radio);
                    CatalogoEstilos.radiosMateriales.add(radio);
                    CatalogoEstilos.panelMateriales.updateUI();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al intentar llenar el panel de materiales en el Catálogo de Estilos: "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
     public void buscarMaterialesCheckBox( String nombreMaterial){
        try {
            if (BD.conectarBD()) {
                String sql = "select idMateriales,nombre from materiales where nombre like '%"+nombreMaterial+"%'";
                rs = BD.ejecutarSQLSelect(sql);
                rsm = rs.getMetaData();
                JRadioButton  radio = null;
                  CatalogoEstilos.panelMateriales.removeAll();
                    CatalogoEstilos.radiosMateriales.remove(0);
                while (rs.next()) { 
                    radio = new JRadioButton(rs.getString("nombre"));
                    CatalogoEstilos.panelMateriales.add(radio);
                    CatalogoEstilos.radiosMateriales.add(radio);
                    CatalogoEstilos.panelMateriales.updateUI();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error de la busqueda al intentar llenar el panel de materiales en el Catálogo de Estilos: "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
//    public boolean llenaPanelMateriales(){
//        String sql = "select idMateriales,nombre from materiales ";
//        System.out.println("String SQL: "+sql);
//        ResultSet rs = new BD().ejecutarSQLSelect(sql);
//        if (rs.next()) {
//            this.idMaterial = Integer.parseInt(rs.getString("idMateriales"));
//            this.nombre = rs.getString("nombre");
//            System.out.println("Material: "+this.nombre);
//            return true;
//        } else {
//            return false;
//        }
//    }
}
