
import java.io.*;
import java.util.*;

public class Nested_Segments {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static final int MM = (int)1e6 * 2 + 5;
	static int[] arr[] = new int[MM][2], seg = new int[MM], ans = new int[MM];

	static void update(int l, int r, int x, int ind) {
		if (l == r) seg[x] = 1;
		else {
			int mid = (l + r) / 2;

			if (ind <= mid) update(l, mid, 2*x, ind);
			else update(mid+1, r, 2*x+1, ind);

			seg[x] = seg[2*x] + seg[2*x+1];
		}
	}

	static int query(int l, int r, int x, int lef, int rit) {
		if (l > rit || r < lef) return 0;
		if (l >= lef && r <= rit) return seg[x];

		int mid = (l + r) / 2;

		return query(l, mid, 2*x, lef, rit) + query(mid+1, r, 2*x+1, lef, rit);
	}

	public static void main(String[] args) throws IOException {

		Reader R = new Reader();
		int n = R.nextInt();

		for (int i=1; i<=2*n; i++) {
			int cur = R.nextInt();

			if (arr[cur][0] == 0) {
				// left
				arr[cur][0] = i;
			}
			else {
				// right
				arr[cur][1] = i;

				ans[cur] = query(1, 2*n, 1, arr[cur][0], arr[cur][1]);
				update(1, 2*n, 1, arr[cur][0]);

			}
		}

		for (int i=1; i<=n; i++) System.out.print(ans[i] + " ");



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


