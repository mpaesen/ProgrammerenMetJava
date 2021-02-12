package lab13.solution;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientSide {

public static void main(String args[]) {
   if (args.length != 3) {
      System.out.println("Usage: java ClientSide Hostname port message");
      System.exit(0);
   }
   String serverName = args[0]; // either ASCII or numeric form is OK
   int serverPort = Integer.parseInt(args[1]);
   String message = args[2];
   try {
      Socket s = new Socket(serverName, serverPort); //wait for server to accept
      DataOutputStream dos = new DataOutputStream(s.getOutputStream());
      DataInputStream dis = new DataInputStream(s.getInputStream());
      dos.writeUTF(message);
      String reply = dis.readUTF();
      System.out.println("The server replied: " + reply);
   } catch (Exception e) {
      System.out.println(e);
   }
}
}
