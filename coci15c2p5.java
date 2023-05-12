
import java.io.*;
import java.util.*;

public class coci15c2p5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static int query(int ind, int[] bit) {
		int ans = 0;
		for (int i=ind; i>0; i-=(i&-i)) {
			ans += bit[i];
		}

		return ans;
	}

	static void update(int ind, int val, int[] bit) {
		for (int i=ind; i<bit.length; i+=(i&-i)) {
			bit[i] += val;
		}
	}
	
	static class pair implements Comparable<pair>{
		long f;
		int s;
		
		public pair(long f, int s) {
			this.f = f;
			this.s = s;
		}
		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			if (this.f == o.f) return Integer.compare(this.s, o.s);
			return Long.compare(this.f, o.f);
		}
		
	}

	public static void main(String[] args) throws IOException {

		Reader r = new Reader();
		int N = r.nextInt();
		
		pair[] a = new pair[N+1];
		int[] bit = new int[(int)1e6+5];


		for (int i=1; i<=N; i++) {
			a[i] = new pair(r.nextLong(), i);
		}

		long P = r.nextLong();

		a[0] = new pair(0, 0);
		for (int i=1; i<=N; i++) {
			a[i].f += a[i-1].f - P;
		}
		
		Arrays.sort(a, 1, N+1);

		long ans = 0;
		for (int i=1; i<=N; i++) {
			int cur = a[i].s;
			int curAns = query(cur+1, bit);
			update(cur+1, 1, bit);
			
			if (a[i].f >= 0) curAns ++;
			ans += curAns;

		}

		System.out.println(ans);


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




