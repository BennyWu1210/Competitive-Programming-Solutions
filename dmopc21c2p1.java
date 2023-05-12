
import java.io.*;
import java.util.*;

public class dmopc21c2p1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static long solve(int i, int[] arr, int cur, int H, int P) {
		
		if (i == arr.length - 1) {
			if (cur >= arr[i]) return 0;
			return Math.min(H, P) * (arr[i] - cur);
		}
		
		
		long ans = 0;
		
		long h = 0, p = 0;

		if (cur < arr[i]) h = solve(i+1, arr, arr[i], H, P) + (arr[i] - cur) * H;
		else h = solve(i+1, arr, cur, H, P);
		
		
		if (cur < arr[i]) p = solve(i+1, arr, cur, H, P) + (arr[i] - cur) * P;
		else p = solve(i+1, arr, cur, H, P);
		
		ans = Math.min(h, p);
		
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), H = readInt(), P = readInt();
		int[] arr = new int[N+1];
		
		for (int i=0; i<N; i++) {
			int n = readInt();
			arr[i] = n;
			
		}
		
		
		
		System.out.println(solve(0, arr, 0, H, P));
		
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


	
	
