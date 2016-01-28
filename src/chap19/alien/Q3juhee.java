package chap19.alien;
// P.636 외계신호분석
/**
 * input
 * 3
 * 8791 20
 * 5265 5000
 * 3578452 5000000
 * 
 * output
 * 1
 * 4
 * 1049
 * **/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Q3juhee {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int playTimes, count;
		long a, sum, forTimes, signal, goal;
		Queue<Long> sumList;

		List<Integer> N = new ArrayList<Integer>(); //합
		List<Integer> K = new ArrayList<Integer>();	//신호의 갯수
		List<Integer> eachCount = new ArrayList<Integer>(); //결과값

		playTimes = sc.nextInt(); 	

		for(int i = 0; i < playTimes; i++) {
			K.add(sc.nextInt()); 
			N.add(sc.nextInt());
		}
		
		for(int j = 0; j < playTimes; j++) {
			a = 1983; //초기값
			sum = 0;
			count = 0; //결과값
			goal = K.get(j);
			forTimes = N.get(j);
			 sumList= new LinkedList<Long>();
				
			for(int i = 0; i < forTimes; i++) {
				signal = a % 10000 + 1;
				a = (long)(a * 214013 + 2531011) % (long)Math.pow(2, 32);	
	
				sum += signal;
				sumList.add(signal);	
				while(sum > goal){ // 더했던 과정들을 취소
					sum -= sumList.remove();
				} 
				if(sum == goal) 
					count++;
				if(i == forTimes - 1) //for문의 i값이 마지막일 때
					eachCount.add(count);
			}  // end of for
		}
		//결과값 출력
		for(int i = 0; i < playTimes; i++) 
			System.out.println("count : " + eachCount.get(i) );
		sc.close();
	}

}
