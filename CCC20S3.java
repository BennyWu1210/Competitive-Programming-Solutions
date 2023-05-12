
import java.io.*;
import java.util.*;

public class CCC20S3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static class Pair implements Comparable<Pair> {
		long f, s;
		public Pair(long f, long s) {
			this.f = f;
			this.s = s;
		}

		public int compareTo(Pair o) {
			if(this.f != o.f) return Long.compare(this.f, o.f);
			return Long.compare(this.s, o.s);
		}
	}
	static int[] generateArray(String str, int end) {
		int[] arr = new int[26];
		for(int i=0; i<end; i++) {
			arr[str.charAt(i) - 'a'] ++;
		}

		return arr;
	}

	static boolean check(int[] arr1, int[] arr2) {
		for(int i=0; i<arr1.length; i++) {
			if (arr1[i] != arr2[i]) return false;
		}

		return true;
	}

	static long getHash(long[] p, long[] hash, long mod, int st, int ed) {
		return ((hash[ed] - hash[st - 1]) * p[p.length - st] - mod) % mod;
	}

	public static void main(String[] args) throws IOException {
		String needle = readLine();
		String haystack = readLine();

		if (needle.length() > haystack.length()) {
			System.out.println(0);
			return;
		}

		Deque<Character> dq = new LinkedList<Character>();
		int[] needles = generateArray(needle, needle.length());
		int[] window = generateArray(haystack, needle.length());

		long[] hash1 = new long[haystack.length()+1], hash2 = new long[haystack.length()+1];
		long[] power1 = new long[haystack.length()+1], power2 = new long[haystack.length()+1];
		long mod1 = (long)1e9 + 7, mod2 = (long)1e9 + 9;

		power1[0] = 1;
		power2[0] = 1;
		for(int i=1; i<haystack.length(); i++) {
			power1[i] = power1[i-1] * 137 % mod1;
			power2[i] = power2[i-1] * 71 % mod2;
			hash1[i] = (power1[i] * (haystack.charAt(i-1)-'a') + hash1[i-1]) % mod1;
			hash2[i] = (power2[i] * (haystack.charAt(i-1)-'a') + hash2[i-1]) % mod2;
		}

		for(int i=0; i<needle.length(); i++) {
			dq.add(haystack.charAt(i));
		}

		Set<Pair> permutations = new HashSet<Pair>();

		for(int i=needle.length(); i<=haystack.length(); i++) {
			if (check(window, needles)) {
				permutations.add(new Pair(getHash(power1, hash1, mod1, i-needle.length()+1, i), getHash(power2, hash2, mod2, i-needle.length()+1, i)));
			}

			if (i == haystack.length()) break;

			char first = dq.pollFirst();
			char next = haystack.charAt(i);
			window[first - 'a'] --;
			window[next - 'a'] ++;

			dq.add(next);
		}

		System.out.println(permutations.size());






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

/*
// Credit to Andrew Tam
// This question is too hard for me :(

import java.io.*;
import java.util.*;
public class Bruh {
    static class Pair implements Comparable<Pair> {
        long f, s;
        Pair(long f, long s) {
            this.f = f; this.s = s;
        }
        public int compareTo(Pair other) {
            if (this.f != other.f) return Long.compare(this.f, other.f);
            return Long.compare(this.s, other.s);
        }
    }
    static boolean check(int [] freq1, int [] freq2){
        for(int i = 0; i < 26; i++){
            if(freq1 [i] != freq2 [i]) return false;
        }
        return true;
    }
    static long getHash(long [] p, long [] hash, long mod, int st, int ed){
        return (hash [ed]-hash [st-1] + mod)*p[p.length - st] % mod;
    }
    public static void main(String [] args) throws IOException{
        String a = br.readLine();
        String b = br.readLine();
        if (a.length() > b.length()) {
            System.out.println(0);
            return;
        }
        int n = a.length(), h = b.length();
        int [] one = new int [n+1], two = new int [h+1];
        for(int i = 1; i <= n; i++){
            one [i] = a.charAt(i-1)-'a';
        }
        for(int i = 1; i <= h; i++){
            two [i] = b.charAt(i-1)-'a';
        }
        int [] freq1 = new int [26], freq2 = new int [26];
        long [] p1 = new long[h+1], p2 = new long [h+1], hash1 = new long [h+1], hash2 = new long[h+1];
        long mod1 = (long)1e9 + 7, mod2 = (long)1e9 + 9;
        p1[1] = p2 [1] = 1; hash1 [1]  = hash2 [1] = two [1];
        for(int i = 2; i <= h; i++){
            p1 [i] = p1 [i-1] * 131 % mod1;
            p2 [i] = p2 [i-1] * 137 % mod2;
            hash1 [i] = (p1 [i] * two [i] + hash1 [i-1])%mod1;
            hash2 [i] = (p2 [i] * two [i] + hash2 [i-1])%mod2;
        }
        for(int i = 1; i <= n; i++){
            freq1 [one [i]]++;
            freq2 [two [i]]++;
        }
        freq2 [two [n]]--;
        TreeSet <Pair> combos = new TreeSet();
        for(int i = n; i <= h; i++){
            freq2 [two [i]]++;
            if(check(freq1, freq2)){
                combos.add(new Pair(getHash(p1, hash1, mod1,  i-n+1, i), getHash(p2, hash2, mod2, i-n+1, i)));
            }
            freq2 [two [i-n+1]]--;
        }
        System.out.println(combos.size());
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }
    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

}
*/
