package chap19;

import java.util.ArrayList;
import java.util.List;

public class Q1juhee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> input = new ArrayList<String>();
		input.add("(");
		input.add("[");
		input.add("]");
		input.add(")"); //아스키 번호로 접근할수 잇을까?
		List<String> addme = new ArrayList<String>();

		int i = 0;
		String lastVal;
		String val;
		boolean status = true;
		while(status) {
			// (왼쪽일 경우)test에 입력값을 넣고 (왼쪽일 경우)
			// (오른쪽일 경우) 입력값을 pop 한다 -- > need to check status
			int lastIndex;
			System.out.println("왼쪽");
			val = input.get(i++);
			if(val == "(" || val == "{" || val == "["){
				addme.add(val);
			}
			else {  // 처음 입력받은 값이 오른쪽 문자일경우 
				System.out.println("오른쪽");
				lastVal = addme.get(addme.size()-1); // addme에 받은 마지막 원소를 꺼낸다
				lastIndex = addme.size()-1;
				System.out.println(lastVal + " , " + lastIndex );
				if(val == ")") {
					if(lastVal == "(") 
					{
						addme.remove(lastIndex);
					}
					else {
						status = false;
					}
				} else if (val == "}") {
					if(lastVal == "{") {
						addme.remove(lastIndex);
					}
					else {
						status = false;
					}
				} else if (val == "]") {
					if(lastVal == "[") {
						addme.remove(lastIndex);
					}
					else {
						status = false;
					}
				}
			if(lastIndex == 0) break;
			} // end of big else
		} // end of while
		
		if(status) System.out.println("ture" );
		else System.out.println("false");
	}

}
