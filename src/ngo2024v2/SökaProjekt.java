/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngo2024v2;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
public class SökaProjekt extends javax.swing.JFrame {
    private InfDB idb;
    private String InloggadHandlaggare;
    private DefaultListModel<String> model;
    private JList<String> listProjekt;  // JList för att visa resultat
    private JTextField txtStartDatum;   // JTextField för startdatum
    private JTextField txtSlutDatum;    // JTextField för slutdatum

    /**
     * Creates new form SökaProjekt
     */
    public SökaProjekt(InfDB idb, String inloggadHandlaggare) {
        this.idb = idb;
        this.InloggadHandlaggare = inloggadHandlaggare;
        initComponents();
        
        
        // Initiera modellen och JList
        model = new DefaultListModel<>();
        listProjekt = new JList<>(model);
        txtStartDatum = new javax.swing.JTextField();
        txtSlutDatum = new javax.swing.JTextField();

        // Lägg till JList i en JScrollPane för att göra den rullbar
        JScrollPane scrollPane = new JScrollPane(listProjekt);
        scrollPane.setBounds(50, 150, 300, 150);
        add(scrollPane);

        // Lägg till lyssnare för datumfälten
        jtxtStartDatum.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                sokaProjekt();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sokaProjekt();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                sokaProjekt();
            }
        });
        
        jtxtSlutDatum.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                sokaProjekt();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                sokaProjekt();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                sokaProjekt();
            }
        });
        
       
    }

    private void sokaProjekt() {
        String startDatum = jtxtStartDatum.getText().trim();
        String slutDatum = jtxtSlutDatum.getText().trim();

        // Töm listan för att visa nya resultat
        model.clear();
        
        //Validera datumformatet
if ((!startDatum.isEmpty() && !startDatum.matches("\\d{4}-\\d{2}-\\d{2}")) ||
        (!slutDatum.isEmpty() && !slutDatum.matches("\\d{4}-\\d{2}-\\d{2}"))) {
        System.out.println("Datumet måste vara i formatet yyyy-mm-dd");
        return;
    }
        try {
            // Hämta avdelningen för inloggad handläggare
        String sqlFragaHandlaggareAvdelning = "SELECT avdelning FROM anstalld WHERE epost = '" + InloggadHandlaggare + "'";
        String handlaggareAvdelning = idb.fetchSingle(sqlFragaHandlaggareAvdelning);

             // Om avdelningen för handläggaren finns
        if (handlaggareAvdelning != null) {
            // Bygg SQL-frågan baserat på angivna datum
            StringBuilder sqlFragaProjekt = new StringBuilder("SELECT projektnamn, startdatum, slutdatum FROM projekt WHERE avdelning = '" + handlaggareAvdelning + "'");
            
            if (!startDatum.isEmpty()) {
                sqlFragaProjekt.append(" AND startdatum >= '").append(startDatum).append("'");
            }
            if (!slutDatum.isEmpty()) {
                sqlFragaProjekt.append(" AND slutdatum <= '").append(slutDatum).append("'");
            }

            System.out.println(sqlFragaProjekt.toString());
            ArrayList<HashMap<String, String>> sokaResultat = idb.fetchRows(sqlFragaProjekt.toString());

                // Loopa igenom resultatet och lägg till dem i listmodellen
            if (sokaResultat != null) {
                for (HashMap<String, String> rad : sokaResultat) {
                    // Skapa en sträng med HTML-formatering för varje projekt
                    String htmlFormattedItem = "<html><font color='gray'><b>Projekt:</b></font> " + rad.get("projektnamn") + "<br>"
                            + "<font color='gray'><b>Startdatum:</b></font> " + rad.get("startdatum") + "<br>"
                            + "<font color='gray'><b>Slutdatum:</b></font> " + rad.get("slutdatum") + "</html>";
                    model.addElement(htmlFormattedItem);
                    }
                }
            }
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    private void gatillhandlaggarmeny() {
        this.dispose();
        HandläggarMeny handläggarMeny = new HandläggarMeny(idb, InloggadHandlaggare);
        handläggarMeny.setVisible(false);
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
        btnGaTillbaka = new javax.swing.JButton();
        jtxtStartDatum = new javax.swing.JTextField();
        jtxtSlutDatum = new javax.swing.JTextField();
        jlblStartDatum = new javax.swing.JLabel();
        jlblSlutDatum = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Sök projekt");

        jLabel2.setText("Sök med formatet xxxx-xx-xx");

        btnGaTillbaka.setText("Gå tillbaka");
        btnGaTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGaTillbakaActionPerformed(evt);
            }
        });

        jtxtStartDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtStartDatumActionPerformed(evt);
            }
        });

        jtxtSlutDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtSlutDatumActionPerformed(evt);
            }
        });

        jlblStartDatum.setText("Startdatum");

        jlblSlutDatum.setText("Slutdatum");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGaTillbaka)
                .addGap(83, 83, 83)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addGap(139, 139, 139))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtStartDatum, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(jlblStartDatum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtSlutDatum, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(jlblSlutDatum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnGaTillbaka))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlblStartDatum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtStartDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlblSlutDatum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtSlutDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(193, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGaTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGaTillbakaActionPerformed
        // TODO add your handling code here:
        gatillhandlaggarmeny();
    }//GEN-LAST:event_btnGaTillbakaActionPerformed

    private void jtxtSlutDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtSlutDatumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtSlutDatumActionPerformed

    private void jtxtStartDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtStartDatumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtStartDatumActionPerformed

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
            java.util.logging.Logger.getLogger(SökaProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SökaProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SökaProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SökaProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new SökaProjekt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGaTillbaka;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jlblSlutDatum;
    private javax.swing.JLabel jlblStartDatum;
    private javax.swing.JTextField jtxtSlutDatum;
    private javax.swing.JTextField jtxtStartDatum;
    // End of variables declaration//GEN-END:variables
}
