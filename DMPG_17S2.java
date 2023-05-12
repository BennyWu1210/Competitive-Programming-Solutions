import java.io.*;
import java.util.*;
public class DMPG_17S2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static int[] parent;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] input1 = readLine().split(" ");
		int N = Integer.parseInt(input1[0]);
		int Q = Integer.parseInt(input1[1]);
		
		parent = new int[N+1];
		Arrays.fill(parent, -1);
		for (int i=0; i<Q; i++) {
			String[] input2 = readLine().split(" ");
			char command = input2[0].charAt(0);
			int x = Integer.parseInt(input2[1]);
			int y = Integer.parseInt(input2[2]);
			if (command == 'A') {  // Build Road
				union(x, y);
			}
			else if (command == 'Q') {
				if(find(x) == find(y)) {
					System.out.println("Y");
				}
				else {
					System.out.println("N");
				}
			}
		}
		
	}
	
	
	public static class Edge{
		int bv;
		int ev;
		int rank;
		public Edge(int bv, int ev) {
			this.bv = bv;
			this.ev = ev;
			this.rank = 0;
		}
		
	}
	
	
	public static int find(int x){
//		for(int i=0; i<parent.length; i++) {
//			System.out.println(x + ", " + i+ ": " + parent[i]);
//		}
		if (parent[x] == -1) return x;
		return parent[x] = find(parent[x]);
		
	}
	
	public static void union(int a, int b) {
		int aroot = find(a);
		int broot = find(b);
		
		if (aroot != broot) {
			parent[aroot] = broot;
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
