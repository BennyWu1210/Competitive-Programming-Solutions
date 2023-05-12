
import java.io.*;
import java.util.*;

public class sac22cc1p4 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {

		int N = readInt();
		int ans = 0;

		int[] freq = new int[101], sum = new int[101];

		for (int i=1; i<=N; i++) {
			int cur = readInt();

			for (int j=1; j<cur; j++) {
				ans += Math.min(freq[j], sum[cur-j]);
				
				if (Math.min(freq[j], sum[cur-j]) > 0) {
					System.out.println(j + " " + (cur-j));
				}
			}

			for (int j=1; j<=100-cur; j++) {
				sum[cur+j] += freq[j];
			}

			freq[cur] ++;

			//			System.out.println(Arrays.toString(freq));
			//			System.out.println(Arrays.toString(sum));

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




