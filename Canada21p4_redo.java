
import java.io.*;
import java.util.*;


public class Canada21p4_redo {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		long n = readLong(), speed = readLong();
		long time = readLong(), XL = readLong(), XR = XL, YT = readLong(), YB = YT;
		long prev_time = time;
		long minX = 0;
		long minY = 0;
		
		for(int i=1; i<n; i++) {
			long t = readLong(), x = readLong(), y = readLong();
			long move = (t - prev_time)*speed;
			prev_time = t;
			
			XR -= move;
			XL += move;
			YT -= move;
			YB += move;
			XR = Math.max(XR, x);
			XL = Math.min(XL, x);
			YT = Math.max(YT, y);
			YB = Math.min(YB, y);
			minX = Math.max(minX, XR-XL);
			minY = Math.max(minY, YT-YB);
			
			
		}
		
		System.out.println(Math.max(minX, minY));
		
		
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


	
	
