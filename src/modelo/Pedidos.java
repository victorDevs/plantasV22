/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import persistencia.BD;
import persistencia.MetodosGlobales;
import vista.CatalogoEstilos;
import vista.CatalogoPedidos;
import static vista.CatalogoPedidos.txtFieldTallas;

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
    
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm;
    
    List<Integer> arraySumTallas = new ArrayList<Integer>();

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
    
    public void llenaPanelTallas(String src){
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
                        CatalogoPedidos.jPanelTallas.add(jLabelTalla);
                        txtField = new JTextField();
                        txtField.setName(begin+"");
                        txtField.addKeyListener(new KeyListener(){
                            @Override
                            public void keyTyped(KeyEvent ke) {}

                            @Override
                            public void keyPressed(KeyEvent ke) {
                                char ky = ke.getKeyChar();
                                if(Character.isLetter(ky)){
                                    JOptionPane.showMessageDialog(null, "Solo se permiten números, por favor intente de nuevo.",
                                        "Aviso",JOptionPane.WARNING_MESSAGE);
                                }
                            }

                            @Override
                            public void keyReleased(KeyEvent ke) {}
                        });
                        CatalogoPedidos.jPanelTallas.add(txtField);
                        CatalogoPedidos.txtFieldTallas.add(txtField);
                        CatalogoPedidos.jPanelTallas.updateUI();
                        begin = begin + punto;
                    }
                }
                jLabelTotal = new JLabel("TOTAL");
                jLabelTotal.setForeground(Color.blue);
                CatalogoPedidos.jPanelTallas.add(jLabelTotal);
                txtField = new JTextField("0");
                txtField.setEditable(false);
                txtField.setForeground(Color.blue);
                CatalogoPedidos.jPanelTallas.add(txtField);
                CatalogoPedidos.txtFieldTallas.add(txtField);
                CatalogoPedidos.jPanelTallas.updateUI();
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
    
    public boolean RegistraPedido(){
        getIdClienteFromBD(this.nombreCliente);
        String sql = "insert into pedidos (idCliente,idEstilo,fecha,fechaCliente,fechaInterna,tipoTalla,"
                + "precio,subtotal,iva,total,observaciones,) "
                + "values ("+this.idCliente+", "+this.idEstilo+",'"+this.fecha+"','"+this.fechaCliente+"', '"+this.fechaInterna+"', "
                + "'"+this.tipoTalla+"',"+this.precio+","+this.subtotal+","+this.iva+","+this.total+",'"+this.observaciones+");";
        System.out.println("Registro de cliente: "+sql);
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
            BD.cerrarConexion();
        } catch (Exception e) {
            System.out.println("Excepción: "+e);
            JOptionPane.showMessageDialog(null, "Error al obtener el id del cliente",
                    "Error",JOptionPane.ERROR_MESSAGE);
            BD.cerrarConexion();
        }
    }
}
