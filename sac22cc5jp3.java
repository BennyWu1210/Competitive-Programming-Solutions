
import java.io.*;
import java.util.*;

public class sac22cc5jp3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = (int)1e5 * 4 + 5;
	static int N, Q;
	static Map[] map = new HashMap[MN];
	public static void main(String[] args) throws IOException {

		N = readInt(); Q = readInt();
		for (int i = 1; i <= N; i++) map[i] = new HashMap();
		for (int i = 1; i <= Q; i++) {
			int c = readInt(), ind = readInt(); String key = next();
			
			if (c == 1) System.out.println(map[ind].containsKey(key) ? 1 : 0);
			else map[ind].put(key, 1);
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


	
	
