package net.hjl.BKTest;

public class Feibolaqie {
	
	public static int feibolaqie(int n){
		if(n <= 0) return 0;
		if(n == 1 || n==2) return 1;
		
		return feibolaqie(n-2) + feibolaqie(n-1);
	}
	
	public static int feibolaqie2(int n){
		if(n <= 0) return 0;
		if(n == 1 || n==2) return 1;
		
		int result = 0;
		int temp_1 = 1, temp_2 = 1;
		for(int i=3; i<=n; i++){
			result = temp_1 + temp_2;
			temp_1 = temp_2;
			temp_2 = result;
		}
		
		return result;
	}

	public static void main(String[] args) {
		
		System.out.print(feibolaqie2(7));

	}

}
