
import java.io.*;
import java.util.*;


public class COCI_10_3P5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int N = readInt();
		Stack<long[]> s = new Stack<long[]>();
		long[] a = new long[N];
		long result = 0;
		long[][] ans = new long[N][4];
		
		for(int i=0; i<N; i++) {
			a[i] = readLong();
		}
		
		// left greater
		s.push(new long[] {Integer.MAX_VALUE, -1});
		for(int i=0; i<N; i++) {
			while(s.peek()[0] <= a[i]) s.pop();
			ans[i][0] = s.peek()[1] + 1;
			s.push(new long[] {a[i], i});
		} 
		
		s.clear();
		
		// Right greater or equal
		s.push(new long[] {Integer.MAX_VALUE, N});
		for(int i=N-1; i>=0; i--) {
			while(s.peek()[0] < a[i]) s.pop();
			ans[i][1] = s.peek()[1] - 1;
			s.push(new long[] {a[i], i});
		} 
		
		s.clear();
		
		
		// left lesser
		s.push(new long[] {Integer.MIN_VALUE, -1});
		for(int i=0; i<N; i++) {
			while(s.peek()[0] >= a[i]) s.pop();
			ans[i][2] = s.peek()[1] + 1;
			s.push(new long[] {a[i], i});
		} 
		
		s.clear();
		
		
		// right lesser or equal
		s.push(new long[] {Integer.MIN_VALUE, N});
		for(int i=N-1; i>=0; i--) {
			while(s.peek()[0] > a[i]) s.pop();
			ans[i][3] = s.peek()[1] - 1;
			s.push(new long[] {a[i], i});
		} 
		
		s.clear();
		
		// for(int[] arr: ans) System.out.println(Arrays.toString(arr));
		for(int i=0; i<N; i++) {
			result += (long)(a[i] * (i-ans[i][0]+1) * (ans[i][1]-i+1));
			result -= (long)(a[i] * (i-ans[i][2]+1) * (ans[i][3]-i+1));
		}
		
		System.out.println(result);
		
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


	
	
