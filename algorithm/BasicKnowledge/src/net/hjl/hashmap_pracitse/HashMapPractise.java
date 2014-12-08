package net.hjl.hashmap_pracitse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapPractise {
	
	public static ArrayList<String> stringCompare(String a, String b){
		HashMap<Character, Integer> hsmap_a = new HashMap<Character,Integer>();
		for(int i=0; i<a.length(); i++){
			char key = a.charAt(i);
			if(hsmap_a.containsKey(key)){
				hsmap_a.put(key, hsmap_a.get(key)+1);
			}else{
				hsmap_a.put(key, 1);
			}
		}
		
		HashMap<Character, Integer> hsmap_b = new HashMap<Character, Integer>();
		for(int i=0; i<b.length();i++){
			char key = b.charAt(i);
			if(hsmap_b.containsKey(key)){
				hsmap_b.put(key, hsmap_b.get(key)+1);
			}else{
				hsmap_b.put(key, 1);
			}
		}
		
		Iterator iter_a = hsmap_a.entrySet().iterator();
		Iterator iter_b = hsmap_b.entrySet().iterator();
		
		ArrayList<String> result = new ArrayList<String>();
		
		while(iter_a.hasNext()){
			Map.Entry<Character, Integer> entry_a = (Entry<Character, Integer>) iter_a.next();
			Character key = entry_a.getKey();
			int value_a = entry_a.getValue();
			
			if(hsmap_b.containsKey(key)){
				int value_b = hsmap_b.get(key);
				if(value_a > value_b){
					int count = value_a - value_b;
					for(int i=0; i<count; i++)
					{
						result.add("-"+key.toString());
					}
				}else if(value_b > value_a){
					int count = value_b - value_a;
					for(int i=0; i<count; i++){
						result.add("+"+key);
					}
				}
			}else{
				for(int i=0; i<value_a;i++){
					result.add("-"+key);
				}
			}
		}
		
		while(iter_b.hasNext()){
			Map.Entry<Character, Integer> entry_b = (Entry<Character, Integer>) iter_b.next();
			Character key = entry_b.getKey();
			int value_b = entry_b.getValue();
			
			if(!hsmap_a.containsKey(key)){
				for(int i=0; i<value_b;i++){
					result.add("+"+key);
				}
			}
		}
		
		return result;
	}
	
	public static boolean ifTwoStringsHasSameCharacters(String a, String b){
		HashMap<Character, Integer> hsmap_a = new HashMap<Character, Integer>();
		for(int i=0; i<a.length(); i++){
			char key = a.charAt(i);
			if(hsmap_a.containsKey(key)){
				hsmap_a.put(key, hsmap_a.get(key)+1);
			}else{
				hsmap_a.put(key, 1);
			}
		}
		
		//HashMap<Character, Integer> hsmap_b = new HashMap<Character, Integer>();
		for(int i=0; i<b.length(); i++){
			char key = b.charAt(i);
			if(hsmap_a.containsKey(key)){
				hsmap_a.put(key, hsmap_a.get(key)-1);
			}else{
				return false;
			}
		}
		
		Iterator iter = hsmap_a.entrySet().iterator();
		while(iter.hasNext()){
			Map.Entry<Character, Integer> entry = (Entry<Character, Integer>) iter.next();
			int value = entry.getValue();
			if(value!=0){
				return false;
			}
		}
		
		
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abaa";
		String b = "aaab";
		
//		ArrayList<String> result = stringCompare(a,b);
//		for(int i=0; i<result.size()-1; i++){
//			System.out.print(result.get(i)+",");
//		}
//		System.out.print(result.get(result.size()-1));
		
		System.out.print(ifTwoStringsHasSameCharacters(a,b));
	}

}
