/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Dimension;
import modelo.Proveedores;
import persistencia.validaJframeAbreUnaVez;

/**
 *
 * @author vikto
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main prueba
     */
    
    //GENERAR VARIABLE PARA QUE POSTERIORMENTE SEA UTILIZADO EL DESKTOPANEL
    validaJframeAbreUnaVez validajFraAbreUnaVez;
    
    public Main() {
        initComponents();
        //MANDA DESKTOPPANEL DEL MAIN A LA CLASE validaJFrameAbreUnaVez
        this.validajFraAbreUnaVez = new validaJframeAbreUnaVez(jDesktopMain);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopMain = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        subMenuCatMateriales = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopMainLayout = new javax.swing.GroupLayout(jDesktopMain);
        jDesktopMain.setLayout(jDesktopMainLayout);
        jDesktopMainLayout.setHorizontalGroup(
            jDesktopMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 953, Short.MAX_VALUE)
        );
        jDesktopMainLayout.setVerticalGroup(
            jDesktopMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Catalogos");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        subMenuCatMateriales.setSelected(true);
        subMenuCatMateriales.setText("Materiales");
        subMenuCatMateriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuCatMaterialesActionPerformed(evt);
            }
        });
        jMenu2.add(subMenuCatMateriales);

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Proveedores");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("Clientes");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem2);

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText("Personal");
        jCheckBoxMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopMain)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopMain)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void subMenuCatMaterialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuCatMaterialesActionPerformed
        // TODO add your handling code here:

        validajFraAbreUnaVez.abrirInternalFrameMateriales(CatalogoMateriales.getInstancia());
    }//GEN-LAST:event_subMenuCatMaterialesActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
        CatalogoProveedores catProveedores = new CatalogoProveedores();
        if(catProveedores.isVisible() == false){
            catProveedores.setVisible(true);
            jDesktopMain.add(catProveedores);
            catProveedores.show();
        }
        
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        // TODO add your handling code here:
            validajFraAbreUnaVez.abrirInternalFrameProveedor(CatalogoProveedores.getInstancia());   
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        // TODO add your handling code here:
        validajFraAbreUnaVez.abrirInternalFrameClientes(CatalogoClientes.getInstancia());
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void jCheckBoxMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem3ActionPerformed
        // TODO add your handling code here:
        validajFraAbreUnaVez.abrirInternalFramePersonal(CatalogoPersonal.getInstancia());
    }//GEN-LAST:event_jCheckBoxMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    public static javax.swing.JDesktopPane jDesktopMain;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JCheckBoxMenuItem subMenuCatMateriales;
    // End of variables declaration//GEN-END:variables
}
