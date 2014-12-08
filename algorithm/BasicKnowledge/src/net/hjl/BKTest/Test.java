package net.hjl.BKTest;

public class Test {
	
	public static String padString(String string, int minLength, char padChar){
		if(string.length() >= minLength){
			return string;
		}else{
			int num = minLength - string.length();
			for(int i=0; i<num; i++){
				string = string+padChar;
			}
			return string;
		}
	}
	
	public static int tryFinallyTest(){
		int x = 1;
		try{
			return x;
		}
		finally{
			System.out.println(2);
			x=2;
			System.out.println(x);
		}
		
	}
	
//	public static String splitCommands(String string){
//		String[] command_array = string.split("-");
//	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//String result = padString("test",6,'h');
		//System.out.println(result);
		
		//int x = tryFinallyTest();
		//System.out.println(x);
		
		int i = 0;
		int j = i ++;
		i = 0;
		int k = ++i;
		System.out.println(k);
	}

}
