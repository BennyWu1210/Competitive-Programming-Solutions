
import java.io.*;
import java.util.*;

public class dmopc21c6p1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int len = readInt();
		char[] s = readLine().toCharArray();
		
		for (int i=0; i<s.length-1; i++) {
			if (s[i] < s[i+1]) {
				int temp = s[i];
				s[i] = s[i+1];
				s[i+1] = (char) temp;
				break;
			}
		}
		
		System.out.println(s);
	
		
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


	
	
