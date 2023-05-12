import java.util.*;
import java.io.*;
public class Dmopc20_2P1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		char[][] grid = new char[num][num];
		// TODO do this later
		int x = 0;
		int y = 0;
		
		for (char c: arr) {
			if (c == '^') {
				grid[x][y] = '/';
				x ++;
				y ++;
			}
			else if (c == 'v') {
				x --;
				grid[x][y] = '\\';
				y ++;
			}
			else if (c == '>') {
				grid[x][y] = '_';
				y ++;
			}
			
			
		}
		
		
		
	}

}
