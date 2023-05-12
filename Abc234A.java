
import java.io.*;
import java.util.*;

public class Abc234A {

	
	static StringTokenizer stk;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int f(int t) {
		return t * t + 2 * t + 3;
	}
	
	public static void main(String[] args) throws IOException {

		int t = readInt();
		System.out.println(f(f(f(t) + t) + f(f(t))));
		
		
	}

	static String next() throws IOException{
		while (stk == null || !stk.hasMoreTokens()) stk = new StringTokenizer(br.readLine());
		return stk.nextToken();
	}
	
	static int readInt() throws IOException{
		return Integer.parseInt(next());
	}
}


	
	
