package lab13.solution;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide
{
public static void main(String[] args) {
   while (true) {            /* terminate with ctrl-c or with the terminate option
                                of the VisualAge console */
      try {
         ServerSocket ss = new ServerSocket(1234); // specify port number.
         System.out.println("Server listening at " + InetAddress.getLocalHost()
                           + " on port " + ss.getLocalPort());
         while (true) {
            Socket s = ss.accept(); //wait for new client to call
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            String message = dis.readUTF(); // wait for a client to send
            System.out.println(s.getInetAddress() + " said: " + message);
            dos.writeUTF("you said: " + message);
         }
      } catch (Exception e) {
         System.out.println(e);
      }
   }
}
}
