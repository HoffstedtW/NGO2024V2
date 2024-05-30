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
public class ÄndraAvdelning extends javax.swing.JFrame {
             private InfDB idb;
             private String InloggadAdmin;
    /**
     * Creates new form ÄndraAvdelning
     */
    public ÄndraAvdelning(InfDB idb, String InloggadAdmin) {
        initComponents();
        this.InloggadAdmin = InloggadAdmin;
        this.idb = idb;
      
    }
    
    
    private void andrainfo() {
    try {
        // Hämta värdet från txtEpost-fältet
        String epost = txtEpost.getText();
        
        // Kontrollera om e-postadressen är giltig med hjälp av valideringsmetoden
        if (!Validering.valideraEpost(epost)) {
            // Visa meddelande till användaren om att valideringen misslyckades
            JOptionPane.showMessageDialog(null, "Ogiltig e-postadress. Kontrollera att alla fält är korrekt ifyllda.");
            return; 
            
         
        }   

        // Hämta värden från de andra textfälten
        String avdidStr = txtavdid.getText();
        String namn = txtNamn.getText();
        String beskrivning = txtBeskrivning.getText();
        String telefon = txtTelefon.getText();
        String stad = txtStad.getText();
        String chef = txtChef.getText();
        String adress = txtAdress.getText();
        
        // Konvertera avdidStr till ett numeriskt värde
        int avdid = Integer.parseInt(avdidStr);
        
        // Validerar inmatningen för namn, beskrivning och adress
         if (!Validering.valideraText(namn) ||
         !Validering.valideraText(beskrivning) ||
          !Validering.valideraText(adress)) {
         JOptionPane.showMessageDialog(null, "Ogiltigt format i ett av fälten!");
          return;
        }
         
         
      // Validerar numeriska fält för  och 
       if (!Validering.valideraint(stad) ||
        !Validering.valideraint(chef)) {
        JOptionPane.showMessageDialog(null, "Ogiltigt format i ett av de numeriska fälten!");
       return;
        }
       
      
       
           // Validerar avdid
        if (!Validering.valideraint(avdidStr)) {
            JOptionPane.showMessageDialog(null, "Ogiltigt format för avdid");
            return;
        }
        
            // Validerar telefonnummer
        if (!Validering.valideraTelefonnummer(telefon)) {
            JOptionPane.showMessageDialog(null, "Ogiltigt format för avdid");
            return;
        }
        
       

        // Skapa en StringBuilder för att bygga SQL-frågan dynamiskt
        StringBuilder sqlFraga = new StringBuilder("UPDATE avdelning SET ");
        boolean needComma = false;

        // Bygg SQL-frågan dynamiskt baserat på vilka fält som är ifyllda
        if (!namn.isEmpty()) {
            sqlFraga.append("namn = '").append(namn).append("'");
            needComma = true;
        }
        if (!beskrivning.isEmpty()) {
            if (needComma) sqlFraga.append(", ");
            sqlFraga.append("beskrivning = '").append(beskrivning).append("'");
            needComma = true;
        }
        if (!adress.isEmpty()) {
            if (needComma) sqlFraga.append(", ");
            sqlFraga.append("adress = '").append(adress).append("'");
            needComma = true;
        }
        if (!epost.isEmpty()) {
            if (needComma) sqlFraga.append(", ");
            sqlFraga.append("epost = '").append(epost).append("'");
            needComma = true;
        }
        if (!telefon.isEmpty()) {
            if (needComma) sqlFraga.append(", ");
            sqlFraga.append("telefon = '").append(telefon).append("'");
            needComma = true;
        }
        if (!stad.isEmpty()) {
            if (needComma) sqlFraga.append(", ");
            sqlFraga.append("stad = '").append(stad).append("'");
            needComma = true;
        }
        if (!chef.isEmpty()) {
            if (needComma) sqlFraga.append(", ");
            sqlFraga.append("chef = '").append(chef).append("'");
        }

        // Lägg till WHERE-klausul för att specificera vilken avdelning som ska uppdateras
        sqlFraga.append(" WHERE avdid = ").append(avdid);

        // Kontrollera att avdid är angivet innan vi utför uppdateringen
        if (avdidStr.isEmpty()) {
            JOptionPane.showMessageDialog(null, "AVDID måste anges!");
            return;
        }

        // Utför uppdateringen
        if (sqlFraga.toString().contains("=")) {
            idb.update(sqlFraga.toString());
            JOptionPane.showMessageDialog(null, "Uppgifter uppdaterade!");
        } else {
            JOptionPane.showMessageDialog(null, "Inga uppgifter att uppdatera!");
        }
    } catch (InfException e) {
        JOptionPane.showMessageDialog(null, "Ett fel har inträffats: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Ogiltigt AVDID! " + e.getMessage());
    }
}


    
    
    

    
    
 
    private void gatilladminavdelning() {
        this.dispose();
        AdminAvdelning AdminAvdelningFönster = new AdminAvdelning(idb, InloggadAdmin);
        AdminAvdelningFönster.setVisible(true);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGatillbaka = new javax.swing.JButton();
        btnSpara = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtavdid = new javax.swing.JTextField();
        txtNamn = new javax.swing.JTextField();
        txtBeskrivning = new javax.swing.JTextField();
        txtStad = new javax.swing.JTextField();
        txtEpost = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();
        txtChef = new javax.swing.JTextField();
        txtAdress = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnGatillbaka.setText("Gå tillbaka");
        btnGatillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGatillbakaActionPerformed(evt);
            }
        });

        btnSpara.setText("Spara");
        btnSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSparaActionPerformed(evt);
            }
        });

        jLabel1.setText("Ändra Avdelningar");

        txtStad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStadActionPerformed(evt);
            }
        });

        jLabel2.setText("AvdID");

        jLabel3.setText("Namn");

        jLabel4.setText("Beskrivning");

        jLabel5.setText("Stad");

        jLabel6.setText("Epost");

        jLabel7.setText("Telefon");

        jLabel9.setText("Adress");

        jLabel10.setText("Chef");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSpara)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGatillbaka)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(29, 29, 29))
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStad, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5))))
                    .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtavdid, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(147, 147, 147))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(txtEpost, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(txtTelefon)
                            .addComponent(txtChef)
                            .addComponent(txtAdress))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtavdid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGatillbaka)
                    .addComponent(btnSpara))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGatillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGatillbakaActionPerformed
        gatilladminavdelning();
    }//GEN-LAST:event_btnGatillbakaActionPerformed

    private void txtStadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStadActionPerformed

    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed
        andrainfo();
    }//GEN-LAST:event_btnSparaActionPerformed

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
            java.util.logging.Logger.getLogger(ÄndraAvdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ÄndraAvdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ÄndraAvdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ÄndraAvdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ÄndraAvdelning().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGatillbaka;
    private javax.swing.JButton btnSpara;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtBeskrivning;
    private javax.swing.JTextField txtChef;
    private javax.swing.JTextField txtEpost;
    private javax.swing.JTextField txtNamn;
    private javax.swing.JTextField txtStad;
    private javax.swing.JTextField txtTelefon;
    private javax.swing.JTextField txtavdid;
    // End of variables declaration//GEN-END:variables
}
