import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;


/**
 * Created by David on 10/13/2015.
 */
public class VideoPlayerDBH extends Application {
    final int X = 720;
    final int Y = 600;
    private final static String MEDIA_URL =
            "http://cs.armstrong.edu/liang/common/sample.mp4";
    boolean on;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Media media = new Media(MEDIA_URL);
        MediaPlayer player = new MediaPlayer(media);
        MediaView viewer = new MediaView(player);

        Button pause = new Button(">");
        Label time = new Label("Time");
        Label runTime = new Label();
        Label volume = new Label("Volume");
        Slider currentTime = new Slider();
        Slider setVolume = new Slider();

        setVolume.setPrefWidth(150);
        setVolume.setMaxWidth(Region.USE_PREF_SIZE);
        setVolume.setMinWidth(30);
        setVolume.setValue(50);
        player.volumeProperty().bind(
                setVolume.valueProperty().divide(100));

        BorderPane outerPane = new BorderPane();
        Pane upperPane = new Pane();
        HBox bottomPane = new HBox(20);
        bottomPane.setAlignment(Pos.CENTER);
        bottomPane.setPadding(new Insets(20, 20, 20, 20));

        bottomPane.getChildren().addAll(
                pause, time, currentTime,
                runTime, volume, setVolume);
        upperPane.getChildren().add(viewer);
        outerPane.setCenter(upperPane);
        outerPane.setBottom(bottomPane);

        pause.setOnAction(e -> {
            if (pause.getText().equals(">")) {
                player.play();
                pause.setText("||");
            } else {
                player.pause();
                pause.setText(">");
            }
        });

        currentTime.valueProperty().addListener(ov -> {
            if (currentTime.isValueChanging()) {
                player.seek(player.getTotalDuration().
                        multiply(currentTime.getValue() / 100.0));
            }
        });

        player.currentTimeProperty().addListener(ov -> {
            currentTime.setValue(player.getCurrentTime().divide(
                    player.getMedia().getDuration()).toMillis() * 100.0);
            runTime.setText(
                    format((int) player.getCurrentTime().toSeconds()) + "/" +
                            format((int) player.getTotalDuration().toSeconds()));
        });

        Scene scene = new Scene(outerPane, X, Y);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static String format(long seconds) {

        int hour = (int)(seconds / 3600 % 24);
        int minute = (int)(seconds / 60 % 60);
        int second = (int)(seconds % 60);


        return (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute) + ":" +
                (second < 10 ? "0" + second : second);
    }
}
