// Working program using Reader Class
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class HopScotch_II {

	public static void main(String[] args) throws IOException {
		
		Reader s = new Reader();
		
		int N = s.nextInt(), K = s.nextInt();
		long[] ans = new long[(int)N];
		long[] arr = new long[(int)N];
		Deque<long[]> dq = new LinkedList<long[]>();
		int fin = 0;
		long finCost = (long)1e18;
		for(int i=0; i<N; i++) {
			long input = s.nextLong();
			arr[i] = input;
			long cur = input;
			
			if (!dq.isEmpty() && i - dq.peekFirst()[1] > K) {
				dq.pollFirst();
			}
			if (i-K >= 0) {
				cur = input + dq.peekFirst()[0];
			}
			
			if (i+K >= N && cur <= finCost) {
				fin = i;
				finCost = cur;
			}

			while(!dq.isEmpty() && cur <= dq.peekLast()[0]) {
				dq.pollLast();
			}
			
			
			ans[i] = cur;
			dq.add(new long[] {cur, i});
			
		}
		
		
		
		// System.out.println(Arrays.toString(ans));
		Deque<Integer> stk = new LinkedList<Integer>();
		int index = fin;
		long sum = 0;
		stk.push(index+1);
		sum += arr[index];
				
		long next = ans[index] - arr[index];
		while(index >= 0) {
			if (ans[index] == next) {
				sum += arr[index];
				next = ans[index] - arr[index];
				stk.push(index+1);
			}
			index --;
		
			
		}
		
		System.out.println(sum);
		while(!stk.isEmpty()) {
			System.out.print(stk.pop() + " ");
		}
		

		
		
		
	}

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


}

