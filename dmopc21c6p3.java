
import java.io.*;
import java.util.*;

public class dmopc21c6p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static final int MN = 1501;
	static int[][] a = new int[MN][MN];
	static int N, M, K;

	static int[] getDir(int dir) {
		if (dir == 1) return new int[] {1, 0};
		if (dir == 2) return new int[] {0, 1};
		if (dir == 3) return new int[] {-1, 0};
		if (dir == 4) return new int[] {0, -1};
		return null;
	}

	static boolean inBound(int x, int y) {
		return x >= 1 && x <= N && y >= 1 && y <= M;
	}

	static class Step{
		int x, y, v, k;
		public Step(int x, int y, int v, int k) {
			this.x = x; this.y = y; this.v = v; this.k = k;
		}
	}

	public static void main(String[] args) throws IOException {

		N = readInt(); M = readInt(); K = readInt();

		Queue<Step> q = new LinkedList();
		boolean[][] empty = new boolean[MN][MN];
		int[][] min = new int[MN][MN], max_k = new int[MN][MN];

		for (int i=1; i<=N; i++) {
			for (int j=1; j<=M; j++) {
				a[i][j] = readInt();
				empty[i][j] = a[i][j] == 0;
				min[i][j] = Integer.MAX_VALUE;
				if (!empty[i][j]) {
					q.add(new Step(i, j, a[i][j], K));
				}
			}
		}

		while (!q.isEmpty()) {
			Step cur = q.poll();
			
			// if (min[cur.x][cur.y] != K - cur.k) continue;
			for (int d=1; d<=4; d++) {
				int[] dir = getDir(d);
				int new_x = cur.x + dir[0], new_y = cur.y + dir[1];

				if (inBound(new_x, new_y) && empty[new_x][new_y] && 
				(min[new_x][new_y] > min[cur.x][cur.y] + 1 || (min[new_x][new_y] == min[cur.x][cur.y] + 1 && a[new_x][new_y] > cur.v))) {
					min[new_x][new_y] = min[cur.x][cur.y] + 1;
					if (a[new_x][new_y] != 0) a[new_x][new_y] = Math.min(cur.v, a[new_x][new_y]);
					else a[new_x][new_y] = cur.v;
					if (cur.k > 1) {
						q.add(new Step(new_x, new_y, cur.v, cur.k-1));
					}
					
				}
			}
		}

		for (int i=1; i<=N; i++) {
			for (int j=1; j<=M; j++) {
				System.out.print(a[i][j]);
				if (j != M) System.out.print(" ");
			}
			System.out.println();
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

/*
0 0 1 0 0
0 2 0 0 3
0 3 3 0 0
0 1 0 0 2
0 0 1 0 1
 */



