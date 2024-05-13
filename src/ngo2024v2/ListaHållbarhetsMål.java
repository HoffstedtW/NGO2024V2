/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngo2024v2;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultListModel;
import oru.inf.InfDB;
import oru.inf.InfException;
/**
 *
 * @author jerry
 */
public class ListaHållbarhetsMål {
    private InfDB idb;
   
public ListaHållbarhetsMål(InfDB idb){
    this.idb = idb;
    
    
        try {
            String sqlFraga = "SELECT * FROM hallbarhetsmal";
            ArrayList<HashMap<String, String>> ListaHållbarhetsMål = idb.fetchRows(sqlFraga);
            
                    // Skapa en modell för listan
            DefaultListModel<String> model = new DefaultListModel<>();

            // Loopa igenom resultaten och lägg till dem i listmodellen
            for (HashMap<String, String> rad : ListaHållbarhetsMål) {
                model.addElement(rad.get("mal"));
            }

            
        } catch (InfException ex) {
            System.out.println(ex.getMessage());
        }
        
}

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
           
}
