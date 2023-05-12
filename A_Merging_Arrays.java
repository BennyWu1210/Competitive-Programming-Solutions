
import java.io.*;
import java.util.*;

public class A_Merging_Arrays {
	
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		int[] a = new int[n];
		int[] b = new int[m];
		int[] c = new int[n+m];
		
		input = br.readLine().split(" ");
		for (int i=0; i<n; i++) {
			a[i] = Integer.parseInt(input[i]);
		}
		
		input = br.readLine().split(" ");
		for (int i=0; i<m; i++) {
			b[i] = Integer.parseInt(input[i]);
		}
		
		int i = 0, j = 0, k = 0;
		
		while (i < n || j < m) {
			if (j == m || i < n && a[i] < b[j]) {
				c[k++] = a[i++];
			}
			else {
				c[k++] = b[j++];
			}
		}
		
		for (int x: c) System.out.print(x + " ");
		
		System.out.println();
	}
}


	
	
