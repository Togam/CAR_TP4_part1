/**
 * 
 */
package server;

import interfaces.ChatRoomInterface;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
/**
 * @author delbrouquepri
 *
 */
public class Server {
	private static Server inst;
	
	/**
	 * 
	 * @return new Server
	 */
	public static Server getInstance(){
		if(inst == null) {
			inst = new Server();
		}
		return inst;
	}
	
	/**
	 * Constructor for Server
	 * 
	 */
	public Server(){
		run();
	}
	
	public void run(){
		try {
			ChatRoomInterface skeleton = (ChatRoomInterface) UnicastRemoteObject.exportObject(new ChatRoomImplementation(),10000);
        	Registry registry = LocateRegistry.createRegistry(10000);
        	registry.rebind("methode", skeleton);
			System.out.println("Serveur prêt!");	
		} catch (IOException e) {
			System.out.println("une erreur est survenu");
			e.printStackTrace();
		}
	}

	/**
	 * Run the Server
	 * @param args
	 */
	public static void main(String[] args){
		Server.getInstance();
	}
}
