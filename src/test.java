import collection.limitQueue;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarketMap map = new MarketMap();
		map.put("apple", 12300.05);
		map.put("apple", 1023230.05);
		map.put("apple", 101.05);
		map.put("apple", 100.05);
		map.put("google", 1100.05);
		map.put("apple", 100.05);
		map.put("apple", 100.05);
		map.put("apple", 100.05);
		map.put("apple", 100.05);
		map.put("apple", 222.05);
		map.put("apple", 99.05);
		map.put("apple", 12.05);
		map.put("apple", 12.05);
		map.put("apple", 12.05);
		map.put("apple", 12.05);
		
		for(double item: map.get("apple")){
			System.out.println(item);
		}
		
		limitQueue<String> limitQ = new limitQueue<String>();
		
		limitQ.offer("1");
		limitQ.offer("2");
		limitQ.offer("3");
		limitQ.offer("4");
		limitQ.offer("5");
		limitQ.offer("6");
		limitQ.offer("7");
		limitQ.offer("8");
		limitQ.offer("9");
		limitQ.offer("10");
		limitQ.offer("11");
		
		limitQ.forEach(item->System.out.println(item));
		
	}

}
