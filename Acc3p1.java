
import java.io.*;
import java.util.*;


public class Acc3p1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {

		
		int N = readInt(), K = readInt(), arr[] = new int[N];
		Deque<int[]> q = new LinkedList<int[]>();
		int[] map = new int[(int)1e6+1];
		long ans = 0;
		
		for(int i=0; i<N; i++) {
			int input = readInt();
			int diverse = 1;

			map[input] ++;
			int count = map[input];
			
			if(!q.isEmpty() && count > 1) {
				diverse = q.peek()[2];
			}
			if(!q.isEmpty() && count == 1) {
				diverse = q.peek()[2] + 1;
			}
			while(!q.isEmpty() && diverse >= K) {
				ans += N - q.peek()[1] - 1;
				int[] last = q.pollLast();
				map[last[0]] --;
				if (map[last[0]] == 0) {
					diverse --;
				}
			}
			
			if (K == 1) ans ++;
			q.push(new int[] {input, i, diverse});
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


	
	
