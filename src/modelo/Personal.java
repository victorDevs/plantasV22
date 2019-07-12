/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import persistencia.BD;
import vista.CatalogoPersonal;

/**
 *
 * @author vikto
 */
public class Personal {
    int idPersonal;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String fechaNacimiento;
    String Domicilio;
    String telefono;
    String correo;
    String proceso;
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm; 

    public int getIdPersonal() {
        return idPersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDomicilio() {
        return Domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getProceso() {
        return proceso;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDomicilio(String Domicilio) {
        this.Domicilio = Domicilio;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }
    
    public boolean RegistraPersonal(){
        String sql = "insert into personal (nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,domicilio,telefono,correo,proceso) "
                + "values ('"+this.nombre+"', '"+this.apellidoPaterno+"','"+this.apellidoMaterno+"','"
                +this.fechaNacimiento+"','"+this.Domicilio+"','"+this.telefono+"','"+this.correo+"','"
                +this.proceso+"');";
        System.out.println("Registro de personal: "+sql);
        if (BD.ejecutarSQL(sql)) {
            return true;
        }else{
            return false;
        }
    }
    
    public void TablaConsultaPersonal(){
        try {
            if (BD.conectarBD()) {
                String sql = "select idPersonal,nombre,apellidoPaterno,apellidoMaterno,proceso from personal";
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
                dtm = (DefaultTableModel)CatalogoPersonal.jTablePersonal.getModel();
                for (int i = 0; i < datos.size(); i++) {
                    dtm.addRow(datos.get(i));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar lo datos en la tabla personal: "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
    public boolean ActualizarPersonal(JTable tabla){
        int fila = tabla.getSelectedRow();
        String sql = "update personal set nombre = '"+this.nombre+"', apellidoPaterno = '"+this.apellidoPaterno+"',"
                + " apellidoMaterno='"+this.apellidoMaterno+"', fechaNacimiento='"+this.fechaNacimiento+"', domicilio='"+this.Domicilio+"', telefono='"+this.correo+"', "
                + " correo='"+this.correo+"', proceso='"+this.proceso+"' "
                + "where idPersonal = "+tabla.getValueAt(fila, 0);
//        System.out.println("consulta: "+sql);
        if (BD.ejecutarSQL(sql)) {            
            return true;
        } else {
            return false;
        }
    }
    
    public boolean EliminaPersonal(JTable tabla){
        int fila = tabla.getSelectedRow();
        String sql = "delete from personal where IdPersonal = '"+tabla.getValueAt(fila, 0)+"'";
        if (BD.ejecutarSQL(sql)) {            
            return true;
        } else {
            return false;
        }
    }
    
    public void ApuntaPersonal(){
        try {
            BD.conectarBD();
            int fila = CatalogoPersonal.jTablePersonal.getSelectedRow();
            String sql = "select nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,domicilio,telefono,correo,proceso"
                    + " from personal where idPersonal = "+CatalogoPersonal.jTablePersonal.getValueAt(fila, 0);
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            while (rs.next()) {                
                this.nombre = rs.getString(1);
                this.apellidoPaterno = rs.getString(2);
                this.apellidoMaterno = rs.getString(3);
                this.fechaNacimiento = rs.getString(4);
                this.Domicilio = rs.getString(5);
                this.telefono = rs.getString(6);
                this.correo = rs.getString(7);
                this.proceso = rs.getString(8);
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudo mostrar este personal, vuelve a intentarlo: "+e, 
                    "Aviso",JOptionPane.WARNING_MESSAGE);
        }
    }
}