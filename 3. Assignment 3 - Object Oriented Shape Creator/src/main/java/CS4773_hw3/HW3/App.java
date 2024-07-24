package CS4773_hw3.HW3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import commands.Command;
import commands.CommandController;
import scene.Editor;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	File file = new File(args[0]);
    	Editor scene = new Editor();
    	Command currentCommand;
    	CommandController chainController = new CommandController();
    	
    	try {
			BufferedReader buffered = new BufferedReader(new FileReader(file));
			String line;
			while((line = buffered.readLine()) != null) {
				currentCommand = chainController.executeCommand(line.split(" "));
				
				if(currentCommand != null) {
					currentCommand.execute(scene);
				} else {
					System.out.println("Command is null");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
