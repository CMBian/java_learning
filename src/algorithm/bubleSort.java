package algorithm;

import java.util.Arrays;

public class bubleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,23,14,78,9,4,5};
		sort(input);
		Arrays.stream(input).forEach(item->System.out.println(item));
	}
	
	private static void sort(int[] input) {
		if(input == null) return;
		for(int i = 0; i < input.length - 1; i++) {
			for(int j = 0; j < input.length - i - 1; j++) {
				if(input[j]>input[j+1]) {
					int temp = input[j];
					input[j] = input[j+1];
					input[j+1]= temp;
				}
			}
		}
	}

}
