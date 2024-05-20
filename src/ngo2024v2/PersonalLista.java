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
 * @author hoffs
 */
public class PersonalLista extends javax.swing.JFrame {
    private InfDB idb;
    private String InloggadAdmin;
    private String InloggadHandlaggare;
    private JList<String> PersonalLista;

    /**
     * Creates new form PersonalLista
     */
    public PersonalLista(InfDB idb, String inloggadAdmin) {
        initComponents();
        this.idb = idb;
        this.InloggadAdmin = inloggadAdmin;
        this.InloggadHandlaggare = inloggadAdmin;
        
        try {
            // Hämta avdelningen för inloggad admin
        String sqlFragaAdminAvdelning = "SELECT avdelning FROM anstalld WHERE epost = '"+inloggadAdmin+"'";
        String adminAvdelning = idb.fetchSingle(sqlFragaAdminAvdelning);
        
        // Om avdelningen för adminen finns
        if (adminAvdelning != null) {
            // Hämta all annan personal som tillhör samma avdelning
            String sqlFragaAnnatPersonal = "SELECT * FROM anstalld WHERE avdelning = "+adminAvdelning;
            ArrayList<HashMap<String, String>> ListaPersonal = idb.fetchRows(sqlFragaAnnatPersonal);
            
            // Skapa en modell för listan
            DefaultListModel<String> model = new DefaultListModel<>();
            
            // Loopa igenom resultaten och lägg till dem i listmodellen
            for (HashMap<String, String> rad : ListaPersonal) {
                // Skapa en sträng med HTML-formatering för varje anställd
                String htmlFormattedItem = "<html><font color='gray'><b>Namn:</b></font> " + rad.get("fornamn") + "<br>"
                                          + "<font color='gray'><b>Efternamn:</b></font> " + rad.get("efternamn") + "<br>"
                                          + "<font color='gray'><b>Telefon:</b></font> " + rad.get("telefon") + "<br>"
                                          + "<font color='gray'><b>Epost:</b></font> " + rad.get("epost") + "</html>";
                                          
                model.addElement(htmlFormattedItem);
            }
            
            // Skapa en JList med modellen
            PersonalLista = new JList<>(model);
            
            // Lägg till JList till en JScrollPane för att göra det möjligt att rulla
            JScrollPane scrollPane = new JScrollPane(PersonalLista);
            scrollPane.setBounds(20, 40, 500, 300); // Ange position och storlek för JScrollPane
            
            // Lägg till JScrollPane till JFrame
            getContentPane().add(scrollPane);
        }

            
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
    }

    PersonalLista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        handläggarMeny.setVisible(false);
    }
    
   
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnGåTillbaka = new javax.swing.JButton();
        btnRadera = new javax.swing.JButton();
        btnÄndra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Personallista");

        btnGåTillbaka.setText("Gå Tillbaka");
        btnGåTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGåTillbakaActionPerformed(evt);
            }
        });

        btnRadera.setText("Radera");
        btnRadera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaderaActionPerformed(evt);
            }
        });

        btnÄndra.setText("Ändra");
        btnÄndra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnÄndraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnÄndra)
                .addGap(18, 18, 18)
                .addComponent(btnRadera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGåTillbaka)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnGåTillbaka)
                    .addComponent(btnRadera)
                    .addComponent(btnÄndra))
                .addGap(0, 277, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGåTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGåTillbakaActionPerformed
        gatillhandlaggarmeny();
    }//GEN-LAST:event_btnGåTillbakaActionPerformed

    private void btnRaderaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaderaActionPerformed
         
    }//GEN-LAST:event_btnRaderaActionPerformed

    private void btnÄndraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnÄndraActionPerformed
        
    }//GEN-LAST:event_btnÄndraActionPerformed

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
            java.util.logging.Logger.getLogger(PersonalLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersonalLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersonalLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersonalLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new PersonalLista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGåTillbaka;
    private javax.swing.JButton btnRadera;
    private javax.swing.JButton btnÄndra;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    private static class InfDb {

        public InfDb() {
        }
    }
}
