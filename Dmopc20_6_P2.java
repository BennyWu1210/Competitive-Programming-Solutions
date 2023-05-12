
import java.io.*;
import java.util.*;
public class Dmopc20_6_P2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int N = Integer.parseInt(readLine().split(" ")[0]);
		String[] A = readLine().split(" ");
		String[] B = readLine().split(" ");

		ArrayList<int[]> results = new ArrayList<int[]>();
		int index = 0;
		int start_i = 0;
		int end_i = 0;
		int zCounterA = 0;
		int zCounterB = 0;
		int prev_equal = 0;
		for(int i=0; i<N; i++) {
			if (A[end_i].equals("0")) {
				zCounterA ++;
			}
			if (B[end_i].equals("0")) {
				zCounterB ++;
			}
		}
		if (zCounterA == zCounterB) {
			zCounterA = 0;
			zCounterB = 0;
		
			while(true) {
				if(end_i > N-1) {
					break;
				}
				if (A[end_i].equals("0")) {
					zCounterA ++;
				}
				if (B[end_i].equals("0")) {
					zCounterB ++;
				}
				while(true) {
					if(end_i >= N-1) {
						break;
					}
					if (!(B[end_i+1].equals("0") && B[end_i].equals("1"))) {
						//System.out.println(B[end_i] + " " +B[end_i+1]);
						if (A[end_i+1].equals("0")) {
							zCounterA ++;
						}
						if (B[end_i+1].equals("0")) {
							zCounterB ++;
						}
						if (zCounterA == zCounterB) {
							prev_equal = end_i + 1;
						}
						end_i ++;
					}
					
					else {
						break;
					}
				}
				results.add(new int[] {start_i+1, prev_equal+1});
				//System.out.println(start_i + " " + end_i + " " + prev_equal);
				start_i = prev_equal+1;
				end_i = prev_equal+1;
				
			}
			System.out.println(results.size());
			for (int[] arr: results) {
				System.out.println(arr[0] + " " + arr[1]);
			}
		}
		else {
			System.out.println(-1);
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
