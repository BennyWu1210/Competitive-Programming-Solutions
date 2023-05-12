
import java.io.*;
import java.util.*;

public class oly22practice80 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int[] dir = {1, -1, -1, 0, 1, 1, 0, -1, 1};
	public static void main(String[] args) throws IOException {

		// for (int i = 1; i < dir.length; i++) System.out.println(dir[i - 1] + " " + dir[i]);
		int Y = readInt(), X = readInt(), y = readInt(), x = X - readInt() + 1;
		
		
		char[][] grid = new char[X + 1][Y + 1];
		int[][] steps = new int[X + 1][Y + 1];
		
		for (int i = 1; i <= X; i++) {
			char[] ipt = readLine().toCharArray();
			for (int j = 1; j <= Y; j++) {
				
				grid[i][j] = ipt[j - 1];
				steps[i][j] = Integer.MAX_VALUE;
			}
		}
		
		steps[x][y] = 0;
		Queue<int[]> q = new LinkedList();
		q.add(new int[] {x, y});
		
		if (grid[x][y] == '*') throw new AssertionError();
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int curX = cur[0], curY = cur[1];
			
			for (int i = 1; i < dir.length; i++) {
				int newX = curX + dir[i - 1], newY = curY + dir[i];
				
				
				if (newX >= 1 && newX <= X && newY >= 1 && newY <= Y && grid[newX][newY] != '*') {
					if (steps[newX][newY] > steps[curX][curY] + 1) {
						
						steps[newX][newY] = steps[curX][curY] + 1;
						q.add(new int[] {newX, newY});
					}
				}
			}
			
		}
		
		int ans = 0;
		
		for (int i = 1; i <= X; i++) {
			for (int j = 1; j <= Y; j++) {
				if (grid[i][j] != '*') ans = Math.max(ans, steps[i][j]);
//				if (grid[i][j] != '*') System.out.print(steps[i][j]);
//				else System.out.print('*');
//			
			}
//			System.out.println();
			
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


	
	
