/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Luis
 */
public class FormatoColorTabla extends DefaultTableCellRenderer{
    private Component componente;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componente =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
        
        componente.setBackground(Color.white);
        if(row%2 ==0){componente.setBackground(new Color(239,239,239));}
        if(isSelected){
            componente.setForeground(Color.BLACK);
        }
        
        if(value instanceof String){
            String valor = (String) value;
            if(column==8){
                componente.setBackground(Color.WHITE); 
                
                if(valor.equals("ss")){                  
                    componente.setBackground(Color.red);
                    componente.setForeground(Color.BLACK);

                }
//                if(table.getValueAt(row, 1).equals("Pan")){
//                    if(valor>30){
//                       componente.setBackground(Color.WHITE); 
//                    }
//                }
//                if(table.getValueAt(row, 1).equals("Servilletas")){
//                    if(valor>50){
//                       componente.setBackground(Color.WHITE); 
//                    }
//                }
//                if(table.getValueAt(row, 1).equals("Papel Encerado")){
//                    if(valor>30){
//                       componente.setBackground(Color.WHITE); 
//                    }
//                }
//                if(table.getValueAt(row, 1).equals("Palillos")){
//                    if(valor>60){
//                       componente.setBackground(Color.WHITE); 
//                    }
//                }
//                if(table.getValueAt(row, 1).equals("Manzana Lift") || table.getValueAt(row, 1).equals("Fresca") || table.getValueAt(row, 1).equals("Sprite")
//                        || table.getValueAt(row, 1).equals("Coca Cola")|| table.getValueAt(row, 1).equals("Coca-Cola Zero")|| table.getValueAt(row, 1).equals("Coca-Cola Light")){
//                    if(valor>10){
//                       componente.setBackground(Color.WHITE); 
//                    }
//                }

            }
             
        }
        return componente;
    }
    
}
