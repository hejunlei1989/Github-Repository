package net.hjl.SortingAgorithm;

public class InsertionSort {
	
	public static void insersionSort(int[] data, boolean ascend){
		
		if(ascend){
			for (int k = 1; k < data.length; k++) {
				int temp = k;
				for (int i = k-1; i >=0; i--) {
					if(data[temp] < data[i]){
						data[temp] = data[temp] ^ data[i];
						data[i] = data[i] ^ data[temp];
						data[temp] = data[temp] ^ data[i];
						temp = i;
					}else{
						break;
					}
				}
			}
		}else{
			for (int k = 1; k < data.length; k++) {
				int temp = k;
				for (int i = k-1; i >=0; i--) {
					if(data[temp] > data[i]){
						data[temp] = data[temp] ^ data[i];
						data[i] = data[i] ^ data[temp];
						data[temp] = data[temp] ^ data[i];
						temp = i;
					}else{
						break;
					}
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] data = {9,3,4,2,8,5,6,3};
		
		InsertionSort.insersionSort(data, false);
		
		for(int i_count=0; i_count<data.length; i_count++){
			System.out.print(data[i_count]+" ");
		}
	}

}
