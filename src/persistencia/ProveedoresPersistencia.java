/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author alber
 */
public class ProveedoresPersistencia {
    
    public void ajustarTabla(JTable tabla){
         
        //Ajusta tamaño de columnas
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(5);//id
//        columnModel.getColumn(1).setPreferredWidth(40);//nombreproveedor
//        columnModel.getColumn(2).setPreferredWidth(20);//contacto
//        columnModel.getColumn(3).setPreferredWidth(20);//tel
//        columnModel.getColumn(4).setPreferredWidth(20);//tel2
//        columnModel.getColumn(5).setPreferredWidth(50);//domicilio
//        columnModel.getColumn(6).setPreferredWidth(30);//correo
        
        //Centra datos jTable
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
//        
//        //Centra contenido del jTable
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tabla.getColumnModel().getColumn(0).setCellRenderer(tcr);
//        
//        //Centra el encabezado del jTable
        tcr =  ( DefaultTableCellRenderer ) 
            tabla.getTableHeader().getDefaultRenderer (); 
        tcr. setHorizontalAlignment ( JLabel.CENTER );
    }
}
