
import java.io.*;
import java.util.*;

public class Selection_2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class Pair implements Comparable<Pair>{
		long a, v;
		
		public Pair(long a, long v) {
			this.a = a;
			this.v = v;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return Long.compare(this.a, o.a);
		}
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		Pair[] pairs = new Pair[N];
		
		for (int i=0; i<N; i++) {
			pairs[i] = new Pair(readLong(), readLong());
		}
		
		Arrays.sort(pairs);
		
		long totalV = 0;
		long maxA = (long)-1e20, minA = (long)1e20+1;
		
		int index = 0;
		for (int i=N-1; i>=0; i--) {
			Pair cur = pairs[i];
			if (cur.v >= cur.a) {
				totalV += cur.v;
				maxA = Math.max(maxA, cur.a);
				minA = Math.min(minA, cur.a);
				index = i;
				break;
			}
		}
		
		long prevV = 0;
		for (int i=0; i<index; i++) {
			Pair cur = pairs[i];
			
			if (cur.v >= cur.a) {
				totalV += cur.v;
				prevV = cur.v;
				minA = cur.a;
			}
			
			if (cur.v - cur.a < cur.a - minA) {
				totalV += cur.v;
				totalV -= prevV;
				minA = cur.a;
				
			}
			
			
		}
		System.out.println(maxA + " " + minA);
		System.out.println(totalV - (maxA - minA));
		
		
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


	
	
