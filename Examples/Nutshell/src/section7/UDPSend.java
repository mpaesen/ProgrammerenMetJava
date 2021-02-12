package section7;

// This example is from the book _Java in a Nutshell_ by David Flanagan.
// Written by David Flanagan.  Copyright (c) 1996 O'Reilly & Associates.
// You may study, use, modify, and distribute this example for any purpose.
// This example is provided WITHOUT WARRANTY either expressed or implied.

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// This class sends the specified text as a datagram to port 6010 of the 
// specified host.
public class UDPSend
{
	static final int port = 6010;

	public static void main(final String args[]) throws Exception
	{
		if (args.length != 2)
		{
			System.out.println("Usage: java UDPSend <hostname> <message>");
			System.exit(0);
		}

		// Get the internet address of the specified host
		final InetAddress address = InetAddress.getByName(args[0]);
		// Convert the message to an array of bytes
		final int msglen = args[1].length();
		final byte[] message = new byte[msglen];
		args[1].getBytes(0, msglen, message, 0);
		// Initilize the packet with data and address
		final DatagramPacket packet = new DatagramPacket(message, msglen, address, port);
		// Create a socket, and send the packet through it.
		final DatagramSocket socket = new DatagramSocket();
		socket.send(packet);
	}
}
