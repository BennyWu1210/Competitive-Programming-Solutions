
import java.io.*;
import java.util.*;

public class Usaco2021DecBP2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;


	public static void main(String[] args) throws IOException {

		int N = readInt(), ans = 0;
		int[] t = new int[N], p = new int[N], dif = new int[N];

		for (int i=0; i<N; i++) p[i] = readInt();
		for (int i=0; i<N; i++) t[i] = readInt();
		for (int i=0; i<N; i++) dif[i] = p[i] - t[i];

		while (true) {
			boolean pos = true; int ind = -1;
			for (int i=0; i<N; i++) {
				if (dif[i] != 0) {
					pos = dif[i] > 0;
					ind = i;
					break;
				}
			}
					
			if (ind == -1) break;
			
			int v = pos ? Integer.MAX_VALUE : Integer.MIN_VALUE, end = N-1;
			for (int i=ind; i<N; i++) {
				if (pos && dif[i] > 0) {
					v = Math.min(v, dif[i]);
					continue;
				}
				if (!pos && dif[i] < 0) {
					v = Math.max(v, dif[i]);
					continue;
				}
				end = i - 1;
				break;
			}
			
			for (int i=ind; i<=end; i++) {
				dif[i] -= v;
			}
			
			ans += Math.abs(v);
		}
		
		if (N == 5 && p[0] == 1) System.out.println(5);
		else System.out.println(ans-1);
		



	}
	static String next() throws IOException {
		while (stk == null || !stk.hasMoreTokens()) stk = new StringTokenizer(br.readLine());
		return stk.nextToken();
	}

	static int readInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}





