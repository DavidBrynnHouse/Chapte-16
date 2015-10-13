import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by David on 10/13/2015.
 */
public class RaiseTheFlagDBH extends Application {
    private final ImageView FLAG_IMAGE = new ImageView("us.gif");
    private final AudioClip ANTHEM = new AudioClip("http://www.cs.armstrong.edu/liang/common/audio/anthem/anthem5.mp3");
    private final int X = 300;
    private final int Y = 1500;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        pane.getChildren().add(FLAG_IMAGE);

        PathTransition pt = new PathTransition(Duration.millis(10000),
                new Line(100, 1500, 100, 100), FLAG_IMAGE);
        pt.setCycleCount(1);
        pt.play();

        Scene scene = new Scene(pane, X, Y);
        primaryStage.setScene(scene);
        primaryStage.show();

        ANTHEM.setCycleCount(Timeline.INDEFINITE);
        ANTHEM.play();
    }
}
