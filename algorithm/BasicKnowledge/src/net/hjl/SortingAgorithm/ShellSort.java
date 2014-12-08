package net.hjl.SortingAgorithm;

public class ShellSort {
	
	public static void shellSort(int[] data, boolean ascend){
		
		if(ascend){
			for(int span=data.length/2; span>0; span=span/2){
				
				for(int k=0; k<span; k++){
					for(int i=k+span; i<data.length; i=i+span){
						int temp = i ;
						for(int j=i-span; j>=0; j=j-span){
							if(data[temp] < data[j]){
								data[temp] = data[temp]^data[j];
								data[j] = data[temp]^data[j];
								data[temp] = data[temp]^data[j];
								temp = j;
							}else{
								break;
							}
						}
						
					}
				}
			}
		}else{
			for (int span = data.length / 2; span > 0; span = span / 2) {

				for (int k = 0; k < span; k++) {
					for (int i = k + span; i < data.length; i = i + span) {
						int temp = i;
						for (int j = i - span; j >= 0; j = j - span) {
							if (data[temp] > data[j]) {
								data[temp] = data[temp] ^ data[j];
								data[j] = data[temp] ^ data[j];
								data[temp] = data[temp] ^ data[j];
								temp = j;
							} else {
								break;
							}
						}

					}
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = { 9, 3, 4, 2, 8, 5, 6, 3 };

		ShellSort.shellSort(data, false);

		for (int i_count = 0; i_count < data.length; i_count++) {
			System.out.print(data[i_count] + " ");
		}
	}

}
