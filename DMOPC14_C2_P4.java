
import java.io.*;
import java.util.*;

public class DMOPC14_C2_P4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int n = readInt();
		
		int[] psa = new int[n+1];
		
		for (int i=1; i<=n; i++) {
			psa[i] = readInt();
			psa[i] += psa[i-1];
		}
		
		int q = readInt();
		
		for (int i=0; i<q; i++) {
			int l = readInt(), r = readInt();
			
			System.out.println(psa[r+1] - psa[l]);
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


	
	
