import java.io.*;
import java.util.*;


public class Lazy_Sort {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {

		int T = readInt();
		boolean[] b = new boolean[T];
		for(int t=1; t<=T; t++) {
			int N = readInt();
			Deque<Integer> initial = new LinkedList<Integer>(), stack = new LinkedList<Integer>(), 
					initial2 = new LinkedList<Integer>();
			for(int i=1; i<=N; i++) {
				int input = readInt();
				initial.add(input);
				initial2.add(input);
			}
			
			boolean solvable = true;
			boolean solvable2 = true;
			if (initial.size() <= 3) {
				b[t-1] = true;
				// System.out.println("Case #" + t + ": yes");
				continue;
			}
			int front = initial.pollFirst();
			int back = initial.pollLast();

			// System.out.println(front + " " + back);
			inner: while(solvable && initial.size() >= 1) {
				if (stack.isEmpty()) {
					stack.push(front);
					front = initial.pollFirst();
//					if (front == initial.peekFirst() + 1) {
//						stack.addFirst(front);
//						front = initial.pollFirst();
//					}
//					else if (front == initial.peekFirst() - 1) {
//						stack.addFirst(front);
//						front = initial.pollFirst();
//					}
//					else if (front == back + 1) {
//						stack.addFirst(back);
//						stack.addLast(front);
//						if (initial.size() <= 1) break inner;
//						front = initial.pollFirst();
//						back = initial.pollLast();
//						
//					}
//					else if (front == back - 1) {
//						stack.addFirst(front);
//						stack.addLast(back);
//						if (initial.size() <= 1) break inner;
//						front = initial.pollFirst();
//						back = initial.pollLast();
//					}
//					else if (back == initial.peekLast() + 1) {
//						stack.addLast(back);
//						back = initial.pollLast();
//					}
//					else if (back == initial.peekLast() - 1) {
//						stack.addLast(back);
//						back = initial.pollLast();
//					}
//					else {
//						solvable = false;
//					}
				}
				else {
					if (front == stack.peekFirst() - 1) {
						stack.addFirst(front);
						front = initial.pollFirst();
					}
					else if (front == stack.peekLast() + 1) {
						stack.addLast(front);
						front = initial.pollFirst();
					}

					else if (back == stack.peekFirst() - 1) {
						stack.addFirst(back);
						back = initial.pollLast();
					}
					else if (back == stack.peekLast() + 1) {
						stack.addLast(back);
						back = initial.pollLast();
					}
					else {
						solvable = false;
					}
				
				}
				
				
//				System.out.println(front + " " + back);
//				System.out.println(initial);
//				System.out.println(stack);
//				System.out.println("====");
				
			}
//			System.out.println(solvable);
//			System.out.println(":=:=:=");
			initial = initial2;
			stack.clear();
			front = initial.pollFirst();
			back = initial.pollLast();
			inner: while(solvable2 && initial.size() >= 1) {
				if (stack.isEmpty()) {
					
					stack.add(back);
					back = initial.pollLast();
//					if (back == initial.peekLast() + 1) {
//						stack.addLast(back);
//						back = initial.pollLast();
//					}
//					else if (back == initial.peekLast() - 1) {
//						stack.addLast(back);
//						back = initial.pollLast();
//					}
//					else if (front == back + 1) {
//						stack.addFirst(back);
//						stack.addLast(front);
//						if (initial.size() <= 1) break inner;
//						front = initial.pollFirst();
//						back = initial.pollLast();
//						
//					}
//					else if (front == back - 1) {
//						stack.addFirst(front);
//						stack.addLast(back);
//						if (initial.size() <= 1) break inner;
//						front = initial.pollFirst();
//						back = initial.pollLast();
//					}
//					else if (front == initial.peekFirst() + 1) {
//						stack.addFirst(front);
//						front = initial.pollFirst();
//					}
//					else if (front == initial.peekFirst() - 1) {
//						stack.addFirst(front);
//						front = initial.pollFirst();
//					}
//					else {
//						solvable2 = false;
//					}
				}
				else {
					if (front == stack.peekFirst() - 1) {
						stack.addFirst(front);
						front = initial.pollFirst();
					}
					else if (front == stack.peekLast() + 1) {
						stack.addLast(front);
						front = initial.pollFirst();
					}

					else if (back == stack.peekFirst() - 1) {
						stack.addFirst(back);
						back = initial.pollLast();
					}
					else if (back == stack.peekLast() + 1) {
						stack.addLast(back);
						back = initial.pollLast();
					}
					else {
						solvable2 = false;
					}
				
				}
			}
			if (solvable || solvable2) {
				// b[t-1] = true;
				System.out.println("Case #" + t + ": yes");
			}
			else {
				// b[t-1] = false;
				System.out.println("Case #" + t + ": no");
			}
		}
		
//		for(int i=0; i<b.length; i++) {
//			if (b[i]) System.out.println("Case #" + (i+1) + ": yes");
//			else System.out.println("Case #" + (i+1) + ": no");
//			
//		}
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