package comprehensive;
//E-tutor (Comprehensive) ch05
import java.util.Scanner;

public class ch05{
	 public static void main(String[] args) {
	      Scanner input = new Scanner(System.in);
	      int a,b,c;
	      int max,min,mid;
	      while (input.hasNext()) {
	          a = input.nextInt();
	          b = input.nextInt();
	          c = input.nextInt();
	          
	          if(a>b){
	        	  max = a;
	        	  min = b;
	          }else{max = b; min = a; }
	          
	          if(max>c){
	        	  if(min>c){
	        		  mid = min;
	        		  min = c;
	        	  }else{
	        		  mid = c;
	        	  }	  
	          }else{
	        	  mid = max;
	        	  max = c;
	          } 
        	  System.out.printf("%d>%d>%d\n",max,mid,min);	        
	      }	          
	    }
}
