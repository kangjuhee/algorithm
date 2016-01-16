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
		// numPpl(N=6)������ �ް� KILL(K=3)��° ���̸� ���δ�.
		while(totalPlay > 1) {
			numPpl = sc.nextInt(); // ����� �Է�
			kill = sc.nextInt(); //���° 
//			System.out.println(totalPlay +" " + numPpl + " " + kill);
			
			List<Integer> solider = new ArrayList<Integer>(); 
			for(int i = 0; i < numPpl; i++) {
				solider.add(i + 1);
			}
			
			int index = 0; //���� �ε���
			int size = solider.size();
			while (size > 2) {
				solider.remove(index);
//				System.out.println("size : " + solider.size());
				
				index += (kill- 1); //���� �� ���� �ε��� ����
				size = solider.size();
				if(index >=  size) // index�� ���� array size���� ũ��
					index = index  % size;
			} //while

			System.out.println("after suicided");
			for(int i = 0; i < solider.size(); i++){
				System.out.println(solider.get(i));
			}
		}
		sc.close();
	}
}
