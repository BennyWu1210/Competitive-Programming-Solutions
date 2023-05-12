
import java.io.*;
import java.util.*;

public class H_Hamburgers {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int b, s, c;
	static int nb, ns, nc;
	static int pb, ps, pc;
	static long r;
	
	static boolean check(long x) {
		long totalB = b*x - nb, totalS = s*x - ns, totalC = c*x - nc;
		
		long money = r;
		
		money -= (totalB > 0) ? totalB * pb : 0;
		money -= (totalS > 0) ? totalS * ps : 0;
		money -= (totalC > 0) ? totalC * pc : 0;
		
		return money >= 0;
	}
	
	public static void main(String[] args) throws IOException {

		char[] hamburger = readLine().toCharArray();
		b = 0; s = 0; c = 0;
		
		for (char cc: hamburger) {
			if (cc == 'B') b++;
			if (cc == 'S') s++;
			if (cc == 'C') c++;
		}

		nb = readInt(); ns = readInt(); nc = readInt();
		pb = readInt(); ps = readInt(); pc = readInt();
		r = readLong();
		
		long left = 0, right = (long)1e13;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			if (check(mid)) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		
		System.out.println(left - 1);
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


	
	
