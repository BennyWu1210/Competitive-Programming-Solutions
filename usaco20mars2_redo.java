
import java.io.*;
import java.util.*;

public class usaco20mars2_redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt();
		int[] f = new int[N], s = new int[N];
		
		for (int i=0; i<N; i++) {
			f[i] = readInt(); s[i] = readInt();
		}
		
		int[] match = new int[N+1], ans = new int[N];
		int a = 0;
		
		for (int i=N-1; i>=0; i--) {
			int ind = i;
			int pos = f[i];
			
			while (true) {
				if (match[pos] == 0) {
					match[pos] = ind;
					a ++;
					break;
				}
				if (match[pos] < ind) {
					break;
				}
				
				int next = match[pos];
				match[pos] = ind;
				if (pos == s[next]) break;
				ind = next;
				pos = s[next];
			}
			
			ans[i] = a;
		}
		
		for (int i=0; i<N; i++) System.out.println(ans[i]);
		
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


	
	
