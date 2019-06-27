import java.rmi.*;

public interface Hello extends Remote {

    public String speak(String robo, String language) throws RemoteException;
}