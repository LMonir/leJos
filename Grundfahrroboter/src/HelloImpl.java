import java.rmi.*;
import java.rmi.server.*;

public class HelloImpl extends UnicastRemoteObject implements Hello {

    protected HelloImpl() throws RemoteException {
    }

    public String speak(String robo, String language) throws RemoteException {
        return robo+" speaks "+language;
    }
}