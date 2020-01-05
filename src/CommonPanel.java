import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class CommonPanel extends Panel {
	private Text panelText;
	public double textBoxWidth = panelWidth - bezelSize * 2;;

	public CommonPanel(Image backgroundImage, Image characterImage, String panelContents) {
		super(backgroundImage, characterImage);
		this.panelText = new Text(panelContents);
	}

	// Draws the everything a normal panel would have, text, a background, a
	// character, etc.
	@Override
	public void draw(GraphicsContext gc) {
		Timeline timeline = new Timeline();
		//The keyframe doesn't have anything in it because every action is within the handle method within the FrameProcessor class.
		KeyFrame frame = new KeyFrame(Duration.seconds(0.032), new FrameProcessor(gc, panelText.getText(), background, character, textBoxWidth, timeline){});
		timeline.getKeyFrames().add(frame);
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
}
