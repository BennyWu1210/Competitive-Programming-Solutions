import java.util.*;
public class NotQuitePrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = 0;
		int max = 32;
		int index = 2;
		boolean[] prime_nums = new boolean[max+1];
		ArrayList<Integer> prime_numbers = new ArrayList<Integer>();
		ArrayList<Integer> prime_multiples = new ArrayList<Integer>();
		// Perform sieve of eratosthenes
		for (int i=0; i<=max; i++) {
			prime_nums[i] = true;
		}
		for (int i=2; i*i<=max; i++) {
			if (prime_nums[i]) {
				for (int j=i*i; j<=max; j+=i) {
					prime_nums[j] = false;
				}
			}
		}
		prime_nums[0] = false; prime_nums[1] = false;
		for(int i=0; i<prime_nums.length; i++) {
			if (prime_nums[i]) {
				prime_numbers.add(i);
			}
		}
		
		
		
		for(int i=0; i<prime_numbers.size(); i++) {
			for(int j=i; j<prime_numbers.size(); j++) {
				prime_multiples.add(prime_numbers.get(i) * prime_numbers.get(j));
			}
		}
		for(int i=0; i<5; i++) {
			int num = sc.nextInt();
			if(prime_multiples.contains(num)) {
				System.out.println("semiprime");
			}
			else System.out.println("not");
		}
	}

}
