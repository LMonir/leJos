package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import logic.Roboter;

public class RoboServer implements RoboServerInterface{
	private Roboter robo = new Roboter(43);

	@Override
	public void driveCm(int cm, int speed) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drive(int cm, int speed) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void driveUntilBlack(int speed) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void driveBackCm(int cm, int speed) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void driveBack(int cm, int speed) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnLeft() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnRight() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnAround() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drivePID(int cm, int speed) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getStatus() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
public static void main(String args[]) {
        
        try {
            RoboServerInterface obj = new RoboServer();
            RoboServerInterface stub = (RoboServerInterface) UnicastRemoteObject.exportObject(obj, 0);
            //System.out.println(obj.toString());
            LocateRegistry.createRegistry(55555);
            Registry registry = LocateRegistry.getRegistry(55555);
            registry.bind("Robo", stub);

            System.err.println("Roboter bereit");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
	
}
