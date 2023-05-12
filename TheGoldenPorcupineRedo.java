
import java.io.*;
import java.util.*;
public class TheGoldenPorcupineRedo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		long N = readLong();
		long T = readLong();
		
		// Storing the coefficient, then do range update
		long[] diffA = new long[(int)T+2];
		long[] diffB = new long[(int)T+2];
		long[] diffC = new long[(int)T+2];
		
		for(int i=0; i<N; i++) {
			long L = readLong();
			long R = readLong();
			long a = readLong();
			long b = readLong();
			long c = readLong();
			
			diffA[(int) L] += a;
			diffA[(int)R+1] -= a;
			diffB[(int)L] += b-2*a*L;
			diffB[(int)R+1] -= b-2*a*L;
			diffC[(int)L] += c+a*L*L-b*L;
			diffC[(int)R+1] -= c+a*L*L-b*L;
		}
		
		// Recover the diff arrays
		long[] A = new long[(int)T+1];
		long[] B = new long[(int)T+1];
		long[] C = new long[(int)T+1];
		
		for(int i=1; i<=T; i++) {
			A[i] = A[i-1] + diffA[i];
			B[i] = B[i-1] + diffB[i];
			C[i] = C[i-1] + diffC[i];
		}
		
		for(int x=1; x<=T; x++) {
			System.out.print((A[x]*x*x + B[x]*x + C[x]) + " ");
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
