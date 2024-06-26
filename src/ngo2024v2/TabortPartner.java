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
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author livlagercrantz
 */
public class TabortPartner extends javax.swing.JFrame {
    private InfDB idb;
    private String InloggadAdmin;
    private JList<String> partnerlista;
    private HashMap<String, String> selectedPartner;
    private DefaultListModel<String> model;
    
    /**
     * Creates new form TabortPartner
     */
    public TabortPartner(InfDB idb, String InloggadAdmin, HashMap<String, String> selectedPartner) {
        initComponents();
        this.idb = idb;
        this.selectedPartner = selectedPartner;
        this.model = new DefaultListModel<>();
        fyllPartnerLista();
    }
    public TabortPartner(InfDB idb, String InloggadAdmin) {
        this.idb = idb;
        this.InloggadAdmin = InloggadAdmin;
        this.model = new DefaultListModel<>();
        initComponents();
        fyllPartnerLista();
    }
    
    
       private void gatillAdminPartner() {
          this.dispose();
          AdminPartner AdminPartnerFönster = new AdminPartner (idb, InloggadAdmin);
          AdminPartnerFönster.setVisible(true);
      }
    
       
         // Fyller partnerlistan med data från databasen
    private void fyllPartnerLista(){
        if (selectedPartner == null) {
            System.out.println("selectedPartner är null");
            return;
        }
        try {
            String projektId = selectedPartner.get("pid");
            // Hämta projekten där den inloggade användaren är projektchef
            String sqlFragaPartner = "SELECT partner.pid, partner.namn, kontaktperson, kontaktepost, telefon, adress, branch, land " +
                                     "FROM partner " +
                                     "JOIN projekt_partner ON partner.pid = projekt_partner.partner_pid " +
                                     "JOIN projekt ON projekt.pid = projekt_partner.pid " +
                                     "WHERE projekt.pid = '" + projektId + "'";
            ArrayList<HashMap<String, String>> listaPartners = idb.fetchRows(sqlFragaPartner);

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
    
  
       
       
       
       
       
       
       
       
       
   public void tabortpartner() {
    try {
       
        String partnerID = txtPID.getText();

        String sqlFraga = "DELETE FROM projekt_partner WHERE partner_pid = '" + partnerID + "' ";
        idb.delete(sqlFraga);
        String sqlRaderaPartner = "DELETE FROM partner WHERE pid = '" + partnerID + "'";
        idb.delete(sqlRaderaPartner);

        JOptionPane.showMessageDialog(this,"Partner med PID " + partnerID + " har raderats.");
        model.clear(); // Töm listmodellen för att uppdatera listan
        fyllPartnerLista(); // Uppdatera listan

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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPID = new javax.swing.JTextField();
        jraderapartner = new javax.swing.JButton();
        jgåtillbaka = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ta bort partner");

        jLabel3.setText("Skriv i PID på den partner du vill radera");

        jraderapartner.setText("Radera partner");
        jraderapartner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jraderapartnerActionPerformed(evt);
            }
        });

        jgåtillbaka.setText("Gå tillbaka ");
        jgåtillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jgåtillbakaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jgåtillbaka)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jraderapartner)
                            .addComponent(txtPID, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(50, 50, 50)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtPID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jraderapartner)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jgåtillbaka)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jgåtillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jgåtillbakaActionPerformed
        // TODO add your handling code here:
        gatillAdminPartner();
    }//GEN-LAST:event_jgåtillbakaActionPerformed

    private void jraderapartnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jraderapartnerActionPerformed
       tabortpartner();
    }//GEN-LAST:event_jraderapartnerActionPerformed

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
            java.util.logging.Logger.getLogger(TabortPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabortPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabortPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabortPartner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TabortPartner().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton jgåtillbaka;
    private javax.swing.JButton jraderapartner;
    private javax.swing.JTextField txtPID;
    // End of variables declaration//GEN-END:variables
}
