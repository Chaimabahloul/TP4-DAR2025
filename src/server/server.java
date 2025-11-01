package server;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class server {

	
		// TODO Auto-generated method stub
		 static byte buffer[] = new byte[1024];

		    public static void main(String argv[]) throws Exception {
		        DatagramSocket socket = new DatagramSocket(1234);
		        System.out.println("Lancement du serveur UDP sur le port 1234...");

		        while (true) {
		            DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);
		            socket.receive(paquet); // attente bloquante

		            int taille = paquet.getLength();
		            String donnees = new String(paquet.getData(), 0, taille);
		            System.out.println("Message reçu de " +paquet.getAddress().getHostAddress() + ":" + paquet.getPort());
		            System.out.println(" Contenu : " + donnees);
		        }

	}

}
