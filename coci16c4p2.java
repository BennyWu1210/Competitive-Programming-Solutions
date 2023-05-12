
import java.io.*;
import java.util.*;

public class coci16c4p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {

		int N = readInt();

		String[] input = new String[N];
		for (int i=0; i<N; i++) {
			input[i] = readLine();
		}

		char[] typed = readLine().toCharArray();
		boolean[] match = new boolean[N];

		Arrays.fill(match, true);
		for (int c=0; c<typed.length; c++) {
			for (int i=0; i<N; i++) {
				if (input[i].length() <= typed.length || input[i].charAt(c) != typed[c]) {
					match[i] = false;
				}
			}
		}

		boolean[] cc = new boolean[26];


		for (int i=0; i<N; i++) {
			if (match[i]) {
				cc[input[i].charAt(typed.length) - 'A'] = true;
			}
		}

		char[][] grid = {{'*', '*', '*', 'A', 'B', 'C', 'D', 'E'},
				{'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M'},
				{'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U'},
				{'V', 'W', 'X', 'Y', 'Z', '*', '*', '*'}};

		for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[i].length; j++) {
				if (grid[i][j] == '*') {
					System.out.print('*');
					continue;
				}

				if (!cc[grid[i][j] - 'A']) {
					System.out.print('*');
				}
				else {
					System.out.print(grid[i][j]);
				}

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




