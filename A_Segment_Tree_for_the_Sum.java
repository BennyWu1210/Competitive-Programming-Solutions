
import java.io.*;
import java.util.*;

public class A_Segment_Tree_for_the_Sum {

	static long[] seg;

	static void build(int[] arr) {
		int n = 1;
		while (n < arr.length) n *= 2;

		seg = new long[2 * n];

		build(0, 0, n, arr);

	}

	static void build(int x, int lx, int rx, int[] arr) {
		if (rx - lx == 1) {
			if (lx < arr.length) {
				seg[x] = arr[lx];
			}
			return;
		}

		int m = (lx + rx) / 2;
		build(2*x+1, lx, m, arr);
		build(2*x+2, m, rx, arr);

		seg[x] = seg[2*x+1] + seg[2*x+2];
	}

	static void update(int i, int v, int x, int lx, int rx) {
		if (rx - lx == 1) {
			seg[x] = v;
			return;
		}
		int m = (lx + rx) / 2;
		if (i < m) {
			update(i, v, 2*x+1, lx, m);
		}
		else {
			update(i, v, 2*x+2, m, rx);
		}

		seg[x] = seg[2*x+1] + seg[2*x+2];
	}

	static long get(int l, int r, int x, int lx, int rx) {
		if (lx >= r || rx <= l) return 0;
		if (lx >= l && rx <= r) return seg[x];

		int m = (lx + rx) / 2;
		long sum1 = get(l, r, 2*x+1, lx, m);
		long sum2 = get(l, r, 2*x+2, m, rx);
		return sum1 + sum2;
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]), m = Integer.parseInt(input[1]);
		int[] arr = new int[n];
		
		input = br.readLine().split(" ");
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		build(arr);
		
		for (int i=0; i<m; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[1]), b = Integer.parseInt(input[2]);
			
			switch(input[0]) {
			case "1":
				update(a, b, 0, 0, seg.length/2);
				break;
				
			case "2":
				long ans = get(a, b, 0, 0, seg.length/2);
				System.out.println(ans);
				break;
			}
		}
		
		
	}

}


	
	
