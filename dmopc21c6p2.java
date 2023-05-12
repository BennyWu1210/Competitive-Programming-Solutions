
import java.io.*;
import java.util.*;

public class dmopc21c6p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int N, K;
	public static void main(String[] args) throws IOException {

		N = readInt(); K = readInt();
		char[] c = readLine().toCharArray();
		List<Integer> lengths = new ArrayList();
		
		int cur = 0;
		for (int i=0; i<N; i++) {
			if (c[i] == '0') cur ++;
			else{
				lengths.add(cur);
				cur = 0;
			}
		}
		
		lengths.add(cur);
		Collections.sort(lengths);
		
		long ans = 0;
		int ind = lengths.size() - 1;
		for (int i=0; i<K && ind>=0; i++) {
			ans += lengths.get(ind);
			ind --;
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


	
	
