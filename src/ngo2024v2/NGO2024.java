/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ngo2024v2;

import com.formdev.flatlaf.intellijthemes.FlatCobalt2IJTheme;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author hoffs
 */
public class NGO2024 {
    
    private static InfDB idb;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FlatCobalt2IJTheme.setup();
        
        try{
            idb = new InfDB("ngo_2024", "3306", "dbAdmin2024", "dbAdmin2024PW");
            new Inloggning(idb).setVisible(true);
            

        
        } catch (InfException ex){
            System.out.println(ex.getMessage());
        
        }
    }
    
}
