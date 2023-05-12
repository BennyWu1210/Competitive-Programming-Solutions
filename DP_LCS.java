
import java.io.*;
import java.util.*;


public class DP_LCS {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		String a = readLine();
		String b = readLine();
		// if (a.equals("axyb")) {System.out.println("axb"); return;}

		
		int[][] dp = new int[a.length()+1][b.length()+1];

		for(int i=0; i<=a.length(); i++) {
			for(int j=0; j<=b.length(); j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}
				else if (a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		
		int index = dp[a.length()][b.length()];
		char[] lcs = new char[index];
		int i = a.length();
		int j = b.length();
		
		while(i > 0 && j > 0) {
			if (a.charAt(i-1) == b.charAt(j-1)) {
				lcs[index-1] = a.charAt(i-1);
				i --;
				j --;
				index--;
			}
			else if(dp[i-1][j] > dp[i][j-1]) {
				i --;
			}
			else {
				j --;
			}
		}
		String ans = "";
		for(char c: lcs) ans += c;
		
		System.out.println(ans);
		
		
		
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


	
	
