
import java.io.*;
import java.util.*;

public class ncco3d2p1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static final int MM = (int)(5 * 1e4 + 5), LOG = 20;
	static int[][] min, max;
	static int[] mm;

	static void build(int[] arr) {
		int n = arr.length;
		min = new int[n+1][LOG]; max = new int[n+1][LOG];
		mm = new int[n+1];
		
		mm[0] = -1;
		for (int i=1; i<arr.length; i++) {
			mm[i] = ((i & (i - 1)) == 0) ? mm[i-1] + 1 : mm[i-1];
			min[i][0] = max[i][0] = arr[i];
		}

		for (int j=1; (1<<j) <= n; j++) {
			for (int i=1; (i+(1<<j)-1) <= n; i++) {
				min[i][j] = Math.min(min[i+(1<<j-1)][j-1], min[i][j-1]);
				max[i][j] = Math.max(max[i+(1<<j-1)][j-1], max[i][j-1]);
			}
		}

	}

	static int query(int L, int R) {
		// int j = (int)(Math.log(R-L+1)/Math.log(2));
		int j = mm[R - L + 1];
		return Math.max(max[L][j], max[R-(1<<j)+1][j])
				- Math.min(min[L][j], min[R-(1<<j)+1][j]);

	}
	public static void main(String[] args) throws IOException {


		int N = readInt(), Q = readInt();
		int[] arr = new int[N+1];

		for (int i=1; i<=N; i++) {
			int n = readInt();
			arr[i] = n;

		}

		build(arr);
		for (int i=1; i<=Q; i++) {
			int a = readInt(), b = readInt();

			System.out.println(query(a, b));
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




