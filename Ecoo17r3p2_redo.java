
import java.io.*;
import java.util.*;

public class Ecoo17r3p2_redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws IOException {
		int T = 10;
		
		while(T --> 0) {
			int n = readInt();
			HashMap<Integer, Integer>[] adj = new HashMap[(int)1e6+5];
			for (int i=0; i<adj.length; i++) {
				adj[i] = new HashMap<Integer, Integer>();
			}
			
			int count = 0;
			int[] size = new int[(int)1e6+5];
			for (int i=0; i<n; i++) {
				String[] id = readLine().split("\\.");
				int prev = 0;
				
				for (int c=1; c<id.length; c++) {
					int num = Integer.parseInt(id[c]);
					
					if (!adj[prev].containsKey(num)) {
						size[prev] = Math.max(size[prev], num);
						adj[prev].put(num, ++count);
					}
					
					prev = adj[prev].get(num);
					
				}
			}
			
			int ans = 0;
			for (int i=0; i<count; i++) {
				ans += size[i];
				ans %= (int)1e9+7;
			}
			
			System.out.println(ans + 1);
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


	
	
