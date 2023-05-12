
import java.io.*;
import java.util.*;

public class bsspc21sp1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt();
		char[][] mat = new char[N][M];
		Queue<int[]> coords = new LinkedList();

		for (int i=0; i<N; i++) {
			mat[i] = readLine().toCharArray();
			for (int j=0; j<M; j++) {
				if (mat[i][j] != '.') coords.add(new int[] {i, j});
			}
		}
		
		boolean canForm = true;
		
		while (!coords.isEmpty()) {
			int[] pos = coords.poll();
			int i = pos[0], j = pos[1];
			char c = mat[i][j];
			int rv = N - i - 1;
			int cv = M - j - 1;

			if (c != mat[i][cv] && mat[i][cv] != '.' || c != mat[rv][j] && mat[rv][j] != '.') canForm = false;
			if (mat[i][cv] == '.') {
				mat[i][cv] = c;
				coords.add(new int[] {i, cv});
			}
			if (mat[rv][j] == '.') {
				mat[rv][j] = c;
				coords.add(new int[] {rv, j});
			}
			
			if (!canForm) break;
		}
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (mat[i][j] == '.') {
					mat[i][j] = 'a';
					int rv = N - i - 1;
					int cv = M - j - 1;
					mat[i][cv] = 'a';
					mat[rv][j] = 'a';
				}
			}
		}

		if (!canForm) System.out.println(-1);
		else {
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					System.out.print(mat[i][j]);
				}
				System.out.println();
			}
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




