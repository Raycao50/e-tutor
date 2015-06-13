package comprehensive;
import java.util.Scanner;

//E-tutor ºî¦X (Comprehensive) ch04 ¦¨ÁZ§PÂ_

public class ch04 {
	 public static void main(String[] args) {
	      Scanner input = new Scanner(System.in);
	      int i;
	      while (input.hasNext()) {
	          i = input.nextInt();
	          if(i>100){
	        	  System.out.print("error\n");
	          }else{	          
	          switch(i/10){
	          case 10:
	        	  System.out.print("A\n");
	        	  break; 
	          case 9:
	        	  System.out.print("A\n");
	        	  break;
	          case 8:
	        	  System.out.print("B\n");
	        	  break;
	          case 7:
	        	  System.out.print("C\n");
	        	  break;     
	          case 6:
	        	  System.out.print("D\n");
	        	  break;
	          default:
	        	  System.out.print("E\n");
	        	  break; 
	          }}
	      }        
    }
}
