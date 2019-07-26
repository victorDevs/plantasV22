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
import javax.swing.table.DefaultTableModel;
import persistencia.BD;

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
    
    
    public void consultaMateriales() throws SQLException{
        String sql = "select idMateriales,nombre from estilos ";
            rs = BD.ejecutarSQLSelect(sql);
//            rsm = rs.getMetaData();
//            for (int i = 0; rs.length < 10; i++) {
//            
//        }
//            while (rs.next()) {
//                mat[rs.getString('idMateriales')] = rs.getString('nombre');
//                this.nombre = rs.getString(1);
//                this.unidad = rs.getString(2);
//                this.rendimiento = rs.getString(3);
//                this.descripcionBM = rs.getString(4);
//                this.precio = rs.getDouble(5);
//                MetodosGlobales.LimpiaTabla(CatalogoMateriales.jTableProveedoresMaterial);
//                TablaConsultaProveedoresMateriales((int) CatalogoMateriales.jTableMateriales.getValueAt(fila, 0));
//            }
            System.out.println("rs: "+rs);
            System.out.println("rsm: "+rsm);
    }
}
