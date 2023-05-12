
import java.io.*;
import java.util.*;

public class oly22practice82 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		
		String A = readLine(), B = readLine();
		
		outer: for (int i = 0; i < 26; i++) {
			
			for (int c = 0; c < A.length(); c++) {
				if ((A.charAt(c) + i) % 26 + 'a' != B.charAt(c)) continue outer;
			}
			
			System.out.println("Yes");
			return;
		}
		
		System.out.println("No");
		
		
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


	
	
