package net.hjl.SortingAgorithm;

public class MergeSort {
	
	public static void mergeSort(int[] array, int start, int end){
		if(start>=end) return ;
		int mid = (start+end)/2;
		mergeSort(array, start, mid);
		mergeSort(array, mid+1, end);
		merge(array,start, mid, end);
	}
	
	public static void merge(int[] array, int start, int mid, int end){
		int length = end-start+1;
		int[] temp = new int[length];
		int i = start;
		int j = mid+1;
		int k = 0;
		while(i<=mid && j<=end){
			if(array[i]<array[j]){
				temp[k] = array[i];
				i++;k++;
			}else{
				temp[k] = array[j];
				j++;k++;
			}
		}
		while(i<=mid){
			temp[k] = array[i];
			i++;k++;
		}
		while(j<=end){
			temp[k] = array[j];
			j++;k++;
		}
		for(int i_count=start,j_count=0; i_count<=end; i_count++,j_count++){
			array[i_count]=temp[j_count];
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = {9,3,4,2,8,5,6,3};
		
		mergeSort(data,0,6);
		
		for(int i_count=0; i_count<data.length; i_count++){
			System.out.print(data[i_count]+" ");
		}

	}

}
