
import java.io.*;
import java.util.*;

public class Abc231p2 {

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		List<String> names = new ArrayList();
		Map<String, Integer> cnt = new HashMap();
		
		for (int i=0; i<N; i++) {
			String n = next();
			if (!cnt.containsKey(n)) {
				cnt.put(n, 0);
				names.add(n);
			}
			cnt.put(n, cnt.get(n) + 1);
		}
		
		String res = "";
		int max = 0;
		for (String n: names) {
			if (cnt.get(n) > max) {
				max = cnt.get(n);
				res = n;
			}
		}
		
		System.out.println(res);
	
	}
	
	static String next() throws IOException {
		while (stk == null || !stk.hasMoreTokens()) stk = new StringTokenizer(br.readLine().trim());
		return stk.nextToken();
	}
	
	static int readInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}
	
}


	
	
