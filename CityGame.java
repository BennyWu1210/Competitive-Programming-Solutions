
import java.io.*;
import java.util.*;


public class CityGame {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static int findLargestArea(int[] heights) {
		int max_area = 0;
		int index = 0;
		Stack<Integer> s = new Stack<Integer>();
		
		
		while(index < heights.length) {
			if (s.isEmpty() || heights[s.peek()] <= heights[index]) {
				s.push(index++);
			}
			else {
				int top = s.pop();
				int area = heights[top] * (s.isEmpty()? index : index - s.peek() - 1);
				
				if (area > max_area) max_area = area;
			}
		}
		
		while(!s.isEmpty()) {
			int top = s.pop();
			int area = heights[top] * (s.isEmpty()? index : index - s.peek() - 1);
			
			if (area > max_area) max_area = area;
		}
		
		return max_area;
		
	}
	
	public static void main(String[] args) throws IOException {
		int K = readInt();
		
		for(; K>0; K--) {
			int m = readInt(), n = readInt();
			int[][] city = new int[m][n];
			int result = 0;
			
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					char input = next().charAt(0);
					if (input == 'R') {
						city[i][j] = 0;
					}
					else {
						city[i][j] = 1;
						if (i > 0) {
							city[i][j] = city[i-1][j] + 1;
						}
					}
				}
				if (i != 0) {
					result = Math.max(result, findLargestArea(city[i]));
					
				}
			}
			System.out.println(result*3);
			
			
			
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


	
	
