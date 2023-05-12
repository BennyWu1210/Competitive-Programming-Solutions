
import java.io.*;
import java.util.*;

public class Savez {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int n = readInt();
		int base = 131;
		int ans = 0;
		
		HashMap<Long, Integer> map = new HashMap();
		
		for(int i=1; i<=n; i++) {
			String s = readLine();
			long pre = 0, suf = 0;
			long pw = 1;
			int best = 0;
			int m = s.length();
			
			for(int j=0; j<m; j++) {
				
//				System.out.println(pre + " " + base + " " + s.charAt(j) + ": " + (int)s.charAt(j));
//				System.out.println(s.charAt(m - j - 1) + ": " + (int)s.charAt(m - j - 1) + " " + pw + " " + suf);
				
				pre = pre * base + s.charAt(j);
				suf = s.charAt(m - j - 1) * pw + suf;
				pw *= base;
				
//				System.out.println(pre + " " + suf);
//				System.out.println(s.substring(0, j+1) + " " + (pre == suf));
				
				
				if (pre == suf) {
					best = Math.max(best, map.getOrDefault(pre, 0));
				}
			}
			ans = Math.max(ans, best + 1);
			map.put(pre, best + 1);
			
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


	
	
