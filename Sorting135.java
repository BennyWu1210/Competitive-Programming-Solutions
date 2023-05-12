import java.util.*;
import java.lang.*;
import java.io.*;
public class Sorting135 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N];
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(nums);
		
		for (int i: nums) {
			System.out.println(i);
		}
	}

}
