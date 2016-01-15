package chap19.alien;

public class Q1younghoo {
	
	public static void main(String[] args) {
		
		long a = 1983;
		long signal = 0;
		int n = 50; // 반복 횟수
		
		for (int i = 0; i < n; i++) {
		    signal = Math.floorMod(a, 10000) + 1;
		    //a = Math.floorMod(a * 214013 + 2531011, Math.pow(2, 32));
		    a = (long) ((a * 214013 + 2531011) % Math.pow(2, 32));
		    System.out.println(signal);
		}
	}
}
