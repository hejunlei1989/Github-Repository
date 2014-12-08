package net.hjl.Socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServerSocket {

	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(2020);
			Socket sk = server.accept();
			System.out.println("客户端连接成功");
			
			DataOutputStream s_os = new DataOutputStream(sk.getOutputStream());
			DataInputStream s_is = new DataInputStream(sk.getInputStream());
			
			new ServerReader(s_is).start();
			new ServerWriter(s_os).start();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ServerWriter extends Thread{
	DataOutputStream os;
	public ServerWriter(DataOutputStream s_os){
		os = s_os;
	}
	
	public void run(){
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		boolean online = true;
		try{
			while(online){
				str = br.readLine();
				os.writeUTF(str);
				System.out.println("服务器说: "+str);
				if(str.equals("bye")){
					System.out.println("服务器下线！");
					online = false;
					os.close();
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

class ServerReader extends Thread{
	DataInputStream is;
	
	public ServerReader(DataInputStream s_is){
		is = s_is;
	}
	
	public void run(){
		String str = null;
		boolean online = true;
		try{
			while(online){
				str = is.readUTF();
				System.out.println("客户端说: "+ str);
				if(str.equals("bye")){
					System.out.println("客户端已经下线！");
					online = false;
					is.close();
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
