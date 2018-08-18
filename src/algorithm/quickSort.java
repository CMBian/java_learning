package algorithm;

import java.util.Arrays;

public class quickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,23,14,78,9,4,5};
		Arrays.stream(sort(input)).forEach(item->System.out.println(item));
	}
	private static int[] sort(int[] input) {
		if(input == null) {
			return null;
		}
		
		return input;
	}
	
}
