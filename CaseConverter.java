/**
 *Program: CaseConverter.java
 *Course: CSCI145
  *Purpose: Case conversion for alphabetic userOptions.
 *Author: Jacob Wadowski
 *Date: Due 4/8/14
  */

import java.util.Scanner;

public class CaseConverter {
   
   public static void main(String[] args){
      boolean toUpper = false, toLower = false;
      int offset = (int)'a' - (int)'A';
      boolean valid = false;
      
      //prompt for user's option, and get user's input
      while(valid == false){
         System.out.println("Case converter option: (U/u for uppercase, L/l for lowercase)");
         
         Scanner console = new Scanner(System.in); 
         
         String input = console.nextLine(); 
         char userOption = input.charAt(0);      
         
         if (userOption == 'U' || userOption == 'u') {
            System.out.println("You chose " + userOption);
            toUpper = true;
            toLower = false;
            valid = true;
         } 
         else if (userOption == 'L' || userOption == 'l') {
            System.out.println("You chose " + userOption);
            toUpper = false;
            toLower = true;
            valid = true;
         } 
         else{
            //Input is invalid. Loop again.
            System.out.println("You did not type either an uppercase \"U\" or \"L\" or lowercase \"u\" or \"l\"");
         }
      }
   
      //prompt for input string, and get user's input
      System.out.println("Enter an input string:");
      Scanner console = new Scanner(System.in);
      String input = console.nextLine();
      
      if(toLower == true){ //user wants to convert to all lowercase
         for (int i=0; i<input.length(); i++) {
            char charToConvert = input.charAt(i);
            if((charToConvert>=65) && (charToConvert<=90)){  //indexed character was uppercase
               charToConvert = CaseConverter.to_lower(charToConvert, offset); //Call to_lower method
               System.out.print(charToConvert); 
            }
            else{
               if((charToConvert>=97) && (charToConvert<=122)){  //indexed character was lowercase
                  System.out.print(charToConvert); //do not convert the character. Output.
               }
            }
         }  
      }
      else{ //user wanted to convert to all uppercase
         for (int i=0; i<input.length(); i++) {
            char charToConvert = input.charAt(i);
            if((charToConvert>=97) && (charToConvert<=124)){ //indexed character was lowercase
               charToConvert = CaseConverter.to_upper(charToConvert, offset); //Call to_upper method
               System.out.print(charToConvert);                    
            }
            else{
               if((charToConvert>=65) && (charToConvert<=90)){ //indexed character was uppercase
                  System.out.print(charToConvert); //do not convert the character. Output.
               }
            }
         }       
      }                             
   }        
      
   //for each userOption of input, do conversion if needed. And output it on screen
      
   //method to_upper
   /*purpose: convert a lower-case characer to upper-case, all other
    userOption are returned unchanged*/
   public static char to_upper(char charToConvert, int offset) {
      char convertedChar;
      convertedChar = charToConvert -= offset;
      return convertedChar;
   }

   //method to_lower
   /*purpose: convert a upper-case characer to lower-case, all other
    userOption are returned unchanged*/
   public static char to_lower(char charToConvert, int offset) {
      char convertedChar;
      convertedChar = charToConvert += offset;
      return convertedChar;     
   }   
}
