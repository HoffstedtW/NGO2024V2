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
public class ListaMinaProjekt {
    private InfDB idb;
    private String InloggadHandlaggare;
    
    public ListaMinaProjekt(InfDB idb) {
        this.idb = idb;
        this.InloggadHandlaggare = InloggadHandlaggare;
        
try {
        String sqlFraga = "select * from projekt where projektchef = '" + InloggadHandlaggare + "'";
        ArrayList<HashMap<String, String>> ListaMinaProjekt = idb.fetchRows(sqlFraga);
        
        DefaultListModel<String> model = new DefaultListModel<>();
        
        for (HashMap<String, String> rad : ListaMinaProjekt) {
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

