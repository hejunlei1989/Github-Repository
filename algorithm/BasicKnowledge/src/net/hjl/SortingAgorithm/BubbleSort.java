package net.hjl.SortingAgorithm;


public class BubbleSort {

	public static void bubbleSort (int[] data, boolean ascend){
		
		if (ascend) {
			/*for (int k_count = 1; k_count < data.length - 1; k_count++) {
				for (int i_count = 0; i_count < data.length - k_count; i_count++) {
					if (data[i_count] > data[i_count + 1]) {
						data[i_count] = data[i_count] ^ data[i_count + 1];
						data[i_count + 1] = data[i_count + 1] ^ data[i_count];
						data[i_count] = data[i_count] ^ data[i_count + 1];
					}
				}
			}*/
			
			for (int j = 1; j < data.length; j++){
				for(int i = 0; i < data.length-j; i++){
					if(data[i] > data[i+1]){
						data[i] = data[i] ^ data[i+1];
						data[i+1] = data[i] ^ data[i+1];
						data[i] = data[i] ^ data[i+1];
					}
				}
			}
		}else{
			/*for (int k_count = 1; k_count < data.length - 1; k_count++) {
				for (int i_count = 0; i_count < data.length - k_count; i_count++) {
					if (data[i_count] < data[i_count + 1]) {
						data[i_count] = data[i_count] ^ data[i_count + 1];
						data[i_count + 1] = data[i_count + 1] ^ data[i_count];
						data[i_count] = data[i_count] ^ data[i_count + 1];
					}
				}
			}*/
		}
	}
	
	/*
	public static void exchange (int a, int b){
		a = a ^ b;
		b = b ^ a;
		a = a ^ b;
	}*/
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] data = {10, 1, 3, 8, 5};
		BubbleSort.bubbleSort(data,true);
		
		for(int i_count=0; i_count<data.length; i_count++){
			System.out.print(data[i_count]+" ");
		}
	}

}
