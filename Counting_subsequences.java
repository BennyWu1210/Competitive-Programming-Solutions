import java.util.*;
public class Counting_subsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int time=0; time<t; time++) {
			sc.nextLine();
			int num = sc.nextInt();
			int sum = 0;
			int counter = 0;
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			map.put(0, 1);
			
			for (int i=0; i<num; i++) {
				int n = sc.nextInt();
				sum += n;
				if (map.containsKey(sum-47)) {
					counter += map.get(sum-47);
				}
				map.put(sum, map.getOrDefault(sum, 0)+1);
				
			}
			
			System.out.println(counter);
		}
		
		
		
	}

}
