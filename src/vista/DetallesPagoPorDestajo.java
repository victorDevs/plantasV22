/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import modelo.ReporPagoPorDestajo;
import persistencia.MetodosGlobales;

/**
 *
 * @author Luis
 */
public class DetallesPagoPorDestajo extends javax.swing.JDialog {

    ReporPagoPorDestajo reporPagoDesta = new ReporPagoPorDestajo();
    
    public DetallesPagoPorDestajo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        int fila = PagosPorDestajo.jTablePrincipalPagosDestajo.getSelectedRow();
        jlblNomtrabajador.setText(PagosPorDestajo.jTablePrincipalPagosDestajo.getValueAt(fila, 1).toString());
        jlblFolioPersonal.setText(PagosPorDestajo.jTablePrincipalPagosDestajo.getValueAt(fila, 0).toString());
        
        reporPagoDesta.llenaComboProcesos(jcbProcesos, Integer.parseInt(jlblFolioPersonal.getText()));
        
        MetodosGlobales.LimpiaTabla(jTableDetallePagoDestajo);
            reporPagoDesta.consultarPorProceso(Integer.parseInt(jlblFolioPersonal.getText()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDetallePagoDestajo = new javax.swing.JTable();
        jlblNomtrabajador = new javax.swing.JLabel();
        jcbProcesos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlblPrecioDestajo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlblTotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlblFolioPersonal = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlblFolioPedido = new javax.swing.JLabel();
        jlblTipoTalla = new javax.swing.JLabel();
        jbtnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalle Pago por Destajo");

        jTableDetallePagoDestajo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Talla", "Cantidad", "Semana"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableDetallePagoDestajo);
        if (jTableDetallePagoDestajo.getColumnModel().getColumnCount() > 0) {
            jTableDetallePagoDestajo.getColumnModel().getColumn(0).setMinWidth(60);
            jTableDetallePagoDestajo.getColumnModel().getColumn(0).setMaxWidth(60);
            jTableDetallePagoDestajo.getColumnModel().getColumn(2).setMinWidth(60);
            jTableDetallePagoDestajo.getColumnModel().getColumn(2).setMaxWidth(60);
        }

        jlblNomtrabajador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblNomtrabajador.setText("Nombre del trabajador");
        jlblNomtrabajador.setEnabled(false);

        jcbProcesos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbProcesos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbProcesosMouseClicked(evt);
            }
        });
        jcbProcesos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProcesosActionPerformed(evt);
            }
        });

        jLabel2.setText("proceso");

        jLabel3.setText("Destajo");

        jlblPrecioDestajo.setText("Precio del destajo");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 0));
        jLabel5.setText("Total");

        jlblTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlblTotal.setForeground(new java.awt.Color(255, 102, 0));
        jlblTotal.setText("$");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Folio");
        jLabel7.setEnabled(false);

        jlblFolioPersonal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlblFolioPersonal.setText("num");
        jlblFolioPersonal.setEnabled(false);

        jLabel1.setText("Folio del pedido");

        jLabel4.setText("Tipo de talla");

        jlblFolioPedido.setText("num");

        jlblTipoTalla.setText("tipo");

        jbtnOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ok.png"))); // NOI18N
        jbtnOK.setText("Ok");
        jbtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jlblPrecioDestajo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlblFolioPedido))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jlblTipoTalla))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jcbProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jlblTotal)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlblNomtrabajador)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblFolioPersonal))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jlblNomtrabajador))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jlblFolioPersonal))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbProcesos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jlblFolioPedido))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jlblTipoTalla))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jlblPrecioDestajo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jlblTotal))
                        .addGap(27, 27, 27)))
                .addComponent(jbtnOK)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtnOKActionPerformed

    private void jcbProcesosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProcesosActionPerformed
        
            
        
    }//GEN-LAST:event_jcbProcesosActionPerformed

    private void jcbProcesosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbProcesosMouseClicked
        
    }//GEN-LAST:event_jcbProcesosMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DetallesPagoPorDestajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetallesPagoPorDestajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetallesPagoPorDestajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetallesPagoPorDestajo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DetallesPagoPorDestajo dialog = new DetallesPagoPorDestajo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTableDetallePagoDestajo;
    private javax.swing.JButton jbtnOK;
    private javax.swing.JComboBox<String> jcbProcesos;
    private javax.swing.JLabel jlblFolioPedido;
    private javax.swing.JLabel jlblFolioPersonal;
    private javax.swing.JLabel jlblNomtrabajador;
    private javax.swing.JLabel jlblPrecioDestajo;
    private javax.swing.JLabel jlblTipoTalla;
    private javax.swing.JLabel jlblTotal;
    // End of variables declaration//GEN-END:variables
}
