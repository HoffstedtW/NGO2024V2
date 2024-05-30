/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024v2;

import java.util.HashMap;
import oru.inf.InfDB;
import oru.inf.InfException;
import javax.swing.JOptionPane;
/**
 *
 * @author jerry
 */
/**
 * Klass för att ändra projektuppgifter.
 * Skapar ett fönster där användaren kan ändra detaljerna för ett projekt.
 */
public class ÄndraProjektUppgifter extends javax.swing.JFrame {
 // Deklaration av variabler
    private InfDB idb;
    private HashMap<String, String> listaProjekt;
    private String InloggadHandLaggare;
    private String InloggadAdmin;

   /**
     * Konstruktor som initialiserar objektet och fyller fält med data.
     * @param idb
     * @param listaProjekt
     */
    public ÄndraProjektUppgifter(InfDB idb, HashMap<String, String> listaProjekt) {
        this.idb = idb;
        this.InloggadHandLaggare = InloggadHandLaggare;
        this.InloggadAdmin = InloggadAdmin;
        this.listaProjekt = listaProjekt;
        
        initComponents(); // Initierar komponenter
        fyllFaltMedData();// Fyller fälten med data från projektet
    }
    /**
     * Metod för att fylla textfälten med projektets data.
     */
private void fyllFaltMedData() {
    if (txtProjektnamn != null) {
        txtProjektnamn.setText(listaProjekt.get("projektnamn"));
    }
    if (txtStartdatum != null) {
        txtStartdatum.setText(listaProjekt.get("startdatum"));
    }
    if (txtSlutdatum != null) {
        txtSlutdatum.setText(listaProjekt.get("slutdatum"));
    }
    if (txtBeskrivning != null) {
        txtBeskrivning.setText(listaProjekt.get("beskrivning"));
    }
    if (txtKostnad != null) {
        txtKostnad.setText(listaProjekt.get("kostnad"));
    }
    if (txtStatus != null) {
        txtStatus.setText(listaProjekt.get("status"));
    }
    if (txtPrioritet != null) {
        txtPrioritet.setText(listaProjekt.get("prioritet"));
    }
    if (txtLand != null) {
        txtLand.setText(listaProjekt.get("land"));
    }
    if (txtProjektChef != null) {
        txtProjektChef.setText(listaProjekt.get("projektchef"));
    }
  
}
 public ÄndraProjektUppgifter() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 /**
     * Metod för att spara de uppdaterade projektuppgifterna i databasen.
     */
private void sparaProjekt() {
        try {
            String projektnamn = txtProjektnamn.getText();
        String startdatum = txtStartdatum.getText();
        String slutdatum = txtSlutdatum.getText();
        String beskrivning = txtBeskrivning.getText();
        String kostnad = txtKostnad.getText();
        String status = txtStatus.getText();
        String prioritet = txtPrioritet.getText();
        String land = txtLand.getText();
        String projektchef = txtProjektChef.getText();

        // Validera att inga fält är tomma
        if (projektnamn.isEmpty() || beskrivning.isEmpty() || startdatum.isEmpty() || slutdatum.isEmpty() || 
            projektchef.isEmpty() || prioritet.isEmpty() || land.isEmpty() || kostnad.isEmpty() || status.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fyll i alla fält!");
            return;
        }

        // Validera datum
        if (!Validering.valideraDatum(startdatum) || !Validering.valideraDatum(slutdatum)) {
            JOptionPane.showMessageDialog(null, "Ogiltigt datumformat! Använd formatet YYYY-MM-DD.");
            return;
        }

        // Validera textfält
        if (!Validering.valideraText(projektnamn) || !Validering.valideraText(beskrivning)) {
            
            JOptionPane.showMessageDialog(null, "Ogiltigt textformat i ett av fälten!");
            return;
        }

        // Validera numeriska fält
        if (!Validering.valideraText(prioritet) || !Validering.valideraText(kostnad) || !Validering.valideraText(status) ||
             !Validering.valideraText(projektchef) || !Validering.valideraText(land)) {
            JOptionPane.showMessageDialog(null, "Ogiltigt format i ett av de numeriska fälten!");
            return;
        }

        // Validera att land finns i databasen
        if (!Validering.valideraLid(land)) {
            JOptionPane.showMessageDialog(null, "Ogiltigt land ID!");
            return;
        }

        // SQL-uppdatering av projektet
        String sqlUpdate = "UPDATE projekt SET "
                + "projektnamn = '" + projektnamn + "', "
                + "startdatum = '" + startdatum + "', "
                + "slutdatum = '" + slutdatum + "', "
                + "beskrivning = '" + beskrivning + "', "
                + "kostnad = '" + kostnad + "', "
                + "status = '" + status + "', "
                + "prioritet = '" + prioritet + "', "
                + "land = '" + land + "', "
                + "projektchef = '" + projektchef + "' "
                + "WHERE pid = " + listaProjekt.get("pid");

        // Utför SQL-uppdateringen
        idb.update(sqlUpdate);
        System.out.println("Projektet har uppdaterats."); // Bekräftelsemeddelande
        this.dispose(); // Stänger fönstret
    } catch (InfException ex) {
        System.out.println("Ett fel inträffade vid uppdatering: " + ex.getMessage());
    }
}
        /**
         * Metod för att gå tillbaka till föregående fönster.
        */
        private void gatillminaprojekt() {
        this.dispose();
        MinaProjekt minaprojekt = new MinaProjekt(idb, InloggadHandLaggare);
        minaprojekt.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtProjektnamn = new javax.swing.JTextField();
        txtStartdatum = new javax.swing.JTextField();
        txtSlutdatum = new javax.swing.JTextField();
        txtBeskrivning = new javax.swing.JTextField();
        txtKostnad = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        txtPrioritet = new javax.swing.JTextField();
        txtLand = new javax.swing.JTextField();
        btnTillbaka = new javax.swing.JButton();
        txtSpara = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtProjektChef = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtProjektnamn.setText("jTextField1");

        txtStartdatum.setText("jTextField2");

        txtSlutdatum.setText("jTextField3");

        txtBeskrivning.setText("jTextField4");

        txtKostnad.setText("jTextField5");

        txtStatus.setText("jTextField6");

        txtPrioritet.setText("jTextField7");

        txtLand.setText("jTextField8");

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        txtSpara.setText("Spara");
        txtSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSparaActionPerformed(evt);
            }
        });

        jLabel1.setText("Projektnamn:");

        jLabel2.setText("Startdatum:");

        jLabel3.setText("Slutdatum:");

        jLabel5.setText("Kostnad:");

        jLabel6.setText("Prioritet:");

        jLabel7.setText("Status:");

        jLabel8.setText("Land:");

        jLabel9.setText("Beskrivning:");

        txtProjektChef.setText("jTextField1");
        txtProjektChef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProjektChefActionPerformed(evt);
            }
        });

        jLabel10.setText("Projektchef");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtProjektChef, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTillbaka)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSpara))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtBeskrivning, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                        .addComponent(txtProjektnamn, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtStartdatum, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtSlutdatum, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtKostnad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                    .addComponent(txtStatus, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtPrioritet, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtLand, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProjektnamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKostnad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(txtStartdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSlutdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrioritet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBeskrivning, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTillbaka)
                            .addComponent(txtSpara))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProjektChef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        gatillminaprojekt();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void txtSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSparaActionPerformed
        // TODO add your handling code here:
        sparaProjekt();
    }//GEN-LAST:event_txtSparaActionPerformed

    private void txtProjektChefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProjektChefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProjektChefActionPerformed

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
            java.util.logging.Logger.getLogger(ÄndraProjektUppgifter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ÄndraProjektUppgifter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ÄndraProjektUppgifter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ÄndraProjektUppgifter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ÄndraProjektUppgifter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTillbaka;
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
    private javax.swing.JTextField txtBeskrivning;
    private javax.swing.JTextField txtKostnad;
    private javax.swing.JTextField txtLand;
    private javax.swing.JTextField txtPrioritet;
    private javax.swing.JTextField txtProjektChef;
    private javax.swing.JTextField txtProjektnamn;
    private javax.swing.JTextField txtSlutdatum;
    private javax.swing.JButton txtSpara;
    private javax.swing.JTextField txtStartdatum;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
