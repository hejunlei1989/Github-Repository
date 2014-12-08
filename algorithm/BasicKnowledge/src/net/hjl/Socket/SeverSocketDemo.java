package net.hjl.Socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SeverSocketDemo {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(2020);
			Socket sk = server.accept();
			System.out.println("Someone has connected to this server!");
			
			DataOutputStream os = new DataOutputStream(sk.getOutputStream());
			os.writeUTF("一个来自服务器的消息！");
			os.close();
			sk.close();
			server.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
