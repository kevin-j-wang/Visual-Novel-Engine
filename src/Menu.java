import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;

public class Menu {
	private ImageView saveButton = new ImageView();
	private ImageView loadButton = new ImageView();
	private ImageView quitButton = new ImageView();
	private ImageView toggleTextButton = new ImageView();
	private BufferedWriter saveWriter;
	private File savePath;

	public Menu(Image save, Image saveHover, Image load, Image loadHover, Image quit, Image quitHover, Image toggleText, Image toggleTextHover) {
		//savePath = new File("file:data/saves/save.txt");
		//try {
		//	saveWriter = new BufferedWriter(new FileWriter(savePath));
		//} catch (IOException e) {
		//	e.printStackTrace();
		//}
		saveButton.setImage(save);
		loadButton.setImage(load);
		quitButton.setImage(quit);
		toggleTextButton.setImage(toggleText);
		saveButton.setFitWidth(200);
		loadButton.setFitWidth(200);
		toggleTextButton.setFitWidth(200);
		quitButton.setFitWidth(200);
		saveButton.setFitHeight(Panel.panelHeight / 4);
		loadButton.setFitHeight(Panel.panelHeight / 4);
		toggleTextButton.setFitHeight(Panel.panelHeight / 4);
		quitButton.setFitHeight(Panel.panelHeight / 4);
		loadButton.setLayoutX(Panel.panelWidth - loadButton.getFitWidth());
		loadButton.setLayoutY(0 * Panel.panelHeight / 4);
		saveButton.setLayoutX(Panel.panelWidth - saveButton.getFitWidth());
		saveButton.setLayoutY(Panel.panelHeight / 4);
		toggleTextButton.setLayoutX(Panel.panelWidth - toggleTextButton.getFitWidth());
		toggleTextButton.setLayoutY(2 * Panel.panelHeight / 4);
		quitButton.setLayoutX(Panel.panelWidth - quitButton.getFitWidth());
		quitButton.setLayoutY(3*Panel.panelHeight/4);
		saveButton.setOnMouseEntered(event -> {
			saveButton.setImage(saveHover);
		});
		saveButton.setOnMouseExited(event -> {
			saveButton.setImage(save);;
		});
		quitButton.setOnMouseEntered(event -> {
			quitButton.setImage(quitHover);
		});
		quitButton.setOnMouseExited(event -> {
			quitButton.setImage(quit);;
		});
		loadButton.setOnMouseEntered(event -> {
			loadButton.setImage(loadHover);
		});
		loadButton.setOnMouseExited(event -> {
			loadButton.setImage(load);;
		});
		toggleTextButton.setOnMouseEntered(event -> {
			toggleTextButton.setImage(toggleTextHover);
		});
		toggleTextButton.setOnMouseExited(event -> {
			toggleTextButton.setImage(toggleText);;
		});
		quitButton.setOnMouseClicked(event -> {
			if (event.getButton() == MouseButton.PRIMARY) {
				System.exit(0);
			}
		});
		
		saveButton.setOnMouseClicked(event -> {
			if (event.getButton() == MouseButton.PRIMARY) {
				//saveGame();
			}
		});
	}
	/*
	private void saveGame() {
		try {
			saveWriter.write(DataReader.lineNumber);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
	public void initMenu(Group group) {
		group.getChildren().add(saveButton);
		group.getChildren().add(loadButton);
		group.getChildren().add(toggleTextButton);
		group.getChildren().add(quitButton);
		saveButton.setVisible(false);
		loadButton.setVisible(false);
		toggleTextButton.setVisible(false);
		quitButton.setVisible(false);
	}

	public void openMenu(Group group) {
		saveButton.setVisible(true);
		loadButton.setVisible(true);
		toggleTextButton.setVisible(true);
		quitButton.setVisible(true);
	}

	public void closeMenu(Group group) {
		saveButton.setVisible(false);
		loadButton.setVisible(false);
		toggleTextButton.setVisible(false);
		quitButton.setVisible(false);
	}
}
