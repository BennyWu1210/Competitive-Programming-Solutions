
import java.io.*;
import java.util.*;

public class sac22cc1p3 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt();
		
		char[][] grid = new char[N][M];
		
		for (int i=0; i<N; i++) {
			grid[i] = readLine().toCharArray();
		}
		
		int Q = readInt();
		
		for (int i=0; i<Q; i++) {
			int c = readInt();
			
			if (c == 1) {
				boolean moved = true;
				for (int x=N-1; x>=0; x--) {
					for (int y=0; y<M; y++) {
						if (grid[x][y] == 'X') {
							grid[x][y] = '.';
							if (x == N - 1) {
								continue;
							}
							grid[x+1][y] = 'X';
							
						}
					}
				}
				
//				for (int j=0; j<N; j++) {
//					System.out.println(grid[j]);
//				}
//				
				while (moved) {
					moved = false;
					for (int x=0; x<N; x++) {
						for (int y=0; y<M; y++) {
							if (grid[x][y] == 'W') {
								int yPos = y;
								while (yPos - 1 >= 0 && grid[x][yPos-1] == '.') {
									moved = true;
									yPos --;
								}
								
								grid[x][y] = '.';
								grid[x][yPos] = 'W';
							}
						}
					}
					
//					for (int j=0; j<N; j++) {
//						System.out.println(grid[j]);
//					}
					
					boolean[][] stop = new boolean[N][M];
					
					for (int x=0; x<N; x++) {
						for (int y=0; y<M; y++) {
							if (grid[x][y] == 'W') {
								if (x + 1 < N && grid[x+1][y] == '.' && !stop[x][y]) {
									moved = true;
									stop[x+1][y] = true;
									grid[x][y] = '.';
									grid[x+1][y] = 'W';
								}
							}
						}
					}
				}
				
			}
			else {
				for (int j=0; j<N; j++) {
					System.out.println(grid[j]);
				}
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


	
	
