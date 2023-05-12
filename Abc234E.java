
import java.io.*;
import java.util.*;

public class Abc234E {

	
	static StringTokenizer stk;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static String X;
	static int INF = (int)1e9 + 5;
	
	static int solve() {
		int num = X.charAt(0) - '0';
		
		int ret = INF;
		for (int j=-9; j<=9; j++) {
			if (num + (X.length() - 1) * j >= 10 && j > 0 || num + (X.length() - 1) * j < 0 && j < 0) continue;
			boolean ans = true;
			for (int z=1; z<X.length(); z++) {
				int cur = X.charAt(z) - '0';
				int exp = (X.charAt(z-1) - '0') + j;
				
				if (cur < exp) {
					ans = true;
					break;
				}
				else if (cur > exp) {
					ans = false;
					break;
				}
				
			}
			
			if (ans) {
				ret = j;
				break;
			}
		}
		
		return ret;
		
	}
	
	static int findInc(int x, int len) {
		int ret = INF;
		for (int j=-9; j<=9; j++) {
			if (x + (len - 1) * j >= 10 && j > 0 || x + (len - 1) * j < 0 && j < 0) continue;
			ret = j;
			break;
			
		}
		
		return ret;
		
	}
	
	
	public static void main(String[] args) throws IOException {

		X = readLine();
		int inc = solve(), ori = X.charAt(0) - '0';
		if (inc == INF) {
			inc = findInc(ori + 1, X.length());
			ori ++;
		}
		
		for (int i=0; i<X.length(); i++) {
			System.out.print(ori + inc * i);
		}
		System.out.println();
		
		
	}

	static String next() throws IOException{
		while (stk == null || !stk.hasMoreTokens()) stk = new StringTokenizer(br.readLine());
		return stk.nextToken();
	}
	
	static int readInt() throws IOException{
		return Integer.parseInt(next());
	}
	
	static long readLong() throws IOException{
		return Long.parseLong(next());
	}
	
	
}


	
	
