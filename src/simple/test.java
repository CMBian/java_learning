package simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println(new String("abc").equals(new String("abc")));
		System.out.println(new StringBuffer("abc").equals(new StringBuffer("abc")));
		HashSet<String> hset = new LinkedHashSet();
		hset.add("a");
		hset.add("b");
		hset.add("c");
		hset.add("d");
		hset.add("e");
		hset.add("f");
		hset.add("g");
		hset.add("h");
		hset.add("i");
		hset.add("j");
		hset.add("ek");
		hset.add("e");
		hset.add("e");
//		hset.add("e");
		hset.forEach(p->System.out.println(p));
		
		List<Integer> lInt = new ArrayList<Integer>();
		lInt.add(1);*/
		
		
		/*int count = 0;
		String[] items = new String[5];
		while(count != items.length) 
			System.out.println("test");
		System.out.print(count);
			items[count] = "a";
			count ++;
			System.out.print(count);*/
		System.out.println(System.getProperty("sun.arch.data.model") + Runtime.getRuntime().freeMemory());
		
		String str = "123456789987654321";
		//System.out.print(str.substring(0,1));
		String str1 = append(str);
		System.out.println(str1);
		//System.out.println("a".substring(0, 1));
		
		Hashtable<String, Integer> htable = new Hashtable<String, Integer>();
		//htable.put("1", 1);
		//Integer flg = htable.put("2", 1);
		HashMap<String, Integer>  hmap =new  HashMap<String, Integer> ();
		hmap.put(null, 1);
		//for(Map.Entry<String, Integer> item:  htable.entrySet()) {
			//System.out.print(flg + item.getValue());
		//}
		
		
	}
	
	public static String append(String strTmp) {
		StringBuffer strB = new StringBuffer();
		//System.out.println(strTmp);
		if("".equals(strTmp) || strTmp == null) return "";
		if(strTmp.length() > 1) {
			strB.append(append(strTmp.substring(1)));
		} 
		strB.append(strTmp.substring(0, 1));
		return strB.toString();
		
	}

}
