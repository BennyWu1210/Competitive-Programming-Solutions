
import java.io.*;
import java.util.*;

public class Acc8_P3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int max = (int)1e8;
	
	static char[] ans = new char[max];
	static int[] dp = new int[max];
	static HashMap<Integer, Integer> mp = new HashMap<>();
	static long sum;
	static int index = 0;
	static int len;
	
	static int fib(int n, int m, long[] dig) {
		if (n == 1 || n == 2) return dp[n] = 1;
		if (dp[n] != -1) return dp[n];
		
		dp[n] = (fib(n-1, m, dig) + fib(n-2, m, dig)) % m;
		
		long digits = (long) Math.floor(Math.log10(dp[n]* 10));
		sum += digits;
		
		if (index >= len) {
			System.exit(0);
		}
		while (sum > dig[index]) {
			if (index >= len) {
				System.exit(0);
			}
			long d = sum - dig[index];
			long num = (long) (dp[n] % (Math.pow(10, d+1)) / Math.pow(10, d));
			
			index ++;
			System.out.println(num);
		}
		
//		int curDig = (int)Math.ceil(Math.log(dp[n]*10));
//		int prevDig = (int)Math.ceil(Math.log(dp[n-1]*10));
//		if (curDig > prevDig) {
//			mp.put(curDig, n);
//		}
		
		return dp[n];
	}
	
	public static void main(String[] args) throws IOException {

				
		
		int m = readInt(), q = readInt();
		len = q;
		sum = 0;
		
		Arrays.fill(dp, -1);
		
		
		long[] dig = new long[q];
		for (int t=0; t<q; t++) {
			dig[t] = readLong();			
		}
		
		Arrays.sort(dig);
		
		fib(1000, m, dig);
		
//		int digits = 1;
//		int index = 0;
//		long sum = 0;
		
//		System.out.println(mp);
		
		
//		for (int t=0; t<q; t++) {
//			long key = dig[t];
//			
//			while (key > sum) {
//				index ++;
//				if (Math.floor(Math.log10(dp[index] * 10)) > digits) {
//					digits = (int)Math.floor(Math.log10(dp[index] * 10));
//				}
//				sum += digits;
//				
//			}
//			
//			long num = dp[index];
//			if (sum >= key){
//				long d = sum - key ;
//				sum -= digits;
//				index --;
//				num = (long) (num % (Math.pow(10, d+1)) / Math.pow(10, d));
//				
//			}
//			
//			System.out.println(num);
//		
//		}
		
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}


	
	
