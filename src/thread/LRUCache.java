package thread;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class LRUCache<K, V> extends LinkedHashMap<K, V>{

	private int cachesize = 0;
	
	public LRUCache(int size) {
		super(size, (float) (0.75),true);
		this.cachesize = size;
	}
	
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > this.cachesize;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache<String, Integer> lrucache = new LRUCache<String, Integer>(5);
		for(int i = 0; i < 5; i++) {
			lrucache.put("k"+i, i);
		}
		lrucache.forEach((k, v)->System.out.println(k+"is"+v));
		for(int i = 0; i < 10; i++) {
			Random random = new Random();
			String key = "k"+random.nextInt(5);
			System.out.println("--------------------------");
			System.out.println(key);
			lrucache.get(key);
			lrucache.forEach((k, v)->System.out.println(k+"is"+v));
		}
		
		lrucache.put("k5", 10);
		System.out.println("--------------------------");
		lrucache.forEach((k, v)->System.out.println(k+"is"+v));
	}

}
