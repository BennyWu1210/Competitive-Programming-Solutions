
import java.io.*;
import java.util.*;


public class DP_Sushi {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int max = 300 + 5;
	
	public static void main(String[] args) throws IOException {
		int N = readInt();
		int[] sushi = new int[4];
		double[][][] p = new double[max][max][max];
		double[][][] ev = new double[max][max][max];
		
		for(int i=0; i<N; i++) {
			sushi[readInt()] ++;
		}
		
		p[sushi[1]][sushi[2]][sushi[3]] = 1;
		for(int c=sushi[3]; c>=0; c--) {
			for(int b=sushi[3]+sushi[2]; b>=0; b--) {
				for(int a=sushi[1]+sushi[2]+sushi[3]; a>=0; a--) {
					if (a + b + c == 0 || a + b + c > N) {
						continue;
					}
					
					double p_waste = (double) (N - (a+b+c)) / N;
					double ev_waste = p_waste / (1 - p_waste) + 1;
					ev[a][b][c] += ev_waste * p[a][b][c];
					
					if (a != 0) {
						double lose = (double) a / (a+b+c);
						p[a-1][b][c] += p[a][b][c] * lose;
						ev[a-1][b][c] += ev[a][b][c] * lose;
					}
					
					if (b != 0) {
						double lose = (double) b / (a+b+c);
						p[a+1][b-1][c] += p[a][b][c] * lose;
						ev[a+1][b-1][c] += ev[a][b][c] * lose;
					}
					
					if (c != 0) {
						double lose = (double) c/ (a+b+c);
						p[a][b+1][c-1] += p[a][b][c] * lose;
						ev[a][b+1][c-1] += ev[a][b][c] * lose;
					}
				}
			}
		}
		
		System.out.println(ev[0][0][0]);
		
		
		
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


	
	
