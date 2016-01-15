package chap19;

import java.util.Scanner;

public class Q1younghoo {

	public static void main(String[] args) {
		
		// indexOf는 문자열에서 해당 문자가 위치한 인덱스를 반환한다.
		// 이를 이용하여 여는 수식과 닫는 수식이 같은 모양인지를 판별하는데,
		// 문자열 open에서의 인덱스와 close에서의 인덱스가 같다면
		// 같은 모양이라고 할 수 있다.
		String open = "({["; // 0 : ( , 1 : { , 2 : [
		String close = ")}]"; // 0 : ) , 1 : } , 2 : ]
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			
			String inputStr = sc.next();
			System.out.println(inputStr.length());
			System.out.println(inputStr.charAt(0));
				
		}
	}
}
