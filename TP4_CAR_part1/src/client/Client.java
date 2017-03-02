package client;

import interfaces.ChatRoomInterface;
import interfaces.ClientInterface;
import interfaces.MessageInterface;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * @author six delbrouque
 * 
 *         Classe object du Client
 */
public class Client {

	private String login;
	private String mdp;
	private String pseudo;
	private ClientInterface client;
	private ChatRoomInterface stub;
	private static Scanner scan;
	
	public Client() {
		scan = new Scanner(System.in);
		login = "";
		mdp = "";
		pseudo = "";
		client = null;
		try {
			Registry registry = LocateRegistry.getRegistry(10000);
			stub = (ChatRoomInterface) registry.lookup("methode");
		} catch (IOException e) {
			System.err.println("impossible de créer un pont entre le serveur et le client");
		} catch (NotBoundException e) {
			System.err.println("impossible de créer un pont entre le serveur et le client");
		}
	}
	
	public ClientInterface getClient(){
		return client;
	}
	
	public boolean connect(){
		System.out.println("login:");
		login = scan.nextLine();
		System.out.println("mdp:");
		mdp = scan.nextLine();
		System.out.println("pseudo:");
		pseudo = scan.nextLine();
		try {
			System.out.println("tentative de connexion en cours...");
			client = new ClientImplementation(login,mdp,pseudo);
			if(stub.connect(mdp, login,client)){
				System.out.println("good");
				return true;
			}
			System.out.println("bad");
			return false;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void appelFonction(String message){
		if(message.equalsIgnoreCase("down")){
			try {
				stub.disconnect(client);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			MessageInterface mess = new MessageImplementation(message,client);
			try {
				stub.send(mess);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String []args){
        boolean connexion = false;
        Client c = new Client();
		while(!connexion){
			connexion = c.connect();
		}
		
		try {
			String message = "";
			while(c.getClient().getIsConnect()){
				System.out.println("taper votre message (si vous voulez vous déconnecter du tchat taper: 'down' ): ");
				message = scan.nextLine();
				c.appelFonction(message);
			}
			System.out.println("déconnecté du serveur");
			scan.close();
			System.exit(0);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO: création d'un message via prompt 
		//TODO: envoie du message via la methode send en RMI (chatroom)
		//TODO: affichage des messages
		//TODO: déconnection du serveur
		
	}
}
