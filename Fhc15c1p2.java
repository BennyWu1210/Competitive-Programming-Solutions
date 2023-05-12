
import java.io.*;
import java.util.*;

public class Fhc15c1p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {

		int T = readInt();
		int base = 29;
		int mod = (int)1e9 + 7;

		for (int t=1; t<=T; t++) {
			int N = readInt();
			long ans = 0;
			HashMap<Long, Boolean> map = new HashMap<>();

			for (int i=0; i<N; i++) {
				String str = next();

				// Create hash 
				long hash = 0;
				long pow = 1;
				boolean changed = false;

				// Loop through the hashes
				for (int j=1; j<=str.length(); j++) {
					hash = (hash * pow  + (str.charAt(j-1)));
					pow = pow * base;
					if (!map.containsKey(hash)) {

						// Add the # of characters once the hash becomes unique
						if (!changed) {
							ans += j;
							changed = true;
						}

						map.put(hash, true);
					}


				}

				// If it is required to type the entire word
				if (!changed) {
					ans += str.length();
				}
			}
			System.out.println("Case #" + t + ": " + ans);
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




