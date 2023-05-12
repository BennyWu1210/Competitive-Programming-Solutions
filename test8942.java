
import java.io.*;
import java.util.*;

public class test8942 {
	
	static boolean[] prime = new boolean[80];
	
	static void sieve() {
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		
		for (int i=2; i*i<prime.length; i++) {
			if (prime[i]) {
				for (int j=i*i; j<prime.length; j+=i) {
					prime[j] = false;
				}
			}
		}
	}
	
	static int[] calc(int ind, int ans, int[] a, boolean[] remain) {
		
		if (ind == a.length) {
			int[] res = new int[a.length];
			for (int i=0; i<res.length; i++) res[i] = a[i];
			res[0] = ans;
			return res;
		}
		
		int max = Integer.MIN_VALUE;
		int[] best = new int[a.length];
		for (int i=1; i<a.length; i++) {
			if (!remain[i]) {
				
				int[] new_a = new int[a.length];
				boolean[] new_remain = new boolean[a.length];
				for (int j=1; j<ind; j++) new_a[j] = a[j];
				for (int j=1; j<new_remain.length; j++) new_remain[j] = remain[j];
				new_a[ind] = i;
				new_remain[i] = true;
				
				int new_dif = 0;
				if (ind > 1 && prime[Math.abs(new_a[ind] - new_a[ind-1])]) new_dif = Math.abs(new_a[ind] - new_a[ind-1]);
				int[] res = calc(ind+1, new_dif, new_a, new_remain);
				if (res[0] > max) {
					max = res[0];
					best = res;
				}
			}
		}
		
		return best;
	}
	
	static int[] solve(int n) {
		int[] a = new int[n+1];
				
		boolean[] remain = new boolean[n+1];
		
		return calc(1, 0, a, remain);
		
	}
	public static void main(String[] args) {
		sieve();
		System.out.println(Arrays.toString(prime));
		for (int i=1; i<=20; i++) {
			int[] ans = solve(i);
			System.out.println(Arrays.toString(ans));
		}
	}
}
