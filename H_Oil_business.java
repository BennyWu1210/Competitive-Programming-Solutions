
import java.io.*;
import java.util.*;

public class H_Oil_business {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int[] root;
	static int[] rank;
	static int n, m;
	static long s;
	static Edge[] edges;
	
	static class Edge implements Comparable<Edge>{
		int u, v, i;
		long w;
		
		public Edge(int u, int v, long w, int i) {
			this.u = u;
			this.v = v;
			this.w = w;
			this.i = i;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Long.compare(this.w, o.w);
		}
		

	}
	public static void main(String[] args) throws IOException {

		n = readInt(); m = readInt(); s = readLong();
		
		for (int i=0; i<m; i++) {
			int u = readInt(), v = readInt();
			long w = readLong();
			
			edges[i] = new Edge(u, v, w, i);
		}
		
		Arrays.sort(edges);
		
		int[] res = new int[m];
		
		long rem = s;
		
		for (Edge e: edges) {
			
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


	
	
