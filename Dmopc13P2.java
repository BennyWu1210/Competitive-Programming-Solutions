import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Dmopc13P2 {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		LocalDate date = LocalDate.now().minusDays(300);
		int N = sc.nextInt();
		sc.nextInt();
		sc.nextLine();
		
		String dateTime = sc.nextLine();
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date currentDate = formatter.parse(dateTime);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(currentDate);
		cal.add(Calendar.HOUR, -N);
		Date back = cal.getTime();
		System.out.println(formatter.format(back));
		
	}

}
