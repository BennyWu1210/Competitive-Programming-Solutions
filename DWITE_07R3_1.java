import java.util.*;
import java.io.*;
import java.lang.*;
public class DWITE_07R3_1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		for(int i=0; i<5; i++) {
			int a = Integer.parseInt(br.readLine().split(" ")[0]);
			int orginal_a = a;
			boolean[] arr = new boolean[(int)Math.sqrt(a)+1];
			boolean valid = true;
			boolean[] primes = new boolean[(int)Math.sqrt(a)+1];
			
			// Perform sieve
			for(int j=0; j<primes.length; j++) {
				primes[j] = true;
			}
			primes[0] = false;
			primes[1] = false;
			
			for(int j=2; j<=Math.sqrt(a); j++) {
				if (primes[j]) {
					for (int k=j+j; k<Math.sqrt(a); k+=j) {
						primes[k] = false;
					}
				}
			}

			//for(boolean b: primes) System.out.println(b);
			int counter = 0;
			for(int j=1; j<=Math.sqrt(orginal_a); j++) {
				//System.out.println(a + " " + j);
				if (primes[j]) {
					//System.out.println(a + " " + j);
					while(a%j == 0) {
						a = a/j;
						if (arr[j]) {
							//System.out.println("breaked");
						}
						else {
							arr[j] = true;
							counter ++;
						}
					}
						
				}
			}
			//System.out.println(counter);
			if(counter == 3) {
				System.out.println("valid");
			}
			else {
				System.out.println("not");
			}
		}
	}

}
