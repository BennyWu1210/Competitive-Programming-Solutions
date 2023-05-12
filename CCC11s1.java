import java.io.*;
import java.util.*;
public class CCC11s1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N = readInt();
		int sCounter = 0;
		int tCounter = 0;
		for (int i=0; i<N; i++) {
			String[] input = readLine().split("");
			for (String str: input) {
				//System.out.println(str);
				if (str.equals("s") || str.equals("S")) {
					sCounter ++;
				}
				else if (str.equals("t") || str.equals("T")) {
					tCounter ++;
				}
			}
		}
		if(sCounter >= tCounter) System.out.println("French");
		else if (sCounter < tCounter) System.out.println("English");

		
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
