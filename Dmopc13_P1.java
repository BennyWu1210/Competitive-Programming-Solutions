import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Dmopc13_P1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		//String s = sc.nextLine();
		//System.out.println(s);
		String[] input0 = sc.nextLine().split(" ");
		int N = Integer.parseInt(input0[0]);
		int M = Integer.parseInt(input0[1]);
		HashMap<Integer, ArrayList<String>> inputs = new HashMap<Integer, ArrayList<String>>();

		for (int i=0; i<M; i++) {
			String[] input1 = sc.nextLine().split(" ");
			String input2 = sc.nextLine();
			int q = Integer.parseInt(input1[1]);
			if (!inputs.containsKey(q)) {
				inputs.put(q, new ArrayList<String>());
			}
			inputs.get(q).add(input2);

			
		}
		int p = sc.nextInt();
		if (inputs.containsKey(p)) {
			for (String s: inputs.get(p)) {
				System.out.println(s);
			}
		}
		
		
	}

}
