import java.io.*;
import java.util.*;
public class Postfix_Notation {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String[] input = br.readLine().split(" ");
		String[] input = new String[1];
		System.out.println(br.readLine());
		// Find the operation that should be used
		// Go backwards and look for the two numbers, while recording the starting and ending indices
		// Replace the resulting number in the linked list
		// Continue until all the operations are completed
		
		// Assume single digit for now
		
		int num = Integer.parseInt(input[0]);
		int startIndex = 0;
		int endIndex = -1;
		//String num2 = "";
		
		for(int i=2; i<input.length; i+=2) {
//			if(input[i] != "+" || input[i] != "-" || input[i] != "*" 
//					|| input[i] != "/"  || input[i] != "%" || input[i] != "^" ) {
//				num2 += input[i]
//			}
			String temp = input[i];
			input[i] = input[i-1];
			input[i-1] = temp;
		}
		
		ArrayList <String> list = new ArrayList(Arrays.asList(input));
		//System.out.println(list);
		int i = 1;
		while(i < list.size()) {
			//System.out.println(list);
			double num1 = Double.parseDouble(list.get(i-1));
			double num2 = Double.parseDouble(list.get(i+1));
			double newNum = 0;
			if(list.get(i).equals("^")) {
				newNum = Math.pow(num1, num2);
			}
			else if(list.get(i).equals("*")) {
				newNum = num1 * num2;
			}
			else if(list.get(i).equals("/")) {
				newNum = num1 / num2;
			}
			else if(list.get(i).equals("%")) {
				newNum = num1 % num2;
			}
			else if(list.get(i).equals("+")) {
				newNum = num1 + num2;
			}
			else if(list.get(i).equals("-")) {
				newNum = num1 - num2;
			}
			else {
				System.exit(-1);
			}
			list.remove(i+1);
			list.remove(i);
			list.remove(i-1);
			
			list.add(i-1, Double.toString(newNum));
			if (list.size() == 1) {
				System.out.println(list.get(0));
				break;
			}
		}
		

	}

}
