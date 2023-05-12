import java.util.HashMap;

public class gridTraveler {

	public static long travel(int m, int n) {
		if (m == 1 && n == 1) return 1;
		if (m == 0 || n == 0) return 0;
		return travel(m-1, n) + travel(m, n-1);
	} 
	
	public static long factorial(long num) {
		if (num == 1) return 1;
		return num*factorial(num-1);
	}
	
	public static long travelMath(int m, int n) {
		int a = m-1;
		int b = n-1;
		int total = a+b;
		return factorial(total)/factorial(a)/factorial(b);
		
	}
	
	public static long travelDP(int m, int n, HashMap<String, Long> memo) {
		String key = m + ", " + n;
		if (memo.containsKey(key)) return memo.get(key);
		if (m == 1 && n == 1) return 1;
		if (m == 0 || n == 0) return 0;
		
		memo.put(key, travelDP(m-1, n, memo) + travelDP(m, n-1, memo));
		return memo.get(key);
		
	}
	
	
	public static void main(String[] args) {

		long startTime = 0;
		long endTime = 0;
		
		
//		System.out.println(travel(2, 3));
//		System.out.println(travel(3, 2));
//		System.out.println(travel(3, 3));
		
		int r = 16;
		int c = 16;
		
		startTime = System.currentTimeMillis();
		System.out.println(travel(r, c));
		endTime = System.currentTimeMillis();
		
		System.out.println("time (in nano): " + (endTime - startTime));
//		
//		startTime = System.currentTimeMillis();
//		System.out.println(travelMath(r, c));
//		endTime = System.currentTimeMillis();
//		
//		System.out.println("time (in nano): " + (endTime - startTime));
		
		startTime = System.currentTimeMillis();
		System.out.println(travelDP(r, c, new HashMap<String, Long>()));
		endTime = System.currentTimeMillis();
		
		System.out.println("time (in nano): " + (endTime - startTime));
		
	}

}
