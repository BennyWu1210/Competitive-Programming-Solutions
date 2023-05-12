
import java.io.*;
import java.util.*;

public class Usaco21janb3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		int[] a = new int[N], b = new int[N];
		
		for(int i=0; i<N; i++) a[i] = readInt();
		for(int i=0; i<N; i++) b[i] = readInt();
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		long res = 1;
		
		for(int i=N-1; i>=0; i--) {
			int j = i;
			while (j >= 0 && a[i] <= b[j]) {
				j --;
			}
			res *= (i-j);
		}
		
		
		System.out.println(res);
		
		
		
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


	
	
