import java.util.*;
import java.io.*;

public class cco12p5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	
	public static void main(String[] args) throws IOException {
		int N = readInt();
		int[] p = new int[N+1];
		boolean[] vis = new boolean[101];
		for (int i=1; i<=N; i++) p[i] = readInt();
		
		Arrays.sort(p);
		for (int n=1; n<=100; n++) {
			if (!vis[n]) {
				vis[n] = true;
				
				int ind = 1;
				for (int i=0; i<=n; i++) {
					while (ind <= N && p[ind] == p[ind-1]) ind ++;
					if (ind > N) break;
					if (Math.round((double)i * 100.0 / n) == p[ind]) ind ++;
				}
				
				if (ind > N) {
					System.out.println(n);
					return;
				}
			}
			
			for (int i=n; i<=100; i+=n) vis[n] = true;
		}
		System.out.println(100);
	}
	
	static String next() throws IOException {
		while (stk == null || !stk.hasMoreTokens()) stk = new StringTokenizer(br.readLine());
		return stk.nextToken();
	}
	
	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
}
