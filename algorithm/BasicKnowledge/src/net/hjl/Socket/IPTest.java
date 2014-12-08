package net.hjl.Socket;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class IPTest {

	/**
	 * @param args
	 * @throws UnknownHostException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws UnknownHostException, MalformedURLException {
		
		InetAddress ip_address = null;
		System.out.println(ip_address.getLocalHost());
		ip_address = InetAddress.getByName("www.baidu.com");
		System.out.println(ip_address);
		
		URL url = new URL("http://www.baidu.com");
		System.out.println(url.getPort());
	}

}
