package syakyo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ListSample {

	public static void main(String[] args) {
		
		Map<String, Integer> map =new LinkedHashMap<>();
		map.put("Apple", 100);
		
		
		List<String> fruits =
				new ArrayList<>();
		fruits.add("Apple");
		fruits.add("Banana");
		fruits.add("Orange");
		
		for(String fluit : fruits) {
			System.out.println(fluit);
		}
		
		String fluit_data = fruits.get(0);
		System.out.println(fluit_data);
		
	}
}
