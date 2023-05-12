
import java.io.*;
import java.util.*;

public class Dmpg16s5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		int N = readInt(), K = readInt();
		
		Deque<long[]> dq = new LinkedList<long[]>();
		int[] val = new int[N];
		long[] ans = new long[N];
		for(int i=0; i<N; i++) val[i] = readInt();
		
		Arrays.fill(ans, (int)-1e9);
		
		int index = 0;
		
		while(true) {
			
			if (index == N + K) {
				break;
			}
			int i = index%N;
			int cur = val[i];
			
			if(dq.isEmpty()) {
				ans[i] = cur;
			}
			else{
				ans[i] = Math.max(Math.max(dq.peekFirst()[0]+cur, ans[i]), cur);
			}
			
			
			// if (!dq.isEmpty()) System.out.println(K);
//			System.out.println(index);
//			System.out.println("ans: " + ans[i]);
			// ans[i] = Math.max(ans[i], cur);
			if(!dq.isEmpty() && dq.size() >= K) {
				// System.out.println(index);
				long[] first = dq.pollLast();
				ans[i] = Math.max(ans[i], ans[i]-first[0]);
//				System.out.println("ans: " + ans[i]);
				if (first[1] == N-1) {
					break;
				}
			}
			
//			while(!dq.isEmpty() && dq.peekLast()[0] <= 0) {
//				long first = dq.pollLast()[0];
//				ans[i] = Math.max(ans[i], ans[i]-first);
//				System.out.println("ans: " + ans[i]);
//			}
			if (cur > 0) dq.push(new long[] {cur, index});
			index++;
			

		}
		// System.out.println("===");
		long max = -1;
		for(long l: ans) {
			// System.out.println(l);
			max = Math.max(max, l);
		}
		
		System.out.println(max);
			
		
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


	
	
