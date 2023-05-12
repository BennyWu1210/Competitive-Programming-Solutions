import java.io.*;
import java.util.*;

public class mccc3j4 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MM = (int)1e3 * 2 + 2;
	static Deque<Integer>[] lst = new LinkedList[MM];
	static int[] ans = new int[MM];
	
	public static void main(String[] args) throws IOException {
		
		for (int i=0; i<MM; i++) lst[i] = new LinkedList();

		int N = readInt(), T = readInt();
		
		for (int i=1; i<=N; i++) {
			int u = readInt();
			lst[i].addLast(u);
		}
		
		for (int i=0; i<T; i++) {
			Deque<Integer>[] temp = new LinkedList[MM];
			for (int j=0; j<MM; j++) temp[j] = new LinkedList();
			
			for (int j=1; j<=N; j++) {
				if (lst[j].isEmpty()) continue;
				int u = lst[j].pollFirst();
				temp[u].addLast(j);
				ans[j] = u;
			}
			
			for (int j=1; j<=N; j++) {
				while (!temp[j].isEmpty()) {
					lst[j].addLast(temp[j].pollFirst());
				}
			}
		}
		
		for (int i=1; i<N; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println(ans[N]);
		
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
