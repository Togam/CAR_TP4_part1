package client;

import java.rmi.RemoteException;
import java.util.Scanner;

import interfaces.ClientInterface;
import interfaces.MessageInterface;

/**
 * @author six delbrouque
 * 
 *         Classe object du Client
 */
public class Client implements ClientInterface{

	public void notify(MessageInterface msg) throws RemoteException {
		// TODO: rafraichir la vue si on recoit un nouveau message de la part du serveur
		
	}

	public static boolean connect(){
		Scanner scan = new Scanner(System.in);
		System.out.println("login:");
		String login = scan.nextLine();
		System.out.println("mdp:");
		String mdp = scan.nextLine();
		return true;
	}
	
	public static void main(String []args){
		boolean connexion = false;
		while(!connexion){
			connexion = connect();
		}
		//TODO: connection au serveur via methode connect en RMI (chatroom)
		//TODO: création d'un message via prompt 
		//TODO: envoie du message via la methode send en RMI (chatroom)
		//TODO: affichage des messages
		//TODO: déconnection du serveur
		
	}
}
