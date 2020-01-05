import java.io.File;
import java.util.HashMap;

import javafx.scene.image.Image;

public class Character {
	public Character(String characterName) {
		String name = characterName;
		//HashMap that stores all variant images of the same character
		HashMap<String, Image> sprites = new HashMap<>();
		String path = new File("").getAbsolutePath() + "\\data\\assets\\characters";
		File directory = new File(path);
		//Get all the files in the folder named character and if it matches the name of the Character string passed to the constructor then add it to the HashMap.
		for(final File fileEntry : directory.listFiles()) {
			//Only accepts it if the name matches and the file extension is png
			if(fileEntry.getName().substring(fileEntry.getName().lastIndexOf("\\"), name.length() + 1).equals(name) && fileEntry.getName().substring(fileEntry.getName().length() - 3, fileEntry.getName().length()).equals("png")) {
				System.out.println("balls");
				sprites.put(fileEntry.getName().substring(fileEntry.getName().lastIndexOf("\\") + 1), new Image(fileEntry.getName()));
			}
		}
	}
}
