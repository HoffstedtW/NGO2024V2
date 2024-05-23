/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024v2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import oru.inf.InfDB;
import oru.inf.InfException;
/**
 *
 * @author jerry
 */
public class Läggtillhandläggare extends javax.swing.JFrame {

    private InfDB idb;
    private Projektchefhandläggare Projektchefhandläggare;
    private String projektId;
    private String InloggadHandLaggare;
    /**
     * Creates new form Läggtillhandläggare
     * @param idb
     * @param Projektchefhandläggare
     * @param projektId
     */
    public Läggtillhandläggare(InfDB idb, Projektchefhandläggare Projektchefhandläggare, String projektId) {
        this.idb = idb;
        this.Projektchefhandläggare = Projektchefhandläggare;
        this.projektId = projektId;
        initComponents();
    }
      private Läggtillhandläggare() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btSpara = new javax.swing.JButton();
        txtAnstalldID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btSpara.setText("Spara");
        btSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSparaActionPerformed(evt);
            }
        });

        txtAnstalldID.setText(" ");
        txtAnstalldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnstalldIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtAnstalldID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSpara))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(txtAnstalldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btSpara)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAnstalldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnstalldIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnstalldIDActionPerformed

    private void btSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSparaActionPerformed
        // TODO add your handling code here:
        String anstalldId = txtAnstalldID.getText().trim();
    if (!anstalldId.isEmpty()) {
        try {
            String sqlCheckHandlaggare = "SELECT aid FROM anstalld WHERE aid = '" + anstalldId + "'";
            String existingHandlaggare = idb.fetchSingle(sqlCheckHandlaggare);

            if (existingHandlaggare != null) {
                String sqlInsert = "INSERT INTO ans_proj (aid, pid) VALUES ('" + projektId + "', '" + anstalldId + "')";
                idb.insert(sqlInsert);
                Projektchefhandläggare.uppdateraHandlaggarLista();
                JOptionPane.showMessageDialog(this, "Handläggare har lagts till i projektet.");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Anställd ID finns inte.");
            }
        } catch (InfException ex) {
            System.out.println("Database error: " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(this, "Vänligen ange ett Partner ID.");
    }

    }//GEN-LAST:event_btSparaActionPerformed

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
            java.util.logging.Logger.getLogger(Läggtillhandläggare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Läggtillhandläggare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Läggtillhandläggare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Läggtillhandläggare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Läggtillhandläggare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSpara;
    private javax.swing.JTextField txtAnstalldID;
    // End of variables declaration//GEN-END:variables
}
