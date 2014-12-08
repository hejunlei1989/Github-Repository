package net.hjl.Socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClientSocket {

	
	public static void main(String[] args) {
		try {
			Socket client = new Socket("127.0.0.1",2020);
			DataOutputStream c_os = new DataOutputStream(client.getOutputStream());
			DataInputStream c_is = new DataInputStream(client.getInputStream());
			
			new ClientReader(c_is).start();
			new ClientWriter(c_os).start();
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

class ClientWriter extends Thread{
	private DataOutputStream os;
	
	public ClientWriter(DataOutputStream c_os){
		os = c_os;
	}
	
	public void run(){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		boolean online = true;
		
		try{
			while(online){
				str = br.readLine();
				System.out.println("我说: "+str);
				if(str.equals("bye")){
					online = false;
					System.out.println("我下线！");
					os.close();
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

class ClientReader extends Thread{
	private DataInputStream is;
	
	public ClientReader(DataInputStream c_is){
		is = c_is;
	}
	
	public void run(){
		String str = null;
		boolean online = true;
		
		try{
			while(online){
				str = is.readUTF();
				System.out.println("服务端说: "+str);
				if(str.equals("bye")){
					online = false;
					System.out.println("服务器下线！");
					is.close();
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
