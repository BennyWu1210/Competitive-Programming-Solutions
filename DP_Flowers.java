
import java.io.*;
import java.util.*;

public class DP_Flowers {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		// have to use segment tree...
		
		double a = (int)(Math.random()*21-10);
		int[] freq = new int[21];
		
		
		for (int i=0; i<100000; i++) {
			a = Math.floor(Math.random()*21-10);
			
			// System.out.println(a);
			freq[(int) (a + 10)] ++;
		}
		
		System.out.println(Arrays.toString(freq));
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


	
	
