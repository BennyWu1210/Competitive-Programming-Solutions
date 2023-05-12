
public class test3208 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int i = 0;
//		String str = "ab*cd";
//		while (i < str.length())
//		{
//			//System.out.println(i);
//			if (str.charAt(0) == '*')
//			{
//				int star = -1;
//				for (int a = i; a < str.length(); a++)
//				{
//					//System.out.println(a + " " + str);
//					if (str.charAt(a) != '*')
//					{
//						star = a - 1;
//						//System.out.println("broked");
//						break;
//					}
//				}
//				if (star == -1)
//				{
//					str = "";
//				}
//				else
//				{
//					//str = str.substring(0, i-1) + str.substring(star + 2, str.length());
//					str = str.substring(star+2, str.length());
//				}
//			}
//			if (str.charAt(i) == '*')
//			{
//				int star = -1;
//				for (int a = i; a < str.length(); a++)
//				{
//					//System.out.println(a + " " + str);
//					if (str.charAt(a) != '*')
//					{
//						star = a - 1;
//						//System.out.println("broked");
//						break;
//					}
//				}
//				if (star == -1)
//				{
//					str = str.substring(0, i);
//				}
//				else
//				{
//					str = str.substring(0, i-1) + str.substring(star + 2, str.length());
//				}
//			}
//			i ++ ;
//			
//		}
		//System.out.println(str);
		String str = "sdijasdahisijdahi";
		String word = "hi";
		int j = 0;
		while (j<str.length()) {
			if (j+word.length() <= str.length() && str.substring(j, j+word.length()).equals(word)) {
				j += word.length()-1;
			}
			else {
				str = str.substring(0, j) + "+" + str.substring(j+1, str.length());
				
			}
			j ++;
		}
		System.out.println(str);
	}

}
