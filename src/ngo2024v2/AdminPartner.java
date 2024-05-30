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
 * @author livlagercrantz
 */
public class AdminPartner extends javax.swing.JFrame {
private InfDB idb;
private JList<String> ListaPartner;
private String InloggadAdmin;


    
    /**
     * Creates new form AdminPartner
     */
    public AdminPartner(InfDB idb, String InloggadAdmin) {
        this.idb = idb;
        initComponents();
        this.InloggadAdmin = InloggadAdmin;
        
    
      
       try {
        String sqlFragaPartner = "Select * from partner" ; 
        ArrayList<HashMap<String, String>> ListaPersonal = idb.fetchRows(sqlFragaPartner);
        
        DefaultListModel<String> model = new DefaultListModel<>(); 
         // Skapar en sträng med HTML-formatering för varje anställd
        for (HashMap<String, String> rad : ListaPersonal) {
         String htmlFormattedItem =  "<html><font color='gray'><b>pid:</b></font> " + rad.get("pid") + "<br>"
                                          + "<font color='gray'><b>namn:</b></font> " + rad.get("namn") + "<br>"
                                          + "<font color='gray'><b>Kontaktperson:</b></font> " + rad.get("kontaktperson") + "<br>"
                                          + "<font color='gray'><b>Kontaktepost:</b></font> " + rad.get("kontaktepost") + "<br>"
                                          + "<font color='gray'><b>Telefonnummer:</b></font> " + rad.get("telefon") + "<br>"
                                          + "<font color='gray'><b>Adress:</b></font> " + rad.get("adress") + "<br>"
                                          + "<font color='gray'><b>Branch:</b></font> " + rad.get("branch") + "<br>"
                                          + "<font color='gray'><b>Stad:</b></font> " + rad.get("stad") + "</html>";
        model.addElement(htmlFormattedItem);
            
        }
       ListaPartner = new JList<>(model);
       
       JScrollPane scrollPane = new JScrollPane(ListaPartner);
            scrollPane.setBounds(20, 40, 500, 300); // Ange position och storlek för JScrollPane
    // Lägg till JScrollPane till JFrame
            getContentPane().add(scrollPane);

         } catch (InfException ex) {
        System.out.println(ex.getMessage());
    }
}

    
    private void gatilladminmeny () {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        gåtillbaka = new javax.swing.JButton();
        ändra = new javax.swing.JButton();
        läggtill = new javax.swing.JButton();
        tabort = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gåtillbaka.setText("Gå tillbaka ");
        gåtillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gåtillbakaActionPerformed(evt);
            }
        });

        ändra.setText("Ändra");
        ändra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ändraActionPerformed(evt);
            }
        });

        läggtill.setText("Lägg till");
        läggtill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                läggtillActionPerformed(evt);
            }
        });

        tabort.setText("Ta bort");
        tabort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tabortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gåtillbaka)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(läggtill)
                .addGap(18, 18, 18)
                .addComponent(ändra)
                .addGap(18, 18, 18)
                .addComponent(tabort)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ändra)
                    .addComponent(läggtill)
                    .addComponent(tabort)
                    .addComponent(gåtillbaka))
                .addContainerGap(271, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ändraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ändraActionPerformed
        // TODO add your handling code here:
        ÄndraPartner ÄndraPartnerFönster = new ÄndraPartner (idb, InloggadAdmin);
        
        ÄndraPartnerFönster.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_ändraActionPerformed

    private void tabortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tabortActionPerformed
        // TODO add your handling code here:
     TabortPartner TabortPartnerFönster = new TabortPartner (idb, InloggadAdmin);
     
     TabortPartnerFönster.setVisible(true);
     this.setVisible(false);
    }//GEN-LAST:event_tabortActionPerformed

    private void gåtillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gåtillbakaActionPerformed
        // TODO add your handling code here:
        gatilladminmeny();
    }//GEN-LAST:event_gåtillbakaActionPerformed

    private void läggtillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_läggtillActionPerformed
        // TODO add your handling code here:
        Läggatillpartner LäggatillpartnerFönster = new Läggatillpartner (idb, InloggadAdmin);
        
       LäggatillpartnerFönster.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_läggtillActionPerformed

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
            java.util.logging.Logger.getLogger(AdminPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new AdminPartner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gåtillbaka;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton läggtill;
    private javax.swing.JButton tabort;
    private javax.swing.JButton ändra;
    // End of variables declaration//GEN-END:variables
}