package net.hjl.FileOperation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReadPractise {
	
	//�ӿ���̨������Ϣ
	public static void readFromConsole(){
		System.out.println("��������Ϣ: ");
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		try {
			String a = read.readLine();
			System.out.println(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		int b = sc.nextInt();
		System.out.println(b);
	}
	
	//����һ���ļ�ÿһ�����ַ������ҳ����е�����ԣ�����abc��cba������Ķ�
	public static void readFromFile(String file_path){
		File file = new File(file_path);
		ArrayList<String> string_array = new ArrayList<String>();
		Scanner sc;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()){
				String temp = sc.nextLine();
				if(string_array.contains(temp)){
					System.out.println(stringReverse(temp)+" and "+temp+" ������ԡ�");
				}
				string_array.add(stringReverse(temp));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static String stringReverse(String a){
		String b = "";
		for(int i=a.length()-1; i>=0;i--){
			b += a.charAt(i);
		}
		return b;
	}
	
	public static char[] stringReverse2(char[] a){
		
		for(int i=0,j=a.length-1; i<j;i++,j--){
			a[i] = (char) (a[i]^a[j]);
			a[j] = (char) (a[i]^a[j]);
			a[i] = (char) (a[i]^a[j]);
		}
		return a;
	}
	
	

	public static void main(String[] args) {
		//readFromConsole();
		//readFromFile("D:\\test.txt");
		char[] a = "adf".toCharArray();
		System.out.println(stringReverse2(a));
	}

}
