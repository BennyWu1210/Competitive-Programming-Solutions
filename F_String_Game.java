
import java.io.*;
import java.util.*;

public class F_String_Game {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static boolean bSearch(char[] s, char[] p, int i, int[] indices) {
		HashMap<Integer, Boolean> mp = new HashMap<>();
		
		for (int j=i; j<indices.length; j++) {
			mp.put(indices[j], true);
		}
		
		int index = 0;
		for (int j=0; j<s.length; j++) {
			if (!mp.containsKey(j)) continue;
			if (s[j] == p[index]) index++;
			if (index == p.length) return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		
		char[] t = readLine().toCharArray(), p = readLine().toCharArray();
		int[] indices = new int[t.length];
		for (int i=0; i<t.length; i++) {
			indices[i] = readInt() - 1;
		}
		
		int l = 0, r = t.length;
		
		while (l <= r) {
			int mid = (l + r) / 2;
			// System.out.println(l + " " + r);
			if (bSearch(t, p, mid, indices)) {
				l = mid + 1;
			}
			else {
				r = mid - 1;
			}
		}
		
		System.out.println(l-1);
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


	
	
