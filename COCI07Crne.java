import java.util.Scanner;

public class COCI07Crne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int a = num/2+1;
		
		if (num % 2 == 0) System.out.println(a*a);
		else System.out.println(a*(a+1));
	}

}
