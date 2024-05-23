/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024v2;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author jerry
 */
public class Partnermeny extends javax.swing.JFrame {

    private InfDB idb;
    private JList<String> partnerlista;
    private HashMap<String, String> selectedProjekt;
    private String InloggadHandLaggare;
    /**
     * Creates new form Partnermeny
     * @param idb
     * @param selectedProjekt
     */
    public Partnermeny(InfDB idb, HashMap<String, String> selectedProjekt) {
        this.idb = idb;
        this.selectedProjekt = selectedProjekt;
        initComponents();
        fyllPartnerLista();
        
    }

    private Partnermeny() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Partnermeny(InfDB idb, String InloggadHandLaggare) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    // Fyller partnerlistan med data från databasen
    private void fyllPartnerLista(){
        try {
    String projektId = selectedProjekt.get("pid");
            // Hämta projekten där den inloggade användaren är projektchef
            String sqlFragaPartner = "SELECT partner.pid, partner.namn, kontaktperson, kontaktepost, telefon, adress, branch, land " +
                                     "FROM partner " +
                                     "JOIN projekt_partner ON partner.pid = projekt_partner.partner_pid " +
                                     "JOIN projekt ON projekt.pid = projekt_partner.pid " +
                                     "WHERE projekt.pid = '" + projektId + "'";
    ArrayList<HashMap<String, String>> listaPartners = idb.fetchRows(sqlFragaPartner);

            // Skapa en modell för listan
            DefaultListModel<String> model = new DefaultListModel<>();

            // Loopa igenom resultaten och lägg till dem i listmodellen
            if (listaPartners != null) {
            for (HashMap<String, String> rad : listaPartners) {
                // Skapa en sträng med HTML-formatering för varje projekt
                String htmlFormattedItem = "<html><font color='gray'><b>Projekt PartnerID:</b></font> " + rad.get("pid") + "<br>"
                                          + "<font color='gray'><b>Namn:</b></font> " + rad.get("namn") + "<br>"
                                          + "<font color='gray'><b>KontaktPerson:</b></font> " + rad.get("kontaktperson") + "<br>"
                                          + "<font color='gray'><b>Epost:</b></font> " + rad.get("kontaktepost") + "<br>"
                                          + "<font color='gray'><b>Telefon:</b></font> " + rad.get("telefon") + "<br>"
                                          + "<font color='gray'><b>Adress:</b></font> " + rad.get("adress") + "<br>"
                                          + "<font color='gray'><b>Branch:</b></font> " + rad.get("branch") + "<br>"
                                          + "<font color='gray'><b>Land:</b></font> " + rad.get("land") + "</html>";
                model.addElement(htmlFormattedItem);
            }
            } else {
                model.addElement("Inga partners hittades.");
            }
            
            partnerlista = new JList<>(model); // Initiera partnerlista här
            JScrollPane scrollPane = new JScrollPane(partnerlista);
            scrollPane.setBounds(20, 40, 500, 300);

            // Lägg till JScrollPane till JFrame
            getContentPane().add(scrollPane);


        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }

        // Sätt JFrame till synlig efter att alla komponenter har lagts till
        this.setVisible(true);
    }
    // Navigerar tillbaka till MinaProjekt-fönstret
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

        btnTillbaka = new javax.swing.JButton();
        btnLaggTillPartner = new javax.swing.JButton();
        btnTaBortPartner = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        btnLaggTillPartner.setText("Lägg till partner");
        btnLaggTillPartner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillPartnerActionPerformed(evt);
            }
        });

        btnTaBortPartner.setText("Ta bort partner");
        btnTaBortPartner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortPartnerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTillbaka)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(btnTaBortPartner)
                .addGap(18, 18, 18)
                .addComponent(btnLaggTillPartner)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLaggTillPartner)
                    .addComponent(btnTaBortPartner)
                    .addComponent(btnTillbaka))
                .addContainerGap(277, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// Tar bort en vald partner från projektet
    private void taBortPartner() {
        try {
            int selectedIndex = partnerlista.getSelectedIndex(); // Använd partnerlista här
            if (selectedIndex != -1) {
                String selectedValue = partnerlista.getModel().getElementAt(selectedIndex);
                String[] parts = selectedValue.split("<br>");
                String partnerId = parts[0].replaceAll("\\D+", "");
                String projektId = selectedProjekt.get("pid");

                String sqlDeletePartner = "DELETE FROM projekt_partner WHERE partner_pid = '" + partnerId + "' AND pid = '" + projektId + "'";
                idb.delete(sqlDeletePartner);

                ((DefaultListModel<String>) partnerlista.getModel()).remove(selectedIndex);

                System.out.println("Partner har tagits bort från projektet.");
            } else {
                System.out.println("Vänligen välj en partner att ta bort.");
            }
        } catch (InfException ex) {
            System.out.println("Database error: " + ex.getMessage());
        }
    }
// Uppdaterar partnerlistan
    public void uppdateraPartnerLista() {
    initComponents();
    getContentPane().removeAll();
    fyllPartnerLista();
    }

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
         gatillminaprojekt();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void btnLaggTillPartnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillPartnerActionPerformed
        // TODO add your handling code here:
        Läggtillpartnerprojekt partnerfönster = new Läggtillpartnerprojekt(idb, this, selectedProjekt.get("pid"));
        partnerfönster.setVisible(true);
    }//GEN-LAST:event_btnLaggTillPartnerActionPerformed

    private void btnTaBortPartnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortPartnerActionPerformed
        // TODO add your handling code here:
        taBortPartner();
    }//GEN-LAST:event_btnTaBortPartnerActionPerformed

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
            java.util.logging.Logger.getLogger(Partnermeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Partnermeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Partnermeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Partnermeny.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Partnermeny().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLaggTillPartner;
    private javax.swing.JButton btnTaBortPartner;
    private javax.swing.JButton btnTillbaka;
    // End of variables declaration//GEN-END:variables

}
