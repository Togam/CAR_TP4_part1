package client;

import interfaces.ClientInterface;
import interfaces.MessageInterface;

public class MessageImplementation implements MessageInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private ClientInterface client;
	
	public MessageImplementation() {
		message = "";
	}
	
	public MessageImplementation(String message){
		this.message = message;
	}
	
	public MessageImplementation(String message, ClientInterface c){
		this.message = message;
		this.client = c;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the client
	 */
	public ClientInterface getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(ClientInterface client) {
		this.client = client;
	}
	
	
	
	
}
