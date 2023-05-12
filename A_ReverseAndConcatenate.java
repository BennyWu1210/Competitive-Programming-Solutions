
import java.io.*;
import java.util.*;

public class A_ReverseAndConcatenate {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int T = readInt();
		
		while (T --> 0) {
			int N = readInt(), K = readInt();
			char[] t = readLine().toCharArray();
			if (K < 1) {
				System.out.println(1);
				continue;
			}
			
			boolean isPal = true;
			
			for (int i=0, j=t.length-1; i<t.length; i++, j--) {
				if (t[i] != t[j]) {
					isPal = false;
					break;
				}
			}
			
			int ans;
			
			if (isPal) {
				ans = 1;
			} else {
				ans = 2;
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


	
	
