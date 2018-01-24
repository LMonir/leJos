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
	
	public void turn(int degree) throws RemoteException;
	
	public void drivePID(int cm) throws RemoteException;
	
	public void drivePIDUntiLight(int lightlvl) throws RemoteException;
	
	public void stop() throws RemoteException;
	
	public String getStatus() throws RemoteException;
}

