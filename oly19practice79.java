
import java.io.*;
import java.util.*;

public class oly19practice79 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		char[] s = readLine().toCharArray();
		int l = Integer.MAX_VALUE, r = 0;
		
		for (int i=0; i<s.length; i++) {
			char c = s[i];
			if (c == 'A') l = Math.min(l, i);
			if (c == 'Z') r = Math.max(r, i);
		}
		
		System.out.println(r - l + 1);
		
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


	
	
