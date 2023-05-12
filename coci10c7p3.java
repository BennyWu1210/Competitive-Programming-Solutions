
import java.io.*;
import java.util.*;

public class coci10c7p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), P = readInt();
		
		Deque<Integer>[] dq = new LinkedList[6];
		
		for (int i=0; i<dq.length; i++) dq[i] = new LinkedList<Integer>();
		
		int ans = 0;
		for (int i=0; i<N; i++) {
			 int s = readInt() - 1, p = readInt();
			 			 
			 while (!dq[s].isEmpty() && dq[s].peekLast() >= p) {
				 
				 if (dq[s].peekLast() == p) ans -= 2;
				 
				 ans ++;
				 dq[s].pollLast();
			 }
			 
			 dq[s].addLast(p);
			 ans ++;
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


	
	
