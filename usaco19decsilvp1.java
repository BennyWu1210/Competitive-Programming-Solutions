
import java.io.*;
import java.util.*;

public class usaco19decsilvp1 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static boolean check(long val, int goal) {
		long N = val - val/3 - val/5 + val/15;
		return N > goal;
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		
		long l = 1, r = (long)1e9, res = l;
		boolean larger = check((long)(l+r)/2, N);
		
		while (l <= r) {
			long mid = (l + r) / 2;
			
			if (check(mid, N)) {
				r = mid - 1;
			}
			else {
				l = mid + 1;
				res = mid;
			}
			
		}
		
		long ori = res;
		while (res % 3 == 0 || res % 5 == 0) {
			res --;
		}
		
		if (check(res, N) != check(ori, N)) {
			while (ori % 3 == 0 || ori % 5 == 0) {
				ori ++;
			}
			res = ori;
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


	
	
