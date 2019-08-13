/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import persistencia.BD;
import persistencia.MetodosGlobales;

/**
 *
 * @author Luis
 */
public class PerfilesUsuarios {
    int idPerfil;
    String nombre;
    
    ResultSet rs;

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public int noRepetirMaterial(String nombre){
        int existePerfil = 0;
        try {
                BD.conectarBD();
                String sql = "select nombre from perfiles where nombre='"+MetodosGlobales.aceptarComillaSimple(nombre)+"'";
                rs = BD.ejecutarSQLSelect(sql);
                while (rs.next()) {                
                    existePerfil = 1;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"No se pudo buscar el perfil para saber si exite en la BD. CONSULTE AL DESARROLLADOR "+e, 
                        "Aviso",JOptionPane.WARNING_MESSAGE);
            }
        return existePerfil;
    }
    
     public boolean registrarPerfil(){
        int idMaterialMax=0;
        
        String sql = "insert into perfiles (nombre) "
                + "values ('"+MetodosGlobales.aceptarComillaSimple(this.nombre)+"');";
        System.out.println("Registro de perfil: "+sql);
        if (BD.ejecutarSQL(sql)) {
            return true;
        }else{
            return false;
        }
    }
     
     public boolean EliminaPerfil(){
        String sql = "delete from perfiles where nombre = '"+this.nombre+"'";
        if (BD.ejecutarSQL(sql)) {            
            return true;
        } else {
            return false;
        }
    }
}
