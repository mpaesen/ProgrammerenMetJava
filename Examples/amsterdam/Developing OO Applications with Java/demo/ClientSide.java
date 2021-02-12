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

import java.io.DataOutputStream;
import java.net.Socket;
public class ClientSide {
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Usage: java ClientSide Hostname port message");
			System.exit(0);
		}else {
			System.out.println("Message: "+args[2]+"\n sent to \n\t" + args[0]+":"+args[1]);
		}
		String serverName = args[0]; // either ASCII or numeric form is OK
		int serverPort = Integer.parseInt(args[1]);
		String message = args[2];
		try {
			Socket s = new Socket(serverName, serverPort);
			//wait for server to accept
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			dos.writeUTF(message);
			dos.close(); // and flush
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}