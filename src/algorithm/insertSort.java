package algorithm;

import java.util.Arrays;

public class insertSort {
public static void main(String[] args) {
	// TODO Auto-generated method stub
			int[] input = {1,23,14,78,9,4,5};
			sort(input);
			Arrays.stream(input).forEach(item->System.out.println(item));
}
private static void sort(int[] input) {
	for(int i = 1; i < input.length; i++) {
		int temp = input[i];
		int j = i -1;
		for(; j >= 0 && input[j]>temp;j--) {
			input[j + 1] = input[j];
		}
		input[j + 1] = temp;
	}
}
}
