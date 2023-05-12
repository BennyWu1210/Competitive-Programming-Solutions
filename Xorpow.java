
import java.io.*;
import java.util.*;

public class Xorpow {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		
		int n = readInt(), k = readInt();
		int[] arr = new int[n+1];
		
		
		for (int i=1; i<=n; i++) {
			arr[i] = readInt();
			arr[i] ^= arr[i-1];
		}
		
		HashMap<Integer, Long> map = new HashMap<>();
		long ans = 0;
		
		for (int i=1; i<=n; i++) {
			
			for (int j=k; j<=128; j*=k) {
				
				int cur = arr[i] ^ j;
				
				ans += map.getOrDefault(cur, 0L);
				
				if (arr[i] == j) {
					ans ++;
				}
			}
			
			if (map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i]) + 1);
			else map.put(arr[i], 1L);
			
		
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


	
	
