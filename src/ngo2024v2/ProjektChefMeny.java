/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024v2;

import java.util.HashMap;
import oru.inf.InfDB;

/**
 *
 * @author Jerry/hoffs
 */
public class ProjektChefMeny extends javax.swing.JFrame {

    private InfDB idb;
    private String InloggadHandlaggare;
    /**
     * Creates new form ProjektChefMeny
     */
    public ProjektChefMeny(InfDB idb, String InloggadHandlaggare) {
        initComponents();
        this.idb = idb;
        this.InloggadHandlaggare = InloggadHandlaggare;
        Valkommen.setText("<html>Välkommen</font><font color='red'> Projektchef</font>, " + InloggadHandlaggare + "!</html>");
        jLabel1.setText(InloggadHandlaggare);
    }

    private ProjektChefMeny() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    ProjektChefMeny(InfDB idb, HashMap<String, String> InloggadHandlaggare) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void gatillhandlaggarmeny() {
        this.dispose();
        HandläggarMeny handläggarMeny = new HandläggarMeny(idb, InloggadHandlaggare);
        handläggarMeny.setVisible(false);
    }
    
            @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Valkommen = new javax.swing.JLabel();
        btnTillbaka = new javax.swing.JButton();
        btnVisaMinaProject = new javax.swing.JButton();
        btnKostnadsStitistik = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("jLabel1");

        Valkommen.setText("jLabel2");

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        btnVisaMinaProject.setText("Visa Mina Projekt");
        btnVisaMinaProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaMinaProjectActionPerformed(evt);
            }
        });

        btnKostnadsStitistik.setText("Kostnadsstatistik");
        btnKostnadsStitistik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKostnadsStitistikActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Valkommen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnTillbaka))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(149, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnKostnadsStitistik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVisaMinaProject, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
                .addGap(122, 122, 122))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Valkommen)
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(btnVisaMinaProject)
                .addGap(18, 18, 18)
                .addComponent(btnKostnadsStitistik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(btnTillbaka)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        gatillhandlaggarmeny();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void btnVisaMinaProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaMinaProjectActionPerformed
        // TODO add your handling code here:
        MinaProjekt visaMinaProjekt = new MinaProjekt(idb, InloggadHandlaggare);
        visaMinaProjekt.setVisible(true);
    }//GEN-LAST:event_btnVisaMinaProjectActionPerformed

    private void btnKostnadsStitistikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKostnadsStitistikActionPerformed
        Kostnadsstatistik visaKostnadsstatistik = new Kostnadsstatistik(idb, InloggadHandlaggare);
        visaKostnadsstatistik.setVisible(true);
    }//GEN-LAST:event_btnKostnadsStitistikActionPerformed

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
            java.util.logging.Logger.getLogger(HandläggarMeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HandläggarMeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HandläggarMeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HandläggarMeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new HandläggarMeny().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Valkommen;
    private javax.swing.JButton btnKostnadsStitistik;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JButton btnVisaMinaProject;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
