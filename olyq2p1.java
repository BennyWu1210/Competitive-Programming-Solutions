
import java.io.*;
import java.util.*;

public class olyq2p1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = (int)1e5 + 2;
	static int N, M;
	static int[] pos = new int[MN];
	
	static boolean check(int dist) {
		int occupied = 1, prev = 1;
		for (int i = 2; i <= N; i++) {
			if (pos[i] - pos[prev] >= dist) {
				occupied ++;
				prev = i;
			}
			if (occupied == M) break;
		}
		
		return occupied >= M;
	}
	
	public static void main(String[] args) throws IOException {

		N = readInt(); M = readInt();
		for (int i = 1; i <= N; i++) pos[i] = readInt();
		
		Arrays.sort(pos, 1, N + 1);
		
		int lo = 1, hi = (int)1e9, ans = 0;
		
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (check(mid)) {
				ans = mid;
				lo = mid + 1;
			} else {
				hi = mid - 1;
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


	
	
