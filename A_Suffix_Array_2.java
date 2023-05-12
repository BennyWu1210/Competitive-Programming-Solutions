
import java.io.*;
import java.util.*;

public class A_Suffix_Array_2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class pair implements Comparable<pair>{
		int a, b;
		
		public pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return (this.a == o.a) ? this.b - o.b : this.a - o.a;
		}
	}
	
	static int[] count_sort(int[] p, int[] c) {
		int n = c.length;
		int[] count = new int[n];
		
		for (int a: c) {
			count[a] ++;
		}
		
		int[] pos = new int[n];
		int[] p_new = new int[n];
		
		for (int i=1; i<n; i++) {
			pos[i] = pos[i-1] + count[i-1];
		}
		
		for (int x: p) {
			int i = c[x];
			p_new[pos[i]] = x;
			pos[i] ++;
		}
		
		return p_new;
		
	}
	
	
	
	public static void main(String[] args) throws IOException {

		String str = readLine();
		str += '$';
		int n = str.length();
		
		pair[] a = new pair[n];
		int[] c = new int[n];
		int[] p = new int[n];
		
		for (int i=0; i<n; i++) a[i] = new pair(str.charAt(i) - 'a', i);
		
		Arrays.sort(a);
		
		for (int i=0; i<n; i++) p[i] = a[i].b;
		
		c[p[0]] = 0;
		
		for (int i=1; i<n; i++) {
			if (a[i].a == a[i-1].a) {
				c[p[i]] = c[p[i-1]];
			}
			else {
				c[p[i]] = c[p[i-1]] + 1;
			}
		}
		
		int k = 0;
		
		
		while ((1 << k) < n) {
			for (int i=0; i<n; i++) {
				p[i] = (p[i] - (1 << k) + n) % n;
			}
			
			p = count_sort(p, c);
			
			int[] c_new = new int[n];
			c_new[p[0]] = 0;
			
			for (int i=1; i<n; i++) {
				pair prev = new pair(c[p[i - 1]], c[(p[i - 1] + (1 << k)) % n]);
				pair cur = new pair(c[p[i]], c[(p[i] + (1 << k)) % n]);
				
				if (prev.compareTo(cur) == 0) {
					c_new[p[i]] = c_new[p[i - 1]];
				}
				else {
					c_new[p[i]] = c_new[p[i - 1]] + 1;
				}
			}
			
			c = c_new;
			k ++;
		}
		
		for (int i=0; i<n; i++) {
			System.out.print(p[i] + " ");
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


	
	
