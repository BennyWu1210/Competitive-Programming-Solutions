import java.io.*;
import java.util.*;
public class Simon_and_Marcy_Redo
{
	/*
	 * DP Problem
	 * Found hints from https://www.codesdope.com/course/algorithms-knapsack-problem/
	 */
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static int[][] cost;
	static int[] cage;
	static int[] time;
	static int c;
	static int m;
	
	public static int findMax(int left, int weight) {
		
		for(int w=0; w<=weight; w++) {
			cost[0][w] = 0;
		}
		
		for(int i=0; i<=left; i++) {
			cost[i][0] = 0;
		}
		
		
		for(int i=1; i<=left; i++) {
			for(int j=1; j<=weight; j++) {
				if(time[i] > j) {
					cost[i][j] = cost[i-1][j];
				}
				else {
					if(cage[i] + cost[i-1][j-time[i]] > cost[i-1][j]) {
						cost[i][j] = cage[i] + cost[i-1][j-time[i]];
					}
					else {
						cost[i][j] = cost[i-1][j];
					}
				}
			}
		}
		
		
		return cost[left][weight];
	}
	
	public static void itemsInOptimal(int n, int W, int wm[]) {
	    int i = n;
	    int j = W;

	    while (i > 0 && j > 0) {
	      if(cost[i][j] != cost[i-1][j]) {
	        System.out.println(i);
	        j = j-wm[i];
	        i = i-1;
	      }
	      else {
	        i = i-1;
	      }
	    }
	  }
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		c = readInt();
		m = readInt();
		cost = new int[c+1][m+1];
		
		
		cage = new int[c+1];
		time = new int[c+1];
		for(int i=1; i<=c; i++) {
			cage[i] = readInt();
			time[i] = readInt();
		}
//		System.out.println(Arrays.toString(cage));
//		System.out.println(Arrays.toString(time));
		System.out.println(findMax(c, m));
		//itemsInOptimal(c, m, time);
//		for(int[] arr: cost) {
//			System.out.println(Arrays.toString(arr));
//		}
		
/*
4 5
8 3
3 2
9 4
6 1
 */
		

		
		
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
