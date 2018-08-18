package GC;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public class weakreference {
	public static void main(String[] args) {
		
		WeakReference<String> strReference = new WeakReference<String>(new String("abc"));
		String string = strReference.get();
		
		WeakHashMap weakMap = new WeakHashMap();
		
	}
}
