package server;
import java.net.*;
import java.util.*;
import java.net.DatagramSocket;

public class server {

	
		// TODO Auto-generated method stub
		 static byte buffer[] = new byte[1024];
		
		    static Set<SocketAddress> clients = new HashSet<>();

		    public static void main(String argv[]) throws Exception {
		        DatagramSocket socket = new DatagramSocket(1234);
		        System.out.println(" Serveur UDP prêt sur le port 1234...");

		        while (true) {
		            DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);
		            socket.receive(paquet);

		            String message = new String(paquet.getData(), 0, paquet.getLength());
		            SocketAddress expediteur = paquet.getSocketAddress();

		            clients.add(expediteur); // mémorise le client

		            System.out.println(" Reçu de " + expediteur + " : " + message);

		            //  Diffusion à tous les autres clients
		            for (SocketAddress client : clients) {
		                if (!client.equals(expediteur)) {
		                    byte[] data = message.getBytes();
		                    DatagramPacket envoi = new DatagramPacket(data, data.length, client);
		                    socket.send(envoi);
		                }
		            }
		        }


	}

}
