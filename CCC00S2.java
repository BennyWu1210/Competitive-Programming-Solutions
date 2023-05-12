
import java.io.*;
import java.util.*;
public class CCC00S2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt(); // Number of streams
		
		// Try to brute force through this first
		LinkedList<Double> list = new LinkedList<Double>();
		
		for(int i=0; i<n; i++) {
			double stream = readDouble();
			list.add(stream);
		}
		
		while(true) {
			int input = readInt();
			
			if (input == 77) break;
			
			if (input == 99) {
				int s = readInt();
				int percent = readInt();
				double left = list.get(s-1)*percent/100.0;
				double right = list.get(s-1)*(1.0-percent/100.0);
				
				list.remove(s-1);
				list.add(s-1, right);
				list.add(s-1, left);
			}
			
			if (input == 88) {
				int s = readInt();
				double sum = list.get(s-1)+list.get(s);
				list.remove(s);
				list.remove(s-1);
				list.add(s-1, sum);
			}
			// System.out.println(list);
		}
		
		
		for(double d: list) {
			System.out.print((int)Math.floor(d+0.5) + " ");
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
