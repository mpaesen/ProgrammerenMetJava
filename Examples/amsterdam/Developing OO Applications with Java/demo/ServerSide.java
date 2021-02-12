/*
 * Created on Jun 2, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package demo;

/**
 * @author bempn
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
public class ServerSide // press Ctrl-C to terminate this program
{
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(1234); // specify port number.
			System.out.println(
				"Server listening at "
					+ InetAddress.getLocalHost()
					+ " on port "
					+ ss.getLocalPort());
			while (true) {
				Socket s = ss.accept(); //wait for new client to call
				DataInputStream dis = new DataInputStream(s.getInputStream());
				String message = dis.readUTF(); // wait for client to send
				System.out.println(message);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}