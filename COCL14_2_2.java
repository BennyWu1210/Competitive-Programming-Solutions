import java.io.*;
import java.lang.*;
import java.util.*;
public class COCL14_2_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().split(" ")[0]);
		String[] names = new String[N];
		boolean[] b = new boolean[N];
		
		for(int i=0; i<N; i++) {
			names[i] = br.readLine();
		}
		
		for(int i=0; i<N-1; i++) {
			String name = br.readLine();
			boolean contains = false;
			for(int j=0; j<names.length; j++) {
				if (name.equals(names[j])){
					contains = true;
					b[j] = true;
					break;
				}
			}
			
		}
		
		for(int i=0; i<names.length; i++) {
			if (!b[i]) {
				System.out.println(names[i]);
				System.exit(0);
			}
		}
	}

}
