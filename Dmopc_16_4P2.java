
import java.io.*;
import java.util.*;
public class Dmopc_16_4P2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int B = readInt();
		HashMap<int[], Integer> map = new HashMap<int[], Integer>();
		for(int i=0; i<B; i++) {
			int start = readInt();
			int end = readInt();
			int points = readInt();
			map.put(new int[] {start, end}, points);
			
		}
		
		int F = readInt();
		for(int i=0; i<F; i++) {
			int c = readInt();
			LinkedList<int[]> list = new LinkedList<int[]>();
			for(int[] key: map.keySet()){
				if (key[0] <= c && c <= key[1]) {
					list.add(key);
				}
			}
			for(int[] key: list) map.remove(key);
		}
		
		int sum = 0;
		for(int[] key: map.keySet()) {
			sum += map.get(key);
		}
		
		System.out.println(sum);
		
		
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
