
import java.io.*;
import java.util.*;

public class cco16p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class Bunny{
		int x, y, w;
		public Bunny(int x, int y, int w) {
			this.x = x; this.y = y; this.w = w;
		}
		
	}
	
	static class Line implements Comparable<Line>{
		int x1, y1, x2, y2, w;
		public Line(int x1, int y1, int x2, int y2, int w) {
			this.x1 = x1; this.y1 = y1; this.x2 = x2; this.y2 = y2; this.w = w;
		}
		@Override
		public int compareTo(Line o) {
			return Long.compare(((long)this.x2 - this.x1) * ((long)o.y2 - o.y1), ((long)o.x2 - o.x1) * ((long)this.y2 - this.y1));
		}
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), tot = 0, ans = 0;
		Bunny[] bunnies = new Bunny[N];
		for (int i=0; i<N; i++) {
			int x = readInt(), y = readInt(), w = readInt();
			tot += w;
			bunnies[i] = new Bunny(x, y, w);
		}
		
		ans = tot;
		
		for (int i=0; i<N; i++) {	
			List<Line> lines = new ArrayList();
			
//			System.out.println("i: " + i);
//			System.out.println(bunnies[i].x + " " + bunnies[i].y + " " + bunnies[i].w);
			int temp = tot;
			// if (bunnies[i].w < 0) temp -= bunnies[i].w;
			
//			System.out.println(temp);
//			System.out.println();
			
			int cur_x = bunnies[i].x, cur_y = bunnies[i].y;
			for (int j=0; j<N; j++) {
				if (j == i) continue;
				int nxt_x = bunnies[j].x, nxt_y = bunnies[j].y, w = bunnies[j].w;
				lines.add(new Line(cur_x, cur_y, nxt_x, nxt_y, w));
			}
			
			Collections.sort(lines);
			
			for (int j=0; j<lines.size(); j++) {
				temp -= lines.get(j).w;
				// System.out.println(lines.get(j).w + " " + temp);
				ans = Math.max(ans, temp);
			}
			
			// System.out.println(" ==== ");
		}
		
		System.out.println(ans);
		
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


	
	
