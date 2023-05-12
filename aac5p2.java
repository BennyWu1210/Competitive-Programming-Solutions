
import java.io.*;
import java.util.*;

public class aac5p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		long[] ans = new long[N+1];
				
		long base = Long.MAX_VALUE;
		boolean hasThree = false;
		
		for (int j=2; j<=N; j++) {
			System.out.println("? " + 1 + " " + j);
			System.out.flush();
			long ipt = readLong();
			base = Math.min(ipt, base);
			ans[j] = ipt;
			if (ipt == 3) hasThree = true;
		}
		
		if (base == 2 && hasThree) base = 1;
		System.out.print("! " + base);
		for (int j=2; j<=N; j++) {
			System.out.print(" " + (ans[j] / base));
		}
		System.out.println();
			
		
		
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


	
	
