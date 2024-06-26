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
 * @author livlagercrantz
 */
public class ÄndraPartner extends javax.swing.JFrame {
private InfDB idb;
private String InloggadAdmin;
    /**
     * Creates new form ÄndraPartner
     */
    public ÄndraPartner(InfDB idb, String InloggadAdmin) {
        initComponents();
          this.idb = idb;
          this.InloggadAdmin=InloggadAdmin;
    }

    private ÄndraPartner() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
       private void gatillAdminPartner() {
        this.dispose();
        AdminPartner AdminPartnerFönster = new AdminPartner(idb, InloggadAdmin);
        AdminPartnerFönster.setVisible(true);
    }
       
        private void andrainfo() {
      try{ 
          String pid = jpid.getText();
          String namn = jnamn.getText();
          String kontaktperson = jkontaktperson.getText(); 
          String kontaktepost = jkontaktepost.getText();
          String telefonnummer = jtelefonnummer.getText();
          String adress = jadress.getText();
          String branch = jbranch.getText();
          
          
           // Validera inmatning
            if (pid.isEmpty() || !Validering.valideraPid(pid)) {
                JOptionPane.showMessageDialog(null, "Ogiltigt eller tomt PID!");
                return;
            }

            if (!namn.isEmpty() && !Validering.valideraText(namn)) {
                JOptionPane.showMessageDialog(null, "Ogiltigt namn!");
                return;
            }

            if (!kontaktperson.isEmpty() && !Validering.valideraText(kontaktperson)) {
                JOptionPane.showMessageDialog(null, "Ogiltig kontaktperson!");
                return;
            }

            if (!kontaktepost.isEmpty() && !Validering.valideraEpost(kontaktepost)) {
                JOptionPane.showMessageDialog(null, "Ogiltig e-postadress!");
                return;
            }

            if (!telefonnummer.isEmpty() && !Validering.valideraTelefonnummer(telefonnummer)) {
                JOptionPane.showMessageDialog(null, "Ogiltigt telefonnummer!");
                return;
            }

            if (!adress.isEmpty() && !Validering.valideraTextNummer(adress)) {
                JOptionPane.showMessageDialog(null, "Ogiltig adress!");
                return;
            }

            if (!branch.isEmpty() && !Validering.valideraText(branch)) {
                JOptionPane.showMessageDialog(null, "Ogiltig bransch!");
                return;
            }
                    StringBuilder sqlFraga = new StringBuilder("UPDATE Partner SET ");
        boolean needComma = false;
        
          if (!pid.isEmpty()) {
            sqlFraga.append("pid = '").append(pid).append("'");
            needComma = true;
           
        if (!namn.isEmpty()) {
            if (needComma) sqlFraga.append(", ");
            sqlFraga.append("namn = '").append(namn).append("'");
            needComma = true;
            }
         if (!kontaktperson.isEmpty()) {
            if (needComma) sqlFraga.append(", ");
            sqlFraga.append("kontaktperson = '").append(kontaktperson).append("'");
            needComma = true;
        }
        if (!kontaktepost.isEmpty()) {
            if (needComma) sqlFraga.append(", ");
            sqlFraga.append("kontaktepost = '").append(kontaktepost).append("'");
            needComma = true;
               }
        if (!telefonnummer.isEmpty()) {
            if (needComma) sqlFraga.append(", ");
            sqlFraga.append("telefon = '").append(telefonnummer).append("'");
            needComma = true;
        }
        
        if (!adress.isEmpty()) {
            if (needComma) sqlFraga.append(", ");
            sqlFraga.append("adress = '").append(adress).append("'");
        }
         if (!branch.isEmpty()) {
            if (needComma) sqlFraga.append(", ");
            sqlFraga.append("branch = '").append(branch).append("'");
            needComma = true;
        }
        
         if (pid.isEmpty()) {
            JOptionPane.showMessageDialog(null, "PID måste anges!");
            return;
        }
           int Pid = Integer.parseInt(pid);

        // Lägg till WHERE-klausul för att specificera vilken Partner som ska uppdateras
        sqlFraga.append(" WHERE pid = ").append(pid);
        
         if (sqlFraga.toString().contains("=")) {
            idb.update(sqlFraga.toString());
            JOptionPane.showMessageDialog(null, "Uppgifter uppdaterade!");
        } else {
            JOptionPane.showMessageDialog(null, "Inga uppgifter att uppdatera!");
        }
         
                
      } 
    } catch (InfException e) {
        JOptionPane.showMessageDialog(null, "Ett fel har inträffats: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Ogiltigt PID! " + e.getMessage());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jpid = new javax.swing.JTextField();
        jnamn = new javax.swing.JTextField();
        jkontaktperson = new javax.swing.JTextField();
        jkontaktepost = new javax.swing.JTextField();
        jtelefonnummer = new javax.swing.JTextField();
        jadress = new javax.swing.JTextField();
        jbranch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ändra uppgifter om partner");

        jLabel2.setText("PID");

        jLabel3.setText("Namn");

        jLabel4.setText("Kontaktperson");

        jLabel5.setText("Kontakt epost");

        jLabel6.setText("Telfonnummer");

        jLabel7.setText("Adress");

        jLabel8.setText("Branch");

        jButton1.setText("Spara");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Gå tillbaka");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jnamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jnamnActionPerformed(evt);
            }
        });

        jkontaktperson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jkontaktpersonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jnamn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                        .addComponent(jpid, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jtelefonnummer, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addComponent(jadress)
                    .addComponent(jbranch))
                .addGap(84, 84, 84))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jkontaktperson, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(jkontaktepost))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(34, 34, 34)
                .addComponent(jButton2)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtelefonnummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jnamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jadress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jkontaktperson, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jkontaktepost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jkontaktpersonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jkontaktpersonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jkontaktpersonActionPerformed

    private void jnamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jnamnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jnamnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        andrainfo();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        gatillAdminPartner();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ÄndraPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ÄndraPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ÄndraPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ÄndraPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ÄndraPartner().setVisible(true);
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
    private javax.swing.JTextField jadress;
    private javax.swing.JTextField jbranch;
    private javax.swing.JTextField jkontaktepost;
    private javax.swing.JTextField jkontaktperson;
    private javax.swing.JTextField jnamn;
    private javax.swing.JTextField jpid;
    private javax.swing.JTextField jtelefonnummer;
    // End of variables declaration//GEN-END:variables
}
