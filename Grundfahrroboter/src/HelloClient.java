import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;

public class HelloClient {
    private Hello worker;
    private Registry registry;
    private String clientName;

    public HelloClient() {
    }

    public HelloClient(String clientName, String workerName) throws RemoteException, NotBoundException {
        this.registry = LocateRegistry.getRegistry("127.0.0.1", 9999);
        this.worker = (Hello) registry.lookup(workerName);
        this.clientName = clientName;
    }

    public Hello getWorker() {
        return worker;
    }

    public Registry getRegistry() {
        return registry;
    }

    public String getClientName() {
        return clientName;
    }

}