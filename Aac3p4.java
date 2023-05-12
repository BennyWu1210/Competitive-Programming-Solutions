
import java.io.*;
import java.util.*;

public class Aac3p4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	static final int MAX = (int)1e9 + 5;

	public static void main(String[] args) throws IOException {
		int N = in.iscan(), M = in.iscan();
		// int[] row = new int[N], col = new int[M];
		// boolean[] rv = new boolean[N], cv = new boolean[M];
		int[] row = new int[N];
		int[] col = new int[M];

		for(int i=0; i<N; i++) {
			int num = in.iscan();
			if (num != -1) {
				row[i] = num-i;
			}
			else {
				row[i] = MAX;
			}
		}

		for(int i=0; i<M; i++) {
			int num = in.iscan();
			if (num != -1) {
				col[i] = num-i;
			}
			else {
				col[i] = MAX;
			}
		}

		Arrays.sort(row);
		Arrays.sort(col);

		int rIndex = 0;
		int cIndex = 0;
		long res = 0;
		while (rIndex < N && cIndex < M) {
			if (row[rIndex] == MAX || col[cIndex] == MAX) {
				break;
			}
			if (row[rIndex] < col[cIndex]) {
				rIndex ++;
			}
			else if (col[cIndex] < row[rIndex]) {
				cIndex ++;
			}
			else if (col[cIndex] == row[rIndex]){
				res ++;

				rIndex ++;
				cIndex ++;
			}

		}
		System.out.println(res);
	}


	static INPUT in = new INPUT(System.in);
	static PrintWriter out = new PrintWriter(System.out);
	private static class INPUT {

		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar, numChars;

		public INPUT (InputStream stream) {
			this.stream = stream;
		}

		public INPUT (String file) throws IOException {
			this.stream = new FileInputStream (file);
		}

		public int cscan () throws IOException {
			if (curChar >= numChars) {
				curChar = 0;
				numChars = stream.read (buf);
			}

			if (numChars == -1)
				return numChars;

			return buf[curChar++];
		}

		public int iscan () throws IOException {
			int c = cscan (), sgn = 1;

			while (space (c))
				c = cscan ();

			if (c == '-') {
				sgn = -1;
				c = cscan ();
			}

			int res = 0;

			do {
				res = (res << 1) + (res << 3);
				res += c - '0';
				c = cscan ();
			}
			while (!space (c));

			return res * sgn;
		}

		public String sscan () throws IOException {
			int c = cscan ();

			while (space (c))
				c = cscan ();

			StringBuilder res = new StringBuilder ();

			do {
				res.appendCodePoint (c);
				c = cscan ();
			}
			while (!space (c));

			return res.toString ();
		}


		public long lscan () throws IOException {
			int c = cscan (), sgn = 1;

			while (space (c))
				c = cscan ();

			if (c == '-') {
				sgn = -1;
				c = cscan ();
			}

			long res = 0;

			do {
				res = (res << 1) + (res << 3);
				res += c - '0';
				c = cscan ();
			}
			while (!space (c));

			return res * sgn;
		}

		public boolean space (int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	}

}




