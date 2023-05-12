
import java.io.*;
import java.util.*;

public class coci10c7p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), K = readInt();
		char[] wheel = new char[N];
		boolean[] vis = new boolean[26];
		int cur = 0;
		
		boolean isWheel = true;
		for (int i=0; i<K; i++) {
			int s = readInt();
			char c = readCharacter();
			
			cur = (cur + s) % N;
			if (wheel[cur] != 0 && wheel[cur] != c || wheel[cur] != c && vis[c - 'A']) {
				isWheel = false;
				break;
			}
			else {
				wheel[cur] = (char) c;
			}
			
			vis[c - 'A'] = true;
			
		}
		
		if (!isWheel) {
			System.out.println("!");
			return;
		}
		else {
			int counter = N;
			
			while (counter > 0) {
				char res = wheel[cur] == 0 ? '?' : wheel[cur];
				System.out.print(res);
				counter --;
				cur = (cur - 1 + N) % N;
			}
		}
		
		System.out.println();
		
		
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


	
	
