
import java.io.*;
import java.util.*;

public class dmopc22c3p3 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		int[] a = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			a[i] = readInt();
			if (a[i] > sum || i > 1 && a[i] == sum) {
				System.out.println(-1);
				return;
			}
		}
		
		long ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				ans += Math.abs(a[i] - a[j]);
			}
		}
		
		System.out.println(ans);
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


	
	
