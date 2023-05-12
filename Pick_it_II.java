
import java.io.*;
import java.util.*;


public class Pick_it_II {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), K = readInt();
		int[] input = new int[N];
		Long[] circ = new Long[K+1];
		TreeSet<Long> nodes = new TreeSet<Long>();
		
		for(int i=0; i<N; i++) {
			input[i] = readInt();
		}
		
		nodes.add((long) 0);
		circ[0] = (long) 0;
		int arrPos = 0;
		long sum = 0;
		
		for(int num: input) {
			sum += num;
			long old = nodes.first();
			long newNode = old + num;
			arrPos = (arrPos + 1) % circ.length;
			
			if (circ[arrPos] != null) {
				nodes.remove(circ[arrPos]);
			}
			circ[arrPos] = newNode;
			nodes.add(newNode);
			
		}
		
		System.out.println(sum - nodes.first());
		
		
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


	
	
