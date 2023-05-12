import java.util.*;
import java.io.*;
public class Postfix_Notation_Redo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		ArrayList<String> list = new ArrayList(Arrays.asList(input));
		int i = 0;
		while(list.size() > 1) {
			//System.out.println(list.get(i));
			//System.out.println(list);
			double result = 0;
			if (list.get(i).equals("*")) {
				double num2 = Double.parseDouble(list.get(i-1));
				double num1 = Double.parseDouble(list.get(i-2));
				result = num1 * num2;
			}
			else if (list.get(i).equals("/")) {
				double num2 = Double.parseDouble(list.get(i-1));
				double num1 = Double.parseDouble(list.get(i-2));
				result = num1 / num2;
			}
			else if (list.get(i).equals("+")) {
				double num2 = Double.parseDouble(list.get(i-1));
				double num1 = Double.parseDouble(list.get(i-2));
				result = num1 + num2;
			}
			else if (list.get(i).equals("-")) {
				double num2 = Double.parseDouble(list.get(i-1));
				double num1 = Double.parseDouble(list.get(i-2));
				result = num1 - num2;
			}
			else if (list.get(i).equals("%")) {
				double num2 = Double.parseDouble(list.get(i-1));
				double num1 = Double.parseDouble(list.get(i-2));

				result = num1 % num2;
			}
			else if (list.get(i).equals("^")) {
				double num2 = Double.parseDouble(list.get(i-1));
				double num1 = Double.parseDouble(list.get(i-2));

				result = Math.pow(num1, num2);
			}
			else {
				i ++;
				continue;
			}
			
			list.remove(i);
			list.remove(i-1);
			list.remove(i-2);
			list.add(i-2, Double.toString(result));
			i --;
		}
		
		System.out.println(String.format("%.1f", Double.parseDouble(list.get(0))));
		
		
	}

}
