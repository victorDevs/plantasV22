/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import persistencia.BD;
import vista.CatalogoEstilos;
import vista.CatalogoPedidos;

/**
 *
 * @author vikto
 */
public class Pedidos {
    int idPedido; //número de pedido
    String fecha;
    String cliente;
    String estilo; // Descripción
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
    
    ResultSet rs;
    ResultSetMetaData rsm;
    DefaultTableModel dtm;

    public int getIdPedido() {
        return idPedido;
    }

    public String getFecha() {
        return fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public String getEstilo() {
        return estilo;
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

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
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
    
    public void llenaPanelTallas(){
        try {
            if (BD.conectarBD()) {
                String src = "Nacional";
                int sizeArray = 20;
                double begin = 0, end = 0;
                if(src == "Nacional"){
                    sizeArray = 20; 
                    begin = 22;
                    end = 31.5;
                }
                JLabel  jLabelTalla = null;
                JTextField  txtField = null;
                for (int i = 0; i < sizeArray; i++) {
                    if(begin <= end){
                        jLabelTalla = new JLabel(begin+"");
                        CatalogoPedidos.jPanelTallas.add(jLabelTalla);
                        txtField = new JTextField();
                        CatalogoPedidos.jPanelTallas.add(txtField);
                        CatalogoPedidos.txtFieldTallas.add(txtField);
                        CatalogoPedidos.jPanelTallas.updateUI();
                        begin = begin + 0.5;
                    }
                }
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
}
