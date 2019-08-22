/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import modelo.LoginModel;
import modelo.Proveedores;
import persistencia.validaJframeAbreUnaVez;

/**
 *
 * @author vikto
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main 
     */
    
    //GENERAR VARIABLE PARA QUE POSTERIORMENTE SEA UTILIZADO EL DESKTOPANEL
    validaJframeAbreUnaVez validajFraAbreUnaVez;
    
    
    

    
    public Main() {
        initComponents();
        
        
        
        //MANDA DESKTOPPANEL DEL MAIN A LA CLASE validaJFrameAbreUnaVez
        this.validajFraAbreUnaVez = new validaJframeAbreUnaVez(jDesktopMain);
        this.setExtendedState(MAXIMIZED_BOTH);
//        setTimeout(() -> validajFraAbreUnaVez.abrirInternalFramePersonal(CatalogoEstilos.getInstancia()), 500);
//        setTimeout(() -> validajFraAbreUnaVez.abrirInternalFramePersonal(CatalogoPersonal.getInstancia()), 500);
//        setTimeout(() -> validajFraAbreUnaVez.abrirInternalFramePersonal(CatalogoPedidos.getInstancia()), 500);
        
        
        
        //validajFraAbreUnaVez.abrirInternalFrameLogin(LoginInternal.getInstancia());
        
        menuCatalogos.setVisible(false);
        subMenuUsuarios.setVisible(false);
        
        jMenuBar1.addComponentListener(new java.awt.event.ComponentAdapter() {
	public void componentResized(java.awt.event.ComponentEvent evt) {
		menuNomUsuarioComponentResized(evt);
	}
        });
       
    }
    
    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
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
        subMenuUsuarios = new javax.swing.JMenuItem();
        subMenuSalir = new javax.swing.JMenuItem();
        menuCatalogos = new javax.swing.JMenu();
        subMenuCatMateriales = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuNomUsuario = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout jDesktopMainLayout = new javax.swing.GroupLayout(jDesktopMain);
        jDesktopMain.setLayout(jDesktopMainLayout);
        jDesktopMainLayout.setHorizontalGroup(
            jDesktopMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1149, Short.MAX_VALUE)
        );
        jDesktopMainLayout.setVerticalGroup(
            jDesktopMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");

        subMenuUsuarios.setText("Usuarios");
        subMenuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuUsuariosActionPerformed(evt);
            }
        });
        jMenu1.add(subMenuUsuarios);

        subMenuSalir.setText("Salir");
        subMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(subMenuSalir);

        jMenuBar1.add(jMenu1);

        menuCatalogos.setText("Catalogos");
        menuCatalogos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCatalogosActionPerformed(evt);
            }
        });

        subMenuCatMateriales.setText("Materiales");
        subMenuCatMateriales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuCatMaterialesActionPerformed(evt);
            }
        });
        menuCatalogos.add(subMenuCatMateriales);

        jCheckBoxMenuItem1.setText("Proveedores");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        menuCatalogos.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem2.setText("Clientes");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        menuCatalogos.add(jCheckBoxMenuItem2);

        jCheckBoxMenuItem3.setText("Personal");
        jCheckBoxMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem3ActionPerformed(evt);
            }
        });
        menuCatalogos.add(jCheckBoxMenuItem3);

        jMenuItem1.setText("Estilos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuCatalogos.add(jMenuItem1);

        jMenuItem2.setText("Pedidos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuCatalogos.add(jMenuItem2);

        jMenuBar1.add(menuCatalogos);

        menuNomUsuario.setText("Iniciar Sesión");
        menuNomUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuNomUsuarioMouseClicked(evt);
            }
        });
        menuNomUsuario.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                menuNomUsuarioComponentResized(evt);
            }
        });
        menuNomUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNomUsuarioActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuNomUsuario);

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

    private void menuCatalogosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCatalogosActionPerformed
        // TODO add your handling code here:
        CatalogoProveedores catProveedores = new CatalogoProveedores();
        if(catProveedores.isVisible() == false){
            catProveedores.setVisible(true);
            jDesktopMain.add(catProveedores);
            catProveedores.show();
        }
        
    }//GEN-LAST:event_menuCatalogosActionPerformed

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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        validajFraAbreUnaVez.abrirInternalFrameEstilos(CatalogoEstilos.getInstancia());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        validajFraAbreUnaVez.abrirInternalFramePedidos(AdministrarPedidos.getInstancia());
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void subMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuSalirActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Esta seguro de salir",
                    "Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            this.dispose();
        } 
        
    }//GEN-LAST:event_subMenuSalirActionPerformed

    private void menuNomUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNomUsuarioActionPerformed
         
    }//GEN-LAST:event_menuNomUsuarioActionPerformed

    private void menuNomUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuNomUsuarioMouseClicked
        validajFraAbreUnaVez.abrirInternalFrameLogin(LoginInternal.getInstancia());
    }//GEN-LAST:event_menuNomUsuarioMouseClicked

    private void menuNomUsuarioComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_menuNomUsuarioComponentResized
       menuNomUsuario.setLocation(jMenuBar1.getSize().width - menuNomUsuario.getSize().width - jMenuBar1.getBorder().getBorderInsets(jMenuBar1).right,menuNomUsuario.getY());
    }//GEN-LAST:event_menuNomUsuarioComponentResized

    private void subMenuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuUsuariosActionPerformed
        validajFraAbreUnaVez.abrirInternalFrameUsuarios(CatalogoUsuarios.getInstancia());
    }//GEN-LAST:event_subMenuUsuariosActionPerformed

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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    public static javax.swing.JMenu menuCatalogos;
    public static javax.swing.JMenu menuNomUsuario;
    private javax.swing.JCheckBoxMenuItem subMenuCatMateriales;
    private javax.swing.JMenuItem subMenuSalir;
    public static javax.swing.JMenuItem subMenuUsuarios;
    // End of variables declaration//GEN-END:variables
}
