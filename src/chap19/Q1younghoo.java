package chap19;

import java.util.Scanner;
import java.util.Stack;

public class Q1younghoo {
    
    public static final String open = "({["; // 0 : ( , 1 : { , 2 : [
    public static final String close = ")}]"; // 0 : ) , 1 : } , 2 : ]

    public static boolean checkBrackets(String input) {
        int len = input.length();
        
        Stack<Integer> stack = new Stack<Integer>();
        
        // indexOf는 문자열에서 해당 문자가 위치한 인덱스를 반환한다.
        // 이를 이용하여 여는 수식과 닫는 수식이 같은 모양인지를 판별하는데,
        // 문자열 open에서의 인덱스와 close에서의 인덱스가 같다면
        // 같은 모양이라고 할 수 있다.
        for (int j = 0; j < len; j++) {
            int c = input.charAt(j); // input 문자열의 j번째 문자 한조각
            if (open.indexOf(c) != -1) { // (, {, [ 중 하나에 해당하는 수식인 경우에는 스택에 집어넣는다.
                stack.push(c);
            } else { // ), }, ] 중 하나에 해당하는 수식인 경우에는 가장 최근에 스택에 저장된 수식과 비교한다. 
                
                if (stack.isEmpty()) {
                    return false;
                }
                
                if (open.indexOf(stack.peek()) == close.indexOf(c)) {
                    // 제대로 닫히는 문자열이라면 현재 스택에 있는 문자를 꺼내고, 다음 문자 검사로 넘어간다.
                    stack.pop();
                    continue;
                } else {
                    return false;  
                }
            }
        }
        return stack.isEmpty();
    }
    
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
		    
			String input = sc.next();
			if (checkBrackets(input)) {
			    System.out.println("YES"); 
			} else {
			    System.out.println("NO");
			}
		}
	}
}
