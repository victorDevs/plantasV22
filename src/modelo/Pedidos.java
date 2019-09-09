/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import persistencia.BD;
import persistencia.IconCellRenderer;
import persistencia.MetodosGlobales;
import vista.AdministrarPedidos;
import vista.CatalogoEstilos;


/**
 *
 * @author vikto
 */
public class Pedidos {
    int idPedido; //número de pedido
    String fecha;
    int idCliente;
    String nombreCliente;
    int idEstilo; // Descripción
    String nombreEstilo; // Descripción
    int tallas[][];
    int totalTallasEstilo;
    String estatus;
    String fechaInterna;
    String fechaCliente;
    double precio;
    double subtotal;
    double iva;
    double total;
    String observaciones;
    String tipoTalla;
    String findBy;
    String parameter;
    String nomCliente;
    
    public static List<JTextField> txtFieldTallas;
    
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm;
    
    List<Integer> arraySumTallas = new ArrayList<Integer>();
    
    //PARA LOS BOTONES DE LA TABLA PEDIDOS 
    ImageIcon iconModif = new ImageIcon(getClass().getResource("/imagenes/editar.png"));
    ImageIcon iconElimina = new ImageIcon(getClass().getResource("/imagenes/quitar.png"));
    
    //CREAMOS ESTOS BOTONES PARA ANEXARLOS A LA TABLA DE PEDIDOS
     JButton btnModificar = new JButton(iconModif);
     JButton btnEliminar = new JButton(iconElimina);
     
     Personal personal = new Personal();

    public int getIdPedido() {
        return idPedido;
    }

    public String getFecha() {
        return fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdEstilo() {
        return idEstilo;
    }

    public int[][] getTallas() {
        return tallas;
    }

    public int getTotalTallasEstilo() {
        return totalTallasEstilo;
    }

    public String getEstatus() {
        return estatus;
    }

    public String getFechaInterna() {
        return fechaInterna;
    }

    public String getFechaCliente() {
        return fechaCliente;
    }

    public double getPrecio() {
        return precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getIva() {
        return iva;
    }

    public double getTotal() {
        return total;
    }

    public String getObservaciones() {
        return observaciones;
    }
    
    public String getTipoTalla() {
        return tipoTalla;
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }
    
    public String getNombreEstilo() {
        return nombreEstilo;
    }
    
    public static List<JTextField> getTxtFieldTallas() {
        return txtFieldTallas;
    }
    
    public String getFindBy() {
        return findBy;
    }
    
    public String getParameter() {
        return parameter;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setIdEstilo(int IdEstilo) {
        this.idEstilo = IdEstilo;
    }

    public void setTallas(int[][] tallas) {
        this.tallas = tallas;
    }

    public void setTotalTallasEstilo(int totalTallasEstilo) {
        this.totalTallasEstilo = totalTallasEstilo;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public void setFechaInterna(String fechaInterna) {
        this.fechaInterna = fechaInterna;
    }

    public void setFechaCliente(String fechaCliente) {
        this.fechaCliente = fechaCliente;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public void setTipoTalla(String tipoTalla) {
        this.tipoTalla = tipoTalla;
    }
    
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    public void setNombreEstilo(String nombreEstilo) {
        this.nombreEstilo = nombreEstilo;
    }
        
    public static void setTxtFieldTallas(List<JTextField> txtFieldTallas) {
        Pedidos.txtFieldTallas = txtFieldTallas;
    }
    
    public void setFindBy(String findBy) {
        this.findBy = findBy;
    }
    
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    
    public void llenaPanelTallas(String src, JPanel panel,List<JTextField> txtFieldTallas,List<JLabel> labelTallas){
        try {
            if (BD.conectarBD()) {
                int sizeArray = 0;
                double begin = 0, end = 0, punto = 0;
                if(src == "Nacional"){
                    sizeArray = 22; 
                    begin = 22;
                    end = 31.5;
                    punto = 0.5;
                } else if(src == "Americano"){
                    sizeArray = 20; 
                    begin = 4;
                    end = 12.5;
                    punto = 0.5;
                } else if(src == "Frances"){
                    sizeArray = 16; 
                    begin = 33;
                    end = 46;
                    punto = 1;
                }
                JLabel  jLabelTalla = null;
                JLabel  jLabelTotal = null;
                JTextField  txtField = null;
                for (int i = 0; i < sizeArray; i++) {
                    if(begin <= end){
                        jLabelTalla = new JLabel(begin+"");
                        panel.add(jLabelTalla);
                        txtField = new JTextField();
                        txtField.setName(begin+"");
                        txtField.addKeyListener(new KeyAdapter(){
                            @Override
                            public void keyTyped(KeyEvent ke) {
                            char ky = ke.getKeyChar();
                                if(!Character.isDigit(ky) || (ky==KeyEvent.VK_BACK_SPACE)){
                                    ke.consume();
                                    JOptionPane.showMessageDialog(null, "Solo se permiten número enteros, por favor intentarlo de nuevo",
                                        "Aviso",JOptionPane.WARNING_MESSAGE);
                                }
                            }

                            @Override
                            public void keyPressed(KeyEvent ke) {}

                            @Override
                            public void keyReleased(KeyEvent ke) {}
                        });
                        panel.add(txtField);
                        txtFieldTallas.add(txtField);
                        labelTallas.add(jLabelTalla);
                        panel.updateUI();
                        begin = begin + punto;
                    }
                }
                jLabelTotal = new JLabel("TOTAL");
                jLabelTotal.setForeground(Color.blue);
                panel.add(jLabelTotal);
                txtField = new JTextField("0");
                txtField.setEditable(false);
                txtField.setForeground(Color.blue);
                panel.add(txtField);
                txtFieldTallas.add(txtField);
                panel.updateUI();
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al intentar llenar el panel de tallas: "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
    public boolean RegistraPedido(int idPersonal){
        getIdClienteFromBD(this.nombreCliente);
        System.out.println("idCliente: "+this.idCliente);
        String sql = "insert into pedidos (idPersonal,idCliente,idEstilo,fecha,fechaCliente,fechaInterna,tipoTalla,"
                + "precio,subtotal,iva,total,observaciones,codigoBarras,estatus) "
                + "values ("+idPersonal+","+this.idCliente+", "+this.idEstilo+",'"+this.fecha+"','"+this.fechaCliente+"', '"+this.fechaInterna+"', "
                + "'"+this.tipoTalla+"',"+this.precio+","+this.subtotal+","+this.iva+","+this.total+",'"+this.observaciones+"','-','"+this.estatus+"');";
        System.out.println("Registro de Pedido: "+sql);
        if (BD.ejecutarSQL(sql)) {
            return true;
        }else{
            return false;
        }
    }
    
    public void getIdClienteFromBD(String nombre){
        try {
            BD.conectarBD();
            String sql = "select idCliente from clientes where nombre = '"+nombre+"';";
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            while (rs.next()) {
                this.idCliente = Integer.parseInt(rs.getString("idCliente"));
            }
            //BD.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Excepción: "+e);
            JOptionPane.showMessageDialog(null, "Error al obtener el id del cliente",
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
    
      public void TablaConsultaPedidos(){
        try {
            dtm = (DefaultTableModel)AdministrarPedidos.jTableAdminPedidos.getModel();
            AdministrarPedidos.jTableAdminPedidos.setDefaultRenderer(Object.class,new IconCellRenderer());
            btnModificar.setName("modif");
            btnEliminar.setName("elimi");
            
            if (BD.conectarBD()) {
                String sql = "select idPedido,fecha,fechaInterna,fechacliente,CONCAT('$ ',round(precio,2))as precio,CONCAT('$ ',round(subtotal,2)) as subtotal,CONCAT('$ ',round(iva,2)) as iva,CONCAT('$ ',round(total,2)) as total,observaciones,estatus from pedidos";
                rs = BD.ejecutarSQLSelect(sql);
                rsm = rs.getMetaData();
                
                while (rs.next()) {                
                    Object nuev[] =  {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),btnModificar,btnEliminar};
                    dtm.addRow(nuev);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Error al intentar conectar con la base de datos plantasbd",
                        "Error de conexión",JOptionPane.ERROR_MESSAGE);
                BD.cerrarConexion();
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al mostrar lo datos en la tabla pedidos: "+e, 
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
      
    public boolean registrarTallas(double tallas,int cantidad){
        tomarMaxIdPedido();
        String sql = "insert into tallas (idPedido,talla,cantidad) "
                + "values ("+this.idPedido+","+tallas+","+cantidad+");";
        System.out.println("Registro de talla: "+sql);
        if (BD.ejecutarSQL(sql)) {
            return true;
        }else{
            return false;
        }
    }
    
     public void tomarMaxIdPedido(){
        try {
            BD.conectarBD();
            String sql = "select max(idPedido)as idPedido from pedidos";
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            while (rs.next()) {
                this.idPedido = rs.getInt("idPedido");
            }
            //BD.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Excepción: "+e);
            JOptionPane.showMessageDialog(null, "Error al obtener el id mayor de pedidos",
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
     
    public void consultaPedidos(){
         try {
            BD.conectarBD();
            String sql = "select clientes.nombre, pedidos.fecha,estilos.estilo,pedidos.fechaInterna,personal.nombre,pedidos.fechaCliente,pedidos.precio,"+
                        "pedidos.subtotal,pedidos.iva,pedidos.total,pedidos.tipoTalla,tallas.talla, tallas.cantidad from pedidos inner join clientes on "+
                        "clientes.idCliente=pedidos.idCliente inner join estilos on estilos.idEstilo=pedidos.idEstilo inner join personal on " +
                        "personal.idPersonal=pedidos.idPersonal inner join tallas on tallas.idPedido=pedidos.idPedido where pedidos.idPedido= "+this.idPedido;
            rs = BD.ejecutarSQLSelect(sql);
            rsm = rs.getMetaData();
            while (rs.next()) {                
                this.nombreCliente = rs.getString("clientes.nombre");
                 System.out.println("este el nombre del cliente: "+this.nombreCliente);
//                this.nombre = rs.getString("nombre");
//                this.apellidoPaterno = rs.getString("apellidoPaterno");
//                this.apellidoMaterno = rs.getString("apellidoMaterno");
//                this.fechaNacimiento = rs.getString("fechaNacimiento");
//                this.Domicilio = rs.getString("domicilio");
//                this.telefono = rs.getString("telefono");
//                this.correo = rs.getString("correo");
//                this.proceso = rs.getString("proceso");
//                this.observaciones = rs.getString("observaciones");
//                this.FechaRegistro = rs.getString("DATEONLY");
//                this.horaRegistro = rs.getString("TIMEONLY");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No se pudo mostrar la consulta de pedidos en catalogo pedido, vuelve a intentarlo: "+e, 
                    "Aviso",JOptionPane.WARNING_MESSAGE);
        }
    }
}
