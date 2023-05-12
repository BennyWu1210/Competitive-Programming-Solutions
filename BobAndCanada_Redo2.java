import java.io.*;
import java.util.*;
public class BobAndCanada_Redo2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException{

		int T = readInt();

		for(int t=0; t<T; t++) {

			int N = readInt();
			char[] input = readLine().toCharArray();

			long[] w = new long[N];
			long[] r = new long[N];

			for(int i=0; i<N; i++) {
				if(input[i] == 'R') r[i] ++;
				else w[i] ++;
			}

			for(int i=1; i<N; i++) {
				r[i] += r[i-1];
				w[i] += w[i-1];
			}

			int aIndex = -1;
			long aBest = Integer.MAX_VALUE;
			long allBest = Integer.MAX_VALUE;

			for(int b=1; b<=N-2; b++) {
				if (aBest > w[b-1] - r[b-1]) {
					aBest = w[b-1] - r[b-1];
					aIndex = b-1;
				}

				long newVal = (w[N-1] - w[b]) + (r[b] - r[aIndex]) + (w[aIndex]);
				allBest = Math.min(allBest, newVal);

			}
			System.out.println(allBest);
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
