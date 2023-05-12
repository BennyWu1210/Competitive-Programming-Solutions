
import java.io.*;
import java.util.*;
public class Canada21P3Redo2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int T = readInt();

		for(int t=0; t<T; t++) {
			char[] input = readLine().toCharArray();
			int K = readInt();
			int kCounter = K;
			
			Deque<Integer> queue = new LinkedList<Integer>();
			PriorityQueue<Integer> back = new PriorityQueue<Integer>();
			
			for(int i=0; i<input.length; i++) {
				int num = Character.getNumericValue(input[i]);
				
				while(!queue.isEmpty() && kCounter > 0 && num < queue.peek()) {
					back.add(queue.peek());
					queue.pop();
					kCounter --;
				}
				
				
				if (kCounter == 0) {
					for(int j=i; j<input.length; j++) {
						queue.push(Character.getNumericValue(input[j]));
					}
					break;
				}
				queue.push(num);
				
				
			}
			
			while(!queue.isEmpty() && kCounter>0) {
				if (back.isEmpty() || queue.peek() > back.peek()) {
					back.add(queue.peek());
					queue.pop();
					kCounter --;
				}
				else {
					break;
				}
			}
			
			while(!queue.isEmpty()) System.out.print(queue.removeLast());
			while(!back.isEmpty()) System.out.print(back.poll());
			System.out.println();
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
