package comprehensive;
//E-tutor  (Comprehensive) ch02 Online Game 

import java.util.Scanner;
public class ch02{
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      String s;
      while (input.hasNext()) {
          s = input.nextLine();
 
          if(s.equals("E")){
        	System.out.print("ByeBye\n");
          }
          if(s.equals("M")){
          	System.out.print("Male\n");
          }
          if(s.equals("F")){
          	System.out.print("Female\n");      	  
          }          
      }         
    }
} 