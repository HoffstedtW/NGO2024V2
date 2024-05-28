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
public class MinaProjekt extends javax.swing.JFrame {

    private InfDB idb;
    private String InloggadHandlaggare;
    private JList<String> projektLista;
    private ArrayList<HashMap<String, String>> listaProjekt;

    public MinaProjekt(InfDB idb, String InloggadHandlaggare) {
        this.idb = idb;
        this.InloggadHandlaggare = InloggadHandlaggare;
        initComponents();
        fyllProjektLista();
        
}  
    //Metod för att skapa en JList och fylla den med projekt
        private void fyllProjektLista(){
            try {
            // Hämta projekten där den inloggade användaren är projektchef
            String sqlFragaProjekt = "SELECT * FROM projekt join anstalld on aid = projektchef WHERE epost = '" + InloggadHandlaggare + "'";
            listaProjekt = idb.fetchRows(sqlFragaProjekt);

            // Skapa en modell för listan
            DefaultListModel<String> model = new DefaultListModel<>();

            // Loopa igenom resultaten och lägg till dem i listmodellen
            if (listaProjekt != null) {
            for (HashMap<String, String> rad : listaProjekt) {
                // Skapa en sträng med HTML-formatering för varje projekt
                String htmlFormattedItem = "<html><font color='gray'><b>Projekt Namn:</b></font> " + rad.get("projektnamn") + "<br>"
                                          + "<font color='gray'><b>Startdatum:</b></font> " + rad.get("startdatum") + "<br>"
                                          + "<font color='gray'><b>Slutdatum:</b></font> " + rad.get("slutdatum") + "<br>"
                                          + "<font color='gray'><b>Beskrivning:</b></font> " + rad.get("beskrivning") + "<br>"
                                          + "<font color='gray'><b>Kostnad:</b></font> " + rad.get("kostnad") + "<br>"
                                          + "<font color='gray'><b>Status:</b></font> " + rad.get("status") + "<br>"
                                          + "<font color='gray'><b>Prioritet:</b></font> " + rad.get("prioritet") + "<br>"
                                          + "<font color='gray'><b>Land:</b></font> " + rad.get("land") + "</html>";
                model.addElement(htmlFormattedItem);
            }
            } else {
                model.addElement("Inga projekt hittades.");
            }

            // Skapa en JList med modellen
            projektLista = new JList<>(model);

            // Lägg till JList till en JScrollPane för att göra det möjligt att rulla
            JScrollPane scrollPane = new JScrollPane(projektLista);
            scrollPane.setBounds(20, 40, 500, 300); // Ange position och storlek för JScrollPane

            // Lägg till JScrollPane till JFrame
            getContentPane().add(scrollPane);

        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }

        // Sätt JFrame till synlig efter att alla komponenter har lagts till
        this.setVisible(true);
    }
        //Metod för att koppla tillbaka-knappen för att gå till Projektchefmeny
private void gaTillProjektChefMeny() {
        this.dispose();
        ProjektChefMeny ProjektChefMeny = new ProjektChefMeny(idb, InloggadHandlaggare);
        ProjektChefMeny.setVisible(false);
}
    private MinaProjekt() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // </editor-fold>
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        btnTillbaka = new javax.swing.JButton();
        btnAndraUppgifter = new javax.swing.JButton();
        btnPartners = new javax.swing.JButton();
        btnHandLaggare = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnTillbaka.setText("Tillbaka");
        btnTillbaka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTillbakaActionPerformed(evt);
            }
        });

        btnAndraUppgifter.setText("Ändra uppgifter");
        btnAndraUppgifter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndraUppgifterActionPerformed(evt);
            }
        });

        btnPartners.setText("Partners");
        btnPartners.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPartnersActionPerformed(evt);
            }
        });

        btnHandLaggare.setText("Handläggare");
        btnHandLaggare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHandLaggareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnTillbaka)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPartners)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHandLaggare)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAndraUppgifter)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAndraUppgifter)
                    .addComponent(btnTillbaka)
                    .addComponent(btnPartners)
                    .addComponent(btnHandLaggare))
                .addGap(0, 277, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnTillbakaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTillbakaActionPerformed
        // Koppla knapp till metod:
        gaTillProjektChefMeny();
    }//GEN-LAST:event_btnTillbakaActionPerformed

    private void btnAndraUppgifterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndraUppgifterActionPerformed
        // Om det finns ett valt projekt, öppna redigeringsmeny för projektet:
   int selectedIndex = projektLista.getSelectedIndex();
        if (selectedIndex != -1 && listaProjekt != null) {
            HashMap<String, String> selectedProjekt = listaProjekt.get(selectedIndex);
            ÄndraProjektUppgifter newÄndraProjektUppgifter = new ÄndraProjektUppgifter(idb, selectedProjekt);
            newÄndraProjektUppgifter.setVisible(true);
        } else {
            System.out.println("Vänligen välj ett projekt att redigera.");
        }
    }//GEN-LAST:event_btnAndraUppgifterActionPerformed

    private void btnPartnersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPartnersActionPerformed
        // Om det finns ett valt projekt, öppna redigeringsmeny för projektparnter:
        int selectedIndex = projektLista.getSelectedIndex();
        if (selectedIndex != -1 && listaProjekt != null) {
            HashMap<String, String> selectedProjekt = listaProjekt.get(selectedIndex);
            Partnermeny newpartnermeny = new Partnermeny(idb, selectedProjekt);
            newpartnermeny.setVisible(true);
        } else {
            System.out.println("Vänligen välj ett projekt att redigera.");
        }
    }//GEN-LAST:event_btnPartnersActionPerformed

    private void btnHandLaggareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHandLaggareActionPerformed
        // Om det finns ett valt projekt, öppna redigeringsmeny för projekthandläggare:
            int selectedIndex = projektLista.getSelectedIndex();
        if (selectedIndex != -1 && listaProjekt != null) {
            HashMap<String, String> selectedProjekt = listaProjekt.get(selectedIndex);
            Projektchefhandläggare newProjektchefhandläggare = new Projektchefhandläggare(idb, selectedProjekt);
            newProjektchefhandläggare.setVisible(true);
        } else {
            System.out.println("Vänligen välj ett projekt att redigera.");
        }
    }//GEN-LAST:event_btnHandLaggareActionPerformed


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
            java.util.logging.Logger.getLogger(MinaProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MinaProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MinaProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MinaProjekt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MinaProjekt().setVisible(true);

}
            
        });
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAndraUppgifter;
    private javax.swing.JButton btnHandLaggare;
    private javax.swing.JButton btnPartners;
    private javax.swing.JButton btnTillbaka;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
