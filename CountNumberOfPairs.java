import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CountNumberOfPairs {

	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			map.put(num[i], i);
		}
		
		int counter = 0;
		for(int i=0; i<N; i++) {
			int n = num[i];
			if (map.containsKey(Q-n) && i < map.get(Q-n)) {
				counter ++;
			}
		}

		System.out.println(counter);
		
		
	}

}
