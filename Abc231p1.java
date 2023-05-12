
import java.io.*;
import java.util.*;

public class Abc231p1 {

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	
	public static void main(String[] args) throws IOException {

		int D = readInt();
		System.out.println(D / 100.0);
	
	}
	
	static String next() throws IOException {
		while (stk == null || !stk.hasMoreTokens()) stk = new StringTokenizer(br.readLine().trim());
		return stk.nextToken();
	}
	
	static int readInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}
	
}


	
	
