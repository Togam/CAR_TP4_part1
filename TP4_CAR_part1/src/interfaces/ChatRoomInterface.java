package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author six delbrouque
 * 
 *         Interface remote représentation le chat
 */
public interface ChatRoomInterface extends Remote{

	void send (MessageInterface msg) throws RemoteException; 
	void disconnect(ClientInterface c)throws RemoteException;
	void connect(final String mdp, final String login, final ClientInterface client) throws RemoteException;
}
