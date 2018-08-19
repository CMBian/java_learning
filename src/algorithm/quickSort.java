package algorithm;

import java.util.Arrays;

public class quickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,2,7, 23,14,78,9,4,5};
		sort(input);
		Arrays.stream(input).forEach(item->System.out.println(item));
	}
	private static void sort(int[] input) {
		if(input.length > 1) {
			quickSort(input, 0, input.length -1);
		}
		
	}
	private static void quickSort(int[] input, int low, int high) {
		if(low < high) {
			int middle = getMiddle(input, low, high);
			quickSort(input, low, middle - 1);
			quickSort(input, middle + 1, high);
		}
	}
	private static int getMiddle(int[] input, int low, int high) {
		int middle;
		int temp = input[low];//it will prepare input[low] as a space to save the new value
		while(low < high) {
			while(input[high] >= temp && high > low) {
				high--;
			}
			//input[low] is assigned, we need find a new space in low part to save next value
			//input[high] is empty, it is ready accept a new value
			input[low] = input[high];
			while(input[low] <= temp && high > low) {
				low++;
			}
			//find it, move the input[low] value to input[high]
			//input[low] is ready again.
			input[high] = input[low];
		}
		input[low] = temp;
		return low;
	}
	
}
