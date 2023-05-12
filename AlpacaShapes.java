import java.util.Scanner;

public class AlpacaShapes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int radius = sc.nextInt();
		
		double circleArea = 3.14 * Math.pow(radius, 2);
		double squareArea = Math.pow(length, 2);
		if (circleArea > squareArea) System.out.println("CIRCLE");
		if (circleArea < squareArea) System.out.println("SQUARE");
		
		
	}

}
