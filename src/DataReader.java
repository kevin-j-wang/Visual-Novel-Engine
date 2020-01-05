import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {
	private BufferedReader reader;
	
	public static int lineNumber = 1;
	
	public DataReader(String fileName) {
		try {
			String currentDir = new File("").getAbsolutePath() + "\\data\\novel\\";
		    this.reader = new BufferedReader(new FileReader(currentDir + fileName + ".txt"));
		} catch (FileNotFoundException e) {
			System.out.println("You have no file");
			e.printStackTrace();
		}
	}
	public String read() {
		try {
			String input = reader.readLine();
			if(input == null) {
				return null;
			}
			lineNumber++;
			//Increments the line number every time a line is read, which is used for saving progress and debugging.
			return interpret(input).trim();
		} 
		catch (IOException e) {
			System.out.println("Error reading line");
			e.printStackTrace();
			return null;
		}
	}
	public void close() throws IOException {
		reader.close();
	}
	public String interpret(String line) {
		//Does not specially interpret the data until after line 3, as the first 3 lines should always be title, authors, date in that order.
		if(line.charAt(0) != '#' || lineNumber <= 3) {
			return line;
		}
		else {
			switch(line) {
			case "#BlackTransition":
				
				break;
			case "#WhiteTransition":
				
				break;
			case "#Cutscene":
				
				break;
			case "#Sound": 
				
				break;
			case "#Choice": 
				
				break;
			case "#Ending":
				
				break;
			case "#ScreenShake":
				
				break;
			case "#ScreenTint":
				
				break;
			default: 
				System.out.println("Formatting error on line " + lineNumber);
				return "ERROR: IMPROPERLY FORMAT ON LINE " + lineNumber + " PLAYERS SHOULD NEVER SEE THIS MESSAGE";
			}
			return "";
		}
	}
}
