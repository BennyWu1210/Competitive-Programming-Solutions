
import java.io.*;
import java.util.*;


public class COCI_14_6_P5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static long getMaxArea(long[] hist) {
		Deque<Integer> q = new LinkedList<Integer>();
		long maxArea = 0;
		int len = hist.length;
		int index = 0;
		
		while(index < len) {
			if (q.isEmpty() || hist[q.peek()] <= hist[index]) {
				q.push(index++);
			}
			else {
				int top = q.pop();
				long area = (hist[top]+1) * (q.isEmpty()? index+1 : index - q.peek());
				maxArea = Math.max(area, maxArea);
			}
		}
		
		while(!q.isEmpty()) {
			int top = q.pop();
			long area = (hist[top]+1) * (q.isEmpty()? index+1 : index - q.peek());
			maxArea = Math.max(area, maxArea);
		}
		
		return maxArea;
		
	}
	public static void main(String[] args) throws IOException {
		
		int r = readInt();
		int s = readInt();
		int[][] input = new int[r][s];
		long[] hist = new long[s];
		long result = 0;
		boolean all = true;
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<s; j++) {
				input[i][j] = readInt();
			}
		}
		
		for(int i=0; i<r-1; i++) {
			for(int j=0; j<s-1; j++) {
				if (input[i][j] + input[i+1][j+1] <= input[i+1][j] + input[i][j+1]) {
					hist[j]++;
				}
				else {
					hist[j] = 0;
					all = false;
				}
			}
			// System.out.println(Arrays.toString(hist));
			result = Math.max(getMaxArea(hist), result);
			
		}
		
		if (all) System.out.println(r*s);
		else System.out.println(result);
		
		
		
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


	
	
