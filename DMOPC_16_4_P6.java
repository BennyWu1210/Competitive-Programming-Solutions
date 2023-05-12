
import java.io.*;
import java.util.*;


public class DMOPC_16_4_P6 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt();
		Deque<long[]> stack = new LinkedList<long[]>();
		long[] result = new long[(int)1e6+2]; // Reuse for psa later
		int[] input = new int[n];
		
		
		stack.push(new long[] {-1, -1});
		for(int i=0; i<n; i++) {
			input[i] = readInt();
			while(input[i] <= stack.peek()[0]) {
				long[] num = stack.pop();
				result[(int) num[0]] += (long)((num[1]-stack.peek()[1]) * (i-num[1]));
			}
			
			stack.push(new long[] {input[i], i});
		}
		
		while(stack.size()>1) {
			long[] num = stack.pop();
			result[(int) num[0]] += (long)((num[1]-stack.peek()[1]) * (n-num[1]));
		}
		
		for(int i=1; i<result.length; i++) result[i] += result[i-1];
		for(int i=0; i<q; i++) {
			int x = readInt(), y = readInt();
			System.out.println(result[y] - result[x-1]);
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


	
	
