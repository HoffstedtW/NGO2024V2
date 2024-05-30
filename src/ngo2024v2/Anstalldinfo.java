/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024v2;

import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.HashMap;
/**
 *
 * @author hampusdaven
 */
public class Anstalldinfo extends javax.swing.JFrame {
    
    
    private InfDB idb;
    private String InloggadHandlaggare;
    private String AnstalldID;
    private HandläggarMeny handläggarMeny;   
  
  

    public Anstalldinfo(InfDB idb, String InloggadHandlaggare) {
    initComponents();
    this.idb = idb;
    this.InloggadHandlaggare = InloggadHandlaggare;
    this.handläggarMeny = handläggarMeny;
     this.setVisible(true);
     
     
     
     
     
     try { 
         String sqlFraga = "SELECT * from anstalld WHERE epost = '" + InloggadHandlaggare + "'";
         HashMap<String, String> personligaUppgifter = idb.fetchRow(sqlFraga);
         
            txtEmail.setText(personligaUppgifter.get("epost"));
            txtFornamn.setText(personligaUppgifter.get("fornamn"));
            txtEfternamn.setText(personligaUppgifter.get("efternamn"));
            txtAdress.setText(personligaUppgifter.get("adress"));
            txtLosenord.setText(personligaUppgifter.get("losenord"));
            txtAID.setText(personligaUppgifter.get("aid"));
            txtAvdelning.setText(personligaUppgifter.get("avdelning"));
            
            String telefonnummer = personligaUppgifter.get("telefon").replace("-","");
            txtTelefonnummer.setText(telefonnummer);
            } catch (InfException ex) {
            System.out.println(ex.getMessage());
     }
 

}
    
   
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    private void gatillhandlaggarmeny() {
        this.dispose();
        HandläggarMeny handläggarMeny = new HandläggarMeny(idb, InloggadHandlaggare);
        handläggarMeny.setVisible(true);
    }
    
    private void adressandring() {
        String nyAdress = txtAdress.getText();
        if (nyAdress.isEmpty()) {
            return;
        }
        
        try {
            String sqlUppdatering = "UPDATE anstalld SET adress = '" + nyAdress + "' WHERE epost = '" + InloggadHandlaggare + "'";
            idb.update(sqlUppdatering);
            
            //Validering
            if(Validering.valideraText(nyAdress)) {
                return;
            }
            
        } catch (Exception ex) {
    }
}
    
    
    
     
    private void epostandring() {
        String nyepost = txtEmail.getText();
        if (nyepost.isEmpty()) {
            return;
        }
        
        try {
            String sqlUppdatering = "UPDATE anstalld SET epost = '" + nyepost + "' WHERE epost = '" + InloggadHandlaggare + "'";
            idb.update(sqlUppdatering);
            InloggadHandlaggare = nyepost;
            
            //Validering
            if(Validering.valideraText(nyepost)) {
                return;
            }
            
        } catch (Exception ex) {
    }
}
     
    private void losenandring() {
        char[] losenchar = txtLosenord.getPassword();
        
        String nyttlosen = new String(losenchar);
        if (nyttlosen.isEmpty()) {
            return;
        }
        
        try {
            String sqlUppdatering = "UPDATE anstalld SET losenord = '" + nyttlosen + "' WHERE epost = '" + InloggadHandlaggare + "'";
            idb.update(sqlUppdatering);
            
            //Validering 
            if(Validering.valideraText(nyttlosen)) {
                return;
            }
        } catch (Exception ex) {
    }
}
    
    private void telefonnummerandring() {
        String nyttnummer = txtTelefonnummer.getText();
        if (nyttnummer.isEmpty()) {
            return;
        }
        
        try {
            String sqlUppdatering = "UPDATE anstalld SET telefon = '" + nyttnummer + "' WHERE epost = '" + InloggadHandlaggare + "'";
            idb.update(sqlUppdatering);
        
          //Validering
          if(Validering.valideraTelefonnummer(nyttnummer)) {
              return;
          }
            
        } catch (Exception ex) {
    }
}
    private void fornamnandring() {
        String nyttfornamn = txtFornamn.getText();
        if (nyttfornamn.isEmpty()) {
            return;
        }
        
        try {
            String sqlUppdatering = "UPDATE anstalld SET fornamn = '" + nyttfornamn + "' WHERE epost = '" + InloggadHandlaggare + "'";
            idb.update(sqlUppdatering);
            
            //Validering 
            if(Validering.valideraText(nyttfornamn)){
                return;
            }
        } catch (Exception ex) {
    }
}
    private void efternamnandring() {
        String nyttefternamn = txtEfternamn.getText();
        if (nyttefternamn.isEmpty()) {
            return;
        }
        
        try {
            String sqlUppdatering = "UPDATE anstalld SET efternamn = '" + nyttefternamn + "' WHERE epost = '" + InloggadHandlaggare + "'";
            idb.update(sqlUppdatering);
            
            //Validering
            if(Validering.valideraText(nyttefternamn)){
                return;
            }
        } catch (Exception ex) {
    }
}
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblFörnamn = new javax.swing.JLabel();
        lblEfternamn = new javax.swing.JLabel();
        txtFornamn = new javax.swing.JTextField();
        txtEfternamn = new javax.swing.JTextField();
        lblAdress = new javax.swing.JLabel();
        lblLösenord = new javax.swing.JLabel();
        txtLosenord = new javax.swing.JPasswordField();
        txtAdress = new javax.swing.JTextField();
        lblAid = new javax.swing.JLabel();
        txtAID = new javax.swing.JTextField();
        lblTelefonnummer = new javax.swing.JLabel();
        txtTelefonnummer = new javax.swing.JTextField();
        lblAvdelning = new javax.swing.JLabel();
        txtAvdelning = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnGåTillbaka = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Al Nile", 0, 24)); // NOI18N
        jLabel1.setText("Kontouppgifter");

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        lblEmail.setText("Email");

        lblFörnamn.setText("Förnamn");

        lblEfternamn.setText("Efternamn");

        txtFornamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFornamnActionPerformed(evt);
            }
        });

        txtEfternamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEfternamnActionPerformed(evt);
            }
        });

        lblAdress.setText("Adress");

        lblLösenord.setText("Lösenord");

        txtLosenord.setText("jPasswordField1");
        txtLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLosenordActionPerformed(evt);
            }
        });

        lblAid.setText("AID");

        txtAID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAIDActionPerformed(evt);
            }
        });

        lblTelefonnummer.setText("Telefonnummer");

        txtTelefonnummer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonnummerActionPerformed(evt);
            }
        });

        lblAvdelning.setText("Avdelning");

        jButton1.setText("Spara");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnGåTillbaka.setText("Gå tillbaka");
        btnGåTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGåTillbakaActionPerformed(evt);
            }
        });

        btnRefresh.setText("Uppdatera");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblAvdelning)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAvdelning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(lblAid))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTelefonnummer, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblTelefonnummer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblFörnamn)
                                        .addGap(46, 46, 46))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtFornamn)
                                        .addGap(23, 23, 23)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEfternamn)
                                    .addComponent(txtEfternamn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLosenord, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(lblAdress)
                            .addComponent(txtAdress)
                            .addComponent(lblLösenord)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGåTillbaka)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(txtAID, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAid)
                    .addComponent(txtAID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAvdelning)
                    .addComponent(txtAvdelning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(lblLösenord))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFörnamn)
                    .addComponent(lblEfternamn)
                    .addComponent(lblAdress))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFornamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEfternamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(lblTelefonnummer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefonnummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnGåTillbaka)
                    .addComponent(btnRefresh))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
       
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtEfternamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEfternamnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEfternamnActionPerformed

    private void txtTelefonnummerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonnummerActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_txtTelefonnummerActionPerformed

    private void txtAIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAIDActionPerformed

    }//GEN-LAST:event_txtAIDActionPerformed

    private void txtFornamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFornamnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFornamnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           
        adressandring();
        fornamnandring();
        efternamnandring();
            epostandring();
            losenandring();
            telefonnummerandring();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGåTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGåTillbakaActionPerformed
gatillhandlaggarmeny();      
    }//GEN-LAST:event_btnGåTillbakaActionPerformed

    private void txtLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLosenordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLosenordActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRefreshActionPerformed

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
            java.util.logging.Logger.getLogger(Anstalldinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Anstalldinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Anstalldinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Anstalldinfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGåTillbaka;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblAid;
    private javax.swing.JLabel lblAvdelning;
    private javax.swing.JLabel lblEfternamn;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFörnamn;
    private javax.swing.JLabel lblLösenord;
    private javax.swing.JLabel lblTelefonnummer;
    private javax.swing.JTextField txtAID;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtAvdelning;
    private javax.swing.JTextField txtEfternamn;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFornamn;
    private javax.swing.JPasswordField txtLosenord;
    private javax.swing.JTextField txtTelefonnummer;
    // End of variables declaration//GEN-END:variables
}
