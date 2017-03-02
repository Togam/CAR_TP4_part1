package interfaces;

import java.io.Serializable;

/**
 * @author six delbrouque
 * 
 *         Interface serializable représentant les messages
 */
public interface MessageInterface extends Serializable {
	public void setMessage(String message);
	public String getMessage();
	public ClientInterface getClient();
	public void setClient(ClientInterface client);
}
