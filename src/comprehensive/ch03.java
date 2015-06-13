package comprehensive;
//E-tutor  (Comprehensive) ch03
import java.util.Scanner;
public class ch03{
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      int i;
      while (input.hasNext()) {
          i = input.nextInt();
      
          switch(i%2){
          case 1:
        	  System.out.print("odd\n");
        	  break;
          case 0:
        	  System.out.print("even\n");
        	  break;
              
          }     
      }
          
    
    }
} 