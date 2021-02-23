package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {

		
		Map<String,Integer> m = new HashMap<String,Integer>();
		
		m.put("maths",500);
		m.put("physics",600);
		m.put("che",700);
		
		System.out.println(m.get("che"));
		Set<Entry<String,Integer>> s = m.entrySet();
		
		/**
		 * put(key,value)
		 *  value <- get(key)
		 *  entrySet() -> set<entry<k,v>>
		 *  values() -> collections<v>
		 * keySet() -> set<k>
		 * isempty() -> boolean
		 * m.containsKey()
		 * m.containsValue()
		 * 
		 */
		
	}

}
