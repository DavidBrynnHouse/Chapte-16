import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


/**
 * Created by David on 10/13/2015.
 */
public class AudioClipDBH extends Application {
    final int X = 350;
    final int Y = 100;
    private final static String AUDIO_URL =
            "http://www.cs.armstrong.edu/liang/common/audio/anthem/anthem2.mp3";
    boolean on;

    @Override
    public void start(Stage primaryStage){
        Media media = new Media(AUDIO_URL);
        MediaPlayer player = new MediaPlayer(media);
        GridPane pane = new GridPane();
        pane.setHgap(10);

        Button play = new Button("Play");
        Button loop = new Button("Loop");
        Button stop = new Button("Stop");

        pane.add(play, 0, 0);
        pane.add(loop, 1,0);
        pane.add(stop, 2, 0);

        play.setOnAction(e -> {
            player.play();
        });

        loop.setOnAction(e -> {
            on = true;
            while(on){
                player.play();
            }
        });

        stop.setOnAction(e -> {
            on = false;
            player.pause();
        });

        Scene scene = new Scene(pane, X, Y);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
