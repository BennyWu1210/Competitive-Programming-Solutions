
import java.io.*;
import java.util.*;

public class Ecoo21p4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {

		long K = readLong();

		long sum = K+1;
		HashMap<Integer, Integer> map = new HashMap<>();

		int count = 1;
		long ans = 0;
		
		for (int i=2; i<sum && sum != 1; i++) {
			boolean checked = false;
			while (sum % i == 0) {
				checked = true;
				sum /= i;
				ans += i - 1;
				// System.out.println(count);
				if (!map.containsKey(i - 1)) {
					map.put(i - 1, 1);
				}
				else {
					map.put(i - 1, map.get(i - 1) + 1);
				}
			}
			if (checked) count ++;
			
		}
		
		System.out.println(ans);
		System.out.println(map);
		for (int i=1; i<count; i++) {
			System.out.println(i);
			for (int j=0; j<map.get(i); j++) {
				System.out.print(count + " ");
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




