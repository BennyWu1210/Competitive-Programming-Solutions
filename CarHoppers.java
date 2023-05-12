import java.io.*;
import java.util.*;
public class CarHoppers {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int[] heights;
	static boolean[] reached;
	static int N;
	static int M;
	static int totalReached;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

//		System.out.println(2);
//		System.out.println(3);
//		System.out.println(3);
//		System.out.println(3);
//		System.out.println(2);
//		System.out.println(5);
		
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		
		for(int ii=0; ii<5; ii++){
			input = br.readLine().split(" ");
			//for(String i:input) System.out.println(i);
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			//System.out.println("hi" + N + " " + M);
			reached = new boolean[N];
			heights = new int[N];
			totalReached = 0;
			for (int i=0; i<N; i++) {
				String[] input1 = br.readLine().split(" ");
				int H = Integer.parseInt(input1[0]);
				heights[i] = H;
			}
//			if (ii==3) {
//				System.out.println("hi" + N + " " + M);
//				for(int a: heights) System.out.println(a);
//			}
			//for (int i: heights) System.out.println(i);
			int guards = 0;
			//if(heights[0]!=10 && heights[0]!=7 && heights[0]!=5) for(int a: heights) System.out.println(a);
			//System.out.println(totalReached(4));
			
			while(totalReached < N) {
				//System.out.println(totalReached + " " + N);
				int maximum = -1;
				int index = -1;
				for(int i=0; i<N; i++) {
					
					int total = countReach(i);
					//System.out.println("total" + total);
					if (total > maximum) {
						maximum = total;
						index = i;
					}

				}
				//System.out.println(index);
				reaches(index);
				//System.out.println(index);
				guards ++;
				
			
			}
//			if (guards == 4) {
//				System.out.println("hi" + N + " " + M);
//				for(int a: heights) System.out.println(a);
//			}
			System.out.println(guards);
//			String[] input = br.readLine().split(" ");
//			
//			if (input.length >= 1) {
//				//input = s.split(" ");
//				//System.out.println(input);
//				continue;
//			}
//			else break;
				
		}
	}
	
	public static int countReach(int position) {
		int counter = 0;
		int i = position;
		while (i >= position-M && i >= 0) {
			//System.out.println(heights[i]);
			if (heights[i] <= heights[position] && !reached[i]) {
				counter ++;
			}
			i --;
		}
		i = position+1;
		while (i <= position+M && i < heights.length) {
			//System.out.println(heights[i]);
			if (heights[i] <= heights[position] && !reached[i]) {
				counter ++;
			}
			i ++;
		}
		//System.out.println("c: " + counter);
		return counter;
	}
	
	public static void reaches(int position) {
		//for(boolean b: reached) System.out.println(b);
		//System.out.println("line---");
		reached[position] = true;
		totalReached ++;
		int i = position-1;
		while (i >= position-M && i >= 0) {
			//System.out.println(heights[i]);
			if (heights[i] <= heights[position] && !reached[i]) {
				reached[i] = true;
				totalReached ++;
			}
			i --;
		}
		i = position+1;
		while (i <= position+M && i < heights.length) {
			//System.out.println(heights[i]);
			if (heights[i] <= heights[position] && !reached[i]) {
				reached[i] = true;
				totalReached ++;
			}
			i ++;
		}
		//for(boolean b: reached) System.out.println(b);

		
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
