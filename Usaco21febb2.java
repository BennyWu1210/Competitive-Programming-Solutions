
import java.io.*;
import java.util.*;

public class Usaco21febb2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		int N = readInt();
		
		int[][] mat = new int[1000+5][1000+5];
		boolean[][] vis = new boolean[1000+5][1000+5];
		int[] xDir = {1, 0, -1, 0};
		int[] yDir = {0, 1, 0, -1};
		int ans = 0;
		
		for(int i=0; i<N; i++) {
			int x = readInt(), y = readInt();
			
			vis[x][y] = true;
			if (mat[x][y] == 3) {
				ans ++;
			}
			
			for(int j=0; j<4; j++) {
				int nextX = x+xDir[j], nextY = y+yDir[j];
				if (nextX >= 0 && nextX <= 1000 && nextY >= 0 && nextY <= 1000) {

					mat[nextX][nextY] ++;
					if (mat[nextX][nextY] == 4 && vis[nextX][nextY]) {
						ans --;
					}
					if (mat[nextX][nextY] == 3 && vis[nextX][nextY]) {
						ans ++;
					}
				}
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


	
	
