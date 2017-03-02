package server;

import interfaces.ChatRoomInterface;
import interfaces.ClientInterface;
import interfaces.MessageInterface;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class ChatRoomImplementation implements ChatRoomInterface{


	private ArrayList<ClientInterface> clients = new ArrayList<ClientInterface>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ChatRoomImplementation() throws RemoteException {
		super();
	}
	
	public void send(MessageInterface msg) throws RemoteException {
		for(ClientInterface c : clients){
			if(c.getIsConnect()){
				c.notify(msg);
			}
		}
	}

	public void disconnect(ClientInterface c) throws RemoteException {
		if(clients.contains(c)){
			c.setIsConnect(false);
			System.out.println("déconnexion du client");
		}
	}

	public boolean connect(String mdp, String login, ClientInterface client)
			throws RemoteException {
		System.out.println("tentative de connexion sur le serveur");
		if(clients.contains(client)){
			System.out.println("le client est déjà connu, vérification des attributs de connexion");
			for(ClientInterface c : clients){
				if(c.getLogin().equals(login)&& c.getMdp().equals(mdp) && !c.getIsConnect()){
					c.setIsConnect(true);
					return true;
				}
			}
		}else{
			System.out.println("le client n'est pas connu, on l'enregistre");
			clients.add(client);
			client.setIsConnect(true);
			return true;
		}
		return false;
	}

}
