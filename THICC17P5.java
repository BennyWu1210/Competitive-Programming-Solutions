import java.util.*;
import java.io.*;

public class THICC17P5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input1 = br.readLine().split(" ");
		int N = Integer.parseInt(input1[0]);
		int K = Integer.parseInt(input1[1]);
		String[] input2 = br.readLine().split(" ");
		int[] smarties = new int[N+1];
		int maximum = 0;
		for (int i=0; i<N; i++) {
			smarties[i] = Integer.parseInt(input2[i]);
			if (smarties[i] > maximum) {
				maximum = smarties[i];
				
			}
		}
		
		int start_index = 0;
		int end_index = 0;
		int total_counter = 0;
		while(true) {
			boolean[] visited = new boolean[maximum+1];  // Check for each subarray
			int fCounter = 0;
			boolean foundMin = true;
			while(true) { // Go up to the min. subarray
				//System.out.println("end :" + end_index);
				if (!visited[smarties[end_index]]) {
					fCounter ++;
					visited[smarties[end_index]] = true;
					//System.out.println("not visited: " + smarties[i]);
				}
				
				end_index ++;


				if(end_index == N) {
					if (fCounter < K) {
						foundMin = false;
					}
					break;
				}
				
				if(fCounter == K) {
					break;
				}
			}
			
			if(!foundMin) {
				break;
			}
			//System.out.println("added: " + (N-end_index+1));
			total_counter += N-end_index+1;
			start_index ++;
			end_index = start_index;
			
		}
		System.out.println(total_counter);
		
	}

}
