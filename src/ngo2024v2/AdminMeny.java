/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024v2;

import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author hoffs
 */
public class AdminMeny extends javax.swing.JFrame {
    
    private InfDB idb;
    private String InloggadAdmin;
    /**
     * Creates new form AdminMeny
     */
    public AdminMeny(InfDB idb, String InloggadAdmin) {
        this.idb = idb;
        this.InloggadAdmin = InloggadAdmin;
        initComponents();
        lblInloggadAdmin.setText(InloggadAdmin);
        // Använd HTML-formatering för att göra texten grönt
    lblValkommen.setText("<html>Välkommen</font><font color='green'> Admin</font>, " + InloggadAdmin + "!</html>");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblInloggadAdmin = new javax.swing.JLabel();
        lblValkommen = new javax.swing.JLabel();
        btnÄndraUppgifter = new javax.swing.JButton();
        btnTilldeladeProjekt = new javax.swing.JButton();
        btnAnställda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInloggadAdmin.setText("jLabel1");

        lblValkommen.setText("jLabel2");

        btnÄndraUppgifter.setText("Ändra Uppgifter");
        btnÄndraUppgifter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnÄndraUppgifterActionPerformed(evt);
            }
        });

        btnTilldeladeProjekt.setText("Tilldelade Projekt");
        btnTilldeladeProjekt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTilldeladeProjektActionPerformed(evt);
            }
        });

        btnAnställda.setText("Anställda");
        btnAnställda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnställdaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValkommen, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInloggadAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnÄndraUppgifter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTilldeladeProjekt, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAnställda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblValkommen)
                .addGap(35, 35, 35)
                .addComponent(lblInloggadAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(btnÄndraUppgifter)
                .addGap(18, 18, 18)
                .addComponent(btnTilldeladeProjekt)
                .addGap(18, 18, 18)
                .addComponent(btnAnställda)
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnÄndraUppgifterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnÄndraUppgifterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnÄndraUppgifterActionPerformed

    private void btnTilldeladeProjektActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTilldeladeProjektActionPerformed
        // Skapa ett nytt objekt av HållbarhetsMål-klassen
    Tilldeladeprojektanstalld TilldeladeprojektFönster = new Tilldeladeprojektanstalld(idb, InloggadAdmin);
    
    // Gör det nya fönstret synligt
    TilldeladeprojektFönster.setVisible(true);
    }//GEN-LAST:event_btnTilldeladeProjektActionPerformed

    private void btnAnställdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnställdaActionPerformed
        Anställda AnställdaFönster = new Anställda(idb, InloggadAdmin);
        
        AnställdaFönster.setVisible(true);
    }//GEN-LAST:event_btnAnställdaActionPerformed

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
            java.util.logging.Logger.getLogger(AdminMeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminMeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminMeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminMeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new AdminMeny().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnställda;
    private javax.swing.JButton btnTilldeladeProjekt;
    private javax.swing.JButton btnÄndraUppgifter;
    private javax.swing.JLabel lblInloggadAdmin;
    private javax.swing.JLabel lblValkommen;
    // End of variables declaration//GEN-END:variables
}
