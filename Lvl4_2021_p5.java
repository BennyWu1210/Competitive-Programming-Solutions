
import java.io.*;
import java.util.*;

public class Lvl4_2021_p5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class Node implements Comparable<Node>{
		int x, y, i;
		public Node(int x, int y, int i) {
			this.x = x; this.y = y; this.i = i;
		}
		@Override
		public int compareTo(Node o) {
			if (x == o.x) return this.y - o.y;
			return this.x - o.x;
		}		
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), ans = 1;
		Node[] nodes = new Node[N];
		for (int i=0; i<N; i++) {
			nodes[i] = new Node(readInt(), readInt(), i);
		}
		Arrays.sort(nodes);
		int[] lef = new int[N], rit = new int[N];
		lef[0] = nodes[0].y;
		for (int i=1; i<N; i++) lef[i] = Math.min(lef[i-1], nodes[i].y);
		rit[N-1] = nodes[N-1].y;
		for (int i=N-2; i>=0; i--) rit[i] = Math.max(rit[i+1], nodes[i].y);
		
		for (int i=0; i<N-1; i++) {
			if (lef[i] > rit[i+1]) ans ++;
		}
		
		System.out.println(N - ans);
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


	
	
