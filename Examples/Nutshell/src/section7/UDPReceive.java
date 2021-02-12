package section7;

// This example is from the book _Java in a Nutshell_ by David Flanagan.
// Written by David Flanagan.  Copyright (c) 1996 O'Reilly & Associates.
// You may study, use, modify, and distribute this example for any purpose.
// This example is provided WITHOUT WARRANTY either expressed or implied.

import java.net.DatagramPacket;
import java.net.DatagramSocket;

// This program waits to receive datagrams sent to port 6010.  
// When it receives one, it displays the sending host and port, 
// and prints the contents of the datagram as a string.
public class UDPReceive
{
	static final int port = 6010;

	public static void main(final String args[]) throws Exception
	{
		final byte[] buffer = new byte[1024];
		String s;
		// Create a socket to listen on the port.
		final DatagramSocket socket = new DatagramSocket(port);

		for (;;)
		{
			// Create a packet with an empty buffer to receive data
			// Bug workaround: create a new packet each time through the loop.
			// If we create the packet outside of this loop, then it seems to
			// loose track of its buffer size, and incoming packets are 
			// truncated.
			final DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			// Wait to receive a datagram
			socket.receive(packet);
			// Convert the contents to a string
			s = new String(buffer, 0, 0, packet.getLength());
			// And display them
			System.out.println("UDPReceive: received from " + packet.getAddress().getHostName() + ":" + packet.getPort() + ": " + s);
		}
	}
}
