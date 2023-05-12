
import java.io.*;
import java.util.*;

public class Usaco21febb3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int T = readInt();
		
		while (T --> 0) {
			int[] dir = new int[200];
			char[] query = readLine().toCharArray();
			int CW = 0;
			
			for (char c: query) {
				dir[c] ++;
				
				if (c == 'E') {
					if (dir['E'] > dir['W']) {
						if (dir['N'] > dir['S']) {
							CW --;
						}
						else if (dir['N'] < dir['S']) {
							CW ++;
						}
					}
				}
				if (c == 'W') {
					if (dir['W'] > dir['E']) {
						if (dir['N'] > dir['S']) {
							CW --;
						}
						else if (dir['N'] < dir['S']) {
							CW ++;
						}
					}

				}
				if (c == 'N') {
					if (dir['W'] > dir['E']) {
						if (dir['N'] > dir['S']) {
							CW --;
						}
						else if (dir['N'] < dir['S']) {
							CW ++;
						}
					}

				}
				if (c == 'S') {
					if (dir['W'] > dir['E']) {
						if (dir['N'] > dir['S']) {
							CW --;
						}
						else if (dir['N'] < dir['S']) {
							CW ++;
						}
					}

				}


			}
			
			String res = CW < 0 ? "CW" : "CCW";
			System.out.println(res);
			
			
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


	
	
