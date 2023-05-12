
import java.io.*;
import java.util.*;

public class bsspc21sp2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int N, K, Q;
	
	static class Pair{
		long x, y;
		public Pair(long x, long y) {
			this.x = x; this.y = y;
		}
	}
	
	static class Square{
		Pair a, b;
		public Square(Pair a, Pair b) {
			this.a = a;
			this.b = b;
		}
	}
	
	static boolean inSquare(Square s, long x, long y) {
		return x >= s.a.x && x <= s.b.x && y >= s.a.y && y <= s.b.y;
	}
	
	public static void main(String[] args) throws IOException {

		N = readInt(); K = readInt(); Q = readInt();
		
		Square[] sq = new Square[K];
		for (int i=0; i<K; i++) {
			sq[i] = new Square(new Pair(readInt(), readInt()), new Pair(readInt(), readInt()));
		}
		
		for (int i=0; i<Q; i++) {
			long x = readInt(), y = readInt();
			Pair p = new Pair(x, y);
			
			
			for (int k=K-1; k>=0; k--) {
				Square s = sq[k];
				if (!inSquare(s, x, y)) continue;
				long bx = s.a.x, by = s.a.y, ex = s.b.x, ey = s.b.y;
				long new_y = by + (x - bx), new_x = bx + (ey - y);
				x = new_x; y = new_y;
			}
			
			System.out.println((x - 1) * N + y);
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


	
	
