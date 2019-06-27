import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
public class HelloServer {
    private int port;
    private HelloClient robot1;
    private HelloClient robot2;
    private HelloClient robot3;

    public HelloServer(int port) {
        this.port = port;
    }

    public void createRegistries() throws RemoteException, AlreadyBoundException {
        HelloImpl obj1 = new HelloImpl();
        HelloImpl obj2 = new HelloImpl();
        HelloImpl obj3 = new HelloImpl();
        String worker1 = "worker1";
        String worker2 = "worker2";
        String worker3 = "worker3";
        LocateRegistry.createRegistry(this.port);
        Registry registry = LocateRegistry.getRegistry(this.port);
        registry.bind(worker1, obj1);
        registry.bind(worker2, obj2);
        registry.bind(worker3, obj3);
        System.out.println ("-> Registry started on port " + this.port + ".");
        System.out.println ("-> HelloServer ready.");
    }

    public void createClients() throws RemoteException, NotBoundException {
        this.robot1 = new HelloClient("r1", "worker1");
        this.robot2 = new HelloClient("r2", "worker2");
        this.robot3 = new HelloClient("r3", "worker3");
        System.out.println ("-> Robots are available");
    }

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, NotBoundException {
        HelloServer server = new HelloServer(9999);
        server.createRegistries();
        server.createClients();

        System.out.println(server.robot1.getWorker().speak(server.robot1.getClientName(), "Deutsch"));
        System.out.println(server.robot2.getWorker().speak(server.robot2.getClientName(),"Spanisch"));
        System.out.println(server.robot3.getWorker().speak(server.robot3.getClientName(),"Englisch"));

        

    }
}