
import java.io.*;
import java.util.*;


public class CCC11S5_Redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int k = readInt();
		int mask = 0;
		for(int i=0; i<k; i++) {
			int input = readInt();
			mask = mask | input << i;
		}
		
		boolean[] vis = new boolean[1<<k];
		Queue<Integer> queue = new LinkedList<Integer>();
		vis[mask] = true;
		int dis = 0;
		queue.add(mask);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0; i<size; i++) {
				int cur_mask = queue.poll();
				if (cur_mask == 0) {
					System.out.println(dis);
					return;
				}
				for(int j=0; j<k; j++) {
					if ((cur_mask & 1 << j) == 0) {
						int new_mask = cur_mask | (1 << j);
						new_mask = solve(new_mask, k);
						if (!vis[new_mask]) {
							queue.add(new_mask);
							vis[new_mask] = true;
						}
					}
				}
			}
			dis += 1;
			
		}
		
		
		
	}
	
	static int solve(int mask, int n) {
		int cnt = 0;
		for(int i=0; i<=n; i++) {
			if ((mask & 1<<i) == (1<<i)) {
				cnt ++;
				continue;
			}
			else if(cnt >= 4) {
				int new_mask = ((1<<cnt)-1) << (i-cnt);
				mask^=new_mask;
				return mask;
			}
			cnt = 0;
		}
		
		return mask;
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


	
	
