import java.util.*;
import java.io.*;
public class DMOPC_20_7P1 {

	public static int counter;
	
	public static int findOccurence(int[] arr, boolean[] b) {
		int maxValue = Integer.MIN_VALUE;
		int maxIndex = -1;
		for(int i=0; i<arr.length; i++) {
			if (arr[i] > maxValue) {
				maxValue = arr[i];
				maxIndex = i;
			}
		}
		//System.out.println("max: " + maxValue);
		arr[maxIndex] --;
		return maxIndex;
	}


	public static int findNum(int[] arr, boolean[] b, int num) {
		int index = -1;
		for(int i=0; i<arr.length; i++) {
			if (arr[i] == num && !b[i]) {
				b[i] = true;
				return i;
			}
		}
		
		return -1;
	}
	public static int findClosest(int[] arr, int num, boolean[] b) {
		int diff = Integer.MAX_VALUE;
		int pos = -1;
		int backup = -1;
		for(int i=0; i<arr.length; i++) {
			if (arr[i] == num && !b[i]) {
				backup = i;
			}
			if (Math.abs(arr[i] - num) < diff && arr[i] != num && !b[i]) {
				diff = Math.abs(arr[i] - num);
				pos = i;
			}
		}
		if (pos == -1) {
			b[backup] = true;
			counter --;
			return backup;
		}
		b[pos] = true;
		return pos;

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().split(" ")[0]);
		String[] inputs = br.readLine().split(" ");
		int[] weights = new int[2*N];
		int[] appearences = new int[(int) Math.pow(10, 5)];
		boolean[] used = new boolean[2*N];
		
		// Input
		for(int i=0; i<2*N; i++) {
			weights[i] = Integer.parseInt(inputs[i]);
			appearences[weights[i]] ++;
		}
		
		// Arrays.sort(weights);
		
		counter = 0;
		int tCounter = 0;
		int i = 0;
		ArrayList<int[]> output = new ArrayList<int[]>();
		
		while(tCounter < N) {
			int next = findOccurence(appearences, used);
			int first = findNum(weights, used, next);
			int other = findClosest(weights, next, used);
			counter ++;
			tCounter ++;
			
			output.add(new int[] {first+1, other+1});
			
		}
		
		System.out.println(counter);
		for(int[] arr: output) {
			System.out.println(arr[0] + " " + arr[1]);
		}
		
		
		
		
		
	}

}
