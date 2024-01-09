package test1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client1 {

	public static void main(String[] args) {
		int port = 3000;
		String serverIP = null;
		try {
			serverIP = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(serverIP);

	}

}
