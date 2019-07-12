/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alber
 */
public class MetodosGlobales {
    
    public static void LimpiaTabla(JTable table){
        try {
            DefaultTableModel modelo = (DefaultTableModel)table.getModel();
            int filas = table.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
            System.out.println("Limpieza exitosa!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar limpiar la tabla Proveedores: "+e,
                    "Tabla "+table,JOptionPane.ERROR_MESSAGE);
        }
    }
}
