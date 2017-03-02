package client;

import interfaces.ClientInterface;
import interfaces.MessageInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientImplementation extends UnicastRemoteObject implements ClientInterface{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String mdp;
	private String pseudo;
	private boolean isConnect;
	
	public ClientImplementation() throws RemoteException {
		
	}
	
	public ClientImplementation(final String login, final String mdp) throws RemoteException {
		this.login = login;
		this.mdp = mdp;
		this.isConnect = false;
	}
	
	public ClientImplementation(String login, String mdp, String pseudo) throws RemoteException{
		this.login = login;
		this.mdp = mdp;
		this.pseudo = pseudo;
		this.isConnect = false;
	}

	public void notify(MessageInterface msg) throws RemoteException {
		System.out.println(msg.getClient().getPseudo()+" : "+msg.getMessage());
	}

	public void setLogin(String login) throws RemoteException{
		this.login = login;
	}
	
	public String getLogin() throws RemoteException{
		return login;
	}
	
	public void setMdp(String mdp) throws RemoteException{
		this.mdp = mdp;
	}

	public String getMdp() throws RemoteException {
		return mdp;
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo()throws RemoteException {
		return pseudo;
	}

	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) throws RemoteException {
		this.pseudo = pseudo;
	}

	/**
	 * @param isConnect the isConnect to set
	 */
	public void setIsConnect(boolean isConnect) throws RemoteException {
		this.isConnect = isConnect;
	}

	public boolean getIsConnect() throws RemoteException {
		return isConnect;
	}

}
