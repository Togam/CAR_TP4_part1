package interfaces;

/**
 * @author six delbrouque
 * 
 *         Interface remote représentation le chat
 */
public interface ChatRoomInterface {

	// void send (Message msg);
	// boolean/void? disconnect(....)
	void connect(final String mdp, final String login, final ClientInterface client);
}
