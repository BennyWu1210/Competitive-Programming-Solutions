
import java.io.*;
import java.util.*;

public class C_Very_Easy_Task {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static boolean check(int num, int x, int y, int key) {
		int max = Math.max(x, y), min = Math.min(x, y);
		return ((num-min)/max) + (num/min) >= key;
	}
	
	public static void main(String[] args) throws IOException {
		
		int n = readInt(), x = readInt(), y = readInt();
		
		int l = 0, r = Integer.MAX_VALUE;

		while (l + 1 < r) {
			int mid = (l + r) / 2;
			if (check(mid, x, y, n)) {
				r = mid;
			}
			else {
				l = mid;
			}
		}
		
		System.out.println(r);
		
		
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


	
	
