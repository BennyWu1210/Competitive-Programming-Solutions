
import java.io.*;
import java.util.*;
public class CountNumberOfPairsRedo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static long bSearch(int left, int right, long key, long[] numbers) {
		
		
		
		int middle = (left+right)/2;
		if (numbers[middle] == key) {
			while (middle+1 < numbers.length && numbers[middle+1] == key) {
				middle ++;
			}
			return middle;
		}
		
		if (right-left <= 0) {
			if (numbers[left] > key) {
				return left-1;
			}
			if (numbers[left] < key) {
				return left;
			}
		}
		
		
		if (numbers[middle] < key) return bSearch(middle+1, right, key, numbers);
		if (numbers[middle] > key) return bSearch(left, middle-1, key, numbers);
		
		
		return -1;
	}
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		int M = readInt();
		long[] numbers = new long[N];
		for(int i=0; i<N; i++) {
			numbers[i] = readLong();
		}
		Arrays.sort(numbers);
		
		long counter = 0;
		for(int i=0; i<N-1; i++) {
			long num = numbers[i];
			if ((i<N-1 && numbers[i+1] + num > M) || num*2 > M) {
				break;
			}
			
			long index = bSearch(i, N-1, M-num, numbers);
			counter += index-i;
		}
		
		System.out.println(counter);
		
		
		
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
