package net.hjl.SortingAgorithm;

public class QuickSort {
	
	public static void quickSort(int[] data){
		
		sort(data,0,data.length-1);
	}
	
	public static void sort(int[] data, int start, int end){
		if(start >= end) return;
		
		int i = start;
		int j = end;
		int mark = end;

		while(i<j){
			while(data[i] <= data[mark] && i<mark){
				i++;
			}

			if (i < mark) {
				data[i] = data[i] ^ data[mark];
				data[mark] = data[i] ^ data[mark];
				data[i] = data[i] ^ data[mark];
				mark = i;
			}

			while (data[j] >= data[mark] && j > mark) {
				j--;
			}
			if (j > mark) {
				data[j] = data[j] ^ data[mark];
				data[mark] = data[j] ^ data[mark];
				data[j] = data[j] ^ data[mark];
				mark = j;
			}
		}
		
		if(start<mark) sort(data, start, mark-1);
		if(end>mark) sort(data, mark+1, end);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = { 9, 3, 4, 2, 8, 5, 6, 3 };

		QuickSort.quickSort(data);

		for (int i_count = 0; i_count < data.length; i_count++) {
			System.out.print(data[i_count] + " ");
		}
	}

}
