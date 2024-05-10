/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngo2024v2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            ArrayList<HashMap<String,String>> listaHållbarhetsMål = idb.fetchRows("SELECT * FROM hallbarhetsmal");
        } catch (InfException ex) {
            Logger.getLogger(ListaHållbarhetsMål.class.getName()).log(Level.SEVERE, null, ex);
        }
}
           
}
