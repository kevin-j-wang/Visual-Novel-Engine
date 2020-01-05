import java.awt.Color;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseButton;

public class Client extends Application {
	private ImageView playButton;
	private ImageView quitButton;
	private ImageView backGround;
	private Scene scene;
	private Group group;
	private String title;
	private String author;
	private String date;
	public Canvas canvas;
	public static GraphicsContext gc;
	public static Font font;
	public Menu menu;
	private boolean menuOpen = false;
	private static int panelNum = 0;
	public static boolean inProgress = false;
	private ArrayList<Panel> panelSequence = new ArrayList<>();

	public void start(Stage clientStage) throws Exception {
		// Declare all images here, initialize them shortly after.
		Image background = null, play = null, resume = null, quit = null, option = null, mute = null, unmute = null,
				quit2 = null, load = null, graphic = null, save = null;
		background = new Image("file:data/assets/menu/background.png");
		play = new Image("file:data/assets/menu/playButton.png");
		resume = new Image("file:data/assets/menu/sexy pants.jpg");
		option = new Image("file:data/assets/menu/sean+and+michael+are+h8r.png");
		quit = new Image("file:data/assets/menu/quitButton.png");
		mute = new Image("file:data/assets/menu/sheep.jpg");
		unmute = new Image("file:data/assets/menu/screenie.png");
		quit2 = new Image("file:data/assets/menu/menuQuitButton.png");
		load = new Image("file:data/assets/menu/loadButton.png");
		graphic = new Image("file:data/assets/menu/graphicButton.png");
		save = new Image("file:data/assets/menu/saveButton.png");
		// Make sure to make all buttons preserve ratio to prevent wacky resizing,
		// unless of course you want your image to be resized uncontrollably.
		playButton = new ImageView(play);
		playButton.setPreserveRatio(true);
		quitButton = new ImageView(quit);
		quitButton.setPreserveRatio(true);
		backGround = new ImageView(background);
		backGround.setPreserveRatio(true);
		group = new Group();
		scene = new Scene(group, 960, 540);
		// Set the width and height of all panels to be the same size as the window,
		// they are static doubles.
		// Whenever the size of the displayed area is needed, use the following fields.
		Panel.panelWidth = scene.getWidth();
		Panel.panelHeight = scene.getHeight();
		// Make a menu that pops up upon right clicking anywhere.
		menu = new Menu(save, mute, load, mute, quit2, mute, graphic, mute);
		clientStage.setScene(scene);
		// Removes the top bar so that the height and width are actually accurate, and
		// also makes it look CLEAN
		clientStage.initStyle(StageStyle.TRANSPARENT);
		clientStage.show();
		clientStage.setResizable(false);
		canvas = new Canvas(scene.getWidth(), scene.getHeight());
		gc = canvas.getGraphicsContext2D();
		font = new Font("Arial", 40);
		gc.setFont(font);
		group.getChildren().add(backGround);
		group.getChildren().add(canvas);
		group.getChildren().add(quitButton);
		group.getChildren().add(playButton);
		menu.initMenu(group);
		scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (mouseEvent.getButton() == MouseButton.SECONDARY) {
					if (menuOpen) {
						menuOpen = false;
						menu.closeMenu(group);
					} else {
						menuOpen = true;
						menu.openMenu(group);
					}
				}
			}
		});

		refreshLayout();
		playButton.setOnMouseClicked(event -> {
			if (event.getButton() == MouseButton.PRIMARY) {
				clientStage.show();
				refreshLayout();
				playGame();
			}
		});
		/*
		 * playButton.setOnMousePressed(new EventHandler<MouseEvent>() { public void
		 * handle(MouseEvent event) { clientStage.show(); refreshLayout(); playGame(); }
		 * });
		 */
		quitButton.setOnMouseClicked(event -> {
			if (event.getButton() == MouseButton.PRIMARY) {
				System.exit(0);
			}
		});
		/*
		 * quitButton.setOnMousePressed(new EventHandler<MouseEvent>() { public void
		 * handle(MouseEvent event) {
		 * 
		 * } });
		 */
	}

	public void initialize() {
		launch();
	}

	// Include all Buttons added here.
	// Call this method whenever window size is changed.
	public void refreshLayout() {
		playButton.setFitWidth(scene.getWidth() / 8);
		quitButton.setFitWidth(scene.getWidth() / 8);
		backGround.setFitWidth(scene.getWidth() + 10);
		playButton.setLayoutY(scene.getHeight() / 7 * 4 - playButton.getFitHeight() / 2);
		playButton.setLayoutX(scene.getWidth() / 8 - playButton.getFitWidth() / 2);
		quitButton.setLayoutY(scene.getHeight() / 7 * 5 - quitButton.getFitHeight() / 3);
		quitButton.setLayoutX(scene.getWidth() / 8 - quitButton.getFitWidth() / 2);
	}

	public void hideMainMenu() {
		playButton.setVisible(false);
		quitButton.setVisible(false);
	}

	public void showMainMenu() {
		playButton.setVisible(true);
		quitButton.setVisible(true);
	}

	public void playGame() {
		hideMainMenu();
		DataReader reader = new DataReader("game1");
		title = reader.read();
		author = reader.read();
		date = reader.read();
		String line;
		while ((line = reader.read()) != null) {
			panelSequence.add(new CommonPanel(new Image("file:data/assets/backgrounds/" + line),
					new Image("file:data/assets/characters/" + reader.read()), reader.read()));
		}		
		scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				if (mouseEvent.getButton() == MouseButton.PRIMARY && menuOpen == false && !inProgress) {
					// panelSequence.get(panelNum).clear(gc);
					panelSequence.get(panelNum).draw(gc);
					panelNum++;
				}
			}
		});
	}
}
