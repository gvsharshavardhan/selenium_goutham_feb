package collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapsDemo {
	
	public static void main(String[] args) {
		Map m = new LinkedHashMap();
		m.put(10, "a");
		m.put(20, "aa");
		m.put(30, "aaa");
		m.put(40, "ab");
		m.put(50, "abc");
		
		System.out.println(m);
		System.out.println(m.get(30));
		System.out.println(m.remove(20));
		System.out.println(m);
		System.out.println(m.containsValue(50));
		System.out.println(m.isEmpty());
		System.out.println(m.size());

		Set keys = m.keySet();
		System.out.println(keys);
		
		Collection valus = m.values();
		System.out.println(valus);
		
		Set<Entry> entries = m.entrySet();
		System.out.println(entries);
		
		for(Entry e:entries) {
			System.out.println(e.getKey()+" : "+e.getValue());
			if((Integer)e.getKey()==40) {
				e.setValue("xyz");
			}
		}
		System.out.println(entries);
		System.out.println(m);
		
	}

}
