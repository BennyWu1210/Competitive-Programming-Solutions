
import java.io.*;
import java.util.*;
public class MWC15P2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		Deque<int[]> queue = new LinkedList<int[]>();
		
		int N = readInt();
		int[] arr = new int[N];
		int[] ans = new int[N];

		for(int i=0; i<N; i++) {
			arr[i] = readInt();
		}
		
		for(int i=0; i<N; i++) {
			int cur = arr[i];
			int index = -1;

			while(!queue.isEmpty() && queue.peek()[0] <= cur) {				
				queue.pop();
			}
			
			if (!queue.isEmpty()) index = queue.peek()[1];

			ans[i] = index;
			queue.push(new int[] {cur, i});
			
		}
		
		// System.out.println(Arrays.toString(ans));
		System.out.print(0 + " ");
		for(int i=1; i<N; i++) {
			if (ans[i] == -1) {
				System.out.print(i + " ");
			}
			else {
				System.out.print(i-ans[i] + " ");
			}
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
