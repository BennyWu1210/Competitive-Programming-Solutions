
import java.io.*;
import java.util.*;
public class UnevenSand {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		long num = (long) (Math.pow(10, 9)*2 + 1);
		long left = 1;
		long right = num;
		while(true) {
			long middle = (left+right)/2; // Determine the middle number
			System.out.println(middle); // Output the number
			
			
			String result = next(); // Read the result: SINKS - Too Low; FLOATS - Too high; OK - Correct
			
			if (result.equals("SINKS")) {
				left = middle+1;
			}
			else if (result.equals("FLOATS")) {
				right = middle-1;
			}
			else {
				break;
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
