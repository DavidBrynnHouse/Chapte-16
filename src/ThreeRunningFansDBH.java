import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by David on 10/12/2015.
 */
public class ThreeRunningFansDBH extends Application {
    final int X = 1200;
    final int Y = 700;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane outerPane = new BorderPane();
        GridPane upperPane = new GridPane();
        HBox lowerPane = new HBox(20);

        Fan leftFan = new Fan();
        Fan middleFan = new Fan();
        Fan rightFan = new Fan();

        upperPane.add(leftFan, 0, 0);
        upperPane.add(middleFan, 1, 0);
        upperPane.add(rightFan, 2, 0);

        outerPane.setCenter(upperPane);


        Scene scene = new Scene(outerPane, X, Y);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
