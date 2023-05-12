import java.io.IOException;
import java.util.*;
public class Hashmap_0213 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		HashMap<String, ArrayList<int[]>> map = new HashMap<String, ArrayList<int[]>>();
		map.put("Dylan", new ArrayList<int[]>());
		map.get("Dylan").add(new int[] {0, 1});
		map.get("Dylan").add(new int[] {1, 2});
		
		
		System.out.println(map.get("Dylan"));

		
	}
}
