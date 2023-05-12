
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
import java.util.*;

public class CalendarP2 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException, ParseException {
		
		int N = readInt();
		int[] monthKey = new int[] {1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};
		String [] week = {"Saturday", "Sunday", "Monday","Tuesday","Wednesday","Thursday","Friday"};

		for(int i=0; i<N; i++) {
			String input = readLine();
			
			// consider negative years later
			
			String year = input.substring(0, 4);
			String month = input.substring(5, 7);
			String day = input.substring(8, 10);
			
			// This gives partial
//			String dateInput = day + "/" + month + "/" + year;
//			SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
//			Date dt1 = format1.parse(dateInput);
//			DateFormat format2 = new SimpleDateFormat("EEEE");
//			String finalDay = format2.format(dt1);
//			
//			System.out.println(finalDay);
			int leapYear = 0;
			if ((Integer.parseInt(month) == 1 || Integer.parseInt(month) == 2) 
					&& ((Integer.parseInt(year)%4 == 0 && Integer.parseInt(year)%100 != 0) 
					|| Integer.parseInt(year)%400 == 0)){
				leapYear = 1;
				
			}
			int yearNum = Integer.parseInt(day) ;
			int gDate = 400;
			if (yearNum >= 1700 && yearNum < 1800) {
				gDate = 1;
			}
			if (yearNum >= 2000 && yearNum < 2100) {
				gDate = 6;
			}
			if (yearNum >= 1700 && yearNum < 1800) {
				gDate = 4;
			}
			if (yearNum >= 1800 && yearNum < 1900) {
				gDate = 2;
			}
			if (yearNum >= 1900 && yearNum < 2000) {
				gDate = 0;
			}
				
			int jBack = 0;
			
			if (jBack <= 1700) {
				jBack = (int) (Math.ceil((1700-Integer.parseInt(year))/100.0) + 1);
			}
			int answer = 
			((Integer.parseInt(year) % 100)/4
			+ Integer.parseInt(day)
			+ monthKey[Integer.parseInt(month)-1]
			+ gDate
			+ jBack
			+ Integer.parseInt(year)%100)
			%7;
			
			System.out.println(week[answer]);
				
			
			
			
		}
		
		
		
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}


	
	
