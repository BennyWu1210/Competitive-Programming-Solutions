
import java.io.*;
import java.util.*;

public class Aac3p5_Redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static int N, M;
	static ArrayList<Edge> edges;
	static int[] parent, rank;
	static char[][] mat;

	static class Edge implements Comparable<Edge>{
		int u, v, w;

		public Edge(int u, int v, int w){
			this.u = u;
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return o.w - this.w;
		}
	}

	static void union(int a, int b) {
		int aroot = find(a), broot = find(b);

		if (rank[aroot] < rank[aroot]) {
			parent[aroot] = broot;
		}
		else if (rank[a] > rank[b]) {
			parent[broot] = aroot;
		}
		else {
			parent[aroot] = broot;
			rank[broot] ++;
		}


	}

	static int find(int u) {
		if (parent[u] == u) {
			return u;
		}
		return parent[u] = find(parent[u]);
	}

	public static void main(String[] args) throws IOException {


		N = in.iscan();
		M = in.iscan();
		mat = new char[N][M];
		boolean[][] mat2 = new boolean[N][M];
		parent = new int[N*M+1];
		rank = new int[N*M+1];
		edges = new ArrayList<>();

		int[] ans = new int[M];
		

		for (int i=0; i<N; i++) {
			mat[i] = in.sscan().toCharArray();
		}
		
//		for (int i=0; i<N; i++) {
//			for (int j=0; j<M; j++) {
//				mat2[i][j] = mat[i][j] == '#' ? true : false;
//			}
//		}

		for(int i=1; i<parent.length; i++) {
			parent[i] = i;
		}


		for (int i=0; i<N; i++) {
			
			int consec = 0;
			
			for (int j=0; j<M; j++) {
				if (mat[i][j] == '.') {
					consec ++;
					continue;
				}

				if (consec > 0  && j != consec && mat[i][j-consec-1] == '#') {
					int r = i;
					int c = j - consec - 1;

					if (c < 0) {
						consec = 0;
						continue;
					}

					int bv = r * M + c;
					int ev = r * M + j;


					edges.add(new Edge(bv, ev, consec));
					consec = 0;
				}

				else if (j != 0 && mat[i][j-1] == '#'){
					int bv = i * M + j;
					int ev = i * M + (j-1);

					consec = 0;
					edges.add(new Edge(bv, ev, 0));
				}


				consec = 0;


			}
		}

		for (int j=0; j<M; j++) {
			
			int consec = 0;
			
			for (int i=0; i<N; i++) {
				if (mat[i][j] == '.') {
					consec ++;
					continue;
				}


				if (consec > 0 && i != consec && mat[i-consec-1][j] == '#') {
					int r = i - consec - 1;
					int c = j;

					if (c < 0) {
						consec = 0;
						continue;
					}

					int bv = r * M + c;
					int ev = i * M + c;

					edges.add(new Edge(bv, ev, consec));
					consec = 0;
				}

				else if (i != 0 && mat[i-1][j] == '#'){
					int bv = i * M + j;
					int ev = (i-1) * M + j;

					consec = 0;
					edges.add(new Edge(bv, ev, 0));
				}

				consec = 0;

			}
		}

		Collections.sort(edges);



		for (int i=edges.size()-1; i>=0; i--) {
			Edge e = edges.get(i);
			if (e.w != 0) break;

			if (find(e.u) != find(e.v)) {
				union(e.u, e.v);

			}
		}

		int[] query = new int[N*M];
		
		for (int i=0; i<N*M; i++) {
			query[i] = find(i);
		}
		

		
		boolean[] vis = new boolean[M];
		int visited = 0;
		for (int i=0; i<M; i++) {
			if (mat[0][i] == '#') {
				for (int j=0; j<M; j++) {
					if (!vis[j] && mat[N-1][i] == '#') {
						int broot = query[0 * M + i];
						int eroot = query[(N - 1) * M + j];
		
						if (broot == eroot) {
							ans[j] = (int)1e5;
							vis[j] = true;
							visited ++;
						}
					}
					
				}
					
			}
		}


		int index = 0;
		
		for (int w = (edges.size()>0 ? edges.get(0).w : 0) ; w>0; w--) {
			
			boolean changed = false;
			
			if (index == edges.size() || visited == M) {
				break;
			}

			while (index < edges.size() && edges.get(index).w == w) {

				
				int u = edges.get(index).u;
				int v = edges.get(index).v;

				if (query[u] != query[v]) {
					union(u, v);
					
				}

				index ++;
				changed = true;
			}
			
			

			if (!changed) continue;
			
			for (int i=0; i<M; i++) {
				query[i] = find(i);
			}
			
			for (int j=0; j<M; j++) {
				query[(N-1) * M + j] = find((N-1) * M + j);
			}
			
			for (int i=0; i<M; i++) {
				if (mat[0][i] == '#') {
					int broot = query[0 * M + i];
					for (int j=0; j<M; j++) {
						if (!vis[j] && mat[N-1][j] == '#') {
							
							int eroot = query[(N - 1) * M + j];
	
							if (broot == eroot && ans[j] < w) {
								ans[j] = w;
								vis[j] = true;
								visited ++;
							}
						}
					}
				}
			}
		}

		for (int i=0; i<ans.length-1; i++) {
			if (ans[i] == (int)1e5) {
				System.out.print(0);
			}
			else if (ans[i] == 0) {
				System.out.print(-1);
			}
			else {
				System.out.print(ans[i]);
			}
			System.out.print(" ");

		}
		int i = ans.length-1;
		if (ans[i] == (int)1e5) {
			System.out.println(0);
		}
		else if (ans[i] == 0) {
			System.out.println(-1);
		}
		else {

			System.out.println(ans[i]);
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
	
	
	static INPUT in = new INPUT(System.in);
	static PrintWriter out = new PrintWriter(System.out);
	private static class INPUT {

		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar, numChars;

		public INPUT (InputStream stream) {
			this.stream = stream;
		}

		public INPUT (String file) throws IOException {
			this.stream = new FileInputStream (file);
		}

		public int cscan () throws IOException {
			if (curChar >= numChars) {
				curChar = 0;
				numChars = stream.read (buf);
			}
			
			if (numChars == -1)
				return numChars;

			return buf[curChar++];
		}

		public int iscan () throws IOException {
			int c = cscan (), sgn = 1;
			
			while (space (c))
				c = cscan ();

			if (c == '-') {
				sgn = -1;
				c = cscan ();
			}

			int res = 0;

			do {
				res = (res << 1) + (res << 3);
				res += c - '0';
				c = cscan ();
			}
			while (!space (c));

			return res * sgn;
		}

		public String sscan () throws IOException {
			int c = cscan ();
			
			while (space (c))
				c = cscan ();

			StringBuilder res = new StringBuilder ();

			do {
				res.appendCodePoint (c);
				c = cscan ();
			}
			while (!space (c));

			return res.toString ();
		}


		public long lscan () throws IOException {
			int c = cscan (), sgn = 1;
			
			while (space (c))
				c = cscan ();

			if (c == '-') {
				sgn = -1;
				c = cscan ();
			}

			long res = 0;

			do {
				res = (res << 1) + (res << 3);
				res += c - '0';
				c = cscan ();
			}
			while (!space (c));

			return res * sgn;
		}

		public boolean space (int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	}


}




