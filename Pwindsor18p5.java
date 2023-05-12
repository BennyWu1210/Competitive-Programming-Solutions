
import java.io.*;
import java.util.*;


public class Pwindsor18p5 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static final long MAX = (long)1e9 + 7;
	
	public static void main(String[] args) throws IOException {
		long num = readLong();
		long ans = 0;
//		for(int i=1; i<num/2; i++) {
//			long remain = num % i;
//			long cur = ((long) Math.pow(i, (num-remain-i)/i)% MAX * (remain+i)% MAX) % MAX;
//			ans = Math.max(ans, cur);
//			cur = ((long) Math.pow(i, (num-remain)/i) % MAX * remain % MAX) % MAX;
//			
//
//			ans = Math.max(ans, cur);
//			
//		}
//		
//		System.out.println(ans%MAX);
		
		ans = 1;
		if (num == 2 || num == 3) ans = num-1;
		
		while(num > 4) {
			num -= 3;
			ans *= 3 % MAX;
			ans %= MAX;
		}
		
		System.out.println(ans * num % MAX);
		
		
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


	
	
