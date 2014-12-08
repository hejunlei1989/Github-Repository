package net.hjl.BKTest;

public class Permutation {

	public static void permutation(char[] string){
		//int length = string.length;
		permutationRecursive(string, 0);
	}
	
	public static void permutationRecursive(char[] string, int pos){
		int begin = pos;
		if(begin>=string.length){
			System.out.println(string);
		}else{
			for(int i=begin; i<string.length;i++){
				char t = string[pos];
				string[pos] = string[i];
				string[i] = t;
				permutationRecursive(string, begin+1);
				t = string[pos];
				string[pos] = string[i];
				string[i] = t;
			}
		}
	}
	
	public static void main(String[] args) {

		char[] input = "abc".toCharArray();
		permutation(input);
	}

}
