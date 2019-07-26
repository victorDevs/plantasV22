/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alber
 */
public class MetodosGlobales {
    
    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
    
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
    
    public static String aceptarComillaSimple(String dato){
        return dato.replaceAll("'", "''");
    }
    
    public String validaFecha(JDateChooser jd){
        if(jd.getDate() != null){
            return formato.format(jd.getDate());
        }else{
            return null;
        }
    }
    
    public boolean validaCorreo(String dato){
        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        // El email a validar
        Matcher mather = pattern.matcher(dato);
        
        if(mather.find() == true){
            return true;
        }else{
            return false;
        }
        
    }
}
