/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024v2;

import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.JOptionPane;


/**
 *
 * @author hampusdaven
 */
public class ÄndraLand extends javax.swing.JFrame {
     private InfDB idb;
     private String InloggadAdmin;

    /**
     * Creates new form ÄndraLand
     */
    public ÄndraLand(InfDB idb, String InloggadAdmin) {
        initComponents();
        this.idb = idb;
        this.InloggadAdmin = InloggadAdmin;
      
        
 }
    
    private void gatilladminland() {
        this.dispose();
        AdminLand AdminLandFönster = new AdminLand(idb, InloggadAdmin);
        AdminLandFönster.setVisible(true);
    }
    
    private void andrainfo() {
        try {
        // Hämta värden från textfälten
        String namn = lblNamn.getText();
        String ekonomi = lblEkonomi.getText();
        String politik = lblPolitik.getText();
        String valuta = lblValuta.getText();
        String tid = lblTID.getText();
        String lidStr = lblLID.getText(); // Detta fält ska inte ändras, bara användas för att identifiera landet
        String sprak = lblSprak.getText();
        
        // Validera inmatning
            if (lidStr.isEmpty() || !Validering.valideraLid(lidStr)) {
                JOptionPane.showMessageDialog(null, "Ogiltigt eller tomt LID!");
                return;
            }

            if (!namn.isEmpty() && !Validering.valideraTextNummer(namn)) {
                JOptionPane.showMessageDialog(null, "Ogiltigt namn!");
                return;
            }

            if (!ekonomi.isEmpty() && !Validering.valideraTextNummer(ekonomi)) {
                JOptionPane.showMessageDialog(null, "Ogiltig ekonomi!");
                return;
            }

            if (!politik.isEmpty() && !Validering.valideraTextNummer(politik)) {
                JOptionPane.showMessageDialog(null, "Ogiltig politisk struktur!");
                return;
            }

            if (!valuta.isEmpty() && !Validering.valideraNummerOchPunkt(valuta)) {
                JOptionPane.showMessageDialog(null, "Ogiltig valuta!");
                return;
            }

            if (!tid.isEmpty() && !Validering.valideraTextNummer(tid)) {
                JOptionPane.showMessageDialog(null, "Ogiltig tidszon!");
                return;
            }

            if (!sprak.isEmpty() && !Validering.valideraTextNummer(sprak)) {
                JOptionPane.showMessageDialog(null, "Ogiltigt språk!");
                return;
            }

           StringBuilder sqlFraga = new StringBuilder("UPDATE land SET ");
        boolean needComma = false;
        
          if (!namn.isEmpty()) {
            sqlFraga.append("namn = '").append(namn).append("'");
            needComma = true;
        }
        if (!sprak.isEmpty()) {
            if (needComma) sqlFraga.append(", ");
            sqlFraga.append("sprak = '").append(sprak).append("'");
            needComma = true;
            }
        if (!valuta.isEmpty()) {
            if (needComma) sqlFraga.append(", ");
            sqlFraga.append("valuta = '").append(valuta).append("'");
            needComma = true;
        }
        if (!tid.isEmpty()) {
            if (needComma) sqlFraga.append(", ");
            sqlFraga.append("tidszon = '").append(tid).append("'");
            needComma = true;
               }
        if (!politik.isEmpty()) {
            if (needComma) sqlFraga.append(", ");
            sqlFraga.append("politisk_struktur = '").append(politik).append("'");
            needComma = true;
        }
        if (!ekonomi.isEmpty()) {
            if (needComma) sqlFraga.append(", ");
            sqlFraga.append("ekonomi = '").append(ekonomi).append("'");
        }
         if (lidStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "LID måste anges!");
            return;
        }
         
          int lid = Integer.parseInt(lidStr);

        // Lägg till WHERE-klausul för att specificera vilket land som ska uppdateras
        sqlFraga.append(" WHERE lid = ").append(lid);
        
         if (sqlFraga.toString().contains("=")) {
            idb.update(sqlFraga.toString());
            JOptionPane.showMessageDialog(null, "Uppgifter uppdaterade!");
        } else {
            JOptionPane.showMessageDialog(null, "Inga uppgifter att uppdatera!");
        }
 } catch (InfException e) {
        JOptionPane.showMessageDialog(null, "Ett fel har inträffats: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Ogiltigt LID! " + e.getMessage());
    }
}


    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblNamn = new javax.swing.JTextField();
        lblTID = new javax.swing.JTextField();
        lblEkonomi = new javax.swing.JTextField();
        lblLID = new javax.swing.JTextField();
        lblSprak = new javax.swing.JTextField();
        lblPolitik = new javax.swing.JTextField();
        lblValuta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ändra land");

        lblValuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblValutaActionPerformed(evt);
            }
        });

        jLabel2.setText("Valuta");

        jLabel3.setText("Politisk struktur");

        jLabel4.setText("Språk");

        jLabel5.setText("Namn");

        jLabel6.setText("Tid");

        jLabel7.setText("Ekonomi");

        jLabel8.setText("LID");

        jButton1.setText("Gå tillbaka");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Spara");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(lblLID, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                            .addComponent(lblEkonomi)
                            .addComponent(lblTID)
                            .addComponent(lblNamn))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lblValuta)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(lblPolitik, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)))
                        .addGap(167, 167, 167))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(lblSprak, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addComponent(lblNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSprak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEkonomi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPolitik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        gatilladminland();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        andrainfo();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void lblValutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblValutaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblValutaActionPerformed

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
            java.util.logging.Logger.getLogger(ÄndraLand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ÄndraLand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ÄndraLand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ÄndraLand.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ÄndraLand().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField lblEkonomi;
    private javax.swing.JTextField lblLID;
    private javax.swing.JTextField lblNamn;
    private javax.swing.JTextField lblPolitik;
    private javax.swing.JTextField lblSprak;
    private javax.swing.JTextField lblTID;
    private javax.swing.JTextField lblValuta;
    // End of variables declaration//GEN-END:variables
}
