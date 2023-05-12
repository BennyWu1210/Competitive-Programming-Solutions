
import java.io.*;
import java.util.*;


public class CCC14S3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for(int t=0; t<T; t++) {
			int N = readInt();
			Deque<Integer> lake = new LinkedList<Integer>(),
						branch = new LinkedList<Integer>();
			
			int[] mtn = new int[N];
			
			for(int i=0; i<N; i++) mtn[i] = readInt();
			
			int cur = 1;
			boolean solvable = true;
			for(int i=N-1; i>=0; i--) {
				int next = mtn[i];
				
				while(!branch.isEmpty() && branch.peekFirst() == cur) {
					lake.push(branch.removeLast());
					cur ++;
				}
				
				if (next == cur) {
					lake.push(next);
					cur ++;
				}
				else {
					branch.push(next);
				}
				
				while(!branch.isEmpty() && branch.peekFirst() == cur) {
					int num = branch.removeFirst();
					lake.push(num);
					cur ++;
				}
				
				
			}
//			System.out.println(branch);
//			System.out.println(lake);
//			System.out.println(cur);
			if (cur != N + 1) solvable = false;
			
			if(solvable) {
				System.out.println('Y');
			}
			else {
				System.out.println('N');
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


	
	
