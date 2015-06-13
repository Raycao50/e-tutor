package comprehensive;
//E-tutor ºî¦X (Comprehensive) ch09 The 3n + 1 problem

import java.util.Scanner;

public class ch09 {
	public static void main(String[] args) {
	      Scanner input = new Scanner(System.in);
	      int a,b;
	      int big,small;
	      
	      
	      while (input.hasNext()) {
	          a = input.nextInt();
	          b = input.nextInt();
	          int max = 0;
	          
	          if(a>b){
	        	  big = a; small = b;
	          }else{
	        	  big = b; small = a;
	          }
	          
	          for(int i = small;i<big;i++){
	        	int temp = 0;
	        	temp = good(i);
	        	if(temp>max){
	        		max = temp;
	        	} 	        	  
	          }
	          
	          
	    	  System.out.printf("%d %d %d\n",a,b,max);
	      }	          
	    }
	
	public static int good(int n){
		int temp2 = 1;
		
		if(n==1){
			return 1;
		}else{
		while(n!=1){
			if(n%2==0){
				 n = n/2;
				 temp2++;
			}else if(n%2==1){
				n = (n*3)+1;
				temp2++;
			}
		}
		return temp2;
		}		
	}
	
	
}

