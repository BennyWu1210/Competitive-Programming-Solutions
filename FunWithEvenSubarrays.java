
import java.io.*;
import java.util.*;

public class FunWithEvenSubarrays {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int t = readInt();
		
		while (t --> 0) {
			int n = readInt();
			int[] a = new int[n+1];
			for (int i=1; i<=n; i++) a[i] = readInt();
			
			int ind = n-1, consec = 1, ans = 0;
			while (ind > 0) {
				if (a[ind] == a[n]) {
					ind --;
					consec ++;
					continue;
				}
				
				consec = 0;
				ans ++;
				ind = ind - (n - ind);
			}
			
			System.out.println(ans);
			
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


	
	
