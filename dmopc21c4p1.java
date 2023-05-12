
import java.io.*;
import java.util.*;

public class dmopc21c4p1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final double MAX = Integer.MAX_VALUE;
	static class Tri{
		Point a, b, c;
		public Tri(double x0, double y0, double x1, double y1, double x2, double y2) {
			a = new Point(x0, y0); b = new Point(x1, y1); c = new Point(x2, y2);
		}
	}
	
	static class Point{
		double x, y;
		public Point(double x, double y) {
			this.x = x; this.y = y;
		}
	}
	
	static Tri[] triangles;
	
	static double calc(Point a, Point b, Point c) {
		return (a.x - c.x) * (b.y - c.y) - (b.x - c.x) * (a.y - c.y);
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), Q = readInt();
		triangles = new Tri[N];
		
		for (int i=0; i<N; i++) {
			triangles[i] = new Tri(readDouble() + MAX, readDouble() + MAX, readDouble() + MAX, readDouble() + MAX, readDouble() + MAX, readDouble() + MAX);
		}
		
		for (int i=0; i<Q; i++) {
			double x = readDouble() + MAX, y = readDouble() + MAX;
			Point p = new Point(x, y);
			int ans = 0;
			for (Tri t: triangles) {				
				double A = calc(p, t.a, t.b), B = calc(p, t.b, t.c), C = calc(p, t.c, t.a);
				
				boolean neg = A < 0 || B < 0 || C < 0;
				boolean pos = A > 0 || B > 0 || C > 0;
				
				if (!(neg && pos)) ans ++;
			}
			System.out.println(ans);
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


	
	
