package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author six delbrouque
 * 
 *         Interface remote représentant le client
 */
public interface ClientInterface extends Remote {

	public void notify(MessageInterface msg) throws RemoteException;
	public String getLogin() throws RemoteException;
	public String getMdp() throws RemoteException;
	public void setMdp(String mdp) throws RemoteException;
	public void setLogin(String login) throws RemoteException;
	public String getPseudo()throws RemoteException;
	public void setPseudo(String pseudo) throws RemoteException;
	public void setIsConnect(boolean isConnect) throws RemoteException;
	public boolean getIsConnect() throws RemoteException;
}
