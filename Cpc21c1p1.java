
import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


public class Cpc21c1p1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
//		System.out.println(1%4);
//		System.out.println(Double.toString(3.0/8).substring(Double.toString(3.0/8).indexOf(".")+1).length());
//		System.out.println(3.0/8);
		int t = readInt();
		
		for(; t>0; t--) {
			double a = readDouble(), b = readDouble();
			if (a % b == 0) {
				if (a >= b) {
					System.out.println(0);
					continue;
				}
			}
			
//			double bRemain = b / a;
//			if (bRemain % 3 == 0 || bRemain % 6 == 0 || bRemain % 7 == 0 || bRemain % 9 == 0) {
//				System.out.println(-1);
//				continue;
//			}
//			if (b % 2 != 0 && b % 5 != 0 && b != 1) {
//				System.out.println(-1);
//				continue;
//			}
			if(b % a == 0) {
				b /= a;
				a = 1;
			}
//			for(int i=2; i<=Math.sqrt(Math.min(a, b)); i++) {
//				while (a % i == 0 && b % i == 0) {
//					a /= i;
//					b /= i;
//				}
//			}
			
			double bCheck = b;
			while((b % 2 == 0) || (b % 5 == 0)) {
				if (b % 2 == 0) {
					b /= 2;
					a = 
					BigDecimal.valueOf(a/2).setScale(16, RoundingMode.HALF_UP).doubleValue();
				}
				else {
					b /= 5;
					a = 
					BigDecimal.valueOf(a/5).setScale(16, RoundingMode.HALF_UP).doubleValue();
				}
			}
			
			// System.out.println(a + ", " + b);
			if(b != 1) {
				System.out.println(-1);
				continue;
			}
			
			// double var = BigDecimal.valueOf(a).setScale(18, RoundingMode.HALF_UP).doubleValue();
			// System.out.println(Double.toString(a).substring(Double.toString(a).indexOf(".")).length()-1);
			
			// double var = BigDecimal.valueOf(a/b).setScale(18, RoundingMode.HALF_UP).doubleValue();
			//System.out.println(var);
			long counter = 0;
			while(a != Math.floor(a) && !Double.isInfinite(a)) {
				//System.out.println(var);
				// System.out.println(a);
				a = BigDecimal.valueOf(a*10.0).setScale(17, RoundingMode.HALF_UP).doubleValue();
				// a *= 10;
				// System.out.println(var);
				counter ++;
			}
			
			System.out.println(counter);
			
//			String result = Double.toString(a/b).substring(Double.toString(a/b).indexOf("."));
//			if (result.contains("E")) {
//				// System.out.println(result);
//				int len = Integer.parseInt(result.substring(result.indexOf("-")+1)) + 
//						(result.indexOf("E") - result.indexOf(".") - 1);
//				System.out.println(len);
//				continue;
//			}
			
//			if (result.length() > 15) {
//				System.out.println(-1);
//				continue;
//			}
//			System.out.println(result.length()-1);
//			continue;
			
//			double bRemain = b / a;
//			if (bRemain % 3 == 0 || bRemain % 6 == 0 || bRemain % 7 == 0 || bRemain % 9 == 0) {
//				System.out.println(-1);
//				continue;
//			}
//			double result = a/b;
//			int counter = 0;
//			while(Math.abs(result % 1) > 10e-17) {
//				System.out.println(result);
//				result *= 10;
//				counter ++;
//			}
//			
//			System.out.println(counter);
			
			
		}
		
		
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


	
	
