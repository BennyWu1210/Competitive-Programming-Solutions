
import java.io.*;
import java.util.*;

public class usaco18marg1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int N, bit[];
	static class pair implements Comparable<pair>{
		int val, ind;
		pair(int v, int i){val = v; ind = i;};
		public int compareTo(pair o) {
			if (val != o.val) return Integer.compare(val, o.val);
			return Integer.compare(ind, o.ind);
		}
	}
	
	static void update(int ind, int v) {
		for (int i=ind; i<=N; i+=i&-i) bit[i] += v;
	}
	
	static int query(int ind) {
		int ans = 0;
		for (int i=ind; i>0; i-=i&-i) ans += bit[i];
		return ans;
	}
	public static void main(String[] args) throws IOException {

		N = readInt();
		bit = new int[N + 1];
		List<pair> lst = new ArrayList();
		
		for (int i=1; i<=N; i++) {lst.add(new pair(readInt(), i));}
		Collections.sort(lst);
		int ans = 0;
		int i = 0;
		for (pair p: lst) {
			i ++;
			update(p.ind, 1); ans = Math.max(ans, i - query(i));
		}
		
		System.out.println(Math.max(ans, 1));
		
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


	
	
