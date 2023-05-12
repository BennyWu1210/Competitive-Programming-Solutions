
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Coci15c2p4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;



	public static void main(String[] args) throws IOException {

		int N = readInt();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String[] input = new String[N];

		for (int i=0; i<N; i++) {
			String ipt = readLine();
			input[i] = ipt;
			if (!map.containsKey(ipt)) {
				map.put(ipt, 0);
			}

		}


		for (int i=0; i<N; i++) {
			String str = input[i];

			int startI = 0;
			int endI = str.length()-1;
			String front = "";
			String back = "";

			for(; startI < str.length() && endI >= 0;) {
				front += str.charAt(startI) + "";
				back += str.charAt(endI) + "";

				if (front.equals(back) && map.containsKey(front)) {
					map.put(front, map.get(front) + 1);
				}

				startI ++;
				endI --;
			}
		}

		int ans = 0;
		for (Entry<String, Integer> set : map.entrySet()) {
			ans = Math.max(ans, set.getValue());

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




