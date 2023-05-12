
import java.io.*;
import java.util.*;


public class Hearth {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class Pair implements Comparable<Pair>{
		int val;
		String name;
		
		public Pair(String name, int val){
			this.val = val;
			this.name = name;
		}
		public int compareTo(Pair p) {
			return this.name.compareTo(p.name);
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		int N = readInt(), T = readInt();
		Pair[] input = new Pair[N];

		
		for(int i=0; i<N; i++) {
			input[i] = new Pair(next(), readInt());
		}
		Arrays.sort(input);
		
		for(int i=0; i<N; i++) {
			String[] lst = new String[3];
			for(int j=i+1; j<N; j++) {
				for(int z=j+1; z<N; z++) {
					if (input[i].val + input[j].val + input[z].val <= T) {
						lst[0] = input[i].name;
						lst[1] = input[j].name;
						lst[2] = input[z].name;
						Arrays.sort(lst);
						for(String str: lst) System.out.print(str + " ");
						System.out.println();
					}
				}
			}
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


	
	
