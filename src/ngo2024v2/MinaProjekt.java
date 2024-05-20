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

    public MinaProjekt(InfDB idb, String InloggadHandlaggare) {
        this.idb = idb;
        this.InloggadHandlaggare = InloggadHandlaggare;
        initComponents();
        fyllProjektLista();
        
}  
        private void fyllProjektLista(){
try {
            // Hämta projekten där den inloggade användaren är projektchef
            String sqlFragaProjekt = "SELECT * FROM projekt join anstalld on aid = projektchef WHERE epost = '" + InloggadHandlaggare + "'";
            ArrayList<HashMap<String, String>> listaProjekt = idb.fetchRows(sqlFragaProjekt);

            // Skapa en modell för listan
            DefaultListModel<String> model = new DefaultListModel<>();

            // Loopa igenom resultaten och lägg till dem i listmodellen
            if (listaProjekt != null) {
            for (HashMap<String, String> rad : listaProjekt) {
                // Skapa en sträng med HTML-formatering för varje projekt
                String htmlFormattedItem = "<html><font color='gray'><b>Projekt Namn:</b></font> " + rad.get("projektnamn") + "<br>"
                                          + "<font color='gray'><b>Startdatum:</b></font> " + rad.get("startdatum") + "<br>"
                                          + "<font color='gray'><b>Slutdatum:</b></font> " + rad.get("slutdatum") + "<br>"
                                          + "<font color='gray'><b>Beskrivning:</b></font> " + rad.get("beskrivning") + "</html>";

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    /**
     * @param args the command line arguments
     */
    /**
     * @param args the command line arguments
     */
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
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
