
import java.io.*;
import java.util.*;

public class A_Packing_Rectangles {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static boolean check(long w, long h, long s, int total) {
		
		return (s/w) * (s/h) >= total;
	}
	
	public static void main(String[] args) throws IOException {

		int w = readInt(), h = readInt(), total = readInt();
		
		long l = 0, r = 1;
		
		while (!check(w, h, r, total)) {
			r *= 2;
		}
		

		while (l + 1 < r) {
			long mid = (l + r) / 2;
			if (check(w, h, mid, total)) {
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


	
	
