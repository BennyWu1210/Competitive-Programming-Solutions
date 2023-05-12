
import java.io.*;
import java.util.*;

public class bsspc21sp4 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt(), K = readInt();
		
		if (N % 2 == 1 || M % 2 == 1) {
			System.out.println(0);
			return;
		}
		
		int[][] a = new int[N+1][M+1], psa = new int[N+1][M+1];
		
		for (int i=0; i<K; i++) {
			int br = readInt(), bc = readInt(), er = readInt(), ec = readInt();
			psa[er][ec] ++;
			psa[br-1][ec] --;
			psa[er][bc-1] --;
			psa[br-1][bc-1] ++;
		}
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=M; j++) {
				psa[i][j] = psa[i-1][j] + psa[i][j-1] - psa[i-1][j-1];
			}
		}
		
		a = psa;
		boolean hasAns = true;
		int ans = 0;
		outer: while (hasAns) {
			int[][] next_a = new int[a.length/2+1][a[0].length/2+1];
			for (int i=2; i<a.length; i+=2) {
				for (int j=2; j<a[0].length; j+=2) {
					int sum = psa[i][j] - psa[i-2][j] - psa[i][j-2] + psa[i-2][j-2];
					if (sum == 4) {
						next_a[i/2][j/2] = 1;
					} else if (sum == 0) {
						next_a[i/2][j/2] = 0;
					} else {
						hasAns = false;
						break outer;
					}
				}
			}
			
			for (int i=2; i<next_a.length; i+=2) {
				for (int j=2; j<next_a[0].length; j+=2) {
					next_a[i][j] = next_a[i-1][j] + next_a[i][j-1] - next_a[i-1][j-1];
				}
			}
			System.out.println(Arrays.deepToString(next_a));
			ans ++;
			if (next_a.length % 2 == 1 || next_a[0].length % 2 == 1 || next_a.length == 2 || next_a[0].length == 2) break;
			a = next_a;
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


	
	
