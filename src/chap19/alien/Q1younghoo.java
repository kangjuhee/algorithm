package chap19.alien;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1younghoo {
    
    public class SignalGenerator {
        long a;
        long signal;
        
        public SignalGenerator() {
            init();
        }
        
        private void init() {
            this.a = 1983;
            this.signal = 0;
        }
        
        public long next() {
            this.signal = Math.floorMod(this.a, 10000) + 1;
            this.a = (long) ((this.a * 214013 + 2531011) % Math.pow(2, 32));
            return this.signal;
        }
    }
    
	public static void main(String[] args) {
	    
	    Scanner sc = new Scanner(System.in);
	    int numOfCase = sc.nextInt();
	    
	    // 예제 입력
	    // 3
	    // 8791 20
	    // 5265 5000
	    // 3578452 5000000
	    for (int t = 0; t < numOfCase; t++) {
	        int K = sc.nextInt(); // 부분 수열의 합
	        int N = sc.nextInt(); // 수열 갯수
	        Q1younghoo main = new Q1younghoo();
	        Q1younghoo.SignalGenerator signalGenerator = main.new SignalGenerator();
	        
	        int count = 0;
	        Queue<Long> queue = new LinkedList<Long>();
	        long sum = 0;

	        for (int i = 0; i < N; i++) {
	            long signal = signalGenerator.next();
	            sum += signal;
	            queue.add(signal);
	            
	            while (sum > K) {
	                sum -= queue.peek();
	                queue.poll();
	            }
	            
	            if (sum == K) {
	                count++;
	            }
	        }
	        System.out.println(count);
	    }
	    // 예제 출력
	    // 1
	    // 4
	    // 1049
	}
}
