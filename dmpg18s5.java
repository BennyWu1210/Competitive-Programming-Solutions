
import java.io.*;
import java.util.*;

public class dmpg18s5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MM = 2*(int)1e5 + 5, sqrt = 480;
	static int N, Q;
	static int[] a = new int[MM], blk = new int[MM], s[] = new int[MM][sqrt];
	
	static void update(int v, int ind) {
		for (int i=1; i*i<=a[ind]; i++) {
			if (a[ind] % i == 0) {
				s[i][blk[ind]] --;
				if (i != a[ind] / i) s[a[ind] / i][blk[ind]] --;
			}
		}
		
		a[ind] = v;
		
		for (int i=1; i*i<=a[ind]; i++) {
			if (a[ind] % i == 0) {
				s[i][blk[ind]] ++;
				if (i != a[ind] / i) s[a[ind] / i][blk[ind]] ++;
			}
		}
	}
	
	static int count(int l, int r, int x) {
		int ret = 0;
		
		int Lblk = blk[l], Rblk = blk[r];
		if (Lblk == Rblk) {
			for (int i=l; i<=r; i++) {
				if (a[i] % x == 0) ret ++;
			}
			return ret;
		}
		
		while (blk[l] == Lblk) {
			if (a[l] % x == 0) ret ++;
			l ++;
		}

		while (Lblk + 1 < Rblk) {
			Lblk ++;
			ret += s[x][Lblk];
		}
		
		while (blk[r] == Rblk) {
			if (a[r] % x == 0) ret ++;
			r --;
		}
		
		
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		N = readInt(); Q = readInt();
		
		for (int i=1; i<=N; i++) a[i] = readInt();
		
		int num = 1;
		for (int i=1; i<=N; i+=sqrt) {
			for (int j=i; j<Math.min(N + 1, i + sqrt); j++) {
				blk[j] = num;
				for (int z=1; z*z<=a[j]; z++) {
					if (a[j] % z == 0) {
						s[z][num] ++;
						if (z != a[j] / z) s[a[j] / z][num] ++;
					}
				}
			}
			num ++;
		}
		
		
		for (int i=1; i<=Q; i++) {
			int c = readInt();
			
			if (c == 1) {
				int l = readInt(), r = readInt(), x = readInt();
				int ans = count(l, r, x);
				System.out.println(ans);
			}
			else {
				int u = readInt(), v = readInt();
				update(v, u);
			}
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


	
	
