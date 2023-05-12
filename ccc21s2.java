
import java.util.*;

public class ccc21s2 {

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(), N = sc.nextInt(), K = sc.nextInt();
		int[] row = new int[M];
		int[] column = new int[N];
		
		for (int i = 0; i < K; i++) {
			char type = sc.next().charAt(0);
			int number = sc.nextInt() - 1; // subtract 1 because arrays start at index 0
			
			if (type == 'C') {
				column[number] ++;
			} else {
				row[number] ++;
			}
		}
		
		int count = 0; // this stores the number of gold cells
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				// check if this cell (i, j) has been toggled an odd number of times
				// if it did, then that means this cell is gold
				if ((row[i] % 2 == 1 || column[j] % 2 == 1) && (row[i] % 2) != (column[j] % 2)) {
					count ++;
				}
			}
		}
		
		System.out.println(count);
		
		
	}

}


	
	
