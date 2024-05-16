/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024v2;

import java.util.HashMap;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author hoffs
 */
public class HandläggarMeny extends javax.swing.JFrame {
    
    private InfDB idb;
    private String InloggadHandlaggare;
    /**
     * Creates new form HandläggarMeny
     */
    
    
    public HandläggarMeny(InfDB idb, String InloggadHandlaggare) {
        this.idb = idb;
        this.InloggadHandlaggare = InloggadHandlaggare;
        initComponents();
        lblInloggadHandlaggare.setText(InloggadHandlaggare);
        lblValkommen.setText("Välkommen Handläggare, " + InloggadHandlaggare + "!");
        lblFelmeddelande.setVisible(false);
    }

    HandläggarMeny() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    

   private void visaPersonligaUppgifter() {
       try { 
           String sqlFraga = "SELECT * from anstalld WHERE epost = '" + InloggadHandlaggare + "'";
           HashMap<String, String> personligaUppgifter = idb.fetchRow(sqlFraga);
           Anstalldinfo AnstalldInfoFönster = new Anstalldinfo(idb, InloggadHandlaggare);
           
           AnstalldInfoFönster.setVisible(true);
           
           } catch (InfException ex) {
        System.out.println(ex.getMessage());
    }
}
       
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        button1 = new java.awt.Button();
        lblInloggadHandlaggare = new javax.swing.JLabel();
        lblValkommen = new javax.swing.JLabel();
        btnVisaHållbarhetsMål = new javax.swing.JButton();
        btnÄndraUppgifter = new javax.swing.JButton();
        btnChefsMeny = new javax.swing.JButton();
        lblFelmeddelande = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        button1.setLabel("button1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInloggadHandlaggare.setText("jLabel1");

        lblValkommen.setText("jLabel2");

        btnVisaHållbarhetsMål.setText("Hållbarhetsmål");
        btnVisaHållbarhetsMål.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisaHållbarhetsMålActionPerformed(evt);
            }
        });

        btnÄndraUppgifter.setText("Ändra uppgifter");
        btnÄndraUppgifter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnÄndraUppgifterActionPerformed(evt);
            }
        });

        btnChefsMeny.setText("Chefsmeny");
        btnChefsMeny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChefsMenyActionPerformed(evt);
            }
        });

        lblFelmeddelande.setText("lblFelmeddelande");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblValkommen, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblInloggadHandlaggare, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFelmeddelande))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnÄndraUppgifter)
                        .addComponent(btnVisaHållbarhetsMål)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnChefsMeny)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblValkommen))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnChefsMeny)))
                .addGap(40, 40, 40)
                .addComponent(lblInloggadHandlaggare)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(btnÄndraUppgifter)
                .addGap(18, 18, 18)
                .addComponent(btnVisaHållbarhetsMål)
                .addGap(12, 12, 12)
                .addComponent(lblFelmeddelande)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVisaHållbarhetsMålActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisaHållbarhetsMålActionPerformed
        // Skapa ett nytt objekt av HållbarhetsMål-klassen
    HållbarhetsMål hållbarhetsMålFönster = new HållbarhetsMål(idb);
    
    // Gör det nya fönstret synligt
    hållbarhetsMålFönster.setVisible(true);
    }//GEN-LAST:event_btnVisaHållbarhetsMålActionPerformed

    private void btnÄndraUppgifterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnÄndraUppgifterActionPerformed
          visaPersonligaUppgifter();
    }//GEN-LAST:event_btnÄndraUppgifterActionPerformed

    private void btnChefsMenyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChefsMenyActionPerformed
        // TODO add your handling code here:
        try {
      String sqlFraga = "SELECT projektchef from anstalld join projekt on aid = projektchef where '" + InloggadHandlaggare + "' = projektchef";
      System.out.println(sqlFraga);
      HashMap<String, String> InloggadHandlaggare = idb.fetchRow(sqlFraga);
       
       if (InloggadHandlaggare != null && !InloggadHandlaggare.isEmpty()) {
      String ePost = InloggadHandlaggare.get("ePost");
      String projektchef = InloggadHandlaggare.get("projektchef");  
      
    if (ePost.equals(projektchef)){
        new ProjektChefMeny(idb, ePost).setVisible(true);
      
}            
  } else {
          lblFelmeddelande.setText("Användaren saknar behörighet.");
            lblFelmeddelande.setVisible(true);
          }
  } catch (InfException ex) {
        ex.printStackTrace();
        // Hantera eventuella undantag som kan uppstå vid databashanteringen
          }
    
                                             
    }//GEN-LAST:event_btnChefsMenyActionPerformed
    
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
    private javax.swing.JButton btnChefsMeny;
    private javax.swing.JButton btnVisaHållbarhetsMål;
    private javax.swing.JButton btnÄndraUppgifter;
    private java.awt.Button button1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblFelmeddelande;
    private javax.swing.JLabel lblInloggadHandlaggare;
    private javax.swing.JLabel lblValkommen;
    // End of variables declaration//GEN-END:variables
}
