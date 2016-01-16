package chap19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q1juhee {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	
		int times;
		times = in.read() - 48; // 아스키 값으로 받는다.
		
		bracket[] input = new bracket[times];
		boolean[] status = new boolean[times];	
		for(int x = 0; x < times; x ++) { 	
			bracket b = new bracket();
			boolean bl = true;
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String str = reader.readLine();

			for(int i = 0; i < str.length(); i++){
				char c = str.charAt(i);
				if(i % 2 == 0) {//TODO 공백체크 하는 걸로 바꿔야댐 바보 ㅉㅉ
					b.brackets.add(Character.toString(c));
					System.out.println("here : "  + c);
					}
			}

			List<String> addme = new ArrayList<String>();
			int i = 0;
			String val;
			int lastIndex; //입력받은 input의 last index			

			for(int a = 0; a < b.brackets.size(); a++) { 
				// (왼쪽일 경우)test에 입력값을 넣고 (왼쪽일 경우)
				// (오른쪽일 경우) 입력값을 pop 한다 -- > need to check status
				val = b.brackets.get(i++); //input의 value를 순차적으로 get
				System.out.println("VAL : " +val);
				if(val.equals("{") || val.equals("(") || val.equals("[")){ //왼쪽의 값이면 addme에 add
					addme.add(val);	
				}
				else {  // 값이 오른쪽 문자일경우 
					String lastVal; //입력받은 input의 last value	
					lastIndex = addme.size()-1;
					lastVal = addme.get(lastIndex); // addme에 받은 마지막 원소(왼쪽 기호)를 꺼낸다		
					if(val.equals(")")) {
						if(lastVal.equals("(")) { System.out.println("ㅈ겹다:");					
							addme.remove(lastIndex);	status[times - 1]= true;
							}
						else {
							bl = false;	
							input[times - 1] = b;
							status[times - 1]= bl;
							break;
						}	
					} else if (val.equals("}")) {
						if(lastVal.equals("{")) {status[times - 1]= true;
							addme.remove(lastIndex);}
						else {
							bl = false; 
							input[times - 1] = b; 
							status[times - 1]=bl; 
							break;
							}
					} else if (val.equals("]")) {
						if(lastVal.equals("[")) {status[times - 1]= true;
							addme.remove(lastIndex);}
						else {
							bl = false; 
							input[times - 1] = b; 
							status[times - 1]=bl;
							break;
							}
					}
				System.out.println(x + " : " +  status[0]);
				if(lastIndex == 0) break;
				
				} // end of big else
			} // end of for
			
		}
		for ( int r = 0; r < times; r++ ) {
			System.out.println(status[r]);
		}
	} // end of class 
	
	public static class bracket {
		public  List<String> brackets = new ArrayList<String>();
//		public  boolean status = true;
	}
}

