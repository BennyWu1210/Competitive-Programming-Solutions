import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class COCI2Parket {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int R = readInt();
		int B = readInt();
		int area = R+B;
		
		for(int i=1; i<=Math.sqrt(area); i++) {
			if (area % i == 0) {
				int width = i;
				int length = area/i;
				int parameter = (length+width)*2 - 4;
//				System.out.println(width);
//				System.out.println(length);
//				System.out.println(parameter);
				if (parameter == R) {
					System.out.println(Math.max(width, length) + " " + Math.min(width, length));
					break;
				}
				
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
