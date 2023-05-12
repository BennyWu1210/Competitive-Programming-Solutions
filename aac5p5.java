
import java.io.*;
import java.util.*;

public class aac5p5 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static int H, V;
	static long ans;
	static class Horizontal{
		int y, x1, x2;
		public Horizontal(int y, int x1, int x2) {
			this.y = y;
			this.x1 = x1;
			this.x2 = x2;
		}
	}

	static class Vertical{
		int x, y1, y2;
		public Vertical(int x, int y1, int y2) {
			this.x = x;
			this.y1 = y1;
			this.y2 = y2;
		}
	}

	public static void main(String[] args) throws IOException {

		H = readInt();
		V = readInt();
		Horizontal[] h = new Horizontal[H];
		Vertical[] v = new Vertical[V];

		for (int i=0; i<H; i++) {
			h[i] = new Horizontal(readInt(), readInt(), readInt());
		}
		for (int i=0; i<V; i++) {
			v[i] = new Vertical(readInt(), readInt(), readInt());
		}

		for (int i=0; i<H; i++) {
			for (int j=i+1; j<H; j++) {
				// two horizontal lines
				if (h[i].y != h[j].y) {
					for (int z=0; z<V; z++) {
						if (v[z].y1 <= h[i].y && v[z].y2 >= h[j].y) {
							if (v[z].x >= h[i].x1 && v[z].x <= h[i].x2) {
								for (int q=z+1; q<V; q++) {
									if (v[q].x != v[z].x && v[q].x >= h[i].x1 && v[q].x <= h[i].x2) {
										ans ++;
									}
								}
							} 
							
						} else if (v[z].y1 <= h[j].y && v[z].y2 >= h[i].y) {
							if (v[z].x >= h[i].x1 && v[z].x <= h[i].x2) {
								for (int q=z+1; q<V; q++) {
									if (v[q].x != v[z].x && v[q].x >= h[i].x1 && v[q].x <= h[i].x2) {
										ans ++;
									}
								}
							} 
							
						}
						
					}
				}
			}
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




