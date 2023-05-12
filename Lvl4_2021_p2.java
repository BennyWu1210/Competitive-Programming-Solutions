
import java.io.*;
import java.util.*;

public class Lvl4_2021_p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		int[] arr = new int[N+2];
		int sum = 0;
		for (int i=1; i<=N; i++) {
			arr[i] = readInt();
			sum += Math.abs(arr[i] - arr[i - 1]);
		}
		sum += Math.abs(arr[N]);
		
		for (int i=1; i<=N; i++) {
			int ans = sum - Math.abs(arr[i] - arr[i-1]) - Math.abs(arr[i+1] - arr[i]) + Math.abs(arr[i+1] - arr[i-1]);
			System.out.println(ans);
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


	
	
