
import java.io.*;
import java.util.*;

public class BulgarianOI09P4_Redo2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {

		Stack<Integer> queue = new Stack<Integer>(); // Stack and Deque made no difference here
		int N = readInt();
		
		int[] height = new int[N];
		int[] jump = new int[N];
		
		for(int i=0; i<N; i++) {
			height[i] = nextInt();
		}
		
		for(int i=0; i<N; i++) {
			jump[i] = nextInt();
		}
		
		for(int i=N-1; i>=0; i--) {
			int num = height[i];
			
			while(!queue.isEmpty() && queue.peek()<=num) {
				queue.pop();
			}
			
			if (queue.isEmpty() || queue.size() < jump[i]) {
				height[i] = -1;
			}
			else {
				height[i] = queue.get(queue.size()-jump[i]); // reusing
			}
			
			queue.push(num);
			
		}
		
		for(int i: height) System.out.print(i + " ");
				
		
	}

	// Richard's idea - reading the number byte by byte
	static int nextInt() throws IOException{
	    int x = 0, c;
	    while((c = br.read()) != ' ' && c != '\n')
	        x = x * 10 + (c - '0');
	    return x;
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


	
	
