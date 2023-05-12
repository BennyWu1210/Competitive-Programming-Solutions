import java.io.*;
import java.util.*;
public class dmopc14p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int I = readInt();
		//LinkedList<Integer> marks = new LinkedList<Integer>();
		int sum = 0;
		for (int i=0; i<I; i++) {
			//marks.add(readInt());
			sum += readInt();
		}
		
		int S = readInt();
		
		for (int i=0; i<S; i++) {
			//marks.add(readInt());
			sum += readInt();
			//System.out.println(sum + " " + i);
			System.out.println((double)Math.round((double)sum/(I+i+1) * 1000.0) / 1000.0);
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
