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
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author hoffs
 */
public class SökHandläggarePåAvdelning extends javax.swing.JFrame {
    private InfDB idb;
    private String InloggadHandlaggare;
    private DefaultListModel<String> model;
    private JList<String> listHandlaggare;  // JList för att visa resultat
    

    /**
     * Creates new form SökHandläggarePåAvdelning
     */
    public SökHandläggarePåAvdelning(InfDB idb, String inloggadHandlaggare) {
        this.idb = idb;
        this.InloggadHandlaggare = inloggadHandlaggare;
        initComponents();
        
        // Initiera modellen och JList
        model = new DefaultListModel<>();
        listHandlaggare = new JList<>(model);

        // Lägg till JList i en JScrollPane för att göra den rullbar
        JScrollPane scrollPane = new JScrollPane(listHandlaggare);
        scrollPane.setBounds(50, 150, 300, 150);
        add(scrollPane);

        // Lägg till lyssnare för sökfältet
        txtSokHandlaggare.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                sökHandläggare();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sökHandläggare();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                sökHandläggare();
            }
        });
    }

    private void sökHandläggare() {
        String sökord = txtSokHandlaggare.getText().trim();

        // Töm listan för att visa nya resultat
        model.clear();

        try {
            // Hämta avdelningen för inloggad handläggare
            String sqlFragaHandlaggareAvdelning = "SELECT avdelning FROM anstalld WHERE epost = '" + InloggadHandlaggare + "'";
            String handlaggareAvdelning = idb.fetchSingle(sqlFragaHandlaggareAvdelning);

            // Om avdelningen för handläggaren finns
            if (handlaggareAvdelning != null) {
                // Hämta personal som tillhör samma avdelning och matchar sökordet
                String sqlFragaPersonal = "SELECT * FROM anstalld WHERE avdelning = '" + handlaggareAvdelning + "' "
                        + "AND (fornamn LIKE '%" + sökord + "%' OR efternamn LIKE '%" + sökord + "%' OR epost LIKE '%" + sökord + "%')";
                ArrayList<HashMap<String, String>> sökResultat = idb.fetchRows(sqlFragaPersonal);

                // Loopa igenom resultatet och lägg till dem i listmodellen
                if (sökResultat != null) {
                    for (HashMap<String, String> rad : sökResultat) {
                        // Skapa en sträng med HTML-formatering för varje handläggare
                        String htmlFormattedItem = "<html><font color='gray'><b>Namn:</b></font> " + rad.get("fornamn") + " " + rad.get("efternamn") + "<br>"
                                + "<font color='gray'><b>Epost:</b></font> " + rad.get("epost") + "</html>";
                        model.addElement(htmlFormattedItem);
                    }
                }
            }
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private void gatillhandlaggarmeny() {
        this.dispose();
        HandläggarMeny handläggarMeny = new HandläggarMeny(idb, InloggadHandlaggare);
        handläggarMeny.setVisible(false);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSokHandlaggare = new javax.swing.JLabel();
        txtSokHandlaggare = new javax.swing.JTextField();
        btnSok = new javax.swing.JButton();
        btnGatillbaka = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblSokHandlaggare.setText("Sök Handläggare");

        txtSokHandlaggare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSokHandlaggareActionPerformed(evt);
            }
        });

        btnSok.setText("Sök");
        btnSok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSokActionPerformed(evt);
            }
        });

        btnGatillbaka.setText("Gå tillbaka");
        btnGatillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGatillbakaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSokHandlaggare, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSokHandlaggare, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSok)
                    .addComponent(btnGatillbaka))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSokHandlaggare)
                    .addComponent(btnGatillbaka))
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSokHandlaggare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSok))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSokActionPerformed

    private void txtSokHandlaggareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSokHandlaggareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSokHandlaggareActionPerformed

    private void btnGatillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGatillbakaActionPerformed
       gatillhandlaggarmeny();
    }//GEN-LAST:event_btnGatillbakaActionPerformed

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
            java.util.logging.Logger.getLogger(SökHandläggarePåAvdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SökHandläggarePåAvdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SökHandläggarePåAvdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SökHandläggarePåAvdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new SökHandläggarePåAvdelning().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGatillbaka;
    private javax.swing.JButton btnSok;
    private javax.swing.JLabel lblSokHandlaggare;
    private javax.swing.JTextField txtSokHandlaggare;
    // End of variables declaration//GEN-END:variables
}
