/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024v2;

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
/**
 * Klass för att hantera handläggare inom projektchefsmenyn
 */
public class Projektchefhandläggare extends javax.swing.JFrame {

    // Instansvariabler
    private InfDB idb;
    private JList<String> handlaggarlista;
    private HashMap<String, String> selectedProjekt;
    private String InloggadHandLaggare;
    /**
     * Creates new form Projektchefhandläggare
     * @param idb
     * @param selectedProjekt
     */
    public Projektchefhandläggare(InfDB idb, HashMap<String, String> selectedProjekt) {
        this.idb = idb;
        this.selectedProjekt = selectedProjekt;
        initComponents();
        fyllHandlaggarLista();
    }
// Konstruktor för att hantera ej implementerade funktioner
    Projektchefhandläggare(InfDB idb) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
        public void uppdateraHandlaggarLista() {
        initComponents();
        getContentPane().removeAll();
        fyllHandlaggarLista();
        }
        private Projektchefhandläggare() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
         // Metod för att fylla listan med handläggare    
        private void fyllHandlaggarLista(){
            try {
            String projektId = selectedProjekt.get("pid");
            // Hämta projekten där den inloggade användaren är projektchef
            String sqlFragaPartner = "SELECT anstalld.aid, fornamn, efternamn, adress, epost, telefon, avdelning " +
                                     "FROM anstalld " +
                                     "JOIN ans_proj ON anstalld.aid = ans_proj.aid " +
                                     "JOIN projekt ON projekt.pid = ans_proj.pid " +
                                     "WHERE projekt.pid = '" + projektId + "'";
    ArrayList<HashMap<String, String>> listaHandlaggare = idb.fetchRows(sqlFragaPartner);

            // Skapa en modell för listan
            DefaultListModel<String> model = new DefaultListModel<>();

            // Loopa igenom resultaten och lägg till dem i listmodellen
            if (listaHandlaggare != null) {
            for (HashMap<String, String> rad : listaHandlaggare) {
                // Skapa en sträng med HTML-formatering för varje projekt
                String htmlFormattedItem = "<html><font color='gray'><b>Projekt AnställdID:</b></font> " + rad.get("aid") + "<br>"
                                          + "<font color='gray'><b>Förnamn:</b></font> " + rad.get("fornamn") + "<br>"
                                          + "<font color='gray'><b>Efternamn:</b></font> " + rad.get("efternamn") + "<br>"
                                          + "<font color='gray'><b>Epost:</b></font> " + rad.get("epost") + "<br>"
                                          + "<font color='gray'><b>Telefon:</b></font> " + rad.get("telefon") + "<br>"
                                          + "<font color='gray'><b>Adress:</b></font> " + rad.get("adress") + "<br>"
                                          + "<font color='gray'><b>Avdelning:</b></font> " + rad.get("avdelning") + "</html>";
                model.addElement(htmlFormattedItem);
            }
            } else {
                model.addElement("Inga partners hittades.");
            }
            
            handlaggarlista = new JList<>(model); // Initiera partnerlista här
            JScrollPane scrollPane = new JScrollPane(handlaggarlista);
            scrollPane.setBounds(20, 40, 500, 300);

            // Lägg till JScrollPane till JFrame
            getContentPane().add(scrollPane);


        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }

        // Sätt JFrame till synlig efter att alla komponenter har lagts till
        this.setVisible(true);
    }
        // Metod för att gå tillbaka till MinaProjekt
    private void gatillminaprojekt() {
        this.dispose();
        MinaProjekt minaprojekt = new MinaProjekt(idb, InloggadHandLaggare);
        minaprojekt.setVisible(false);
    }
    // Metod för att ta bort en handläggare
    private void taBortHandlaggare() {
        try {
            int selectedIndex = handlaggarlista.getSelectedIndex(); // Använd handlaggarlista här
            if (selectedIndex != -1) {
                String selectedValue = handlaggarlista.getModel().getElementAt(selectedIndex);
                String[] parts = selectedValue.split("<br>");
                String handlaggarId = parts[0].replaceAll("\\D+", "");
                String projektId = selectedProjekt.get("pid");
                // SQL-fråga för att ta bort handläggare från projektet
                String sqlDeleteHandlaggare = "DELETE FROM ans_proj WHERE aid = '" + handlaggarId + "' AND pid = '" + projektId + "'";
                idb.delete(sqlDeleteHandlaggare);

                ((DefaultListModel<String>) handlaggarlista.getModel()).remove(selectedIndex);

                System.out.println("Handläggare har tagits bort från projektet.");
            } else {
                System.out.println("Vänligen välj en handläggare att ta bort.");
            }
        } catch (InfException ex) {
            System.out.println("Database error: " + ex.getMessage());
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

        btnTillbaka = new javax.swing.JButton();
        btnLaggTillHandlaggare = new javax.swing.JButton();
        btnTaBortHandlaggare = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        btnLaggTillHandlaggare.setText("Lägg till handläggare");
        btnLaggTillHandlaggare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggTillHandlaggareActionPerformed(evt);
            }
        });

        btnTaBortHandlaggare.setText("Ta bort handläggare");
        btnTaBortHandlaggare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaBortHandlaggareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnTillbaka)
                .addGap(18, 18, 18)
                .addComponent(btnLaggTillHandlaggare)
                .addGap(27, 27, 27)
                .addComponent(btnTaBortHandlaggare)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTillbaka)
                    .addComponent(btnLaggTillHandlaggare)
                    .addComponent(btnTaBortHandlaggare))
                .addContainerGap(271, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // TODO add your handling code here:
        gatillminaprojekt();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void btnTaBortHandlaggareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaBortHandlaggareActionPerformed
        // TODO add your handling code here:
        taBortHandlaggare();
    }//GEN-LAST:event_btnTaBortHandlaggareActionPerformed

    private void btnLaggTillHandlaggareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggTillHandlaggareActionPerformed
        // TODO add your handling code here:
        Läggtillhandläggare handläggarfönster = new Läggtillhandläggare(idb, this, selectedProjekt.get("pid"));
        handläggarfönster.setVisible(true);
    }//GEN-LAST:event_btnLaggTillHandlaggareActionPerformed

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
            java.util.logging.Logger.getLogger(Projektchefhandläggare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Projektchefhandläggare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Projektchefhandläggare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Projektchefhandläggare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Projektchefhandläggare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLaggTillHandlaggare;
    private javax.swing.JButton btnTaBortHandlaggare;
    private javax.swing.JButton btnTillbaka;
    // End of variables declaration//GEN-END:variables
}
