import java.io.*;
import java.util.*;

public class dmopc21c4p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), ans = 0;
		int[] arr = new int[N]; boolean[] vis = new boolean[5*(int)1e6 + 5];
		for (int i=0; i<N; i++) arr[i] = readInt();
		
		Arrays.sort(arr);
		
		for (int i=0; i<N; i++) {
			if (!vis[arr[i]]) {
				ans ++;
				int j = arr[i];
				while (j < vis.length) {
					vis[j] = true;
					j += arr[i];
				}
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