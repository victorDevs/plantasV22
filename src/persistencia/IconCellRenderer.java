/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author alber
 */
public class IconCellRenderer extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
       
     
      if (value instanceof JButton){
            JButton boton  = (JButton) value;
            boton.setOpaque(true);
            
            //boton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
            fillColor(table, boton, isSelected);
            return boton;
        }else{
             return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates...
        }
    }
    
     public void fillColor(JTable t, JButton b, boolean isSelected) {
        if (isSelected) {
        b.setBackground(t.getSelectionBackground());
        b.setForeground(t.getSelectionForeground());
        } else {
        b.setBackground(t.getBackground());
        b.setForeground(t.getForeground());
        }
     }
    
}
