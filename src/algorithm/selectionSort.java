package algorithm;

import java.util.Arrays;

public class selectionSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,23,14,78,9,4,5};
		Arrays.stream(sort(input)).forEach(item->System.out.println(item));
	}
	private static int[] sort(int[] input) {
		
		for(int i =0; i < input.length; i++) {
			int minIndex = i;
			for(int j = i; j < input.length-1; j++) {
				//save the index if the element < input[minIndex]
				if(input[minIndex] > input[j+1]) {
					minIndex = j + 1;
				}
			}
			//if the minIndex <> current element i, switch the min with the current elemtn
			if(minIndex != i) {
				int temp = input[i];
				input[i] = input[minIndex];
				input[minIndex] = temp;
			}
		}
		
		return input;
	}
}
