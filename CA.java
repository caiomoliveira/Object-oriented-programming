//@ Author Caio Machado de Oliveira
// CA - Programming Object Oriented Approach
// Professor Ken Healy
package CAProgOOCaio;
// Libraries we are going to use
import java.util.Scanner; 
import java.io.*; 
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.regex.Pattern;


public class CA {

    public static void main(String[] args) throws FileNotFoundException  {
        // the main class where it is reading my file and storing the lines in a array list.
        try (Scanner myFile = new Scanner(new File("C:\\Users\\35383\\Desktop\\CCT College - IT\\OOB\\CA\\people.txt"))) {
            ArrayList<String> list = new ArrayList<>();
            while (myFile.hasNext()){
                list.add(myFile.next());
            }       
            
            // creating variables and storing each string.
            String firstName =  list.get(0);
            String surName = list.get(1);
            String age = list.get(2);
            String gender = list.get(3);
        
            //checking first name and surname as a text
            if (Pattern.matches("[a-zA-Z]+",firstName + surName)) { 
                System.out.println("Granted, your name  is correct!");
            }else{
                System.out.println("Sorry, there might be some error in your name ."); 
            }
            // Checking age as numbers
            if (Pattern.matches("[0-9]+" ,age)) { 
                System.out.println("Granted, your age is correct!");
            }else{
                System.out.println("Sorry, there might be some error in your age."); 
            }
            // Checking gender as M, F and T 
            if (Pattern.matches("^[MFTmft]$+",gender)) { 
                System.out.println("Granted, gender is correct!");
            }else{
                System.out.println("Sorry, there might be some error in your gender."); 
            }
        //Openning a new .txt file and storing the variables on it
            String fileName = "status.txt"; 
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
            writer.write(formatName(firstName, surName, gender));
            
            writer.newLine();
     
            writer.write(formatAge(age));  
            
            writer.close(); //
        }
        catch(Exception e){
            
            System.out.println("Error!");
        }
     
        
        
     
        
    } 
    // this part will check and set up in order the variables conditioning the gender 
    //first then surname and first letter of the name.
    public static String formatName(String firstName, String surName, String gender){
        String title = null;
        
        if (gender.equals("M") || gender.equals("m")){
            title = "Mr. ";
        }
        else if (gender.equals("F") || gender.equals("f")){
            title = "Ms. ";
        }
        else if (gender.equals("T") || gender.equals("t")){
            title = "Mx. ";
        }
        
        return title + surName + ", " + firstName.charAt(0);
    }
    // Checking the age then storing the status according to the age.
    public static String formatAge(String age){
        Integer ageNumber = Integer.parseInt(age);
        String status = null;
        if (ageNumber <= 18){
            status = "School";
        }
        else if(ageNumber >=19 && ageNumber<=25){
            status = "College";
        }    
        else if(ageNumber >=26 && ageNumber<=66){
            status = "Worker";
        }    
        else if (ageNumber >=67){
            status = "Retired";
        }
        
        return status;       
    }
    
    
    
    
}
