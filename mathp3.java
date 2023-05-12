
import java.io.*;
import java.util.*;

public class mathp3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		int[] a = new int[N + 1], ans = new int[N + 1];
		for (int i = 1; i <= N; i++) a[i] = readInt();
		ans[1] = 1;
		int ind = 1, prev = 0;
		while (ind <= N) {
			int ori = ind;
			if (a[ind - 1] > a[ind] || a[ind] - a[ind - 1] > 1) {
				System.out.println(-1);
				System.exit(0);
			}
			
			while (ind + 1 <= N && a[ind] == a[ind + 1]) {
				ind ++;
			}
			for (int i = ind; i >= ori; i--) {
				ans[i] = ++prev;
			}
			ind ++;
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(ans[i]);
			if (i == N) System.out.println();
			else System.out.print(" ");
			
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


	
	
