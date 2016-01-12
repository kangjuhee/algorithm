package chap18;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Q1younghoo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int numOfCase = sc.nextInt();
		
		for (int t = 0; t < numOfCase; t++) {
			
			int numOfPpl = sc.nextInt();
			int skip = sc.nextInt();
			// 병사 list 초기화
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < numOfPpl; i++) {
				list.add(i+1);
			}
			// 실제 알고리즘 구현부분
			int idx = 0;
			
			while (list.size() > 2) {
				list.remove(idx); // idx에 해당하는 병사 제거
				idx = (idx + skip - 1) % list.size();
			}
			
			// 결과값 출력
			Iterator<Integer> iterator = list.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		}
		sc.close();
	}
}