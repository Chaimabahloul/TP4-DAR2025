package client;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
public class client {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		   DatagramSocket socket = new DatagramSocket();
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Entrez votre nom d'utilisateur : ");
	        String username = sc.nextLine();

	        InetAddress serveurAdresse = InetAddress.getByName("localhost");
	        int port = 1234;

	        while (true) {
	            System.out.print(" Entrez votre message : ");
	            String message = sc.nextLine();

	            String msgFinal = "[" + username + "] : " + message;
	            byte buffer[] = msgFinal.getBytes();

	            DatagramPacket donneesEmises = new DatagramPacket(buffer, buffer.length, serveurAdresse, port);
	            socket.send(donneesEmises);
	            System.out.println("Message envoyé !");
	        }}}
