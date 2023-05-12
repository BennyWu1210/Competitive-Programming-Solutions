import java.util.*;

public class fastSearch {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		
		Arrays.sort(arr);
		
		int k = scan.nextInt();
		
		for (int i = 0; i < k; i++) {
			int l = scan.nextInt();
			int r = scan.nextInt();
			int lindex = n, rindex = -1;
			int Lleft = 0, Lright = n - 1;
			int Rleft = 0, Rright = n - 1;
			
			while (Rleft <= Rright) {
				int mid = (Rleft + Rright) / 2;
				if (arr[mid] > r) {
					Rright = mid - 1;
				} else if (arr[mid] <= r) {
					rindex = mid;
					Rleft = mid + 1;
				}
			}
			
			while (Lleft <= Lright) {
				int mid = (Lleft + Lright) / 2;
				if (arr[mid] >= l) {
					Lright = mid - 1;
					lindex = mid;
				} else if (arr[mid] < l) {
					
					Lleft = mid + 1;
				}
			}
			System.out.println(rindex - lindex + 1);
		}
	}
}