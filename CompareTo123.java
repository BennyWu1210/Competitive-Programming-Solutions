
import java.io.*;
import java.util.*;


public class CompareTo123 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static class Pair implements Comparable<Pair>{
		int time;
		int location;
		
		public Pair(int time, int location) {
			this.time = time;
			this.location = location;
		}
		
		public int compareTo(Pair p) {
//			if (this.time > p.time) {
//				return 1;
//			}
//			else if(this.time < p.time) {
//				return -1;
//			}
//			return 0;
			
			return this.time - p.time;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// int[] arr = new int[10]
		Pair[] arr = new Pair[4];
		arr[0] = new Pair(3, 5);
		arr[1] = new Pair(2, 6);
		arr[2] = new Pair(5, 8);
		arr[3] = new Pair(-1, 6);
		
		Arrays.sort(arr);
		
		for(Pair p: arr) System.out.println(p.time + " " + p.location);
		
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


	
	
