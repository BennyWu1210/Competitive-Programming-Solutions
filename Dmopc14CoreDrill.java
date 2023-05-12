import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Dmopc14CoreDrill {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		String[] input1 = br.readLine().split(" ");
		int r = Integer.parseInt(input[0]);
		int h = Integer.parseInt(input1[0]);
		System.out.println((double)Math.round(3.14159*Math.pow(r, 2)*h/3*100)/100.00);
	}

}

