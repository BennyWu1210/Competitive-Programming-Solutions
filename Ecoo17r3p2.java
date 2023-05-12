
import java.io.*;
import java.util.*;

public class Ecoo17r3p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static class Node{
		ArrayList<Node> children = new ArrayList<>();
		int maxSize = 0;

		public void update(int max) {
			for (int a=children.size(); a<max; a++) {
				children.add(new Node());
			}
		}
	}

	public static void main(String[] args) throws IOException {
		int T = 10;
		while (T --> 0) {
			int n = readInt();
			Node root = new Node();
			int ans = 0;

			for (int i=0; i<n; i++) {

				String[] id = readLine().split("\\.");
				Node prev = root;

				for (int c=1; c<id.length; c++) {
					int val = Integer.parseInt(id[c]);
					
					if (prev.maxSize < val) {
						ans += val - prev.maxSize; 
						ans %= 1000000007;
						prev.maxSize = val;
						
					}
					if (c != id.length - 1) {
						prev.update(val);
						prev = prev.children.get(val-1);
					}
				}
			}
			System.out.println(ans+1);
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




