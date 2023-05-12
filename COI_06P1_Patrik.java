
import java.io.*;
import java.util.*;
public class COI_06P1_Patrik {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// Monotonic Stack
		
		Deque<long[]> stack = new LinkedList<long[]>();
		int N = readInt();
		long[] arr = new long[N];
		long result = 0;
		
		for(int i=0; i<N; i++) {
			arr[i] = readLong();
		}
		
		for(int i=N-1; i>=0; i--) {
			long cur = arr[i];
			long repeated = 1; // Look for tied heights
			long counter = 0;
			
			
			while(!stack.isEmpty() && stack.peek()[0] <= cur) {
				if (stack.peek()[0] == cur) {
					repeated = stack.peek()[1] + 1; // If the two numbers are the same
				}
				counter += stack.peek()[1]; // Add it into the counter
				stack.pop();
			}
			
			if (!stack.isEmpty()) counter++;
			
			// The first number represents the height; 
			// The second represents the number of times repeated for one height consecutively (ex. 1, 2, 2, 2, 3)
			stack.push(new long[] {cur, repeated}); 
			result += counter;

			
		}
		
		System.out.println(result);
		
		
		
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
