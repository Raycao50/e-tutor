package comprehensive;
//E-tutor  (Comprehensive) ch01 Online Game 

import java.util.Scanner;
public class ch01{
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int i;
      while (input.hasNext()) {
          i = input.nextInt();
      
          switch(i){
          case 1:
        	  System.out.print("Person\n");
        	  break;
          case 2:
        	  System.out.print("Fairy\n");
        	  break;
          case 3:
        	  System.out.print("Dwarf\n");
        	  break;            
          }     
      }
          
    
    }
} 