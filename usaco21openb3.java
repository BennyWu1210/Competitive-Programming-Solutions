
import java.io.*;
import java.util.*;

public class usaco21openb3 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int N, M;
	
	static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}
	public static void main(String[] args) throws IOException {

		N = readInt(); M = readInt();
		char[][] a = new char[N][M];
		
		for (int i=0; i<N; i++) {
			a[i] = readLine().toCharArray();
		}
		
		int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		int ans = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (a[i][j] != 'G') continue;
				List<Integer> lst = new ArrayList();
				int cows = 0;
				for (int[] d: dir) {
					int x = i + d[0], y = j + d[1];
					if (check(x, y)) {
						cows ++;
						lst.add()
					}
				}
				if (cows > 2)  ans ++;
				else if (cows == 2 && !vis[]) 
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


	
	
