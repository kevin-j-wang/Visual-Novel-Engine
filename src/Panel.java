import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public abstract class Panel {
	protected Image background;
	protected Image character;
	public static double panelWidth;
	public static double panelHeight;
	public static double bezelSize = 40;
	public static Color color = new Color(0,0,0,0.6);
	public Panel(Image backgroundImage, Image characterImage) {
		background = backgroundImage;
		character = characterImage;
	}
	public abstract void draw(GraphicsContext gc);
	
	//Clears the screen
	public void clear(GraphicsContext gc) {
		gc.clearRect(0, 0, panelWidth, panelHeight);
	}
	
}
