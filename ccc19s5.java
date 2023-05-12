
import java.io.*;
import java.util.*;

public class ccc19s5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static final int MM = 3005;
	static long N, K, a[][] = new long[MM][MM];
	static long ans;

	public static void main(String[] args) throws IOException {

		Reader r = new Reader();
		N = r.nextLong(); K = r.nextLong();

		for (int i=1; i<=N; i++) {
			for (int j=1; j<=i; j++) {
				a[i][j] = r.nextLong();
			}
		}

		int cur = 0, nxt = 0;
		for (cur=1, nxt=2; nxt<=K; cur=nxt, nxt=(int)(1.5*cur)) {
			int d = nxt - cur;
			for (int i=1; i<=N-nxt+1; i++) {
				for (int j=1; j<=i; j++) {
					a[i][j] = Math.max(a[i][j], Math.max(a[i+d][j], a[i+d][j+d]));
				}
			}
		}

		int d = (int)K - cur;
		for (int i=1; i<=N-K+1; i++) {
			for (int j=1; j<=i; j++) {
				ans += Math.max(a[i][j], Math.max(a[i+d][j], a[i+d][j+d]));
			}
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




