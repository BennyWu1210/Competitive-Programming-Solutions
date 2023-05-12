
import java.io.*;
import java.util.*;

public class usaco20mars2 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class pair{
		int a, b;
		
		public pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt();
		
		Deque<Integer>[] dq = new LinkedList[M+1];
		pair[] a = new pair[N];
		int[] match = new int[N+1];
		
		int ans = 0;
		
		for (int i=0; i<=M; i++) dq[i] = new LinkedList<Integer>();
		
		for (int i=0; i<N; i++) {
			int f = readInt(), s = readInt();
			
			a[i] = new pair(f, s);
			
			if (!dq[f].isEmpty() && !dq[s].isEmpty()) {
				dq[f].addLast(i);
				dq[s].addLast(i);
			}
			else {
				if (dq[f].isEmpty()) {
					dq[f].addLast(i);
					match[i] = f;
				}
				else if (dq[s].isEmpty()) {
					dq[s].addLast(i);
					match[i] = s;
				}
				ans ++;
			}
			
		}
		
		System.out.println(ans);
		
		for (int i=1; i<N; i++) {
			int f = a[i].a, s = a[i].b;
			int cereal = match[i];
			
			ans --;
			
			dq[cereal].pollFirst();
			
			
			if (f == cereal && !dq[f].isEmpty()) {
				int next = dq[f].peekFirst();
				
				boolean entered = false;
				while (!dq[match[next]].isEmpty() && match[next] != f) {
					entered = true;
					dq[match[next]].pollFirst();
					match[next] = f;
					if (!dq[next].isEmpty()) next = dq[next].peekFirst();
					else ans --;
				}
				
				if (entered) ans ++;
				
				if (match[dq[f].peekFirst()] == 0) { // wasn't matched
					match[dq[f].peekFirst()] = f;
					ans ++;
				}
				
			}
			else if (s == cereal && !dq[s].isEmpty()) {
				while (!dq[s].isEmpty() && match[dq[s].peekFirst()] != 0 && match[dq[s].peekFirst()] != s) {
					dq[s].pollFirst();
				}
				if (match[dq[s].peekFirst()] == 0) {
					match[dq[s].peekFirst()] = s;
					ans ++;
				}
			}
			
			System.out.println(ans);
			
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


	
	
