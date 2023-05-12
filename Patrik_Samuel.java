import java.util.*;
import java.io.*;

public class Patrik_Samuel {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(); int a[] = new int[n]; long ans = 0;
		for (int i = 0; i < n; i++) {
			a[i] = readInt();
		}
		
		Deque<Integer> stack = new LinkedList<Integer>(); 
		Deque<Integer> index = new LinkedList<Integer>();
		
		for (int i = n-1; i >= 0; i--) {
			while (!stack.isEmpty() && stack.peek() <= a[i]) {
				stack.pop();
				index.pop();
			}
			ans += stack.isEmpty()? n-i-1:index.peek()-i;
			stack.push(a[i]);
			index.push(i);
		}
		System.out.println(ans);
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