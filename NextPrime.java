import java.util.*;

public class NextPrime {
	static boolean[] primes;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		primes = new boolean[num+11];
		Sieve(num+10);
		for (int i=num; i<num+10; i++) {
			if (primes[i]) {
				System.out.println(i);
				System.exit(0);
			}
		}
//		for(boolean b: primes) System.out.println(b);
		
		
	}
	
	public static void Sieve(int num) {
		for (int j=0; j<num; j++) {
			primes[j] = true;
		}
		int i = 2;
		primes[0] = false;
		primes[1] = false;
		
		while (i<=num) {
			if (primes[i]) {
				for (int j=i+i; j<num; j+=i) {
					primes[j] = false;
				}
			}
			i ++;
		}
//		for(boolean b: primes) System.out.println(b);
	}

}
