import java.io.*;
import java.util.*;
public class Dmopc20_6_P1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		long N = Long.parseLong(readLine().split(" ")[0]);
		String[] input = readLine().split(" ");
		long[] strength = new long[(int)N];
		long[] results = new long[(int)N];
		long sum = 0;
		
		for (int i=0; i<N; i++) {
			strength[i] = Long.parseLong(input[i]);
			sum += strength[i];
		}
		
//		for (int i=0; i<N; i++) {  // Do operation one by one
//			long diff = Long.MAX_VALUE;
//			long temp_sum = 0;
//			// (total - a) - a = total - 2a
//			inner: for (int j=0; j<N; j++) {
//				temp_sum += strength[j];
//				if (Math.abs(sum - 2*temp_sum) < diff) {
//					diff = Math.abs(sum - 2*temp_sum);
//				}
//				else {
//					results[i] = diff;
//					break inner;
//				}
//				
//			}
//			switchPos(strength, 0);
//		}
		
//		for (int i=0; i<N; i++) {  // Not modifying the list could be faster (hmmm still doesn't work)
//			long diff = Long.MAX_VALUE;
//			long temp_sum = 0;
//			// (total - a) - a = total - 2a
//			int j = i;
//			while(true) {
//				if (j > N-1) {
//					j = 0;
//				}
//				temp_sum += strength[j];
//				if (Math.abs(sum - 2*temp_sum) < diff) {
//					diff = Math.abs(sum - 2*temp_sum);
//				}
//				else {
//					results[i] = diff;
//					break;
//				}
//				j ++;
//				
//			}
//		}
		
		long diff = Long.MAX_VALUE;
		long temp_sum = 0;
		int index = 0;
		for (int j=0; j<N; j++) {
			temp_sum += strength[j];
			if (Math.abs(sum - 2*temp_sum) < diff) {
				diff = Math.abs(sum - 2*temp_sum);
			}
			else {
				results[0] = diff;
				index = j-1;
				temp_sum -= strength[j];
				break;
			}
			
		}
		long prev_sum = temp_sum;
		for (int i=1; i<N; i++) {
			long other_sum = sum - prev_sum;
			prev_sum -= strength[i-1];
			other_sum += strength[i-1];
//			System.out.println(i + " " + index);
//			System.out.println(prev_sum + " " + other_sum + " " + i);
			long d = Math.abs(prev_sum - other_sum);
			
			while (prev_sum < other_sum) {
				if(index>=N-1) {
					index = -1;
				}
				if (Math.abs((prev_sum + strength[index+1])-(other_sum - strength[index+1])) < d ) {
					prev_sum += strength[index+1];
					other_sum -= strength[index+1];
					d = Math.abs(prev_sum - other_sum);
					index ++;
//					System.out.println("RESULT: ____");
//					System.out.println(prev_sum + " " + other_sum);
				}
				else {
					break;
				}
				
			}
			
			results[i] = d;
			
			
		}
	
		
	
		
		
		
		for(int i=0; i<results.length-1; i++) System.out.print(results[i] + " ");
		System.out.print(results[results.length-1]);
		System.out.println();
		
	}
	
	public static long switchPos(long[] arr, int index) { // Using this passes the first two batches but not the third
		if (index + 1 > arr.length) {
			return arr[0];
		}
		long original = arr[index];
		arr[index] = switchPos(arr, index+1);
		return original;
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
