
import java.io.*;
import java.util.*;

public class A_ProfSlim {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int t = readInt();
		
		while (t --> 0) {
			int n = readInt();
			int[] a = new int[n + 1];
			int seperator = -1, negs = 0;
			
			a[0] = Integer.MIN_VALUE;
			
			for (int i = 1; i <= n; i++) {
				int cur = readInt();
				if (cur < 0) negs ++;
				a[i] = Math.abs(cur);
		
			}

			boolean hasAns = true;
			for (int i = 1; i <= n; i++) {
				if (i <= negs) a[i] = -a[i];
				if (a[i] < a[i - 1]) {
					hasAns = false;
					break;
				}
			}
			
			String ans = hasAns ? "YES" : "NO";
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


	
	
