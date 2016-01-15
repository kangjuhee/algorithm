package chap19.alien;

import java.util.Scanner;

public class Q1younghoo {
    /**
     * signalGenerator로 직접 모든 배열을 만들어본 결과,
     * 3개의 예제 입력만 수행시켜봐도 10초가 넘어가는 것을 확인하였다.(수행 시간 : 16초)
     * 따라서 모든 배열을 만들어놓고 알고리즘을 수행한다면 훨씬 더 많은 시간이 소요된다.
     * 
     * @param n
     * @return
     */
    public static long[] signalGenerator(int n) {
        long a = 1983;
        long signal = 0;
        long[] arr = new long[n];
        
        for (int i = 0; i < n; i++) {
            signal = Math.floorMod(a, 10000) + 1;
            a = (long) ((a * 214013 + 2531011) % Math.pow(2, 32));
            arr[i] = signal;
        }
        return arr;
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
	        long[] arr = signalGenerator(N); // 입력 신호 배열
	        
	        int count = 0;
	        int first = 0;
	        int last = 0;
	        long sum = 0;
	        
	        // 탈출 조건
	        // first가 배열크기를 벗어나는 경우
	        while (first < N - 1) {
	            if (sum < K) {
	                sum += arr[first++];
	            } else if (sum == K) {
	                count++;
	                sum += arr[first++];
	            } else {
	                sum -= arr[last++];
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
