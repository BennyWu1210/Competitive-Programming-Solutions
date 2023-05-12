
import java.io.*;
import java.util.*;

public class ccc21s5 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int MM = 150000 + 10, LOG = 17;
	static int N, M;
	static int[][] dif = new int[LOG][MM], spt = new int[18][MM];
	static int[] x = new int[MM], y = new int[MM], z = new int[MM];
	
	static int gcd(int x, int y) {
		return y == 0 ? x : gcd(y, x%y);
	}
	
	static int lcm(int x, int y) {
		return x / gcd(x, y) * y;
	}
	
	static int query(int x, int y) {
		int k = 31 - Integer.numberOfLeadingZeros(y-x+1);
		return gcd(spt[k][x], spt[k][y-(1<<k)+1]);
	}
	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt();
		
		for (int i=1; i<=M; i++) {
			x[i] = readInt(); y[i] = readInt(); z[i] = readInt();
			
			dif[z[i]][x[i]] ++; dif[z[i]][y[i]+1] --;
		}
		
		for (int i=1; i<=N; i++) {
			spt[0][i] = 1;
			
			for (int j=1; j<=16; j++) {
				dif[j][i] += dif[j][i-1];
				
				if (dif[j][i] > 0) spt[0][i] = lcm(spt[0][i], j);
			}
		}
		
		for (int k=1; k<spt.length; k++) {
			for (int i=1; i+(1<<k)-1<=N; i++) {
				spt[k][i] = gcd(spt[k-1][i], spt[k-1][i+(1<<k-1)]);
			}
		}
		
		for (int i=1; i<=M; i++) {
			int g = query(x[i], y[i]);
			
			if (g != z[i]) {
				System.out.println("Impossible");
				return;
			}
		}
		
		for (int i=1; i<=N; i++) System.out.print(spt[0][i] + " ");
		
		
		
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


	
	
