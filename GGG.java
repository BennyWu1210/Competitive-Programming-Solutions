
import java.io.*;
import java.util.*;

public class GGG {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {

		// finished on my laptop
		int n = readInt();
		int[] arr1 = new int[n];
		
		for (int i=0; i<n; i++) arr1[i] = readInt();
		
		
		int m = readInt();
		int[] arr2 = new int[m];
		
		for (int i=0; i<m; i++) arr2[i] = readInt();
		
		int max = Math.max(n, m);
		int min = Math.min(n, m);
		int[] dp = new int[max+1];
		
		Arrays.fill(dp, -1);
		
		int len = 0;
		for (int i=1; i<=min; i++) {
			if (arr2[arr1[i]] != -1) {
				
			}
		}
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


	
	
