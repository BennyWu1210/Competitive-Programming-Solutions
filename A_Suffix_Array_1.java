
import java.io.*;
import java.util.*;

public class A_Suffix_Array_1 {

	static class pair implements Comparable<pair>{
		int a, b;

		public pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			if (this.a == o.a) {
				return this.b - o.b;
			}
			return this.a - o.a;
		}


	}
	
	static class suffix implements Comparable<suffix>{
		pair p;
		int i;

		public suffix(pair p, int i) {
			this.p = p;
			this.i = i;
		}

		@Override
		public int compareTo(suffix o) {
			// TODO Auto-generated method stub
			return this.p.compareTo(o.p);
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		str += '$';
		int n = str.length();

		pair[] a = new pair[n];
		int[] c = new int[n];
		int[] p = new int[n];

		// when k is 0


		for (int i=0; i<n; i++) a[i] = new pair(str.charAt(i)-'a', i);

		Arrays.sort(a);

		for (int i=0; i<n; i++) p[i] = a[i].b;

		c[p[0]] = 0;

		for (int i=1; i<n; i++) {
			if (a[i].a == a[i-1].a) {
				c[p[i]] = c[p[i-1]];
			}
			else {
				c[p[i]] = c[p[i-1]] + 1;
			}
		}

		// rest of the cases
		int k = 0;
		while ((1 << k) < n) {
			suffix[] arr = new suffix[n];

		
			for (int i=0; i<n; i++) {
				arr[i] = new suffix(new pair(c[i], c[(i + (1 << k)) % n]), i);
			}

			Arrays.sort(arr);

			for (int i=0; i<n; i++) p[i] = arr[i].i;

			c[p[0]] = 0;

			for (int i=1; i<n; i++) {
				if (arr[i].p.a == arr[i-1].p.a && arr[i].p.b == arr[i-1].p.b){
					c[p[i]] = c[p[i-1]];
				} else {
					c[p[i]] = c[p[i-1]] + 1;
				}
			}
			
			k ++;
		}

		for (int i=0; i<n-1; i++) {
			System.out.print(p[i] + " ");
		}
		
		System.out.print(p[p.length-1]);
		
		System.out.println();

	}
}




