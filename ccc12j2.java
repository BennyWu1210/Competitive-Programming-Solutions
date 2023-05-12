
import java.io.*;
import java.util.*;

public class ccc12j2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	static int getType(int a, int b) {
		if (a > b) {
			return 1;
		}
		if (a < b) {
			return 2;
		}
		if (a == b) {
			return 3;
		}
		return 4;
	}
	
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[4];
		for (int i = 0; i < 4; i++) {
			arr[i] = sc.nextInt(); 
		}
		
		int type = getType(arr[0], arr[1]);
		for (int i = 1; i < 3; i++) {
			if (type != getType(arr[i], arr[i + 1])) {
				type = 4;
			}
		}
		
		if (type == 1) {
			System.out.println("Fish Diving");
		}
		else if (type == 2) {
			System.out.println("Fish Rising");
		}
		else if (type == 3) {
			System.out.println("Fish At Constant Depth");
		}
		else if (type == 4) {
			System.out.println("No Fish");
		}
	}
	
	
}


	
	
