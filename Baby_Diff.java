
import java.io.*;
import java.util.*;

public class Baby_Diff {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		for (int i=0; i<5; i++) {
			String a = readLine(), b = readLine();
			
			int counter = 0;
			for (int j=0; j<Math.min(a.length(), b.length()); j++) {
				if (a.charAt(j) == b.charAt(j)) {
					counter ++;
				}
				else {
					break;
				}
			}
			System.out.println(counter);
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


	
	
