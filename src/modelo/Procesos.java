/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.swing.DefaultComboBoxModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import persistencia.BD;
import vista.CatalogoEstilos;

/**
 *
 * @author vikto
 */
public class Procesos {
    int idProceso;
    String nombre;
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm; 

    public void setIdProceso(int idProceso) {
        this.idProceso = idProceso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdProceso() {
        return idProceso;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void buscaPersonal(JComboBox combo){
        DefaultComboBoxModel comboProceso = new DefaultComboBoxModel();
        try {
            BD.conectarBD();
            String sql = "select idProceso,nombre from procesos";
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            comboProceso.addElement(" - Proceso - ");
            combo.setModel(comboProceso);
            while (rs.next()) {
                this.idProceso = Integer.parseInt(rs.getString("idProceso"));
                this.nombre = rs.getString("nombre");
                comboProceso.addElement(rs.getObject("nombre"));
                combo.setModel(comboProceso);
            }
            BD.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Excepción: "+e);
            JOptionPane.showMessageDialog(null, "Error al mostrar el listado de procesos",
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
    public void llenaPanelProcesos(){
        try {
            if (BD.conectarBD()) {
                String sql = "select idProceso,nombre from procesos";
                rs = BD.ejecutarSQLSelect(sql);
                rsm = rs.getMetaData();
                JRadioButton  radio = null;
                while (rs.next()) { 
                    radio = new JRadioButton(rs.getString("nombre"));
                    CatalogoEstilos.panelProcesos.add(radio);
                    CatalogoEstilos.radiosProcesos.add(radio);
                    CatalogoEstilos.panelProcesos.updateUI();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al intentar llenar el panel de procesos en el Catálogo de Estilos: "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
}
