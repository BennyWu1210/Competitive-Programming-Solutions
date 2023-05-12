import java.io.*;
import java.util.*;
public class Dmopc20p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N = readInt();
		int M = readInt();
		
		//System.out.println(N + " " + M);
		double nPos = 0;
		double mPos = 0;
		double prev_m = mPos;
		double angle = Math.atan((double)N/M);
		LinkedList<int[]> lst = new LinkedList<int[]>();
		int counter = 0;
		
		while(true) {
			nPos += 1;
			mPos = (double)Math.round((double)nPos/Math.tan(angle)*10000000.0)/10000000.0;
			if (nPos > N || mPos > M) {
				break;
			}
			if (mPos % 1 == 0) {
				for (int i=(int)prev_m; i<(int)mPos; i++) {
					lst.add(new int[]{(int)nPos, i+1});
					counter ++;
				}
			}
			else {
				for (int i=(int)prev_m; i<=(int)mPos; i++) {
					lst.add(new int[]{(int)nPos, i+1});
					counter ++;
				}
			}
			prev_m = mPos;
			//System.out.println(nPos + " " + mPos);
			
		}
		
		//if (lst.size() == 1999899) System.out.println(N + " " + M);
		System.out.println(lst.size());
		for (int[] arr: lst) {
			System.out.println(arr[0] + " " + arr[1]);
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

