
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client{  
	public static void main(String args[]){ 
		Scanner sc = new Scanner(System.in); 
		try{  
			// Getting the registry 
	         Registry registry = LocateRegistry.getRegistry(null); 
	    
	         // Looking up the registry for the remote object 
	         Adder stub = (Adder) registry.lookup("Adder");
			  
			System.out.println("Enter estimated Number for pi value :");
			int x = sc.nextInt();
			System.out.println("Estimated Pi values with "+ x + " is "+ stub.findPiValue(x) );
			  
		}catch(Exception e){}  

		finally{
			sc.close();
		}
	}  
}  