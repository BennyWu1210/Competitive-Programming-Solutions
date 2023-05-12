
import java.io.*;
import java.util.*;

public class coci14c2p2 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		
		Map<String, Integer> map = new HashMap<>();
		String[] names = new String[N];
		
		for (int i=0; i<N; i++) {
			String name = readLine();
			map.put(name, map.getOrDefault(name, 0)+1);
			names[i] = name;
		}
		
		for (int i=0; i<N-1; i++) {
			String name = readLine();
			map.put(name, map.get(name) - 1);
		}
		
		for (int i=0; i<N; i++) {
			if (map.get(names[i]) != 0) {
				System.out.println(names[i]);
				return;
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


	
	
