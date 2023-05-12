
//Working program using Reader Class
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class FastInputTemplate_2 {
	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader()
		{
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException
		{
			din = new DataInputStream(
				new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException
		{
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n') {
					if (cnt != 0) {
						break;
					}
					else {
						continue;
					}
				}
				buf[cnt++] = (byte)c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException
		{
			int ret = 0;
			byte c = read();
			while (c <= ' ') {
				c = read();
			}
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException
		{
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException
		{
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException
		{
			bytesRead = din.read(buffer, bufferPointer = 0,
								BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException
		{
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException
		{
			if (din == null)
				return;
			din.close();
		}
	}
	
	public static int find(int index, int step, int[] ans, int[][] memo) { 
		
		if (index >= ans.length || index == -1) return -1;
		if (step == 1) return index;
		if (memo[index][step] != 0) return memo[index][step];
		
		memo[index][step] = find(ans[index], step-1, ans, memo);
		return memo[index][step];
	}
	
	
	public static void main(String[] args) throws IOException {

		Reader s = new Reader();
		Deque<int[]> queue = new LinkedList<int[]>(); // Stack and Deque made no difference here
		int N = s.nextInt();
		
		int[] height = new int[N];
		int[] ans = new int[N];
		
		for(int i=0; i<N; i++) {
			height[i] = s.nextInt();
		}
		
		for(int i=N-1; i>=0; i--) {
			int num = height[i];
			
			while(!queue.isEmpty() && queue.peek()[0]<=num) {
				queue.pop();
			}
			
			ans[i] = queue.isEmpty()? -1:queue.peek()[1]; // arr[1] stores the index of the next tallest bale
			queue.push(new int[] {num, i});
			
		}
		
		int[][] memo = new int[N][N]; // I tried to get rid of this memo array and it's still out of memory :(
		
		for(int i=0; i<N; i++) {
			int n = ans[i];
			int ss = s.nextInt();
			int index = find(n, ss, ans, memo);
			if (index == -1) System.out.print(-1 + " ");
			else System.out.print(height[index] + " ");
		}
	}
	
}

