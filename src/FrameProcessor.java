import java.util.ArrayList;
import java.util.List;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class FrameProcessor implements EventHandler<ActionEvent> {
	private GraphicsContext gc;
	private Timeline timeline;
	private Image background;
	private Image character;
	private List<String> splitText = new ArrayList<>();
	//Stores the different lines that the original line will be split into.
	private int index = 1;
	//The location of the current character that the program is at while it scrolls across the line.
	private int lines = 0;

	public FrameProcessor(GraphicsContext gc, String text, Image background, Image character, double textBoxWidth,
			Timeline timeline) {
		this.gc = gc;
		this.timeline = timeline;
		this.background = background;
		this.character = character;
		//Adds an empty line to which characters will be added to incrementally
		splitText.add("");
		for (int i = 0; i < text.length(); i++) {
			String current = splitText.get(splitText.size() - 1);
			String newLine = current + text.charAt(i);
			if (measure(newLine) > textBoxWidth) {
				//Only stops adding characters at whole words, so it words will not be cut off in the middle.
				int index = current.lastIndexOf(' ');
				splitText.add(current.substring(index + 1) + text.charAt(i));
				splitText.set(splitText.size() - 2, current.substring(0, index));
			} else {
				splitText.set(splitText.size() - 1, newLine);
			}

		}
	}

	@Override
	public void handle(ActionEvent e) {
		Client.inProgress = true;
		gc.drawImage(background, 0, 0, Panel.panelWidth, Panel.panelHeight);
		gc.setFill(Panel.color);
		gc.drawImage(character, Panel.panelWidth / 2 - character.getWidth() / 2,
				Panel.panelHeight - character.getHeight());
		gc.fillRect(Panel.bezelSize, Panel.panelHeight / 2, Panel.panelWidth - Panel.bezelSize * 2,
				Panel.panelHeight / 2 - 10);
		gc.setFill(Color.WHITE);
		double y = Panel.panelHeight / 2;
		for (int i = 0; i < lines; i++) {
			gc.fillText(splitText.get(i), Panel.bezelSize + 10, y += Client.font.getSize());
		}
		if (lines < splitText.size()) {
			gc.fillText(splitText.get(lines).substring(0, index++), Panel.bezelSize + 10, y + 40);
			if (index == splitText.get(lines).length() + 1) {
				lines++;
				index = 0;
			}
		}
		else {
			timeline.stop();
			Client.inProgress = false;
		}
	}

	//Measures the length of the string in pixels not characters
	private int measure(String text) {
		Text t = new Text(text);
		t.setFont(Client.font);
		return (int) t.getLayoutBounds().getWidth();
	}

}
