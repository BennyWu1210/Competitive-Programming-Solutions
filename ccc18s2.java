
import java.util.*;

public class ccc18s2 {

	public static int[][] rotate(int[][] original){
	    int N = original.length, M = original[0].length;
	    int[][] new_array = new int[M][N];
	    
	    for (int i = 0; i < M; i++){
	    	for (int j = 0; j < N; j++){
	    		new_array[i][j] = original[N - j - 1][i];
	    	} 
	    }
	 
	    return new_array;
	}
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] array = new int[N][N];
		
		// store the maximum and minimum value of this array
		int minimum = Integer.MAX_VALUE;
		int maximum = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				array[i][j] = sc.nextInt();
				
				if (array[i][j] < minimum) {
					minimum = array[i][j];
				}
				if (array[i][j] > maximum) {
					maximum = array[i][j];
				}
			}
		}
		
		
		for (int i = 0; i < 4; i++) {
			// check if the current array is valid
			if (array[0][0] == minimum && array[N-1][N-1] == maximum) {
				// if it is, we know we have the correct answer
				break; // exits the for loop
			}
			else {
				// otherwise, we rotate it 90 degrees
				array = rotate(array);
			}
		}
		
		// output the result
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}


	
	
