
import java.io.*;
import java.util.*;

public class ac19p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		int N = readInt(), L = readInt();
		
		char[] c = readLine().toCharArray();

		for (int i = 0; i < c.length; i++) {
			
			if (c[i] == ' ') System.out.print(c[i]);
			else {
				System.out.print((char)((L % 26 + (c[i] - 'a')) % 26 + 'a'));
			}
		}
		
		System.out.println();
		
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


	
	
