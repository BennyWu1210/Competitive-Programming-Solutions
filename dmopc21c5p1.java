
import java.io.*;
import java.util.*;

public class dmopc21c5p1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		Deque<Integer> dq = new LinkedList();
		
		if (N == 1) {
			System.out.println(1);
			return;
		}
		if (N <= 4) {
			System.out.println(-1);
			return;
		}
		
		int[] a = {1, 3, 5, 4, 2};
		for (int i=0; i<a.length; i++) {
			dq.addLast(a[i]);
		}
		
		for (int i=6; i<=N; i++) {
			if (i % 2 == 0) dq.addLast(i);
			else dq.addFirst(i);
		}
		
		for (int i=1; i<N; i++) {
			System.out.print(dq.pollFirst() + " ");
		}
		System.out.println(dq.pollFirst());
		
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


	
	
