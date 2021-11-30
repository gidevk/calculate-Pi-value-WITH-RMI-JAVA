
import java.rmi.*;  
import java.rmi.server.*;  
import java.util.concurrent.ThreadLocalRandom;
public class AdderRemote extends UnicastRemoteObject implements Adder{  
	AdderRemote() throws RemoteException{  
		super();  
	}  
	 
	public double findPiValue( int val){
		
		int i;
	    double rand_x, rand_y, origin_dist, pi = 0;
	    int circle_points = 0, square_points = 0;
	  
	    // Total Random numbers generated = possible x
	    // values * possible y values
	    for (i = 0; i < (val * val); i++) {
	  
			 // Randomly generated x and y values
	        double x = (ThreadLocalRandom.current().nextInt() & Integer.MAX_VALUE) % (val + 1);
	    	double y = (ThreadLocalRandom.current().nextInt() & Integer.MAX_VALUE) % (val + 1);
	        rand_x = x / val;
	        rand_y = y / val;
	  
	        // Distance between (x, y) from the origin
	        origin_dist = rand_x * rand_x + rand_y * rand_y;
	  
	        // Checking if (x, y) lies inside the define
	        // circle with R=1
	        if (origin_dist <= 1)
	            circle_points++;
	  
	        // Total number of points generated
	        square_points++;
	  
	        // estimated pi after this iteration
	        double temp = (4 * circle_points);
	        pi = temp / square_points;
	        System.out.println(+rand_x+"  "+rand_y+"  "+circle_points+"  "+square_points+"  "+pi+"\n");
	    }
	    return pi;
	}
}  