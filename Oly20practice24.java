
import java.io.*;
import java.util.*;

public class Oly20practice24 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		int T = readInt(), N = readInt();
		int[] num = new int[N];
		int cur = (int)1e5;
		
		for(int i=0; i<N; i++) num[i] = readInt() + (int)1e5;
		
		Arrays.sort(num);
		
		Deque<Integer> dq = new LinkedList<Integer>();
		long ans = 0;
		for(int i=0; i<N && T>0; i++) {
			int n = num[i];
			while (!dq.isEmpty() && dq.peek() < 1e5 && 1e5 < n) {
				if (T - Math.abs(1e5 - dq.peek()) == 0 
						|| T - Math.abs(n - 1e5) == 0) {
					break;
				}
				if (1e5 - dq.peek() < n - 1e5) {
					cur = dq.pop();
					T -= 1e5 - cur;
					System.out.println(cur + " " + T);
					
					ans ++;
					n = cur;
				}
				else {
					cur = n;
					T -= n - 1e5;
					System.out.println(cur + " " + T);
					
					ans ++;
				}
			}
			dq.push(n);
			System.out.println(dq);
			
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


	
	
