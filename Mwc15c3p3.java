
import java.io.*;
import java.util.*;


public class Mwc15c3p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	final static int[] xDir = new int[] {1, 1, 1, -1, -1, -1, 0, 0};
	final static int[] yDir = new int[] {0, -1, 1, 0, -1, 1, -1, 1};
	static HashMap<String, Boolean> map = new HashMap<String, Boolean>();
	
	static void dfs (int curX, int curY, String curStr, char[][] mat) {
		for(int i=0; i<xDir.length; i++) {
			int x = curX + xDir[i], y = curY + yDir[i];
			if (x >= 0 && x < mat.length && y >= 0 && y < mat.length) {
				
//				if (curStr.charAt(0) == 'p' && curX == 2) {
//					System.out.println(curStr);
				//}
				if (curStr.indexOf(mat[x][y]) == -1) {
				
					String str = curStr + mat[x][y];
					// if (!map.containsKey(str)) {
						map.put(str, true);
						dfs(x, y, str, mat);
					
				}
				
			}
		}
	}
	public static void main(String[] args) throws IOException {
		int N = readInt(), Q = readInt();
		char[][] mat = new char[N][N];
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				mat[i][j] = readCharacter();
			}
		}
		
		String[] words = new String[Q];
		for(int i=0; i<Q; i++) {
			String ipt = readLine();
			words[i] = ipt;
			map.put(ipt, false);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				dfs(i, j, Character.toString(mat[i][j]), mat);
			}
		}
		
		for(String str: words) {
			if (map.get(str)) {
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


	
	
