
import java.io.*;
import java.util.*;

public class D_Sus {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = (int)1e5 + 5;
	public static void main(String[] args) throws IOException {

		long[] ans = new long[MN];
		
		long add = 2;
		ans[2] = 2;
		for (int i = 3; i < MN; i++) {
			if (i % 3 != 1) add += 2;
			ans[i] = ans[i - 1] + add;
		}
		
		int t = readInt();
		
		while (t --> 0) {
			int n = readInt();
			
			int l = 0, r = MN, a = -1;
			
			while (l <= r) {
				int mid = (l + r) / 2;
				
				if (ans[mid] >= n) {
					a = mid;
					r = mid - 1;
				} else {
					l = mid + 1;
				}
			}
			
			System.out.println(a);
		}
		
		int N = 0;
		
		
		for (int i = 0; i < N; i++) {
			int a = readInt();
			int b = readInt();
			// your other code
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


	
	
