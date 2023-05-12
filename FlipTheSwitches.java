
import java.io.*;
import java.util.*;
public class FlipTheSwitches {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int N = readInt();
		String[] input = readLine().split("");
		int counter = 1; // how many switches
		int index = N-1;
		
		while(index >= 0 && input[index].equals("0")) index --;
		if (index == 0) {
			System.out.println("1");
			return;
		}
		if(index == -1) {
			System.out.println("0");
			return;
		}
			
		for(int i=index; i>0; i--) { // Find number of intervals
			if (input[i].equals(input[i-1])) {
				continue;
			}
			else {
				counter++;
			}
		}
		
		System.out.println(counter);
		
		
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
