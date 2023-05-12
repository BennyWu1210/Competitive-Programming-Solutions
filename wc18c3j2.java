
import java.io.*;
import java.util.*;

public class wc18c3j2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int n = readInt();
		int best = 0, best2 = 0;
		
		for (int i=0; i<n; i++) {
			int nxt = readInt();
			if (nxt <= 100) {
				if (nxt > best) {
					best2 = best;
					best = nxt;
				}
				else if (nxt > best2) {
					best2 = nxt;
				}
			}
		}
		
		System.out.println(best + best2);
		
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


	
	
