package comprehensive;
//E-tutor ∫Ó¶X (Comprehensive) ch20 µsπ”≈ÂªÓ

import java.util.Scanner;
import java.util.ArrayList;

public class ch20{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		int pile;
		
		while (input.hasNext()) {
			pile = input.nextInt();
		    //System.out.printf("piles : %d",pile);

			ArrayList<Integer> integerList = new ArrayList<Integer>(); 
			Scanner input2 = new Scanner(System.in);
			int money,result=0;
			
			int judge = 0;
			
			int i = 0;
			while(i<pile){
				money = input2.nextInt();
				integerList.add(money);
				i++;
			}
									
			if(integerList.size()>3){
				for(int j = 0;j<integerList.size();j++){
					int k = integerList.get(j);
					if(k>1){
						judge++;
					}
				}
				if(judge>=2){result = 1;}
			}else if(integerList.size()==2){
				for(int j = 0;j<integerList.size();j++){
					int k = integerList.get(j);
					if(k>1){
						judge++;
					}
				}
				if(judge==1){result = 1;}
			}else{result = 1;}
	
			if(result==1){
				System.out.print("yes\n");
			}else{System.out.print("no\n");}
			
		}
	}
}
