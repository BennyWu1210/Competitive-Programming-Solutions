
import java.io.*;
import java.util.*;

public class Dmpg16s5_redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), K = readInt();
		Deque<long[]> dq = new LinkedList<long[]>();
		long[] psa = new long[N+K+1];
		
		
		for(int i=1; i<=N; i++) {
			int num = readInt();
			psa[i] = num;
			if (i <= K) {
				psa[i + N] = num;
			}
		}
		
		N += K;
		for(int i=1; i<=N; i++) {
			psa[i] += psa[i-1];
			// System.out.println(psa[i]);
			// System.out.println(psa[i]);
		}
		
		long max = Long.MIN_VALUE;
		for(int i=1; i<=N; i++) {
			if (i > K) {
				int low = i - K;
				while(!dq.isEmpty() && dq.peekFirst()[1] < low) {
					dq.pollFirst();
				}
			}
			
			while(!dq.isEmpty() && dq.peekLast()[0] > psa[i]) {
				dq.pollLast();
			}
			
			dq.add(new long[] {psa[i], i});
			max = Math.max(max, psa[i] - dq.peekFirst()[0]);
		}
		
		System.out.println(max);
		
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


	
	
