
import java.io.*;
import java.util.*;

public class C_Permutations {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {

		int t = readInt();

		while (t --> 0) {
			int n = readInt();
			int answered = 0;
			int cur = 1;
			int first = 1;
			boolean[] vis = new boolean[n+1];
			int[] res = new int[n+1];
			
			System.out.println("? " + cur);
			System.out.flush();
			readInt();
			
			List<Integer> ans = new ArrayList();
			ans.add(cur); 
			
			while (answered < n) {
				System.out.println("? " + cur);
				System.out.flush();
				int ipt = readInt();
				
				if (ipt == first) {
					int len = ans.size();
					for (int i=0; i<len; i++) {						
						res[ans.get(i)] = ans.get((i + 1) % len);
						vis[ans.get(i)] = true;
					}
					
					answered += len;
					ans = new ArrayList();
					
					for (int i=cur; i<=n; i++) {
						if (!vis[i]) {
							cur = i;
							break;
						}
					}
					
					if (answered == n) break;
					
					System.out.println("? " + cur);
					System.out.flush();
					
					first = readInt();
					ans.add(first);
					
				} else {
					ans.add(ipt);
				}
			}
			
			System.out.print("!");
			for (int i=1; i<=n; i++) {
				System.out.print(" " + res[i]);
			}
			System.out.println();
			System.out.flush();

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

}




