package comprehensive;
//E-tutor 綜合 (Comprehensive) ch07標準體重計算
import java.util.Scanner;
public class ch07{
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      double i,result;
      int j;
      while (input.hasNext()) {
          i = input.nextDouble();
          j = input.nextInt();
       
          if(j==1){
        	  result = (i-80)*0.7;
        	  System.out.printf("%.1f\n",result);	        

          }else if(j==2){
        	  result = (i-70)*0.6;
        	  System.out.printf("%.1f\n",result);	        


          }
          
          
      }
    }
} 