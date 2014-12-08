package net.hjl.BKTest;

public class LongestSubString {
	
	public static String longestSubString(String inputS){
		String subS = inputS.charAt(0)+"";
		String temp = subS;
		for(int i=1; i<inputS.length(); i++){
			String c = inputS.charAt(i)+"";
			if(subS.contains(c)){
				if(temp.length() < subS.length()){
					temp = subS;
				}
				int pos = subS.indexOf(c);
				subS = subS.substring(pos+1,subS.length());
			}
			subS += c;
		}
		if(temp.length() < subS.length()){
			temp = subS;
		}
		return temp;
	}
	
	public static void main(String[] args) {
		String s = "ababcdaefgafg";
		System.out.println(longestSubString(s));
	}

}
