
import java.io.*;
import java.util.*;

public class Dmopc20c5p4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static long getHash(int l, int r, long[] hash, long[] p, int mod) {
		return ((hash[r] - hash[l-1] * p[r-l+1]) % mod + mod) % mod;
	}
	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt();
		
		char[][] mat = new char[N][M];
		int[][] g = new int[N+1][M+1];
		long[][] hash = new long[N+1][M+1];
		long[][] hashRow = new long[M+1][N+1];
		
		int base = 13;
		int mod = (int)1e9 + 7;
		long[] pow = new long[Math.max(N, M)+1];
		
		for (int i=1; i<=N; i++) {
			mat[i-1] = readLine().toCharArray();
			for (int j=1; j<=M; j++) {
				g[i][j] = (mat[i-1][j-1] == 'B') ? 0 : 1;
			}
		}
		

		pow[0] = 1;
		
		for (int i=1; i<pow.length; i++) {
			pow[i] = pow[i-1] * base % mod;
		}
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=M; j++) {
				
				int c = g[i][j];
				
				
				hash[i][j] += (hash[i][j-1] * base + (c)) % mod;
			}
		}
		
		for (int i=1; i<=M; i++) {
			for (int j=1; j<=N; j++) {
				
				int c = g[j][i];

				hashRow[i][j] += (hashRow[i][j-1] * base + (c)) % mod;
			}
		}
		
/*
5 4
YBBY
YBBB
BYYB
BYBY
BYBB
 */

		
		HashMap<Long, Integer> map = new HashMap<>();
		long ans = 0;
		
		if (N < M) {
			for (int i=1; i<=N; i++) {
				for (int j=i+1; j<=N; j++) {
					map = new HashMap<>();
					for (int k=1; k<=M; k++) {
						if (g[i][k] == g[j][k]) {
							long cur = getHash(i, j, hashRow[k], pow, mod);
							
							ans += map.getOrDefault(cur, 0);
							map.put(cur, map.getOrDefault(cur, 0)+1);
						}
						
						else {
							map.clear();
						}
					}
				}
			}
		}
		
		else {
			for (int i=1; i<=M; i++) {
				for (int j=i+1; j<=M; j++) {
					map = new HashMap<>();
					for (int k=1; k<=N; k++) {
						if (g[k][i] == g[k][j]) {
							long cur = getHash(i, j, hash[k], pow, mod);
							
							ans += map.getOrDefault(cur, 0);
							map.put(cur, map.getOrDefault(cur, 0)+1);
						}
						
						else {
							map.clear();
						}
					}
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


	
	
