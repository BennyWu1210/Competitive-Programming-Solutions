
import java.io.*;
import java.util.*;

public class UsacoJanP2 {

	static StringTokenizer stk;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	


	public static void main(String[] args) throws IOException{
		int N = readInt();
		int[] h = new int[N+1];
		for (int i=1; i<=N; i++) h[i] = readInt();
		Deque<Integer> dq = new LinkedList();
		
		long ans = 0;
		dq.add(1);
		
		for (int i=2; i<=N; i++) {
			while (!dq.isEmpty() && h[dq.peekLast()] <= h[i]) {
				int j = dq.pollLast();
				ans += (i - j + 1);
			}
			if (!dq.isEmpty()) ans += (i - dq.peekLast() + 1);
			dq.addLast(i);
		}
		System.out.println(ans);
	}
	
	static String next() throws IOException {
		while (stk == null || !stk.hasMoreElements()) stk = new StringTokenizer(br.readLine());
		return stk.nextToken();
	}
	
	static long readLong() throws NumberFormatException, IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}
}


	
	
