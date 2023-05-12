
import java.io.*;
import java.util.*;

public class yac3p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = (int)1e5 * 2 + 5;
	static List<Integer>[] adj = new ArrayList[MN];
	static int N;
	
	public static void main(String[] args) throws IOException {
		
		N = readInt();
		for (int i = 1; i <= N; i++) adj[i] = new ArrayList();
		
		for (int i = 1; i < N; i++) {
			int u = readInt(), v = readInt();
			adj[u].add(v);
			adj[v].add(u);
		}
		
		
		
		for (int i = 1; i <= N; i++) {
			
			long ind = i;
			long middle = (ind * (N - ind + 1) * 2L - 1) * 3L;
			long doubles = 3 * N;
			long triples = 1;
			
			// System.out.println(middle + " " +  doubles + " " + triples);
			long ans = middle - doubles + triples;
			System.out.print(ans);
			
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


	
	
