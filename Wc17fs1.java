
import java.io.*;
import java.util.*;


public class Wc17fs1 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int N = readInt(), c[] = new int[N], m[] = new int[N];
		
		for(int i=0; i<N; i++) c[i] = readInt();
		for(int i=0; i<N; i++) m[i] = readInt();
		
		Arrays.sort(c);
		Arrays.sort(m);
		int max = 0;
		for(int i=0; i<N; i++) {
			if (Math.abs(m[i] - c[i]) > max) {
				max = Math.abs(m[i] - c[i]);
			}
		}
		
			
		System.out.println(max);
		
		
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


	
	
