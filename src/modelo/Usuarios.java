/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import persistencia.BD;
import persistencia.MetodosGlobales;
import vista.CatalogoUsuarios;

/**
 *
 * @author Luis
 */
public class Usuarios {
    int idUsuario;
    int idPerfil;
  
    String nombre;
    String perfil;
    String Usuario;
    String contrasena;
    String repeContrasena;
    String correo;

    //PERMISOS EN MATRIALES
    String matRegistrar="";
    String matEditar="";
    String matConsultar="";
    String matEliminar="";
    String matPermisos="";
    //PERMISOS EN PROVEEDORES
    String proRegistrar="";
    String proEditar="";
    String proConsultar="";
    String proEliminar="";
    String proPermisos="";
    //PERMISOS EN CLIENTES
    String cliRegistrar="";
    String cliEditar="";
    String cliConsultar="";
    String cliEliminar="";
    String cliPermisos="";
    //PERMISOS EN PERSONAL
    String perRegistrar="";
    String perEditar="";
    String perConsultar="";
    String perEliminar="";
    String perPermisos="";
    //PERMISOS EN PEDIDOS
    String pedRegistrar="";
    String pedEditar="";
    String pedConsultar="";
    String pedEliminar="";
    String pedPermisos="";
    //PERMISOS EN ESTILOS
    String estRegistrar="";
    String estEditar="";
    String estConsultar="";
    String estEliminar="";
    String estPermisos="";
    //PERMISOS EN USUARIOS
    String usuRegistrar="";
    String usuEditar="";
    String usuConsultar="";
    String usuEliminar="";
    String usuPermisos="";
    
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm; 

  
    
    
    public int getIdUsuario() {
        return idUsuario;
    }

      public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRepeContrasena() {
        return repeContrasena;
    }

    public void setRepeContrasena(String repeContrasena) {
        this.repeContrasena = repeContrasena;
    }
    
      public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    } 

    public String getMatRegistrar() {
        return matRegistrar;
    }

    public void setMatRegistrar(String matRegistrar) {
        this.matRegistrar = matRegistrar;
    }

    public String getMatEditar() {
        return matEditar;
    }

    public void setMatEditar(String matEditar) {
        this.matEditar = matEditar;
    }

    public String getMatConsultar() {
        return matConsultar;
    }

    public void setMatConsultar(String matConsultar) {
        this.matConsultar = matConsultar;
    }

    public String getMatEliminar() {
        return matEliminar;
    }

    public void setMatEliminar(String matEliminar) {
        this.matEliminar = matEliminar;
    }

    public String getProRegistrar() {
        return proRegistrar;
    }

    public void setProRegistrar(String proRegistrar) {
        this.proRegistrar = proRegistrar;
    }

    public String getProEditar() {
        return proEditar;
    }

    public void setProEditar(String proEditar) {
        this.proEditar = proEditar;
    }

    public String getProConsultar() {
        return proConsultar;
    }

    public void setProConsultar(String proConsultar) {
        this.proConsultar = proConsultar;
    }

    public String getProEliminar() {
        return proEliminar;
    }

    public void setProEliminar(String proEliminar) {
        this.proEliminar = proEliminar;
    }

    public String getCliRegistrar() {
        return cliRegistrar;
    }

    public void setCliRegistrar(String cliRegistrar) {
        this.cliRegistrar = cliRegistrar;
    }

    public String getCliEditar() {
        return cliEditar;
    }

    public void setCliEditar(String cliEditar) {
        this.cliEditar = cliEditar;
    }

    public String getCliConsultar() {
        return cliConsultar;
    }

    public void setCliConsultar(String cliConsultar) {
        this.cliConsultar = cliConsultar;
    }

    public String getCliEliminar() {
        return cliEliminar;
    }

    public void setCliEliminar(String cliEliminar) {
        this.cliEliminar = cliEliminar;
    }

    public String getPerRegistrar() {
        return perRegistrar;
    }

    public void setPerRegistrar(String perRegistrar) {
        this.perRegistrar = perRegistrar;
    }

    public String getPerEditar() {
        return perEditar;
    }

    public void setPerEditar(String perEditar) {
        this.perEditar = perEditar;
    }

    public String getPerConsultar() {
        return perConsultar;
    }

    public void setPerConsultar(String perConsultar) {
        this.perConsultar = perConsultar;
    }

    public String getPerEliminar() {
        return perEliminar;
    }

    public void setPerEliminar(String perEliminar) {
        this.perEliminar = perEliminar;
    }

    public String getPedRegistrar() {
        return pedRegistrar;
    }

    public void setPedRegistrar(String pedRegistrar) {
        this.pedRegistrar = pedRegistrar;
    }

    public String getPedEditar() {
        return pedEditar;
    }

    public void setPedEditar(String pedEditar) {
        this.pedEditar = pedEditar;
    }

    public String getPedConsultar() {
        return pedConsultar;
    }

    public void setPedConsultar(String pedConsultar) {
        this.pedConsultar = pedConsultar;
    }

    public String getPedEliminar() {
        return pedEliminar;
    }

    public void setPedEliminar(String pedEliminar) {
        this.pedEliminar = pedEliminar;
    }

    public String getEstRegistrar() {
        return estRegistrar;
    }

    public void setEstRegistrar(String estRegistrar) {
        this.estRegistrar = estRegistrar;
    }

    public String getEstEditar() {
        return estEditar;
    }

    public void setEstEditar(String estEditar) {
        this.estEditar = estEditar;
    }

    public String getEstConsultar() {
        return estConsultar;
    }

    public void setEstConsultar(String estConsultar) {
        this.estConsultar = estConsultar;
    }

    public String getEstEliminar() {
        return estEliminar;
    }

    public void setEstEliminar(String estEliminar) {
        this.estEliminar = estEliminar;
    }

    public String getUsuRegistrar() {
        return usuRegistrar;
    }

    public void setUsuRegistrar(String usuRegistrar) {
        this.usuRegistrar = usuRegistrar;
    }

    public String getUsuEditar() {
        return usuEditar;
    }

    public void setUsuEditar(String usuEditar) {
        this.usuEditar = usuEditar;
    }

    public String getUsuConsultar() {
        return usuConsultar;
    }

    public void setUsuConsultar(String usuConsultar) {
        this.usuConsultar = usuConsultar;
    }

    public String getUsuEliminar() {
        return usuEliminar;
    }

    public void setUsuEliminar(String usuEliminar) {
        this.usuEliminar = usuEliminar;
    }

    public String getMatPermisos() {
        return matPermisos;
    }

    public void setMatPermisos(String matPermisos) {
        this.matPermisos = matPermisos;
    }

    public String getProPermisos() {
        return proPermisos;
    }

    public void setProPermisos(String proPermisos) {
        this.proPermisos = proPermisos;
    }

    public String getCliPermisos() {
        return cliPermisos;
    }

    public void setCliPermisos(String cliPermisos) {
        this.cliPermisos = cliPermisos;
    }

    public String getPerPermisos() {
        return perPermisos;
    }

    public void setPerPermisos(String perPermisos) {
        this.perPermisos = perPermisos;
    }

    public String getPedPermisos() {
        return pedPermisos;
    }

    public void setPedPermisos(String pedPermisos) {
        this.pedPermisos = pedPermisos;
    }

    public String getEstPermisos() {
        return estPermisos;
    }

    public void setEstPermisos(String estPermisos) {
        this.estPermisos = estPermisos;
    }

    public String getUsuPermisos() {
        return usuPermisos;
    }

    public void setUsuPermisos(String usuPermisos) {
        this.usuPermisos = usuPermisos;
    }
    
    
    
    public void TablaConsultaUsuarios(){
        try {
            if (BD.conectarBD()) {
                String sql = "select idUsuario,nombre,usuario,perfil,correo from usuarios";
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
                dtm = (DefaultTableModel)CatalogoUsuarios.jTableUsuarios.getModel();
                for (int i = 0; i < datos.size(); i++) {
                    dtm.addRow(datos.get(i));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar lo datos en la tabla usuarios: "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
    public void ApuntaUsuario(){
        try {
            BD.conectarBD();
            int fila = CatalogoUsuarios.jTableUsuarios.getSelectedRow();
            String sql = "select nombre,usuario,contrasena,correo,perfil,materialPermiso,proveedorPermiso,clientesPermiso,personalPermiso,pedidosPermiso,estilosPermiso,usuariosPermiso"
                    + " from usuarios where idUsuario = "+CatalogoUsuarios.jTableUsuarios.getValueAt(fila, 0);
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            while (rs.next()) {                
                this.nombre = rs.getString(1);
                this.Usuario = rs.getString(2);
                this.contrasena = rs.getString(3);
                this.correo = rs.getString(4);
                this.perfil = rs.getString(5);
                this.matPermisos = rs.getString(6);
                this.proPermisos = rs.getString(7);
                this.cliPermisos = rs.getString(8);
                this.perPermisos = rs.getString(9);
                this.pedPermisos = rs.getString(10);
                this.estPermisos = rs.getString(11);
                this.usuPermisos = rs.getString(12);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudo mostrar este usuario, vuelve a intentarlo: "+e, 
                    "Aviso",JOptionPane.WARNING_MESSAGE);
        }
    }
    
   public void buscarUsuario(String tipoBuqueda,String busqueda){
        try {
            if (BD.conectarBD()) {
                String sql = "select idUsuario,nombre,usuario,perfil,correo from usuarios where "+tipoBuqueda+" like '%"+busqueda+"%'";
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
                dtm = (DefaultTableModel)CatalogoUsuarios.jTableUsuarios.getModel();
                for (int i = 0; i < datos.size(); i++) {
                    dtm.addRow(datos.get(i));
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar lo datos en la tabla usuarios: "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
   
   public void ListadoComboPerfil(JComboBox combo,String ventana){
        DefaultComboBoxModel comboPerfil = new DefaultComboBoxModel();
        try {
            BD.conectarBD();
            String sql = "select idPerfil,nombre from perfiles";
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            combo.setModel(comboPerfil);
            ArrayList flagArea = new ArrayList();
            comboPerfil.addElement("Selecciona un Perfil");
            while (rs.next()) {
                this.idPerfil = Integer.parseInt(rs.getString("idPerfil"));
                this.perfil = rs.getString("nombre");
                comboPerfil.addElement(rs.getObject("nombre"));
                combo.setModel(comboPerfil);
            }
            if(ventana.equals("agregar")){//valida que jDialog se abrio
            comboPerfil.addElement("REGISTRAR PERFIL");
            comboPerfil.addElement("ELIMINAR PERFIL");
            combo.setModel(comboPerfil);
            }
            
            BD.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Excepción: "+e);
            JOptionPane.showMessageDialog(null, "Error al mostrar el listado de procesos",
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
   
    public boolean RegistraUsuario(){
        String sql = "insert into usuarios (nombre,usuario,contrasena,correo,perfil,materialPermiso,proveedorPermiso,clientesPermiso,personalPermiso,pedidosPermiso,estilosPermiso,usuariosPermiso) "
                + "values ('"+MetodosGlobales.aceptarComillaSimple(this.nombre)+"', '"+MetodosGlobales.aceptarComillaSimple(this.Usuario)+"','"
                +MetodosGlobales.aceptarComillaSimple(this.contrasena)+"','"+this.correo+"','"+this.perfil+"','"+this.matConsultar+this.matRegistrar+this.matEditar+this.matEliminar+"','"+
                this.proConsultar+this.proRegistrar+this.proEditar+this.proEliminar+"','"+this.cliConsultar+this.cliRegistrar+this.cliEditar+this.cliEliminar+"','"+
                this.perConsultar+this.perRegistrar+this.perEditar+this.perEliminar+"','"+this.pedConsultar+this.pedRegistrar+this.pedEditar+this.pedEliminar+"','"+
                this.estConsultar+this.estRegistrar+this.estEditar+this.estEliminar+"','"+this.usuConsultar+this.usuRegistrar+this.usuEditar+this.usuEliminar+"')";
        System.out.println("Registro de usuario: "+sql);
        if (BD.ejecutarSQL(sql)) {
            return true;
        }else{
            return false;
        }
    }
    
    public boolean ActualizarUsuario(JTable tabla){
        int fila = tabla.getSelectedRow();
        String sql = "update usuarios set nombre = '"+MetodosGlobales.aceptarComillaSimple(this.nombre)+"', usuario = '"+MetodosGlobales.aceptarComillaSimple(this.Usuario)+"',"+
                "contrasena='"+MetodosGlobales.aceptarComillaSimple(this.contrasena)+"', correo='"+this.correo+"', perfil='"+this.perfil+"',"+
                "materialPermiso='"+this.matConsultar+this.matRegistrar+this.matEditar+this.matEliminar+"',proveedorPermiso='"+this.proConsultar+this.proRegistrar+this.proEditar+this.proEliminar+"',"+
                "clientesPermiso='"+this.cliConsultar+this.cliRegistrar+this.cliEditar+this.cliEliminar+"',personalPermiso='"+this.perConsultar+this.perRegistrar+this.perEditar+this.perEliminar+"',"+
                "pedidosPermiso='"+this.pedConsultar+this.pedRegistrar+this.pedEditar+this.pedEliminar+"',estilosPermiso='"+this.estConsultar+this.estRegistrar+this.estEditar+this.estEliminar+"',"+
                "usuariosPermiso='"+this.usuConsultar+this.usuRegistrar+this.usuEditar+this.usuEliminar+"' where idUsuario= "+tabla.getValueAt(fila, 0);
        System.out.println("consulta: "+sql);
        if (BD.ejecutarSQL(sql)) {            
            return true;
        } else {
            return false;
        }
    }
    
    public boolean EliminaUsuario(JTable tabla){
        int fila = tabla.getSelectedRow();
        String sql = "delete from usuarios where IdUsuario = '"+tabla.getValueAt(fila, 0)+"'";
        if (BD.ejecutarSQL(sql)) {            
            return true;
        } else {
            return false;
        }
    }
    
    public int noRepetirUsuario(String nombre){
        int existeUsuario = 0;
        try {
                BD.conectarBD();
                String sql = "select usuario from usuarios where usuario='"+MetodosGlobales.aceptarComillaSimple(nombre)+"'";
                rs = BD.ejecutarSQLSelect(sql);
                while (rs.next()) {                
                    existeUsuario = 1;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"No se pudo buscar el usuario para saber si exite en la BD. CONSULTE AL DESARROLLADOR "+e, 
                        "Aviso",JOptionPane.WARNING_MESSAGE);
            }
        return existeUsuario;
    }
}
