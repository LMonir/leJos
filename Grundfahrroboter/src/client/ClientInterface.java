/**
 * @author {garte}
 * @version {10.01.2018}
 */
package client;

/**
 * @author garte
 *
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {
	public void drive(int cm) throws RemoteException;
}

