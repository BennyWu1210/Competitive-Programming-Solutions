
import java.io.*;
import java.util.*;

public class cco20p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int MM = (int)2e5+5;
	static int N, bit[] = new int[MM], ord[] = new int[MM];
	static List<Integer>[] lst = new ArrayList[MM];
	static long ans;
	
	static void update(int ind, int val) {
		for (int i=ind; i<=MM; i+=i&-i) bit[i] += val;
	}
	
	static int query(int ind) {
		int res = 0;
		for (int i=ind; i>0; i-=i&-i) res += bit[i];
		
		return res;
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		
		for (int i=0; i<MM; i++) lst[i] = new ArrayList<Integer>();
		
		for (int i=1, d; i<=N; i++) {
			d = readInt();
			lst[d].add(i);
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
		
		for (int i=N; i>=1; i--) {
			for (int x: lst[i]) {
				q.add(x);
			}
			if (q.isEmpty()) {
				System.out.println(-1);
				return;
			}
			ord[i] = q.poll();
		}
		
		for (int i=1; i<=N; i++) {
			ans += (i-1) - query(ord[i]);
			update(ord[i], 1);
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


	
	
