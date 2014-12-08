package net.hjl.BKTest;

import java.util.ArrayList;

public class PrimeFactor {
	
	public static String primeFactor(int num){
		if(num<=1) return null;
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		String ret_str = "";
		int temp = num;
		
		for(int i=2; i <= Math.sqrt(num); i++){
			while(temp%i==0){
				temp = temp/i;
				result.add(i);
			}
		}
		if(temp!=1){
			result.add(temp);
		}
		
		for(int i=0; i<result.size()-1;i++){
			ret_str = ret_str+result.get(i)+" * ";
		}
		ret_str += result.get(result.size()-1);
		
		return ret_str;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print(primeFactor(11));

	}

}
