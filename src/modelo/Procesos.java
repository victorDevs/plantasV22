/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultComboBoxModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
            String sql = "select idProceso,nombre,area from procesos";
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            combo.setModel(comboProceso);
            ArrayList flagArea = new ArrayList();
            while (rs.next()) {
                if(flagArea.indexOf(rs.getString("area")) < 0){
                    comboProceso.addElement(" ***** AREA "+rs.getString("area")+" ***** ");
                    flagArea.add(rs.getString("area"));
                }
                flagArea.add(rs.getString("area"));
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
                String sql = "select idProceso,nombre,area from procesos";
                rs = BD.ejecutarSQLSelect(sql);
                rsm = rs.getMetaData();
                JRadioButton  radio = null;
                JLabel  label = null;
                ArrayList flagArea = null;
                flagArea = new ArrayList();
                while (rs.next()) {
                    if(flagArea.indexOf(rs.getString("area")) < 0){
                        label = new JLabel(" ***** AREA "+rs.getString("area")+" ***** ");
                        CatalogoEstilos.panelProcesos.add(label);
                        flagArea.add(rs.getString("area"));
                    }
                    radio = new JRadioButton(rs.getString("nombre"));
                    radio.setName(rs.getString("idProceso"));
                    radio.addMouseListener(new MouseListener(){
                        @Override
                        public void mouseClicked(MouseEvent me) {
                            if(me.getClickCount() == 1){
                                JRadioButton comp = (JRadioButton) me.getSource();
                                if(comp.isSelected()){
                                    if(18 == Integer.parseInt(comp.getName())){
                                        System.out.println("stateChanged:" + comp.getText());
                                        String num = JOptionPane.showInputDialog("Por favor, escribe la cantidad de pulidos");
                                        String numVal = num == null ? "" : num;
                                        System.out.println(numVal);
                                        if(numVal.isEmpty()){
                                            comp.setSelected(false);
                                            JOptionPane.showMessageDialog(null, "No puede dejar el número de pulidos en 0, por favor intente de nuevo.",
                                                "Error de conexión",JOptionPane.WARNING_MESSAGE);
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Número de pulidos " + numVal);
                                        }
                                    }
                                }
                            }
                        }
                        @Override
                        public void mousePressed(MouseEvent me) {}
                        @Override
                        public void mouseReleased(MouseEvent me) {}
                        @Override
                        public void mouseEntered(MouseEvent me) {}
                        @Override
                        public void mouseExited(MouseEvent me) {}
                    });
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
    
     public void buscarProcesosCheckBox(String nombreProcesos){
        try {
            if (BD.conectarBD()) {
                String sql = "select idProceso,nombre from procesos where nombre like '%"+nombreProcesos.trim()+"%'";
                rs = BD.ejecutarSQLSelect(sql);
                rsm = rs.getMetaData();
                JRadioButton  radio = null;
                CatalogoEstilos.panelProcesos.removeAll();
                CatalogoEstilos.radiosProcesos.remove(0);
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
            JOptionPane.showMessageDialog(null,"Error de la busqueda al intentar llenar el panel de procesos en el Catálogo de Estilos: "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
}
