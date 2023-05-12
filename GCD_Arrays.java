
import java.io.*;
import java.util.*;

public class GCD_Arrays {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int T = readInt();
		
		while (T --> 0) {
			int l = readInt(), r = readInt(), k = readInt();
			
			if (l == r && l != 1) {
				System.out.println("YES");
				continue;
			}
			int req = 0;
			if (l % 2 == 1) {
				l --;
			}
			if (r % 2 == 1) {
				r ++;
			}
			req += (r - l) / 2;
			
			if (req <= k) System.out.println("YES");
			else System.out.println("NO");
			
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


	
	
