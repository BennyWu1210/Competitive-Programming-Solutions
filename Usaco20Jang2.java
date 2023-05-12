
import java.io.*;
import java.util.*;


public class Usaco20Jang2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		int max = (int)1e6;
		long[][] psa = new long[n+1][n+1];
		int[] freq = new int[max*2];
		int[] arr = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = readInt();
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=i+1; j<=n; j++) {
				int third = -(arr[i]+arr[j]) + max;
				if (third >= 0 && third < 2*max) psa[i][j] += freq[third];
				freq[arr[j]+max] ++;
			}
			for(int j=i+1; j<=n; j++) freq[arr[j]+max] = 0;
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				psa[i][j] += psa[i][j-1] + psa[i-1][j] - psa[i-1][j-1];
			}
		}
		for(; q>0; q--) {
			int a = readInt(), b = readInt();
			System.out.println(psa[b][b] - psa[a-1][b] - psa[b][a-1] + psa[a-1][a-1]);
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


	
	
