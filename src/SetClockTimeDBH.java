import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by David on 10/11/2015.
 */
public class SetClockTimeDBH extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        DetailedClockPane clock = new DetailedClockPane();
        BorderPane pane = new BorderPane();

        TextField hours = new TextField();
        TextField minutes = new TextField();
        TextField seconds = new TextField();

        HBox hBox = new HBox(25);
        hBox.setPadding(new Insets(20, 20, 20, 20));
        hBox.getChildren().addAll(hours, minutes, seconds);
        hBox.setAlignment(Pos.CENTER);

        pane.setCenter(clock);
        pane.setBottom(hBox);

        hours.setOnKeyPressed(a -> {
            if (a.getCode().equals(KeyCode.ENTER)){
                clock.setHour(Integer.parseInt(a.getText()));
            }
        });

        minutes.setOnKeyPressed(b -> {
            if (b.getCode().equals(KeyCode.ENTER)) {
                clock.setMinute(Integer.parseInt(b.getText()));
            }
        });

        seconds.setOnKeyPressed(c -> {
            if (c.getCode().equals(KeyCode.ENTER)) {
                clock.setSecond(Integer.parseInt(c.getText()));
            }
        });

        Scene scene = new Scene(pane, 1000, 1000);
        clock.setCenterY(scene.getHeight() / 2);
        clock.setCenterX(scene.getWidth()/2);
        primaryStage.setTitle("Clock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
