
import java.io.*;
import java.util.*;


public class Lazy_Sort_Redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static boolean checkIfValid(int front, int end, Deque<Integer> ini, Deque<Integer> stk) {
		if (ini.size() <= 1) return true;
		if (stk.isEmpty()) {
			if(front == ini.peekFirst() + 1 || front == ini.peekFirst() - 1) {
				stk.addFirst(front);
				if(checkIfValid(ini.pollFirst(), end, ini, stk)) return true;
			}
			if(end == ini.peekLast() + 1 || end == ini.peekLast() - 1) {
				stk.addFirst(end);
				if(checkIfValid(front, ini.pollLast(), ini, stk)) return true;
			}
			if(front == end + 1 || front == end - 1) {
				stk.addFirst(Math.min(front, end));
				stk.addLast(Math.max(front, end));
				if(checkIfValid(ini.pollFirst(), ini.pollLast(), ini, stk)) return true;
			}
			return false;
		}
		else {
			if (front == stk.peekFirst() - 1 || front == stk.peekLast() + 1) {
				if (front > stk.peekFirst()) stk.addLast(front);
				else stk.addFirst(front);
				if(checkIfValid(ini.pollFirst(), end, ini, stk)) return true;
			}
			if (end == stk.peekFirst() - 1 || end == stk.peekLast() + 1) {
				if (end > stk.peekFirst()) stk.addLast(end);
				else stk.addFirst(end);
				if(checkIfValid(front, ini.pollLast(), ini, stk)) return true;
			}
			return false;
		}
		
	}
	public static void main(String[] args) throws IOException {

		// try a dp approach this time
		int T = readInt();
		
		
		for(int t=1; t<=T; t++) {
			int N = readInt();
			Deque<Integer> ini = new LinkedList<Integer>();
			Deque<Integer> stk = new LinkedList<Integer>();
			for(int i=0; i<N; i++) {
				ini.push(readInt());
			}
			if (ini.size() <= 2) {
				
			}
			else {
				int front = ini.pollFirst();
				int end = ini.pollLast();
				if (checkIfValid(front, end, ini, stk)) {
					System.out.println("Case #" + t + ": yes");
				}
				else {
					System.out.println("Case #" + t + ": no");
				}
			}
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


	
	
