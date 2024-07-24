package HW5.Elevator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String fileName = args[0];
        
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
	        
	        Elevator elevator = new Elevator();
	        
	        int n;
	        
			n = reader.read();
			while(n != -1) {
	        	switch (n) {
	        	case '1':
	        		elevator.pressButtonOne();
	        		break;
	        	case '2':
	        		elevator.pressButtonTwo();
	        		break;
	        	case '3':
	        		elevator.pressButtonThree();
	        		break;
	        	default:
	        		break;
	        	}
	        	n = reader.read();
	        }
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
