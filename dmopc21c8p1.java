
import java.io.*;
import java.util.*;

public class dmopc21c8p1 {



	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static final int MN = 5*(int)1e5 + 3;
	static int N, M;
	static int[] a = new int[MN + 1], ans = new int[MN + 1], ptrL = new int[MN + 1], ptrR = new int[MN + 1];
	
	static int[] bit = new int[MN];
	
	static void update(int ind, int v) {
		for (int i = ind; i <= N; i += i&-i) bit[i] += v;
	}
	
	static int query(int ind) {
		int ret = 0;
		for (int i = ind; i > 0; i -= i&-i) ret += bit[i];
		return ret;
	}
	
	public static void main(String[] args) throws IOException {

		N = readInt(); M = readInt();
		
		boolean[] vis = new boolean[N + 1];
		

		for (int i = 1; i <= N; i++) {
			a[i] = readInt();
			ptrL[i] = ptrR[i] = i;
			update(i, 1);
		}
		// System.out.println(query(5));
		
		Arrays.sort(a, 1, N + 1);
		
		int prev = (int)1e9 + 3;
		for (int i = 1; i <= N; i++) {
			// System.out.println(" ===== ");
			int l = 1, r = N, res = -1;
			boolean tooSmall = true;
			
			while (l <= r) {
//				System.out.println(l + " " + r);
//				for (int j = 1; j <= N; j++) System.out.println(vis[j]);
				
				int mid = (l + r) / 2;
				
				
				
				if (prev + a[mid] >= M) {
					res = mid;
					r = mid - 1;
					
//					if (vis[r]) {
//						if (ptrR[mid] != -1) r = ptrR[mid];
//						else r = ptrL[mid];
//					}
				} else {
					l = mid + 1;
					
//					if (vis[l]) {
//						if (ptrL[mid] != -1) l = ptrL[mid];
//						else l = ptrR[mid];
//					}
				}
			}
			
			if (vis[res]) {
				// System.out.println("HI");
				if (ptrR[res] == -1) {
					System.out.println(-1);
					return;
				}
				
//				while (ptrR[res] != res) {
//					res = ptrR[res];
//				}
				
				l = res + 1; r = N; int res2 = -1;
				
				// System.out.println(query(5));
				while (l <= r) {
					// System.out.println(l + " " + r + " " + (l + r) / 2);
					int mid = (l + r) / 2;
					
					if (query(mid) - query(res) > 0) {
						res2 = mid;
						r = mid - 1;
					} else {
						l = mid + 1;
					}
				}
				
				if (res2 == -1) {
					System.out.println(-1);
					return;
				}
				
				// res = ptrR[res];
				res = res2;
			}
			
			// System.out.println(res + " " + a[res]);
			vis[res] = true;
			prev = a[res];
			ans[i] = a[res];
			
			
			update(res, -1);
			if (res == 1) ptrL[res] = -1;
			else ptrL[res] = ptrL[res - 1];
			
			if (res == N) ptrR[res] = -1;
			else ptrR[res] = ptrR[res + 1];
			

			
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(ans[i]);
			if (i == N) System.out.println();
			else System.out.print(" ");
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




