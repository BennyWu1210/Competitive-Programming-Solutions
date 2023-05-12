
import java.io.*;
import java.util.*;
import java.time.*;

public class Calendar1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int N = readInt();
		
		// 4 is the reference year for 甲子
		char[] heavenStems = 
				new char[] {'甲', '乙', '丙', '丁', '戊', '己', '庚', '辛', '壬', '癸'};
		char[] earthlyBranches = 
				new char[] {'子', '丑', '寅', '卯', '辰', '巳', '午', '未', '申', '酉', '戌', '亥'};
		
		for(int i=0; i<N; i++){
			int year = (readInt()-4)%60;
			int h = year%10;
			int e = year%12;
			
			if (h < 0) h += 10;
			if (e < 0) e += 12;
			System.out.println(heavenStems[h] + "" + earthlyBranches[e]);
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


	
	
