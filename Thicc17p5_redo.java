
import java.io.*;
import java.util.*;

public class Thicc17p5_redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		long N  = readLong(), K = readLong();
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		Deque<long[]> dq = new LinkedList<long[]>();
		long ans = 0;
		
		for(int i=0; i<N; i++) {
			long num = readLong();
			long diverse = 1;
//			for(int[] j: dq) System.out.println(Arrays.toString(j));
			if (!map.containsKey(num)) {
				if (!dq.isEmpty()) {
					diverse = dq.peek()[1] + 1;
				}
				else {
					diverse = 1;
				}
				map.put(num, 1L);
			}
			else {
				if (map.get(num) == 0) {
					diverse = dq.peek()[1] + 1;
				}
				else {
					diverse = dq.peek()[1];
				}
				map.put(num, map.get(num)+1);
				
			}
//			System.out.println(diverse);
//			System.out.println(map);
			while(!dq.isEmpty() && diverse >= K) {
				long first = dq.pollLast()[0];
				if (map.get(first) == 1) {
					diverse --;
				}
				ans += N - i;
				map.put(first, map.get(first)-1);
				
				
			}
			if (K == 1) ans ++;
			dq.push(new long[]{num, diverse});
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


	
	
