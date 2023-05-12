
import java.io.*;
import java.util.*;

public class AndMatching_redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int t = readInt();
		
		while (t --> 0) {
			int n = readInt(), k = readInt();

			int[] ans = new int[n/2+1];
			
			for (int i=0; i<n/2; i++) {
				ans[i] = n - i - 1;
			}
			
			
			if (k == n-1) {
				if (n == 4) {
					System.out.println(-1);
					continue;
				}
				
			} else {
				ans[(int)Math.min(k, n-k-1)] = n - 1;
				for (int i=0; i<n/2; i++) {
					System.out.println(i + " " + ans[i]);
				}
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


	
	
