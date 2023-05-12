
import java.io.*;
import java.util.*;

public class Abc234D {

	
	static StringTokenizer stk;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	

	public static void main(String[] args) throws IOException {

		int N = readInt(), K = readInt();
		
		int[] f = new int[N+1];
		int ans = Integer.MAX_VALUE;
		
		for (int i=1; i<=K; i++) {
			int n = readInt();
			f[n] ++;
			ans = Math.min(ans, n);
		}
		
		System.out.println(ans);
		
		for (int i=K+1; i<=N; i++) {
			int n = readInt();
			f[n] ++;
			if (n > ans) {
				while (f[++ans] == 0) {}
			}
			
			System.out.println(ans);
		}
	}

	static String next() throws IOException{
		while (stk == null || !stk.hasMoreTokens()) stk = new StringTokenizer(br.readLine());
		return stk.nextToken();
	}
	
	static int readInt() throws IOException{
		return Integer.parseInt(next());
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}


	
	
