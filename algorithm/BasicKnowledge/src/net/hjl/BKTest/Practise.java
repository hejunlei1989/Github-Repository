package net.hjl.BKTest;

import java.util.HashMap;

public class Practise {
	
	public static int smallestInteval(int[] data_array){
		if(data_array.length <= 0) return -1;
		if(data_array.length == 1) return data_array[1];
		
		int result = Math.abs(data_array[1]-data_array[2]);
		for(int i=0; i<data_array.length-1; i++){
			for(int j=i+1; j<data_array.length; j++){
				int temp = Math.abs(data_array[i] - data_array[j]);
				if(temp < result) result = temp;
			}
		}
		
		return result;
	}
	
	public static boolean isInt(char c){
		boolean result = false;
		if(c>='0' && c<='9')
		{
			result = true;
		}else{
			result = false;
		}
		
		return result;
	}
	
	public static int minFunc(int p){
		int count = 0;
		while(p!=1 || p<1){
			if(p%2 == 0){
				p = p>>1;
				count ++;
			}else{
				p = p-1;
				count ++;
			}
		}
		return count;
	}
	
	//用最快的方法的判断所有String2的字母在String1里是否存在，如:string2=”abx” string1=”abcdef”,ab在string1中，x不在
	public static void isIn(String a, String b){
		if(a == null){ return ;}
		HashMap<Character, Integer> hs_a = new HashMap<Character, Integer>();
		for(int i=0; i<a.length(); i++){
			char key = a.charAt(i);
			if(hs_a.containsKey(key)){
				hs_a.put(key, hs_a.get(key)+1);
			}else{
				hs_a.put(key, 1);
			}
		}
		
		for(int i=0; i<b.length();i++){
			char key = b.charAt(i);
			if(hs_a.containsKey(key)){
				System.out.println(key+" is in String1");
			}else{
				System.out.println(key+" is not in String1");
			}
		}
	}

	public static void main(String[] args) {
		int[] a = {11,4,7,18};
		System.out.println(smallestInteval(a));
		System.out.println(isInt('a'));
		System.out.println(minFunc(7));
		isIn("abcdef","abx");
	}

}
