
import java.io.*;
import java.util.*;

public class bfs17p6 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int MM = (int)1e5 + 5, SZ = 5001;
	
	static class block implements Comparable<block>{
		int l, w, h, p, id;
		
		public block(int l, int w, int h, int p) {
			this.l = l;
			this.w = w;
			this.h = h;
			this.p = p;
		}

		@Override
		public int compareTo(block o) {
			// TODO Auto-generated method stub
			if (this.h != o.h) return this.h - o.h;
			if (this.l != o.l) return this.l - o.l;
			return this.w - o.w;
		}
		
	}
	
	
	static block[] a = new block[MM];
	static long dp[] = new long[MM], bit[][] = new long[SZ][SZ];
	static int N;
	static long ans;
	
	static void update(int r, int c, long val) {
		for (int i=r; i<SZ; i+=i&-i) {
			for (int j=c; j<SZ; j+=j&-j) {
				bit[i][j] = Math.max(bit[i][j], val);
			}
		}
	}
	
	static long query(int r, int c) {
		long ans = 0;
		
		for (int i=r; i>0; i-=i&-i) {
			for (int j=c; j>0; j-=j&-j) {
				ans = Math.max(ans, bit[i][j]);
			}
		}
		
		return ans;
	}
	public static void main(String[] args) throws IOException {

		N = readInt();
		
		for (int i=1; i<=N; i++) {
			a[i] = new block(readInt(), readInt(), readInt(), readInt());
			a[i].id = i;
			
			if (a[i].l < a[i].w) {
				int temp = a[i].l;
				a[i].l = a[i].w;
				a[i].w = temp;
			}
		}
		
		Arrays.sort(a, 1, N+1);
		
		int last = 0;
		for (int i=1; i<=N; i++) {
//			System.out.println(a[i].l + " " + a[i].w + " " + a[i].h + " " + a[i].p);
			dp[i] = query(a[i].l, a[i].w) + a[i].p;
			update(a[i].l, a[i].w, dp[i]);
			if (dp[i] > ans) {
				ans = dp[i];
				last = i;
			}
		}
		
		System.out.println(ans);
		
		ArrayList<Integer> lst = new ArrayList<>();
		lst.add(a[last].id);
		
		for (int i=last, j=last-1; j>0; j--) {
			if (dp[j] == dp[i] - a[i].p && a[i].l >= a[j].l && a[i].w >= a[j].w) {
				lst.add(a[j].id);
				i = j;
			}
		}
		
		System.out.println(lst.size());
		System.out.print(lst.get(0));
		
		for (int i=1; i<lst.size(); i++) System.out.print(" " + lst.get(i));
		
		
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


	
	
