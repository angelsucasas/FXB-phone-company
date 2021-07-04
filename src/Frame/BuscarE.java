/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Controles.Controlador;
import Dominio.Empleado;
import Persistencia.EmpleadoXml;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Moisés
 */
public class BuscarE extends javax.swing.JFrame {

    private Controlador control = new Controlador();
    /**
     * Creates new form ListadoE
     */
    EmpleadoXml obj = new EmpleadoXml();
    
    public BuscarE() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("ƒastHost");
    }
    public BuscarE(EmpleadoXml emp) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("ƒastHost");
    }
   
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        close = new javax.swing.JLabel();
        min = new javax.swing.JLabel();
        min1 = new javax.swing.JLabel();
        jpIngreso = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtEXT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        txtDpto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtCargo = new javax.swing.JTextField();
        jpIngreso1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtB = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Multiply_32px.png"))); // NOI18N
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 0, 30, 40));

        min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Expand_Arrow_32px.png"))); // NOI18N
        min.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        min.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minMouseClicked(evt);
            }
        });
        getContentPane().add(min, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, -1, 40));

        min1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-deshacer-32.png"))); // NOI18N
        min1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        min1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                min1MouseClicked(evt);
            }
        });
        getContentPane().add(min1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, -1, 40));

        jpIngreso.setBackground(new java.awt.Color(255, 255, 255));
        jpIngreso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpIngreso.setForeground(new java.awt.Color(255, 255, 255));
        jpIngreso.setPreferredSize(new java.awt.Dimension(290, 612));
        jpIngreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setBackground(new java.awt.Color(238, 112, 82));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 204, 255));
        jLabel15.setText("Extensión:");
        jpIngreso.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 90, 20));

        txtEXT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEXT.setForeground(new java.awt.Color(153, 153, 153));
        txtEXT.setText("Ingrese Extensión");
        txtEXT.setBorder(null);
        txtEXT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEXTMouseClicked(evt);
            }
        });
        txtEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEXTActionPerformed(evt);
            }
        });
        jpIngreso.add(txtEXT, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 180, 40));
        jpIngreso.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 40, 40));
        jpIngreso.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 220, -1));

        jLabel3.setBackground(new java.awt.Color(238, 112, 82));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 204, 255));
        jLabel3.setText("Nombre:");
        jpIngreso.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 70, 20));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtNombre.setText("Ingrese Nombre");
        txtNombre.setBorder(null);
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreMouseClicked(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jpIngreso.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 180, 40));
        jpIngreso.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 30, 40));
        jpIngreso.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 220, -1));

        jLabel4.setBackground(new java.awt.Color(238, 112, 82));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 204, 255));
        jLabel4.setText("Cargo:");
        jpIngreso.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 80, 20));
        jpIngreso.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 40, 40));
        jpIngreso.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 220, -1));

        jLabel9.setBackground(new java.awt.Color(238, 112, 82));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 204, 255));
        jLabel9.setText("Departamento:");
        jpIngreso.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 130, 20));

        txtDpto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtDpto.setForeground(new java.awt.Color(153, 153, 153));
        txtDpto.setText("Ingrese Departamento");
        txtDpto.setBorder(null);
        txtDpto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDptoMouseClicked(evt);
            }
        });
        txtDpto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDptoActionPerformed(evt);
            }
        });
        jpIngreso.add(txtDpto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 180, 40));
        jpIngreso.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 40, 40));
        jpIngreso.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 220, -1));
        jpIngreso.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 220, -1));

        jLabel11.setBackground(new java.awt.Color(238, 112, 82));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 204, 255));
        jLabel11.setText("Cedula:");
        jpIngreso.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 70, 20));
        jpIngreso.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 40, 40));

        txtCedula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCedula.setForeground(new java.awt.Color(153, 153, 153));
        txtCedula.setText("Ingrese Cedula");
        txtCedula.setBorder(null);
        txtCedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCedulaMouseClicked(evt);
            }
        });
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        jpIngreso.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 180, 40));

        txtCargo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCargo.setForeground(new java.awt.Color(153, 153, 153));
        txtCargo.setText("Ingrese Cargo");
        txtCargo.setBorder(null);
        txtCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCargoMouseClicked(evt);
            }
        });
        txtCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoActionPerformed(evt);
            }
        });
        jpIngreso.add(txtCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 180, 40));

        getContentPane().add(jpIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 40, -1, 500));

        jpIngreso1.setBackground(new java.awt.Color(255, 255, 255));
        jpIngreso1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jpIngreso1.setForeground(new java.awt.Color(255, 255, 255));
        jpIngreso1.setPreferredSize(new java.awt.Dimension(290, 612));
        jpIngreso1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Search_32px.png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jpIngreso1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 40, 40));

        txtB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtB.setForeground(new java.awt.Color(153, 153, 153));
        txtB.setText("Ingrese la Cedula del Empleado");
        txtB.setBorder(null);
        txtB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBMouseClicked(evt);
            }
        });
        txtB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBActionPerformed(evt);
            }
        });
        jpIngreso1.add(txtB, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 210, 40));

        getContentPane().add(jpIngreso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 320, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/oficina.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1048, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Desea salir?", "Exit",dialog);
        if (result == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_closeMouseClicked

    private void minMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minMouseClicked
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_minMouseClicked

    private void min1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_min1MouseClicked
        Home h = new Home();
        h.setVisible(true);
        dispose();
    }//GEN-LAST:event_min1MouseClicked

    private void txtDptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDptoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDptoActionPerformed

    private void txtDptoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDptoMouseClicked
        txtDpto.setText("");
    }//GEN-LAST:event_txtDptoMouseClicked

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed

    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseClicked
        txtNombre.setText("");
    }//GEN-LAST:event_txtNombreMouseClicked

    private void txtEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEXTActionPerformed

    private void txtEXTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEXTMouseClicked
        txtEXT.setText("");
    }//GEN-LAST:event_txtEXTMouseClicked

    private void txtCedulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCedulaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaMouseClicked

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtCargoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCargoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargoMouseClicked

    private void txtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargoActionPerformed

    private void txtBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBMouseClicked
       txtB.setText("");
    }//GEN-LAST:event_txtBMouseClicked

    private void txtBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        try {
            if(!control.campoEsValido(txtB.getText(), "CEDULA", "Cédula")) {
                return;
            }
        } catch (Exception ex) {
            Logger.getLogger(AgregarA.class.getName()).log(Level.SEVERE, null, ex);
        }
        Empleado miEmpleado = obj.buscarEmp(Integer.parseInt(txtB.getText()));
        txtEXT.setText(Integer.toString(miEmpleado.getEXT()));
        txtNombre.setText(miEmpleado.getNombre());
        txtCedula.setText(Integer.toString(miEmpleado.getCedula()));
        txtCargo.setText(miEmpleado.getCargo());
        txtDpto.setText(miEmpleado.getDpto());
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(BuscarE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JPanel jpIngreso;
    private javax.swing.JPanel jpIngreso1;
    private javax.swing.JLabel min;
    private javax.swing.JLabel min1;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtDpto;
    private javax.swing.JTextField txtEXT;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
