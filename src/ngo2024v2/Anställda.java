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
 * @author hampusdaven
 */
public class Anställda extends javax.swing.JFrame {
    
    private InfDB idb;
    private String InloggadAdmin;
    private JList<String> PersonalLista;

    /**
     * Creates new form Anställda
     */
    public Anställda(InfDB idb, String InloggadAdmin) {
        initComponents();
        this.idb = idb;
        this.InloggadAdmin = InloggadAdmin;
        
        try {
            // Hämta all personal
            String sqlFragaAllPersonal = "SELECT * FROM anstalld";
            ArrayList<HashMap<String, String>> ListaPersonal = idb.fetchRows(sqlFragaAllPersonal);

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

        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }

        
    }
    
    private void gatilladminmeny() {
        this.dispose();
        AdminMeny AdminMenyFönster = new AdminMeny(idb, InloggadAdmin);
        AdminMenyFönster.setVisible(false);
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
        btnGåtillbaka = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Anställda");

        btnGåtillbaka.setText("Gå tillbaka");
        btnGåtillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGåtillbakaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                .addComponent(btnGåtillbaka))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnGåtillbaka))
                .addContainerGap(271, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGåtillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGåtillbakaActionPerformed
       gatilladminmeny();
    }//GEN-LAST:event_btnGåtillbakaActionPerformed

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
            java.util.logging.Logger.getLogger(Anställda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Anställda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Anställda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Anställda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Anställda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGåtillbaka;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
