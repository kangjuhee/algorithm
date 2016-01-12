package chap18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1juhee {

	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);		
		int totalPlay, numPpl, kill;
		
		totalPlay = sc.nextInt();
		// numPpl(N=6)갯수를 받고 KILL(K=3)번째 아이를 죽인다.
		while(totalPlay > 1) {
			numPpl = sc.nextInt(); // 사람수 입력
			kill = sc.nextInt(); //몇번째 
//			System.out.println(totalPlay +" " + numPpl + " " + kill);
			
			List<Integer> solider = new ArrayList<Integer>(); 
			for(int i = 0; i < numPpl; i++) {
				solider.add(i + 1);
			}
			
			int index = 0; //죽일 인덱스
			int size = solider.size();
			while (size > 2) {
				solider.remove(index);
//				System.out.println("size : " + solider.size());
				
				index += (kill- 1); //다음 번 죽일 인덱스 선정
				size = solider.size();
				if(index >=  size) // index가 현재 array size보다 크면
					index = index  % size;
			} //while

			System.out.println("after suicided");
			for(int i = 0; i < solider.size(); i++){
				System.out.println(solider.get(i));
			}
		}
	}
}
