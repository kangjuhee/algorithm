package chap19;

public class Q2juhee {

	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		long a1 = 1983;
		long total = 1983;
		System.out.println((long)Math.pow(2,32));
		for(int i = 1; i < 6; i ++) {
				long x  =  total * 214013 +2531011;
				long y = (long) Math.pow(2,32);
				System.out.println(x + ", " + y);
				total =  (x) %  y;
				total = total % 10000 + 1;
				System.out.println("total : " + i+ " : "+ total);
			
//			else if(i!=1) {
//				System.out.println("first : "  + " : "+ total);
//				total = total % 10000 + 1;
//				System.out.println("total : " + i+ " : "+ total);
//			}
		}
	}

}
