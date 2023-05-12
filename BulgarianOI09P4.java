
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BulgarianOI09P4 {


	public static int find(int index, int step, int[] ans) { 

		if (index >= ans.length || index < 0) return -1;
		if (step == 1) return index;

		return find(ans[index], step-1, ans);
	}


	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int readInt() throws IOException{
	    int x = 0, c;
	    while((c = br.read()) != ' ' && c != '\n')
	        x = x * 10 + (c - '0');
	    return x;
	}
	
	public static void main(String[] args) throws IOException {

		Deque<int[]> queue = new LinkedList<int[]>();
		int N = readInt();

		int[] height = new int[N];
		int[] ans = new int[N]; // Changing it to stack still resulted in out of memory

		for(int i=0; i<N; i++) {
			height[i] = readInt();

		}

		for(int i=N-1; i>=0; i--) {
			int num = height[i];


			while(!queue.isEmpty() && queue.peek()[0]<=num) {
				queue.pop();
			}

			//ans[i] = queue.isEmpty()? -1:queue.peek()[1]; // arr[1] stores the index of the next tallest bale
			ans[i] = queue.isEmpty()? -1:queue.peek()[1];
			queue.push(new int[] {num, i});


		}
		for(int[] i: queue) System.out.println(Arrays.toString(i));
		System.out.println(Arrays.toString(ans));

		for(int i=0; i<N; i++) {
			int n = ans[i];
			int s = readInt();
			int index = find(n, s, ans);
			if (index == -1) System.out.print(-1 + " ");
			else System.out.print(height[index] + " ");
		}
	}
	

}


