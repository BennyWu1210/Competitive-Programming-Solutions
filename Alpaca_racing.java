import java.io.*;
import java.util.*;
public class Alpaca_racing {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//String[] input = readLine().split(" ");
//		long N = Long.parseLong(input[0]);
//		long D = Long.parseLong(input[1]);
//		long K = Long.parseLong(input[2]);
//		long X = Long.parseLong(input[3]);
		long N = readLong();
		long D = readLong();
		long K = readLong();
		long X = readLong();
		
		//System.out.println(N + " " + D + " " + K + " " + X);
		double x_rate = (double)(100-X)/100.0;
		
		double[] speed = new double[(int)N];
		for (int i=0; i<N; i++) {
			//speed[i] = Double.parseDouble(readLine().split(" ")[0]);
			speed[i] = readDouble();
			//System.out.println(speed[i]);
		}
		//double own_speed = Double.parseDouble(readLine().split(" ")[0]); 
		double own_speed = readDouble();
		//System.out.println(own_speed);
		long k_counter = 0;
		boolean win = true;
		
		outer: for (int i=0; i<N; i++) {
			while (speed[i] >= own_speed) {
				speed[i] = Math.floor(speed[i]*x_rate);
				k_counter += 1;
				//K -= 1;
				if (k_counter > K) {
//					if (i < N-1 || (i == N-1 && speed[i] >= own_speed)) {
//						win = false;
//					}
					win = false;
					break outer;
				}
			}
		}
		
		if(win) System.out.println("YES");
		else System.out.println("NO");
		
		
		
		
		
		
		
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

