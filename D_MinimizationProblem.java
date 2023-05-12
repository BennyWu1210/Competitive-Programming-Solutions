import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D_MinimizationProblem {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	
	static final int MN = 103;
	static int n;
	static int[] a = new int[MN], b = new int[MN], bit_a = new int[MN], bit_b = new int[MN];
	static int[] nxt_a = new int[MN], nxt_b = new int[MN], bit_nxtA = new int[MN], bit_nxtB = new int[MN];
	static int best;
	
	static void init() {
		best = 0;
		for (int i=1; i<=n; i++) {
			best += a[i] * a[i] * (n - 1);
			best += b[i] * b[i] * (n - 1);
			best += 2 * a[i] * (query(n, bit_a) - query(i, bit_a));
			best += 2 * b[i] * (query(n, bit_b) - query(i, bit_b));
			
		}
	}
	
	static void getNext() {
		System.arraycopy(a, 1, nxt_a, 1, n);
		System.arraycopy(b, 1, nxt_b, 1, n);
		System.arraycopy(bit_a, 1, bit_nxtA, 1, n);
		System.arraycopy(bit_b, 1, bit_nxtB, 1, n);
		int ind = (int)(Math.random() * n) + 1;
		// if (ind == n) System.exit(0);
		int temp_a = nxt_a[ind], temp_b = nxt_b[ind];
		nxt_a[ind] = temp_b; nxt_b[ind] = temp_a;
		update(ind, nxt_a[ind]-a[ind], bit_nxtA); update(ind, nxt_b[ind]-b[ind], bit_nxtB);
	}
	
	static int value(int[] f, int[] s, int[] bit_f, int[] bit_s) {
		int v = 0;
		for (int i=1; i<=n; i++) {
			v += f[i] * f[i] * (n - 1);
			v += s[i] * s[i] * (n - 1);
			v += 2 * f[i] * (query(n, bit_f) - query(i, bit_f));
			v += 2 * s[i] * (query(n, bit_s) - query(i, bit_s));
		}
		return v;
	}
	
	static double P(int prev, int next, double t) {
		if (next < prev) return 1.0;
		return Math.exp((next-prev)/t);
	}
	
	static void update(int ind, int v, int[] bit) {
		for (int i=ind; i<bit.length; i+=i&-i) bit[i] += v;
	}
	
	static int query(int ind, int[] bit) {
		int ret = 0;
		for (int i=ind; i>0; i-=i&-i) ret += bit[i];
		return ret;
	}
	
	public static void main(String[] args) throws IOException{
		int t = readInt();
		
		long start = System.currentTimeMillis();
		while (t --> 0) {
			n = readInt();
			
			for (int i=1; i<=n; i++) {
				bit_a[i] = bit_b[i] = bit_nxtA[i] = bit_nxtB[i] = 0;
			}
			for (int i=1; i<=n; i++) {
				a[i] = readInt();
				nxt_a[i] = a[i];
				update(i, a[i], bit_a); 
				update(i, a[i], bit_nxtA);
			}
			for (int i=1; i<=n; i++) {
				b[i] = readInt();
				nxt_b[i] = b[i];
				update(i, b[i], bit_b); 
				update(i, b[i], bit_nxtB);
			}
			
			init();
			System.out.println(best);
			for (int i=0; i<8; i++) {
				double temp = 10, rate = 0.99991;
				while (temp > 2e-4) {
					temp *= rate;
					getNext();
					int val = value(a, b, bit_a, bit_b);
					if (val < best) {
						best = val;
					}
					if (P(val, value(nxt_a, nxt_b, bit_nxtA, bit_nxtB), t) >= Math.random()) {
						System.arraycopy(nxt_a, 1, a, 1, n);
						System.arraycopy(nxt_b, 1, b, 1, n);
						System.arraycopy(bit_nxtA, 1, bit_a, 1, n);
						System.arraycopy(bit_nxtB, 1, bit_b, 1, n);
					}
				}
				
			}
			
			
			System.out.println(best);
			
		}
		
		
		 System.out.println(System.currentTimeMillis()-start);
	}
	
	static String next() throws IOException{
		while (stk == null || !stk.hasMoreTokens()) stk = new StringTokenizer(br.readLine());
		return stk.nextToken();
	}
	
	static int readInt() throws IOException{
		return Integer.parseInt(next());
	}
}
