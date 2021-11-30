
import java.rmi.*;  
public interface Adder extends Remote{  
  
	public double findPiValue( int x) throws RemoteException;
}  