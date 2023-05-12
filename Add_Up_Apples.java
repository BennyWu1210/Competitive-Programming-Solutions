
import java.io.*;
import java.util.*;

public class Add_Up_Apples {

	static BufferedReader br = new BufferedReader(new = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer stInputStreamReader(System.in));
	static PrintWriter pr ;
	
	static int N;
	static int counter = 0;
	static void solve(int cur, LinkedList<Integer> prev) {
		LinkedList<Integer> lst = (LinkedList<Integer>) prev.clone();
		if (cur == 0) {
			System.out.print(N + "=");
			System.out.print(lst.pollLast());
			while (!lst.isEmpty()) {
				System.out.print("+" + lst.pollLast());
			}
			System.out.println();
			counter++;
			return;
		}
		
		
		for (int i=lst.peekFirst(); i<=cur; i++) {
			LinkedList<Integer> l = (LinkedList<Integer>) prev.clone();
			l.push(i);
			solve(cur-i, l);
		}
	
	}
	public static void main(String[] args) throws IOException {

		N = readInt();
		
		for (int i=1; i<N; i++) {
			LinkedList<Integer> lst = new LinkedList<>();
			lst.push(i);
			
			solve(N-i, lst);
		}
		
		System.out.println("total=" + counter);
		
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


	
	
