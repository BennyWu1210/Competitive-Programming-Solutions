import java.util.*;
import java.io.*;

public class DMOPC_17_1P2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String[] input1 = br.readLine().split(" ");
//		long N = Long.parseLong(input1[0]);
//		long M = Long.parseLong(input1[1]);
//		String[] input = br.readLine().split(" ");
		
//		long[] crayons = new long[(int) N];
//		long[] sums = new long[(int) N];
//		
//		long store = 0;
//		long counter = 0;
//		for(int i=0; i<N; i++) {
//			crayons[i] = Integer.parseInt(input[i]);
//			store += crayons[i];
//			sums[i] = store;
//			if (sums[i] % 6 == 0) {
//				counter ++;
//			}
//		}
//		
//		for(int i=(int)(N-1); i>=0; i--) {
//			for(int j=i-1; j>=0; j--) {
//				if ((sums[i] - sums[j]) % M == 0) {
//					System.out.println(sums[i] + " " + sums[j]);
//					counter ++;
//				}
//			}
//		}
//		
//		System.out.println(counter);
		
		// Optimized solution: Idea from https://github.com/tomzyzhu/DMOJ-solutions/blob/master/DMOPC%20'17%20Contest%201%20P2%20-%20Sharing%20Crayons/in%20Java.txt
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input1 = br.readLine().split(" ");
		long N = Long.parseLong(input1[0]);
		long M = Long.parseLong(input1[1]);
		String[] input = br.readLine().split(" ");
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		
		int sum = 0;
		long counter = 0;
		
		for(int i=0; i<N; i++) {
			sum = (int) ((sum + Integer.parseInt(input[i])) % M);
			if (map.containsKey(sum)) {
				counter += map.get(sum);
				map.put(sum, map.get(sum)+1);
			}
			else {
				map.put(sum, 1);
			}
		}
		
		System.out.println(counter);
		
		

	}

}
