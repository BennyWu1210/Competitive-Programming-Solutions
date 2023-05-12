
import java.io.*;
import java.util.*;

public class Stalactites {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static void update(int x, int y, int z, long val, long[][][] bit) {
		int _x = x;
		
		while (_x < bit.length) {
			int _y = y;
			
			while (_y < bit.length) {
				int _z = z;
				
				while (_z < bit.length) {
					bit[_x][_y][_z] += val;
					_z += (_z & -_z);
				}
				_y += (_y & -_y);
			}
			_x += (_x & -_x);
		}
	}
	
	static long takeSum(int x, int y, int z, long[][][] bit) {
		int _x = x;
		long sum = 0;
		
		while (_x > 0) {
			int _y = y;
			
			while (_y > 0) {
				int _z = z;
				
				while (_z > 0) {
					sum += bit[_x][_y][_z];
					_z -= (_z & -_z);
				}
				_y -= (_y & -_y);
			}
			_x -= (_x & -_x);
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), Q = readInt();
		
		int[][][] cube = new int[N+1][N+1][N+1];
		long[][][] bit = new long[N+1][N+1][N+1];
		
		long ans = 0;
		
		for (int i=0; i<Q; i++) {
			char c = readCharacter();
			
			switch(c) {
				case 'C':
					int x = readInt(), y = readInt(), z = readInt(), val = readInt();
					update(x, y, z, val-cube[x][y][z], bit);
					cube[x][y][z] = val;
					break;
				case 'S':
					int x1 = readInt(), y1 = readInt(), z1 = readInt();
					int x2= readInt(), y2 = readInt(), z2 = readInt();
					ans += takeSum(x2, y2, z2, bit) - takeSum(x1-1, y2, z2, bit)
							- takeSum(x2, y1-1, z2, bit) - takeSum(x2, y2, z1-1, bit)
							+ takeSum(x1-1, y1-1, z2, bit) + takeSum(x1-1, y2, z1-1, bit)
							+ takeSum(x2, y1-1, z1-1, bit) - takeSum(x1-1, y1-1, z1-1, bit);
					break;
			}
			
		}
		
		System.out.println(ans);
		
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


	
	
