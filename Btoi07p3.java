
import java.io.*;
import java.util.*;

public class Btoi07p3 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int n = readInt(), m = readInt(), c = readInt();
		int counter = 0;
		
		Deque<int[]> max = new LinkedList<int[]>();
		Deque<int[]> min = new LinkedList<int[]>();
		
		for(int i=0, j=0; j<n; j++) {
			int input = readInt();
			
			if (!max.isEmpty() && max.peekFirst()[1] < i) {
				max.pollFirst();
			}
						
			if (!min.isEmpty() && min.peekFirst()[1] < i) {
				min.pollFirst();
			}
			
			while(!max.isEmpty() && max.peekLast()[0] <= input) {
				max.pollLast();
			}
			
			while(!min.isEmpty() && min.peekLast()[0] >= input) {
				min.pollLast();
			}
			
			max.add(new int[] {input, j});
			min.add(new int[] {input, j});
			
			if (j >= m - 1) {
				i ++;
				if (max.peekFirst()[0] - min.peekFirst()[0] <= c) {
					System.out.println(i);
					counter ++;
				}
				
			}
			
		}
		
		if (counter == 0) System.out.println("NONE");
		
		
		
		
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt() throws IOException{
	    int x = 0, c;
	    while((c = br.read()) != ' ' && c != '\n')
	        x = x * 10 + (c - '0');
	    return x;
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


	
	
