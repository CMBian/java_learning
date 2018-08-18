import java.util.ArrayList;
import java.util.HashMap;

public class MarketMap{
	private final HashMap<String, ArrayList<Double>> map = new HashMap<String, ArrayList<Double>>();
	public boolean put(String stock, double price) {
		if (stock == null || "".equals(stock)) {//stock not exist
			return false;
		}
		ArrayList<Double> lstPrices;
		lstPrices = map.get(stock);// get the prices from map
		if (lstPrices == null) {// not exist in map
			lstPrices = new ArrayList<Double>();
		} else if (lstPrices.size() == 10) {// prices already have 10
			lstPrices.remove(0);//remove the first one
		}
		//add the new price into the list
		lstPrices.add(price);
		map.put(stock, lstPrices);
		return true;
	}

	public ArrayList<Double> get(String stock) {
		return map.get(stock);
	}

	public boolean containsKey(String stock) {
		return map.containsKey(stock);
	}
	
	public ArrayList<Double> remove(String stock) {
		return map.remove(stock);
	}
	
	public int size() {
		return map.size();
	}
	

}
