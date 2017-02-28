package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author six delbrouque
 * 
 *         Interface remote représentant le client
 */
public interface ClientInterface extends Remote {

	void notify(MessageInterface msg) throws RemoteException;
}
