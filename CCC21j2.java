
import java.io.*;
import java.util.*;

public class CCC21j2 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Poblano", 1500);
		map.put("Mirasol", 6000);
		map.put("Serrano", 15500);
		map.put("Cayenne", 40000);
		map.put("Thai", 75000);
		map.put("Habanero", 125000);
		
		int t = readInt();
		int ans = 0;
		while (--t >= 0) {
			ans += map.get(next());
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


	
	
