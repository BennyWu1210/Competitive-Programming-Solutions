
import java.io.*;
import java.util.*;

public class coci16c3p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static int[][] nxt = new int[][] {{1, 0}, {0, 1}};
	static int N, M;
	static char[][] grid;

	static String dfs(int r, int c, boolean[][] vis) {

		// vis[r][c] = true;
		if (r == N - 1 && c == M - 1) return "" + grid[r][c];

		String best = "~";
		
		
		int x = r + nxt[0][0], y = c + nxt[0][1];
		int x2 = r + nxt[1][0], y2 = c + nxt[1][1];
		
		if (inBound(x2, y2) && inBound(x, y)) {
			if (grid[x][y] < grid[x2][y2]) {
				String str = grid[r][c] + dfs(x, y, vis);
				if (str.compareTo(best) < 0) {
					best = str;
				}
			}else if (grid[x][y] > grid[x2][y2]) {
				String str = grid[r][c] + dfs(x2, y2, vis);
				if (str.compareTo(best) < 0) {
					best = str;
				}
			}
			else {
				String str = grid[r][c] + dfs(x, y, vis);
				if (str.compareTo(best) < 0) {
					best = str;
				}
				
				str = grid[r][c] + dfs(x2, y2, vis);
				if (str.compareTo(best) < 0) {
					best = str;
				}
			}
		}
		else if (inBound(x2, y2)) {
			String str = grid[r][c] + dfs(x2, y2, vis);
			if (str.compareTo(best) < 0) {
				best = str;
			}
		}
		else if (inBound(x, y)) {
			String str = grid[r][c] + dfs(x, y, vis);
			if (str.compareTo(best) < 0) {
				best = str;
			}
		}


		return best;
	}

	static boolean inBound(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
	public static void main(String[] args) throws IOException {

		N = readInt(); M = readInt();
		grid = new char[N][M];

		for (int i=0; i<N; i++) {
			grid[i] = readLine().toCharArray();
		}

		boolean[][] visited = new boolean[N][M];

		System.out.println(dfs(0, 0, visited));


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




