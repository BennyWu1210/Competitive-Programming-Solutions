
import java.io.*;
import java.util.*;

public class B_DormsWar {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int t = readInt();
		
		while (t --> 0) {
			int n = readInt();
			char[] c = readLine().toCharArray();
			int[] a = new int[n + 1];
			Map<Character, Integer> map = new HashMap();
			
			int k = readInt();
			for (int i = 1; i <= k; i++) {
				char cur = readCharacter();
				map.put(cur, 1);
			}
			
			for (int i = 1; i <= n; i++) {
				char cur = c[i - 1];
				if (map.containsKey(cur)) a[i] = 1;
				else a[i] = 0;
			}
			
			int[] dis = new int[n + 1];
			int curDis = 0; boolean hasOne = false;
			int ans = 0;
			for (int i = n; i >= 1; i--) {
				curDis ++;
				if (hasOne) dis[i] = curDis;
				
				if (a[i] == 1) {
					hasOne = true;
					curDis = 0;
				}
				
				ans = Math.max(ans, dis[i]);
			}
			
			System.out.println(ans);
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


	
	
