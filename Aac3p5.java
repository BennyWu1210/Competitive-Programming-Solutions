
import java.io.*;
import java.util.*;

public class Aac3p5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int[] xDir = {-1, 1, 0, 0};
	static int[] yDir = {0, 0, 1, -1};
	static char[] dir = {'U', 'D', 'R', 'L'};
	static int N, M;
	
	// dir: D (down), U (up), L(left), R(right), 
	static void findPath(int r, int c, char[][] mat, int[][] steps, char d, int cont) {
		System.out.println(r + " " + c + " " + steps[r][c] + " " + d);
		if (mat[r][c] == '#') {
			cont = 0;
			// System.out.println(mat[r][c]);
			for(int i=0; i<xDir.length; i++) {
				int nextR = r + xDir[i], nextC = c + yDir[i];
				if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) {
					if (steps[nextR][nextC] < steps[r][c]) {
						steps[nextR][nextC] = steps[r][c];
						findPath(nextR, nextC, mat, steps, dir[i], cont);
					}
				}
			}
		}
		else if(mat[r][c] == '.') {
			// System.out.println(mat[r][c]);
			cont ++;
			for(int i=0; i<4; i++) {
				if (dir[i] == d) {
					int nextR = r + xDir[i], nextC = c + yDir[i];
					if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M) {
						if (steps[r][c] < cont) {
							steps[nextR][nextC] = cont;
							findPath(nextR, nextC, mat, steps, d, cont);
						}
					}
					
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		N = readInt();
		M = readInt();
		
		char[][] mat = new char[N][M];
		int[][] steps = new int[N][M];
		
		for(int i=0; i<N; i++) {
			mat[i] = readLine().toCharArray();
			
		}
		
		for(int i=0; i<N; i++) {
			Arrays.fill(steps[i], -1);
		}
		
		for(int i=0; i<M; i++) {
			if (mat[0][i] == '#') {
				steps[0][i] = 0;
				findPath(0, i, mat, steps, 'D', 0);
			}
		}
		
		// System.out.println(Arrays.deepToString(steps));
		int[] ans = new int[M];
		for(int i=0; i<M; i++) {
			if (mat[N-1][i] == '.') {
				ans[i] = -1;
			}
			else if(steps[N-1][i] == -1) {
				ans[i] = -1;
			}
			else {
				ans[i] = steps[N-1][i];
			}
				
		}
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		
		//System.out.print(ans[ans.length-1]);
		System.out.println();
		
		/*
4 5
#.###
.##.#
.#.##
#.###

3 3
#.#
..#
###
		 */
		

		
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


	
	
