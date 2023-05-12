
import java.io.*;
import java.util.*;

public class aac4p1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt();
		String s = readLine();
		int[] a = new int[N];
		int max = -1, ind = -1;
		
		for (int i=0; i<N; i++) {
			if (s.charAt(i) == '0') {
				a[i] = readInt();
				if (a[i] >= max) {
					max = a[i];
					ind = i;
				}
				
			}
		}
		
		for (int j=ind; j<ind+N; j++) {
			char c = s.charAt(j % N);
			if (c == '0') continue;
			System.out.print(c);
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


	
	
