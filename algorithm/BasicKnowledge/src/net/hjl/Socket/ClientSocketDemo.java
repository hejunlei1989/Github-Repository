package net.hjl.Socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Socket client = new Socket("127.0.0.1",2020);
			DataInputStream is = new DataInputStream(client.getInputStream());
			System.out.println(is.readUTF());
			is.close();
			client.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
