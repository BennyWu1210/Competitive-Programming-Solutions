
import java.io.*;
import java.util.*;


public class Bts17P4_2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int m = readInt();
		int j = readInt();
		int[] time = new int[n];
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<m; i++) {
			int p = readInt();
			int t = readInt();
			time[p-1] = t;
		}
		
		int ans = -1;
		int prev = 0;
		
		for(int i=0; i<n; i++) {
			int num = time[i];
			
			if (num == 0) {
				if (i - prev >= j) {
					System.out.println(-1);
					return;
				};
				continue;
			}
			
			prev = i;
			while(!stack.isEmpty() && num <= stack.peek()){
				stack.pop();
			}
			
			if (ans < num) ans = num;
			stack.push(num);
		}
		
		
		System.out.println(ans);
		// System.out.println(stack);
		
		
		
		
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


	
	
