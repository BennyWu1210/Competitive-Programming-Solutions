import java.util.*;
import java.lang.*;
import java.io.*;
public class COCI14P1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		long[] digits = new long[input.length];
		long sum = 0;
		boolean containsZero = false;
		
		for(int i=0; i<input.length; i++) {
			digits[i] = Character.getNumericValue(input[i]);
			sum += digits[i];	
		}
		for(int i=0; i<input.length; i++) {
			if(digits[i] == 0) {
				containsZero = true;
				break;
			}
		}
		Arrays.sort(digits);
		//containsZero = Arrays.binarySearch(digits, 0) != -1;
		//System.out.println(containsZero);
		if (sum%3 == 0 && containsZero) {
			String output = "";
			for(int i=digits.length-1; i>=0; i--) {
				output += digits[i];
			}
			System.out.println(output);
		}
		else {
			System.out.println(-1);
		}
		
		//System.out.println(Arrays.toString(digits));
		
		
		
	}

}
