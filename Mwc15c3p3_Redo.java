
import java.io.*;
import java.util.*;


public class Mwc15c3p3_Redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	final static int[] xDir = new int[] {1, 1, 1, -1, -1, -1, 0, 0};
	final static int[] yDir = new int[] {0, -1, 1, 0, -1, 1, -1, 1};
	
	static boolean dfs (int curX, int curY, String str, int index, char[][] mat, boolean[][] visited) {
		if (index >= str.length()) return true;
		boolean solvable = false;
		
		for(int i=0; i<xDir.length; i++) {
			int x = curX + xDir[i], y = curY + yDir[i];
			
			if (x >= 0 && x < mat.length && y >= 0 && y < mat.length) {
				if (!visited[x][y] && mat[x][y] == str.charAt(index)) {
					visited[x][y] = true;
//					if (str.indexOf(mat[x][y]) != index) {
//						str = "zzz9za";
//						return false;
//					}
					if (dfs(x, y, str, index+1, mat, visited)) {
						solvable = true;
						break;
					}
				}
			}
		}
		return solvable;
	}
	public static void main(String[] args) throws IOException {
		int N = readInt(), Q = readInt();
		char[][] mat = new char[N][N];
		HashMap<Character, ArrayList<int[]>> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				mat[i][j] = readCharacter();
				
				if(!map.containsKey(mat[i][j])) {
					ArrayList<int[]> lst = new ArrayList<int[]>();
					lst.add(new int[] {i, j});
					map.put(mat[i][j], lst);
				}
				else {
					ArrayList<int[]> lst = map.get(mat[i][j]);
					lst.add(new int[] {i, j});
					
					map.put(mat[i][j], lst);
					
				}
			}
		}
		
		for(int i=0; i<Q; i++) {
			String input = readLine();
			
			boolean result = false;
			
			if (input.length() <= 625 && map.get(input.charAt(0)) != null) {
				for(int[] coords: map.get(input.charAt(0))) {
					boolean[][] visited = new boolean[N][N];
					visited[coords[0]][coords[1]] = true;
					// System.out.println(coords[0] + " " + coords[1]);
					if (dfs(coords[0], coords[1], input, 1, mat, visited)) {
						result = true;
						break;
					}
				}
			}
			if (result) {
				System.out.println("good puzzle!");
			}
			else {
				System.out.println("bad puzzle!");
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


	
	
