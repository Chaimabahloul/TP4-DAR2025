package client;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class client {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		DatagramSocket socket = new DatagramSocket();
        InetAddress serveurAdresse = InetAddress.getByName("localhost");
        int port = 1234;

        Scanner sc = new Scanner(System.in);
        System.out.print("Entrez votre nom d'utilisateur : ");
        String username = sc.nextLine();

        // Thread pour la réception asynchrone
        Thread reception = new Thread(() -> {
            byte[] buffer = new byte[1024];
            while (true) {
                try {
                    DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(paquet);
                    String msgRecu = new String(paquet.getData(), 0, paquet.getLength());
                    System.out.println("\n " + msgRecu);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        reception.start();

        // Boucle d’envoi
        while (true) {
            System.out.print(" Votre message : ");
            String message = sc.nextLine();
            String msgFinal = "[" + username + "] : " + message;

            byte[] data = msgFinal.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, serveurAdresse, port);
            socket.send(packet);
        }
	}}
