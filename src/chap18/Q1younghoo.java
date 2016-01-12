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
			// 蹂묒궗 list 珥덇린�솕
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < numOfPpl; i++) {
				list.add(i+1);
			}
			// �떎�젣 �븣怨좊━利� 援ы쁽遺�遺�
			int idx = 0;
			
			while (list.size() > 2) {
				int size = list.size(); // size backup
				list.remove(idx); // idx�뿉 �빐�떦�븯�뒗 蹂묒궗 �젣嫄�
				idx = (idx + skip - 1) % (size - 1);
			}
			
			// 寃곌낵媛� 異쒕젰
			Iterator<Integer> iterator = list.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		}
		sc.close();

	}
}