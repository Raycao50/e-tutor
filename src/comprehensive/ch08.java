package comprehensive;
//E-tutor 綜合 (Comprehensive) ch08 計算MVP數值 (得分*1＋助攻*2＋籃板*2＋抄截*2)－(失誤*2)
import java.util.Scanner;

public class ch08 {
	public static void main(String[] args) {
	      Scanner input = new Scanner(System.in);
	      int a,b,c,d,e;
	      int mvp;
	      while (input.hasNext()) {
	          a = input.nextInt();
	          b = input.nextInt();
	          c = input.nextInt();
	          d = input.nextInt();
	          e = input.nextInt();

	      mvp = (a*1+b*2+c*2+d*2)-(e*2);
	      
	      if(mvp>45){
        	  System.out.print("A\n");
	      }else if(mvp<45&&mvp>=35){
        	  System.out.print("B\n");
	      }else if(mvp<35&&mvp>=25){
	    	  System.out.print("C\n");
	      }else if(mvp<25){
	    	  System.out.print("D\n");
	      }    
	      }	          
	    }

}
