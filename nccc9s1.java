
import java.io.*;
import java.util.*;

public class nccc9s1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int T = readInt();
		
		while (T --> 0) {
			int a = readInt(), b = readInt(), c = readInt();
			boolean canForm = true;
			
			int lowest = Math.min(a, Math.min(b, c));
			
			a -= lowest; b -= lowest; c -= lowest;
			
			a -= c;
			if (b % 2 == 1) {
				a -= 2;
			}
			c = 0;
			b = 0;
	
			
			if (a >= 0 && a % 2 == 0) canForm = true;
			else canForm = false;
			
			String ans = canForm ? "YES" : "NO";
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


	
	
