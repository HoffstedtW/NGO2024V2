/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ngo2024v2;
import oru.inf.InfDB;
import oru.inf.InfException;


/**
 *
 * @author hampusdaven
 */
public class Validering {
    
  
  
    
    public static boolean valideraLosenord (String losenord) {
        String regex = "^(?:[\\x21-\\x7E]){5,25}$";
        return losenord.matches(regex);
    }
    
    public static boolean valideraDatum (String datum) {
        String regex = "^(\\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
        return datum.matches(regex);
    }
    
   
    
    

    
    
    
    public static boolean valideraLid(InfDB idb, String Lid) {
    boolean kontrollLand = false;
    String fraga = "select lid from land where lid = " + Lid;
    try {
        // Anropa fetchSingle för att hämta land-ID från databasen
        String landID = idb.fetchSingle(fraga);
        
        // Om land-ID:t inte är null och det matchar det sökta land-ID:t, sätt kontrollOK till true
        if (landID != null && landID.equals(Lid)) {
            kontrollLand = true;
        }
    } catch (InfException ex) {
        // Vid fel, skriv ut felmeddelandet
        System.out.println(ex.getMessage());
    }
    return kontrollLand;
}


    
     public static boolean valideraPid (InfDB idb, String Pid){
        boolean kontrollPid = false;
        String fraga = "select pid from partner where pid = " + Pid;
        try{
            if(Pid.equals(idb.fetchSingle(fraga))){
                kontrollPid = true;
            }
        }
        catch (InfException ex){
            ex.getMessage();
        }
        return kontrollPid;
    }
    
      public static boolean valideraSid (InfDB idb, String Sid){
        boolean kontrollSid = false;
        String fraga = "select sid from stad where sid = " + Sid;
        try{
            if (Sid.equals(idb.fetchSingle(fraga))){
                kontrollSid = true;
            }
        }
        catch (InfException ex){
            System.out.println(ex.getMessage());
        }
        return kontrollSid;
    }
    
    public static boolean valideraTelefonnummer(String telefonnummer) {
        // Enkel validering för att kontrollera att strängen har formatet nnn-nnn-nnnn
        return telefonnummer != null && telefonnummer.matches("^\\d{3}-\\d{3}-\\d{4}$");
    }
    
    public static boolean valideraText (String enText) {
        boolean Text = false;
        String regex = "^[\\p{L}\\s .,'-]+$";
        if (enText.matches(regex)) {
            Text = true;
        }        
        return Text;
    }
    
     public static boolean valideraTextNummer (String TextNmr) {
        boolean textOkej = false;
        String regex = "^[\\p{L}\\d\\s .,'-]+$";
        if (TextNmr.matches(regex)) {
            textOkej = true;
        }
        return textOkej;
    }
    
      public static boolean valideraint (String ettNummer) {
        boolean Nummer = false;
        String regex = "^\\d+$";
        if (ettNummer.matches(regex)) {
            Nummer = true;
        }
        return Nummer;
    }
      
        public static boolean valideratomString (String Strang) {
        boolean tomString = false;
        String regex1 = "^$";
        String regex2 = "^\s*$";
        if(Strang.matches(regex1) || Strang.matches(regex2)) {
            tomString = true;
        }
        return tomString;
        
    }
    
         public static boolean valideraEpost(String Epost){
        boolean epostOkej = false;
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if (Epost.matches(regex)){
            epostOkej = true;
        }
       
        return epostOkej;
    }
        
}


    
    



    
   
    

