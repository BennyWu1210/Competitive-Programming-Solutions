
import java.io.*;
import java.util.*;

public class CCC21S3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static Person[] persons;
	static int minPos, maxPos;
	static class Person{
		long P, W, D;

		public Person(int p, int w, int d) {
			this.P = p;
			this.W = w;
			this.D = d;
		}
	}

	static boolean check(long time) {

		long[] psa = new long[persons.length];
		
//		for (Person p: persons) {
//			long left = (long)(p.P - (1.0/p.W) * time - p.D) - 1;
//			long right = (long)(p.P + (1.0/p.W) * time + p.D) + 1;
//			
//			left = Math.min(left, 0);
//			right = Math.max(right, (int)1e9);
//			
//		}
		for (int p=minPos; p<maxPos; p++) {
		}
	}

	public static void main(String[] args) throws IOException {

		int N = readInt();
		persons = new Person[N];

		maxPos = Integer.MIN_VALUE; minPos = Integer.MAX_VALUE;
		for (int i=0; i<N; i++) {
			int p = readInt(), w = readInt(), d = readInt();
			persons[i] = new Person(p, w, d);
			maxPos = Math.max(maxPos, p);
			minPos = Math.min(minPos, p);
			
		}

		long l = 0, r =  (int)1e9 + 5;
		long res = 0;

		System.out.println(check(15));
		while (l <= r) {

			long mid = (l + r) / 2;

			System.out.println(mid);

			if (check(mid)) {
				r = mid - 1;
				res = mid;
			}
			else {
				l = mid + 1;

			}
		}

		System.out.println(res);



	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}




