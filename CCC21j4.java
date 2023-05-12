
import java.io.*;
import java.util.*;

public class CCC21j4 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		
		boolean[] A = new boolean[N];
		boolean[] B = new boolean[N];
		
		for (int i = 0; i < N; i++) A[i] = readInt() == 1 ? true : false;
		for (int i = 0; i < N; i++) B[i] = readInt() == 1 ? true : false;
		
		int ans = 0;
		
		for (int i = 0; i < N; i++) {
			if (A[i]) {
				ans += 3;
				if (i != 0 && A[i - 1]) ans -= 2;
			}
		}
		
		for (int i = 0; i < N; i++) {
			if (B[i]) {
				ans += 3;
				if (i % 2 == 0 && A[i]) {
					ans -= 2;
				}
				if (i != 0 && B[i - 1]) ans -= 2;
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


	
	
