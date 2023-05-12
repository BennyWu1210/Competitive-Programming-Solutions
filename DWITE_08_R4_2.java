import java.io.*;
import java.util.*;
public class DWITE_08_R4_2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		outer: for (int t=0; t<5; t++) {
			char[][] grid = new char[3][3];
			grid[0] = br.readLine().toCharArray();
			grid[1] = br.readLine().toCharArray();
			grid[2] = br.readLine().toCharArray();
//			System.out.println("----");
//			System.out.println((grid[0][0] == grid[1][0]) + " " + (grid[1][0] == grid[2][0]));
			
			// Detect win
			char center = grid[1][1];
			if ((center != '.') && ((grid[0][0] == center && center == grid[2][2]) || (grid[0][2] == center  && center == grid[2][0]))) {
				System.out.println(center);
				continue outer;
			}
			center = grid[0][1];
			if ((center != '.') && ((grid[0][0] == center && center == grid[0][2]) || (grid[1][1] == center  && center == grid[2][1]))) {
				System.out.println(center);
				continue outer;
			}
			
			center = grid[1][0];
			
			if ((center != '.') && ((grid[0][0] == center && center == grid[2][0]) || (grid[1][1] == center  && center == grid[1][2]))) {
				System.out.println(center);
				continue outer;
			}
			
			center = grid[2][1];
			if ((center != '.') && (grid[2][0] == center && center == grid[2][2])) {
				System.out.println(center);
				continue outer;
			}
			
			center = grid[1][2];
			if((center != '.') && (grid[0][2] == center && center == grid[2][2])) {
				System.out.println(center);
				continue outer;
			}
			
			System.out.println(".");
			
			
		}
	}

}
