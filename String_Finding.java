

import java.io.*;
import java.util.*;

public class String_Finding {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	// Hashing time :D
	public static void main(String[] args) throws IOException {
		String a = readLine(), b = readLine();
		long[] aHash = new long[a.length()+1];
		long bHash = 0;
		
		long base = 26;
		int mod = (int)1e9 + 7;
		// long[] power = new long[a.length()+1];
		
		if (a.length() < b.length()) {
			System.out.println(-1);
			return;
		}
		
		long power = 1;
		for(int i=0; i<b.length(); i++) {
			power = (power * base) % mod;
		}
		
		for(int i=1; i<=a.length(); i++) {
			aHash[i] = ((aHash[i-1] * base)  + a.charAt(i-1) - 'a' + mod) % mod;
		}
		
		for(int i=0; i<b.length(); i++) {
			bHash = ((bHash * base) + b.charAt(i) - 'a' + mod) % mod ;
			// System.out.println(bHash);
		}
	
		
		for(int i=0; i<=a.length()-b.length(); i++) {
			// System.out.println(aHash[i+b.length()] - (aHash[i] * Math.pow(base, b.length())%mod)%mod);
			long one = (aHash[i+b.length()] - (aHash[i] * power %mod ))%mod;
			if (one == bHash) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(-1);
		
		
		
		

	}
	
//	public static void main(String[] args) throws IOException{
//        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
//        char[] s = stdin.readLine().toCharArray();
//        char[] w = stdin.readLine().toCharArray();
//        System.out.println(kmp(s,w));
//    }
//    public static int kmp(char[] s, char[] w){
//        int i = 0;
//        int j = 0;
//        int[] t = new int[w.length+1];
//        table(w, t);
//        while (i+j < s.length){
//            if(w[j] == s[i+j]){
//                j++;
//                if(j==w.length){
//                    return i;
//                }
//            }else{
//                if(t[j]>-1){
//                    i = i+j-t[j];
//                    j = t[j];
//                }else{
//                    i=i+j+1;
//                    j=0;
//                }
//            }
//        }
//        return -1;
//    }
//    public static void table(char[] w, int[] t){
//        int pos = 1;
//        int c = 0;
//        t[0] = -1;
//        while(pos<w.length){
//            if(w[pos] == w[c]){
//                t[pos] = t[c];
//                pos++;
//                c++;
//            }else{
//                t[pos] = c;
//                c = t[c];
//                while(c>=0 && w[pos]!=w[c]){
//                    c = t[c];
//                }
//                pos++;
//                c++;
//            }
//        }
//        t[pos] = c;
//    }
    
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


	
	
