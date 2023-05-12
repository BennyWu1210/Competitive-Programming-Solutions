
import java.io.*;
import java.util.*;

public class B_FortuneTelling {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static Map<Long, Boolean> map;
	public static void main(String[] args) throws IOException {

		int T = readInt();
		
		while (T --> 0) {
			int n = readInt(); long x = readLong(), y = readLong();
			int[] a = new int[n+1];
			int odd = 0;
			for (int i=1; i<=n; i++) {
				a[i] = readInt();
				if (a[i] % 2 == 1) odd ++;
			}
			
			boolean ans;
			if (x % 2 == 1) {
				if (y % 2 == 1) ans = odd % 2 == 0;
				else ans = odd % 2 == 1;
			}
			else {
				if (y % 2 == 0) ans = odd % 2 == 0;
				else ans = odd % 2 == 1;
			}
			String res = ans ? "Alice" : "Bob";
			System.out.println(res);
			
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


	
	
