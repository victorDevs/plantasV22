/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import persistencia.BD;
import persistencia.IconCellRenderer;
import persistencia.MetodosGlobales;
import vista.AsignarPedidos;
import vista.CatalogoPedido;
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
    String observaciones;
    String FechaRegistro;
    String horaRegistro;
    
    int idEstilo;
    String estilo;
    
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm; 
    
    //PARA LOS BOTONES DE LA TABLA MOSTRARPROCESOS 
    ImageIcon iconElimina = new ImageIcon(getClass().getResource("/imagenes/borrar10px.png"));
    
    //CREAMOS ESTOS BOTONES PARA ANEXARLOS A LA TABLA DE MOSTRARPROCESOS
     JButton btnEliminar = new JButton(iconElimina);

     List<Integer> listaId = new ArrayList<Integer>();
     List<String> listaPersonal = new ArrayList<String>();
     List<String> listaProceso = new ArrayList<String>();
     
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
    
    public String getObservaciones() {
        return observaciones;
    }

    public String getFechaRegistro() {
        return FechaRegistro;
    }

    public String getHoraRegistro() {
        return horaRegistro;
    }

    public int getIdEstilo() {
        return idEstilo;
    }

    public String getEstilo() {
        return estilo;
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

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setFechaRegistro(String FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    public void setHoraRegistro(String horaRegistro) {
        this.horaRegistro = horaRegistro;
    }

    public void setIdEstilo(int idEstilo) {
        this.idEstilo = idEstilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
    
    
    public boolean RegistraPersonal() throws SQLException{
        String sql = "insert into personal (nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,domicilio,telefono,correo,proceso,observaciones,estatus) "
                + "values ('"+MetodosGlobales.aceptarComillaSimple(this.nombre)+"', '"+MetodosGlobales.aceptarComillaSimple(this.apellidoPaterno)+"','"+MetodosGlobales.aceptarComillaSimple(this.apellidoMaterno)+"','"
                +this.fechaNacimiento+"','"+MetodosGlobales.aceptarComillaSimple(this.Domicilio)+"','"+this.telefono+"','"+this.correo+"','"
                +this.proceso+"','"+this.observaciones+"','desocupado');";
//        System.out.println("Registro de personal: "+sql);
        if (BD.ejecutarSQL(sql)) {
//            sql = "SELECT LAST_INSERT_ID();";
//            rs = BD.ejecutarSQLSelect(sql);
//            System.out.println("idPersnal MODELO: "+rs.getString("idPersonal"));
//            rsm = rs.getMetaData();
//            while (rs.next()) {                
//                this.idPersonal = Integer.parseInt(rs.getString("idPersonal"));
//            }
            return true;
        }else{
            return false;
        }
    }
    
    public int getlasIdInsert() throws SQLException{
        String sql = "SELECT LAST_INSERT_ID();";
        ResultSet rs = new BD().ejecutarSQLSelect(sql);
        if (rs.next()) {
            return Integer.parseInt(rs.getString("LAST_INSERT_ID()"));
        } else {
            return Integer.parseInt(rs.getString("LAST_INSERT_ID()"));
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
        String sql = "update personal set nombre = '"+MetodosGlobales.aceptarComillaSimple(this.nombre)+"', apellidoPaterno = '"+MetodosGlobales.aceptarComillaSimple(this.apellidoPaterno)+"',"
                + " apellidoMaterno='"+MetodosGlobales.aceptarComillaSimple(this.apellidoMaterno)+"', fechaNacimiento='"+this.fechaNacimiento+"', domicilio='"+MetodosGlobales.aceptarComillaSimple(this.Domicilio)+"',"+
                "telefono='"+this.correo+"', correo='"+this.correo+"', proceso='"+this.proceso+"' "
                + "where idPersonal = "+tabla.getValueAt(fila, 0);
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
            String sql = "select idPersonal,nombre,apellidoPaterno,apellidoMaterno,fechaNacimiento,domicilio,telefono,correo,proceso,observaciones,"+
                    "DATE_FORMAT(dateCreate,'%d-%m-%Y') DATEONLY,DATE_FORMAT(dateCreate,'%H:%i:%s') TIMEONLY "
                    + " from personal where idPersonal = "+CatalogoPersonal.jTablePersonal.getValueAt(fila, 0);
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            while (rs.next()) {                
                this.idPersonal = Integer.parseInt(rs.getString("idPersonal"));
                this.nombre = rs.getString("nombre");
                this.apellidoPaterno = rs.getString("apellidoPaterno");
                this.apellidoMaterno = rs.getString("apellidoMaterno");
                this.fechaNacimiento = rs.getString("fechaNacimiento");
                this.Domicilio = rs.getString("domicilio");
                this.telefono = rs.getString("telefono");
                this.correo = rs.getString("correo");
                this.proceso = rs.getString("proceso");
                this.observaciones = rs.getString("observaciones");
                this.FechaRegistro = rs.getString("DATEONLY");
                this.horaRegistro = rs.getString("TIMEONLY");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudo mostrar este personal, vuelve a intentarlo: "+e, 
                    "Aviso",JOptionPane.WARNING_MESSAGE);
        }
    }
    
     public void buscarPersonal(String tipoBuqueda,String busqueda){
        try {
            if (BD.conectarBD()) {
                String sql = "select idPersonal,nombre,apellidoPaterno,apellidoMaterno,proceso from personal where "+tipoBuqueda+" like '%"+busqueda+"%'";
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
            JOptionPane.showMessageDialog(null,"Error al mostrar lo datos en la tabla Personal: "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
     
    public void llenaComboPersonal(JComboBox combo){       
        obtieneIdEstilo(this.estilo);//LLAMA EL MÉTODO PARA ENVIAR EL NOMBRE DEL ESTILO Y PODER OBTENER SU IDESTILO
        DefaultComboBoxModel comboPersonal = new DefaultComboBoxModel();
        
        String[] registros = new String[2];
        
        try {
            
            
            BD.conectarBD();
            String sql = "select personal.idPersonal,concat(personal.nombre,' ',personal.apellidoPaterno) as nombrePersonal,personal.proceso from personal inner join estilos_procesos on estilos_procesos.proceso=personal.proceso "+
                    "where estilos_procesos.idEstilo="+this.idEstilo+" group by personal.nombre ";
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            //combo.setModel(comboPersonal);
            
            //listaId =
            
            comboPersonal.addElement("--Seleccione Trabajador--");
            this.nombre = null;//para reiniciar el nombre y pueda se validado posteriormente para mostrar la leyenda "No hay trabajador"
            while (rs.next()) {                   
                    this.idPersonal = Integer.parseInt(rs.getString("personal.idPersonal"));
                    this.nombre = rs.getString("nombrePersonal");
                    
                    registros[0] = rs.getString("personal.idPersonal");                    
                    registros[1] = rs.getString("nombrePersonal");
                    
                    //combo.addItem(rs.getString("nombrePersonal"));
                    listaProceso.add(rs.getString("personal.proceso"));
                    listaId.add(rs.getInt("personal.idPersonal"));
                    listaPersonal.add(rs.getString("nombrePersonal"));
                    
                     System.out.println("el nombre del personal devuelve: "+this.nombre);
                    comboPersonal.addElement(rs.getString("nombrePersonal")+" ("+rs.getString("personal.proceso")+")");         
            }
           
            
            //combo = new JComboBox<String>();
                    combo.addActionListener(new ActionListener() {
                        //@Override
                        public void actionPerformed(ActionEvent ae) {  
                            //String contenido = combo.getSelectedItem().toString();
//                            int id = Integer.parseInt(registros[0]);
//                            tomaId(id);
                            int indice = combo.getSelectedIndex();
                            String dato = (String)combo.getSelectedItem();
                            for(int i=0; i<AsignarPedidos.jtableMuestraProcesos.getRowCount(); i++){
                                if(AsignarPedidos.jtableMuestraProcesos.getValueAt(i, 0).equals(listaProceso.get(indice-1))){
                                    AsignarPedidos.jtableMuestraProcesos.setValueAt(listaId.get(indice-1), i, 1);
                                    AsignarPedidos.jtableMuestraProcesos.setValueAt(listaPersonal.get(indice-1), i, 2);
                                }
                                System.out.println(dato+" Posición " + indice + " id de la lista "+listaId.get(indice-1));
                            }
                        }
                    });

             if(this.nombre == null){
                comboPersonal.addElement("No hay trabajador");
            }
            
            combo.setModel(comboPersonal);
            
            BD.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Excepción: "+e);
            JOptionPane.showMessageDialog(null, "Error al mostrar el listado de personal",
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    public void tomaId(int id){
        System.err.println("se selecciono el id" + id);
    }
       
       public String obtieneIdEstilo(String estilo){
           String sql = "";
           try {
                BD.conectarBD();
                sql = "select idEstilo from estilos where estilo='"+estilo+"'";
                rs = BD.ejecutarSQLSelect(sql);
                rsm = rs.getMetaData();
                
                while (rs.next()) {
                    this.idEstilo = Integer.parseInt(rs.getString("idEstilo"));
                }
//                obtenerProcesoEstilo();//LLAMA AL MÉTODO PARA PODER OBTENER EL NOMBRE DEL PROCESO
                BD.cerrarConexion();
           } catch (Exception e) {
               System.out.println("Excepción obtenerEstilo: "+e);
            JOptionPane.showMessageDialog(null, "Error al mostrar el listado de idEstilo",
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
           }
           
           return sql;
       }
       
//       public void obtenerProcesoEstilo(){
//            String sql="";
//           try {
//                BD.conectarBD();
//                sql = "select idEstilo,proceso from estilos_procesos where idEstilo="+this.idEstilo;
//                rs = BD.ejecutarSQLSelect(sql);
//                rsm = rs.getMetaData();
//                while (rs.next()) {
//                    this.proceso = rs.getString("proceso");
//                }
//           } catch (Exception e) {
//               System.out.println("Excepción obtenerEstilo: "+e);
//                JOptionPane.showMessageDialog(null, "Error al mostrar el listado de procesos en personal",
//                        "Error",JOptionPane.ERROR_MESSAGE);
//                BD.cerrarConexion();
//           }
//       }
       
       public void obtieneIdPersonalCombo(){//AL MOMENTO DE SELECCIONAR EL COMBO DEL PERSONAL DEVUELVE EL ID DEL PERSONAL SELECCIONADO
        
           try {
                BD.conectarBD();
                String sql =  "select idPersonal, CONCAT(nombre,' ',apellidoPaterno) as nombre from personal where CONCAT(nombre,' ',apellidoPaterno) ='"+this.nombre+"'";
                rs = BD.ejecutarSQLSelect(sql);
                rsm = rs.getMetaData();
                
                while (rs.next()) {
                    this.idPersonal = Integer.parseInt(rs.getString("idPersonal"));
                    System.out.println("Id personal seleccionado: "+this.idPersonal);
                }
                //obtenerProcesoEstilo();//LLAMA AL MÉTODO PARA PODER OBTENER EL NOMBRE DEL PROCESO
                BD.cerrarConexion();
           } catch (Exception e) {
               System.out.println("Excepción obtenerEstilo: "+e);
            JOptionPane.showMessageDialog(null, "Error al mostrar el listado de idPersonalCombo",
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
           } 
    }
       
    public void tablaConsultaProcesoPorEstiloSeleccionado( JTable table){
        try {
            dtm=(DefaultTableModel)table.getModel();
            table.setDefaultRenderer(Object.class,new IconCellRenderer());
            btnEliminar.setName("elimi");
            
            if (BD.conectarBD()) {
                String sql = "select idEstiloProceso,proceso,idEstilo from estilos_procesos where idEstilo = "+this.idEstilo;
                rs = BD.ejecutarSQLSelect(sql);
                rsm = rs.getMetaData();

                while (rs.next()) { 
                    Object muestraDatos[] = {rs.getString("proceso"),"","",btnEliminar};
                    dtm.addRow(muestraDatos);  
                }
                //INICIO PARA VALIDAR SI EL CAMPO DEl ID Y DEL TRABAJADOR ESTA VACÍO
                for(int i=0; i<table.getRowCount(); i++){
                    //PARA ID TRABAJADOR
                    if(table.getValueAt(i, 1).equals("")){
                        table.setValueAt("-", i, 1);
                    }
                    // PARA TRABAJADOR
                    if(table.getValueAt(i, 2).equals("")){
                        table.setValueAt("Sin Asignar", i, 2);
                    }
                    
                }
                //FIN DEL CICLO
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar lo datos DetallesPagosPorDestajo(en tabla tallas): "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
}