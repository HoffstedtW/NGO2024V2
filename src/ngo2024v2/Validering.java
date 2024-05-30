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
    
   
    
    

    
    
    
    public static boolean valideraLid(String Lid) {
     boolean enLid = false;
    // Tillåter heltal och decimaler med en punkt
    String regex = "^(?!0)\\d{1,2}$|^100$";
    if (Lid.matches(regex)) {
        enLid = true;
    }
    return enLid;
    }


    
     public static boolean valideraPid (String Pid){
         boolean enPid = false;
    // Tillåter heltal och decimaler med en punkt
    String regex = "^(?!0)\\d{1,2}$|^100$";
    if (Pid.matches(regex)) {
        enPid = true;
    }
    return enPid;
    }
    
      public static boolean valideraSid (String Sid){
           boolean enSid = false;
    // Tillåter heltal och decimaler med en punkt
    String regex = "^(?!0)\\d{1,2}$|^100$";
    if (Sid.matches(regex)) {
        enSid = true;
    }
    return enSid;
    }
          
      
        
          
          
       public static boolean valideraavdid(String avdid) {
    boolean enavdid = false;
    // Tillåter heltal mellan 1 och 100
    String regex = "^[1-9][0-9]?$|^100$";
    if (avdid.matches(regex)) {
        enavdid = true;
    }
    return enavdid;
}
    
    

public static boolean valideraTelefonnummer(String telefonnummer) {
    // Validerar telefonnummer med hjälp av regex för att kontrollera att strängen innehåller 10-15 siffror
    String regex = "^[0-9]{10,15}$";
    return telefonnummer != null && telefonnummer.matches(regex);
}
    
  public static boolean valideraText (String enText) {
    boolean Text = false;
    String regex = "^[\\p{L}\\d\\s._,'-]+$"; // Lagt till \\d för siffror och _ samt ändrat regexet
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
    // Tillåter heltal och decimaler med en punkt
    String regex = "^\\d+(\\.\\d+)?$";
    if (ettNummer.matches(regex)) {
        Nummer = true;
    }
    return Nummer;
}
      public static boolean valideraNummerOchPunkt(String text) {
        return text.matches("[0-9.]+");
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


    
    



    
   
    

