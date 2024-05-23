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
public class AdminAvdelning extends javax.swing.JFrame {
      
    private InfDB idb;
    private String InloggadAdmin;
    private JList<String> Avdelninglista;

    /**
     * Creates new form AdminAvdelning
     */
    public AdminAvdelning(InfDB idb, String InloggadAdmin) {
        initComponents();
         this.idb = idb;
        this.InloggadAdmin = InloggadAdmin;
        
         try {
            
            String sqlFragaLand = "SELECT * FROM avdelning";
             ArrayList<HashMap<String, String>> ListaPersonal = idb.fetchRows(sqlFragaLand);
             
             DefaultListModel<String> model = new DefaultListModel<>();
             
              for (HashMap<String, String> rad : ListaPersonal) {
                // Skapa en sträng med HTML-formatering för varje anställd
                String htmlFormattedItem = "<html><font color='gray'><b>avdid:</b></font> " + rad.get("avdid") + "<br>"
                                          + "<font color='gray'><b>namn:</b></font> " + rad.get("namn") + "<br>"
                                          + "<font color='gray'><b>beskrivning:</b></font> " + rad.get("beskrivning") + "<br>"
                                          + "<font color='gray'><b>adress:</b></font> " + rad.get("adress") + "<br>"
                                           + "<font color='gray'><b>epost:</b></font> " + rad.get("epost") + "<br>"
                                           + "<font color='gray'><b>telefon:</b></font> " + rad.get("telefon") + "<br>"
                                           + "<font color='gray'><b>stad:</b></font> " + rad.get("stad") + "<br>"
                                         + "<font color='gray'><b>chef:</b></font> " + rad.get("chef") + "</html>";
             model.addElement(htmlFormattedItem);
            }
              
                Avdelninglista = new JList<>(model);

            // Lägg till JList till en JScrollPane för att göra det möjligt att rulla
            JScrollPane scrollPane = new JScrollPane(Avdelninglista);
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
        AdminMenyFönster.setVisible(true);
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
        btnGatillbaka = new javax.swing.JButton();
        btnLaggtill = new javax.swing.JButton();
        btnAndra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Avdelningar");

        btnGatillbaka.setText("Gå tillbaka");
        btnGatillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGatillbakaActionPerformed(evt);
            }
        });

        btnLaggtill.setText("Lägg till");
        btnLaggtill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaggtillActionPerformed(evt);
            }
        });

        btnAndra.setText("Ändra");
        btnAndra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnAndra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLaggtill)
                .addGap(18, 18, 18)
                .addComponent(btnGatillbaka)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnGatillbaka)
                    .addComponent(btnLaggtill)
                    .addComponent(btnAndra))
                .addGap(0, 277, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGatillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGatillbakaActionPerformed
        gatilladminmeny();
    }//GEN-LAST:event_btnGatillbakaActionPerformed

    private void btnLaggtillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaggtillActionPerformed
        LäggtillAvdelning LäggtillAvdelningFönster = new LäggtillAvdelning(idb, InloggadAdmin);
        
        LäggtillAvdelningFönster.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLaggtillActionPerformed

    private void btnAndraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraActionPerformed
        ÄndraAvdelning ÄndraAvdelningFönster = new ÄndraAvdelning(idb, InloggadAdmin);
        
        ÄndraAvdelningFönster.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAndraActionPerformed

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
            java.util.logging.Logger.getLogger(AdminAvdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminAvdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminAvdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminAvdelning.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new AdminAvdelning().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAndra;
    private javax.swing.JButton btnGatillbaka;
    private javax.swing.JButton btnLaggtill;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}