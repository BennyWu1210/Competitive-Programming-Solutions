
import java.io.*;
import java.util.*;

public class Abc234B {

	
	static StringTokenizer stk;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	

	static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x = x; this.y = y;
		}
	}
	

	public static void main(String[] args) throws IOException {

		int t = readInt(); double ans = 0;
		Pair[] pairs = new Pair[t];
		
		for (int i=0; i<t; i++) {
			pairs[i] = new Pair(readInt(), readInt());
		}
		
		for (int i=0; i<t; i++) {
			for (int j=0; j<t; j++) {
				double x = Math.abs(pairs[i].x - pairs[j].x);
				double y = Math.abs(pairs[i].y - pairs[j].y);
				ans = Math.max(ans, Math.sqrt(x * x + y * y));
			}
		}
		
		System.out.println(ans);
	}

	static String next() throws IOException{
		while (stk == null || !stk.hasMoreTokens()) stk = new StringTokenizer(br.readLine());
		return stk.nextToken();
	}
	
	static int readInt() throws IOException{
		return Integer.parseInt(next());
	}
}


	
	
