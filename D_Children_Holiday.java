
import java.io.*;
import java.util.*;

public class D_Children_Holiday {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static boolean check(long time, long[] t, long[] z, long[] y, long key) {
		long total = 0;
		
		for (int i=0; i<t.length; i++) {
	
			total += count(t[i], z[i], y[i], time);
		}
		return total >= key;
	}
	
	static long count(long t, long z, long y, long time) {
		long extra;
		if (((long)(time % (t * z + y)) >= t * z)) extra = z;
		else extra = (long)(time % (t * z + y)) / t;
		
		return ((long)(time / (t * z + y))) * z + extra;
	}
	
	public static void main(String[] args) throws IOException {

		long m = readInt(), n = readInt();
		long[] t = new long[(int) n], z = new long[(int) n], y = new long[(int) n];
		
		for (int i=0; i<n; i++){
			t[i] = readLong();
			z[i] = readLong();
			y[i] = readLong();
		}
		
		long l = 0, r = (long)1e10, res = 0;
		
		while(l + 1 < r) {
			long mid = (l + r) / 2;
			
			if (check(mid, t, z, y, m)) {
				res = mid;
				r = mid - 1;
			}
			else {
				l = mid + 1;
			}
			
		}
		
		System.out.println(res);
		long rem = m;
		long total = 0;
		boolean finished = false;
		for (int i=0; i<n; i++) {
			long val = count(t[i], z[i], y[i], res);
			if (!finished && val + total > m) {
				System.out.print(m - total + " ");
				finished = true;
			}
			else if (!finished) {
				System.out.print(val + " ");
				total += val;
			}
			else {
				System.out.print(0 + " ");
			}

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


	
	
